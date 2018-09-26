select zsse_DropView ('i_pricelist_v');
CREATE OR REPLACE VIeW i_pricelist_v as
select pp.M_PRICELIST_VERSION_ID||pp.M_PRODUCT_ID as i_pricelist_v_id,
 pp.M_PRICELIST_VERSION_ID,
 p.value,
 p.name,
 p.AD_CLIENT_ID,
 pp.AD_ORG_ID,
 pp.CREATEDBY,
 pp.created,
 pp.UPDATEDBY,
 pp.updated,
 pp.isactive,
 pp.PRICELIST,
 pp.PRICESTD,
 pp.PRICELIMIT,
 (SELECT PO.C_BPARTNER_ID FROM M_PRODUCT_PO po  WHERE po.m_product_id=p.M_Product_ID and PO.isactive='Y'  and po.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',pp.ad_org_id) ORDER BY COALESCE(po.qualityrating,0) DESC, updated DESC LIMIT 1) as c_bpartner_id,
 (SELECT PO.pricepo FROM M_PRODUCT_PO po  WHERE po.m_product_id=p.M_Product_ID and PO.isactive='Y'  and po.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',pp.ad_org_id) ORDER BY COALESCE(po.qualityrating,0) DESC, updated DESC LIMIT 1) as pricepo
 from m_productprice pp,m_product p where p.m_product_id=pp.m_product_id;


CREATE or replace FUNCTION  i_import_pricelist(p_filename varchar,p_user varchar, p_delimiter varchar) RETURNS varchar
AS $_$
DECLARE

ad_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_org character varying;
v_pversion character varying;
v_productid varchar;
v_cur2 RECORD;
v_cmd varchar;
v_i numeric:=0;
BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_productpriceimport;
  -- Datei in Tabelle
  v_cmd := 'COPY i_productpriceimport  FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||p_delimiter||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
 
    
    
    for v_cur2 in (select * from i_productpriceimport)
    LOOP
        select m_product_id into v_productid from m_product where value=v_cur2.productvalue_key;
        select m_pricelist_version_id,ad_org_id into v_pversion,v_org from m_pricelist_version where name=v_cur2.pricelistversion_key;
        if v_pversion is null  or v_productid is null then
            raise exception '%', 'No Data Found for Pricelist:'||coalesce(v_cur2.pricelistversion_key,'NULL')||' and Product: '||coalesce(v_cur2.productvalue_key,'NULL');
        end if;
        delete from m_productprice where m_product_id=v_productid and m_pricelist_version_id=v_pversion;
        insert into m_productprice (m_productprice_id,AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY,m_product_ID,m_pricelist_version_id,
                               isactive,pricelist,pricestd ,pricelimit)
               values(get_uuid(),ad_client,v_org,now(),p_user,now(),p_user,v_productid,v_pversion,
                      'Y',to_number(v_cur2.pricelist),to_number(v_cur2.pricestd) ,to_number(v_cur2.pricelimit));
        v_i:=v_i+1;
    END LOOP;
    return v_i||' Positionen in Preisliste importiert';  
END;
$_$  LANGUAGE 'plpgsql';



select zsse_DropView ('i_product_v');
CREATE OR REPLACE VIeW i_product_v as
select M_PRODUCT_ID as i_product_v_id,
 AD_CLIENT_ID,
 AD_ORG_ID,
 CREATEDBY,
 created,
 UPDATEDBY,
 updated,
 isactive,
 imageurl ,
 value ,
 name ,
  descriptionurl ,
   upc ,
 description ,
 documentnote ,
 c_uom_id ,
 isstocked ,
 m_product_category_id ,
 volume ,
 weight ,
 shelfwidth ,
 shelfheight ,
 shelfdepth ,
 unitsperpallet ,
 discontinued ,
 discontinuedby ,
 producttype ,
 m_attributeset_id ,
 m_locator_id ,
  ispurchased ,
 issold ,
 isbom ,
 calculated ,
 production ,
 c_tax_id ,
 typeofproduct ,
 isserviceitem ,
 isconsumable ,
 issparepart ,
 isfreightproduct ,
 issetitem ,
 isserialtracking ,
 isbatchtracking ,
 cusomstarifno ,
 c_country_id ,
 basepriceunit ,
 basepricemultiplicator,
 manufacturer,
 manufacturernumber
 from m_product;

 
CREATE or replace FUNCTION  i_import_product(p_filename varchar,p_user varchar, p_delimiter varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_org character varying;
v_pversion character varying;
v_productid varchar;
v_pcat varchar;
v_cur2 RECORD;
v_cmd varchar;
v_i numeric:=0;
v_ii numeric:=0;
v_uom varchar;
v_type varchar;
v_ptype varchar;
v_locat varchar;
v_country varchar;
v_tax varchar;
v_bpuom varchar;
v_lang varchar;
BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_productimport;
  -- Datei in Tabelle
  v_cmd := 'COPY i_productimport  FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||p_delimiter||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
 
    select ad_language into v_lang from ad_client  where ad_client_id=v_client;
    
    for v_cur2 in (select * from i_productimport)
    LOOP
        select m_product_id into v_productid from m_product where value=v_cur2.value;
        select m_product_category_id into v_pcat from m_product_category where name=v_cur2.m_product_category_id;
    --    if  v_pcat is null then
    --        select m_product_category_id into v_pcat from m_product_category_trl where ad_language = 'en_US' and  name=v_cur2.m_product_category_id;
    --    end if;
    --    if  v_pcat is null then
    --        select m_product_category_id into v_pcat from m_product_category_trl where ad_language = v_lang and  name=v_cur2.m_product_category_id;
    --    end if;
        if v_pcat is null then
            raise exception '%', 'Product Category not Found:'||v_cur2.m_product_category_id;
        end if;
        select ad_org_id into v_org from ad_org where name=v_cur2.ad_org_id;
        if v_cur2.ad_org_id='*' then v_org:='0'; end if;
        if v_org is null then
            raise exception '%', 'Organization not Found:'||v_cur2.ad_org_id;
        end if;
        select value into v_type from ad_ref_list where ad_reference_id='D3CE5ED8E56C43E19FA09D10B616BCAA' and name=v_cur2.typeofproduct;
        if  v_type is null then
            select a.value into v_type from ad_ref_list_trl t, ad_ref_list a where t.ad_language = 'de_DE' and a.ad_reference_id='D3CE5ED8E56C43E19FA09D10B616BCAA' and t.name=v_cur2.typeofproduct and t.ad_ref_list_id = a.ad_ref_list_id;
        end if;
        if  v_type is null then
            select ad_ref_listinstance.value into v_type from ad_ref_listinstance,ad_ref_list where ad_ref_list.ad_ref_list_id=ad_ref_listinstance.ad_ref_list_id and 
            ad_ref_list.ad_reference_id='D3CE5ED8E56C43E19FA09D10B616BCAA' and ad_ref_listinstance.name=v_cur2.typeofproduct;
        end if;
        if  v_type is null then
            select ad_ref_listinstance_trl.value into v_type from ad_ref_listinstance_trl,ad_ref_listinstance,ad_ref_list where 
             ad_ref_list.ad_ref_list_id=ad_ref_listinstance.ad_ref_list_id and ad_ref_listinstance_trl.ad_ref_listinstance_id=ad_ref_listinstance.ad_ref_listinstance_id
             and ad_ref_list.ad_reference_id='D3CE5ED8E56C43E19FA09D10B616BCAA' and ad_ref_listinstance_trl.name=v_cur2.typeofproduct limit 1;
        end if;
        if  v_type is null then
            raise exception '%', 'Product Type not Found - :'||v_cur2.typeofproduct;
        end if;
        select c_uom_id into v_uom from c_uom where name=v_cur2.c_uom_id;
        if  v_uom is null then
            select c_uom_id into v_uom from c_uom_trl where ad_language = 'en_US' and name=v_cur2.c_uom_id; 
        end if;
        if  v_uom is null then
            select c_uom_id into v_uom from c_uom_trl where ad_language = v_lang and name=v_cur2.c_uom_id; 
        end if;
        if  v_uom is null then
            raise exception '%', 'Unit of Measure not Found:'||v_cur2.c_uom_id;
        end if;
        select value into v_ptype from ad_ref_list where ad_reference_id='270' and name=v_cur2.producttype;
        if  v_ptype is null then
            select a.value into v_ptype from ad_ref_list_trl t, ad_ref_list a where t.ad_language = 'en_US' and a.ad_reference_id='270' and t.name=v_cur2.producttype and t.ad_ref_list_id = a.ad_ref_list_id;
        end if;
        if  v_ptype is null then
           select a.value into v_ptype from ad_ref_list_trl t, ad_ref_list a where t.ad_language = v_lang and a.ad_reference_id='270' and t.name=v_cur2.producttype and t.ad_ref_list_id = a.ad_ref_list_id;
        end if;
        if  v_ptype is null then
            raise exception '%', 'Type of Product not Found:'||v_cur2.producttype;
        end if;
        select m_locator_id into v_locat from m_locator where value=v_cur2.m_locator_id limit 1;
        /*
        if  v_locat is null then
            raise exception '%', 'Stock Locator not Found:'||v_cur2.m_locator_id;
        end if;       
        */
        select c_country_id into v_country from c_country where name=v_cur2.c_country_id;
       -- if  v_country is null then
       --     raise exception '%', 'Country not Found:'||v_cur2.m_locator_id;
       -- end if;
       if v_cur2.c_tax_id is not null then
        select c_tax_id into v_tax from c_tax where name=v_cur2.c_tax_id;
        if  v_tax is null then
            select c_tax_id into v_tax from c_tax_trl where ad_language = 'en_US' and name=v_cur2.c_tax_id;
        end if;
        if  v_tax is null then
            select c_tax_id into v_tax from c_tax_trl where ad_language = v_lang and name=v_cur2.c_tax_id;
        end if;
       end if;
        --if  v_tax is null then
        --    raise exception '%', 'Tax not Found:'||v_cur2.m_locator_id;
        --end if;
        if v_cur2.basepriceunit is not null then
            select c_uom_id into v_bpuom from c_uom where name=v_cur2.basepriceunit;
            if  v_uom is null then
                select c_uom_id into v_bpuom from c_uom where ad_language = 'en_US' and name=v_cur2.basepriceunit;
            end if;
            if  v_uom is null then
                select c_uom_id into v_bpuom from c_uom where ad_language = v_lang and name=v_cur2.basepriceunit;
            end if;
        end if;
        --if  v_bpuom is null then
        --    raise exception '%', 'Base Price Unit not Found:'||v_cur2.basepriceunit;
        --end if;
        v_i:=v_i+1;
        if v_productid is null then
            insert into m_product(ad_org_id , imageurl , value ,   upc , name ,  descriptionurl , description, documentnote , m_product_category_id ,
                                  typeofproduct , c_uom_id ,  producttype , isstocked ,  m_locator_id ,   isserialtracking , isbatchtracking , weight ,
                                  volume , shelfwidth , shelfheight , shelfdepth , unitsperpallet ,  isconsumable , issparepart , issetitem , isfreightproduct ,
                                  production ,isbom ,  ispurchased ,   manufacturer , manufacturernumber ,  cusomstarifno , c_country_id ,  calculated ,
                                  issold ,  c_tax_id , basepriceunit , basepricemultiplicator , discontinued , discontinuedby ,  isactive ,
                                  CREATED, CREATEDBY, UPDATED, UPDATEDBY,m_product_ID,ad_client_id)
                        values   (v_org,v_cur2.imageurl , v_cur2.value ,   v_cur2.upc , v_cur2.name ,  v_cur2.descriptionurl , v_cur2.description, v_cur2.documentnote,v_pcat,
                                  v_type,v_uom,v_ptype,v_cur2.isstocked ,v_locat,v_cur2.isserialtracking , v_cur2.isbatchtracking ,to_number(v_cur2.weight),
                                  to_number(v_cur2.volume) , to_number(v_cur2.shelfwidth) , to_number(v_cur2.shelfheight) , to_number(v_cur2.shelfdepth) , to_number(v_cur2.unitsperpallet),v_cur2.isconsumable , v_cur2.issparepart , v_cur2.issetitem , v_cur2.isfreightproduct ,
                                  v_cur2.production ,v_cur2.isbom ,  v_cur2.ispurchased ,   v_cur2.manufacturer , v_cur2.manufacturernumber ,  v_cur2.cusomstarifno , v_country ,  v_cur2.calculated ,
                                  v_cur2.issold ,  v_tax , v_bpuom , to_number(v_cur2.basepricemultiplicator) , v_cur2.discontinued , to_date(v_cur2.discontinuedby) ,  v_cur2.isactive,
                                  now(),p_user,now(),p_user,get_uuid(),v_client);
            v_ii:=v_ii+1;
        else
            update m_product set ad_org_id=v_org , imageurl=v_cur2.imageurl , value =v_cur2.value,   upc =v_cur2.upc, name =v_cur2.name,  descriptionurl= v_cur2.descriptionurl, description=v_cur2.description, documentnote =v_cur2.documentnote, m_product_category_id =v_pcat,
                                  typeofproduct=v_type ,   producttype=v_ptype , isstocked =v_cur2.isstocked,  m_locator_id= v_locat,   isserialtracking =v_cur2.isserialtracking, isbatchtracking=v_cur2.isbatchtracking , weight= to_number(v_cur2.weight),
                                  volume =to_number(v_cur2.volume), shelfwidth=to_number(v_cur2.shelfwidth) , shelfheight=to_number(v_cur2.shelfheight) , shelfdepth =to_number(v_cur2.shelfdepth), unitsperpallet=to_number(v_cur2.unitsperpallet) ,  isconsumable =v_cur2.isconsumable, issparepart =v_cur2.issparepart, issetitem =v_cur2.issetitem, isfreightproduct =v_cur2.isfreightproduct,
                                  production= v_cur2.production ,isbom=v_cur2.isbom ,  ispurchased =v_cur2.ispurchased,   manufacturer= v_cur2.manufacturer, manufacturernumber =v_cur2.manufacturernumber,  cusomstarifno =v_cur2.cusomstarifno, c_country_id =v_country,  calculated=v_cur2.calculated  ,
                                  issold =v_cur2.issold ,  c_tax_id=v_tax , basepriceunit =v_bpuom, basepricemultiplicator=to_number(v_cur2.basepricemultiplicator) , discontinued=v_cur2.discontinued , discontinuedby =to_date(v_cur2.discontinuedby),  isactive=v_cur2.isactive,
                                  UPDATEDBY=p_user,updated=now() where m_product_id=v_productid;
        end if;
    END LOOP;
    return v_i||' Artikel importiert, davon '||v_ii||' neu angelegt';  
END;
$_$  LANGUAGE 'plpgsql';



select zsse_DropView ('i_product_po_v');
CREATE OR REPLACE VIeW i_product_po_v as
select po.M_PRODUCT_ID||po.c_bpartner_id||coalesce(po.c_uom_id,'')||coalesce(po.m_manufacturer_id,'')||coalesce(po.manufacturernumber,'') as i_product_po_v_id,
po.AD_CLIENT_ID,
 po.AD_ORG_ID,
 po.CREATEDBY,
 po.created,
 po.UPDATEDBY,
 po.updated,
 po.isactive,
 p.value,
 p.name,
 (select value from c_bpartner where c_bpartner_id=po.c_bpartner_id) as bpvalue,
 zssi_getbpname(po.c_bpartner_id) as bpname,
 po.qualityrating,
 po.iscurrentvendor,
  po.upc,
   po.c_currency_id,
 po.c_uom_id,
 po.pricelist,
 po.pricepo,
 po.pricelastpo,
 po.pricelastinv,
  po.deliverytime_promised,
 po.vendorproductno,
 po.vendorcategory,
  po.m_manufacturer_id,
   po.manufacturernumber,
 po.discontinued,
 po.discontinuedby,
  po.qtystd,
 po.order_min,
 po.ismultipleofminimumqty from m_product_po po,m_product p where p.m_product_id=po.m_product_id;
 
 

 
CREATE or replace FUNCTION  i_import_product_po(p_filename varchar,p_user varchar, p_delimiter varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_org character varying;
v_pversion character varying;
v_productid varchar;
v_productpoid  varchar;
v_bpartner varchar;
v_cur2 RECORD;
v_cmd varchar;
v_i numeric:=0;
v_ii numeric:=0;
v_uom varchar;
v_currency varchar;
v_manufacturer varchar;
v_manufacturernumber varchar;
v_locat varchar;
v_country varchar;
v_tax varchar;
v_bpuom varchar;
v_lang varchar;
BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_product_poimport;
  -- Datei in Tabelle
  v_cmd := 'COPY i_product_poimport  FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||p_delimiter||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
 
    select ad_language into v_lang from ad_client  where ad_client_id=v_client;
    
    for v_cur2 in (select * from i_product_poimport)
    LOOP
        select m_product_id into v_productid from m_product where value=v_cur2.m_product_id;
        
        if v_productid is null then
            raise exception '%', 'Product not Found:'||v_cur2.m_product_id;
        end if;
        select c_bpartner_id into v_bpartner from c_bpartner where name=v_cur2.bpname and value=v_cur2.bpvalue limit 1;
        if v_bpartner is null then
            raise exception '%', 'Business partner not Found:'||v_cur2.bpname;
        end if;
        select ad_org_id into v_org from m_product where  m_product_id=v_productid;
       -- if v_cur2.ad_org_id='*' then v_org:='0'; end if;
        if v_org is null then
            raise exception '%', 'Organization not Found:';
        end if;

        --if  v_currency is null then
        --    raise exception '%', 'Product Type not Found:'||v_cur2.typeofproduct;
        --end if;
        if v_cur2.c_uom_id is not null then 
            select c_uom_id into v_uom from c_uom where name=v_cur2.c_uom_id;
            if  v_uom is null then
               select c_uom_id into v_uom from c_uom_trl where ad_language = 'en_US' and name=v_cur2.c_uom_id; 
            end if;
            if  v_uom is null then
               select c_uom_id into v_uom from c_uom_trl where ad_language = v_lang and name=v_cur2.c_uom_id; 
            end if;
        end if;
         --  raise notice '%', 'Unit of Measure not Found:'||v_uom||'#'||zssi_getproductname(v_productid,'de_DE')||'#'||v_bpartner;
        --end if;
        select m_manufacturer_id into v_manufacturer from m_manufacturer where  name=v_cur2.m_manufacturer_id;
        v_manufacturernumber:=v_cur2.manufacturernumber;
        --if  v_manufacturer is null then
        --    raise exception '%', 'Type of Product not Found:'||v_cur2.typeofproduct;
        --end if;
        select c_currency_id into v_currency from c_currency where iso_code=v_cur2.c_currency_id;
        
        select m_product_po_id into v_productpoid from m_product_po where m_product_id=v_productid and c_bpartner_id= v_bpartner
                                    and case when v_uom is not null then c_uom_id=v_uom else 1=1 end 
                                    and case when v_cur2.manufacturernumber is not null then manufacturernumber=v_cur2.manufacturernumber  else 1=1 end 
                                    and case when v_manufacturer is not null then m_manufacturer_id=v_manufacturer else 1=1 end; 
        
        
        v_i:=v_i+1;
        if v_productpoid is null then
            insert into m_product_po (ad_org_id, m_product_id, c_bpartner_id, qualityrating, iscurrentvendor,  upc,   c_currency_id, c_uom_id, pricelist,
                                      pricepo,   deliverytime_promised, vendorproductno, vendorcategory,  m_manufacturer_id,
                                      manufacturernumber, discontinued, discontinuedby,  qtystd, order_min, ismultipleofminimumqty,
                                      CREATED, CREATEDBY, UPDATED, UPDATEDBY,m_product_po_id,ad_client_id)
                             values  (v_org, v_productid, v_bpartner, to_number(v_cur2.qualityrating), v_cur2.iscurrentvendor,  v_cur2.upc,  v_currency,v_uom, to_number(v_cur2.pricelist),
                                      to_number(v_cur2.pricepo),   to_number(v_cur2.deliverytime_promised), v_cur2.vendorproductno, v_cur2.vendorcategory,  v_manufacturer,
                                      v_cur2.manufacturernumber, v_cur2.discontinued, to_date(v_cur2.discontinuedby),  to_number(v_cur2.qtystd), to_number(v_cur2.order_min), v_cur2.ismultipleofminimumqty,
                                      now(),p_user,now(),p_user,get_uuid(),v_client);
            v_ii:=v_ii+1;
           -- raise notice '%', 'Unit of Measure not Found:'||v_uom||'#'||zssi_getproductname(v_productid,'de_DE')||'#'||v_bpartner||'#Insert'||v_ii;
        else
       -- raise notice '%', 'Unit of Measure not Found:'||v_uom||'#'||zssi_getproductname(v_productid,'de_DE')||'#'||v_bpartner||'#Update'||v_ii;
            update m_product_po set ad_org_id=v_org,qualityrating=to_number(v_cur2.qualityrating), iscurrentvendor=v_cur2.iscurrentvendor,  upc=v_cur2.upc,   c_currency_id=v_currency, pricelist=to_number(v_cur2.pricelist),
                                      pricepo=to_number(v_cur2.pricepo),   deliverytime_promised=to_number(v_cur2.deliverytime_promised), vendorproductno=v_cur2.vendorproductno, vendorcategory=v_cur2.vendorcategory,  
                                      manufacturernumber=v_cur2.manufacturernumber, discontinued=v_cur2.discontinued, discontinuedby=to_date(v_cur2.discontinuedby),  qtystd=to_number(v_cur2.qtystd), order_min=to_number(v_cur2.order_min), ismultipleofminimumqty=v_cur2.ismultipleofminimumqty,
                                      UPDATEDBY=p_user,updated=now() 
                                where m_product_po_id=v_productpoid;
        end if;
        if v_uom is not null then
            if (select count(*) from m_product_uom where m_product_id=v_productid and c_uom_id= v_uom)=0 then
                insert into m_product_uom (ad_org_id, m_product_id,c_uom_id,m_product_uom_id,CREATED, CREATEDBY, UPDATED, UPDATEDBY,ad_client_id)
                       values(v_org, v_productid, v_uom,get_uuid(),now(),p_user,now(),p_user,v_client);
            end if;
        end if;
    v_uom:=null;
    v_manufacturer:=null;
    
    END LOOP;
    return v_i||' Lieferanten-Artikel importiert, davon '||v_ii||' Datensätze neu angelegt';  
END;
$_$  LANGUAGE 'plpgsql';



CREATE or replace FUNCTION  i_import_account(p_filename varchar,p_elementid varchar, p_withupdate varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_org character varying:='0';
v_account character varying;
v_cur2 RECORD;
 v_element c_elementvalue%ROWTYPE;
v_i numeric:=0;
v_count numeric;
v_cmd varchar;
v_oname varchar;
BEGIN
 if p_filename is null then return 'ERROR'; end if;
 create temporary table i_elementvalue as select * from c_elementvalue where c_element_id='';
  
  -- Datei in Tabelle
  v_cmd := 'COPY i_elementvalue  FROM ''/tmp/' || p_filename ||''' CSV DELIMITER as '||chr(39)||';'||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
 
    update i_elementvalue set c_element_id=p_elementid;
    if (select count(*) from c_element where c_element_id=p_elementid)=0 then
        return 'Konenrahmen existiert nicht';
    end if;
    update i_elementvalue set c_elementvalue_id=get_uuid();
    update i_elementvalue set value=lpad(value,4,'0') where length(value)<4;
    update c_elementvalue  set value=lpad(value,4,'0') where length(value)<4 and c_element_id= p_elementid;
    for v_cur2 in (select * from i_elementvalue )
    LOOP
       select c_elementvalue_id,name into v_account,v_oname from c_elementvalue where c_element_id= p_elementid and value=v_cur2.value;
       select * from i_elementvalue  into  v_element where  c_elementvalue_id=v_cur2.c_elementvalue_id;
       if v_account is null then
          insert into c_elementvalue select v_element.*;
       else
        if p_withupdate='Y' then
          update c_elementvalue set name=v_cur2.name,description=v_cur2.description where c_element_id= p_elementid and value=v_cur2.value;
        end if;
       end if;
       v_i:=v_i+1;
    END LOOP;
    drop table i_elementvalue;
    return v_i||' Konten  importiert.';  
END;
$_$  LANGUAGE 'plpgsql';


CREATE or replace FUNCTION  i_import_accounttrl(p_filename varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_org character varying:='0';
v_account character varying;
v_cur2 RECORD;
v_i numeric:=0;
v_count numeric;
v_cmd varchar;
v_oname varchar;
BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_accounttrlimport;
  -- Datei in Tabelle
  v_cmd := 'COPY i_accounttrlimport  FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||';'||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
 
    
    update i_accounttrlimport set accountno=lpad(accountno,4,'0') where length(accountno)<4;
    for v_cur2 in (select * from i_accounttrlimport)
    LOOP
       select c_elementvalue_id,name into v_account,v_oname from c_elementvalue where c_element_id=v_cur2.elementid_key and value=v_cur2.accountno;
       if v_account is not null then
        if (select count(*) from c_elementvalue_trl where c_elementvalue_id=v_account and ad_language=v_cur2.language and name!=v_oname)=0 then
            delete from C_ElementValue_Trl where C_ElementValue_ID=v_account and AD_Language=v_cur2.language;
            INSERT INTO C_ElementValue_Trl( C_ElementValue_Trl_ID, C_ElementValue_ID, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy, Name, IsTranslated)
            values (get_uuid(),v_account,v_cur2.language,v_client,v_org,'100','100',v_cur2.accounttext,'Y');
            v_i:=v_i+1;
        end if;
       end if;
    END LOOP;
    return v_i||' Konten Übersetzungen importiert.';  
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION  i_import_bwaprefstrl(p_filename varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_org character varying:='0';
v_account character varying;
v_cur2 RECORD;
v_i numeric:=0;
v_count numeric;
v_cmd varchar;
v_oname varchar;
BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_bwaprefstrlimport;
  -- Datei in Tabelle
  v_cmd := 'COPY i_bwaprefstrlimport  FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||';'||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
 
    if (select count(*) from zspr_bwaheader_trl where zspr_bwaheader_id='C91138D2EACC49A1809391E8159668AB' and ad_language='en_US')=0 and
        (select count(*) from zspr_bwaheader where zspr_bwaheader_id='C91138D2EACC49A1809391E8159668AB')=1 then
        INSERT INTO zspr_bwaheader_trl( zspr_bwaheader_trl_ID, zspr_bwaheader_ID, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy,
                    Name,headertext,subheadertext,footertext)
            values (get_uuid(),'C91138D2EACC49A1809391E8159668AB','en_US',v_client,v_org,'100','100',
                    'Assets','Provisional report assets (beta)',':','Sum assets');
    end if;
    if (select count(*) from zspr_bwaheader_trl where zspr_bwaheader_id='17C2A9EC04F64FAD8593E5FD762F2390' and ad_language='en_US')=0 and
        (select count(*) from zspr_bwaheader where zspr_bwaheader_id='17C2A9EC04F64FAD8593E5FD762F2390')=1 then
        INSERT INTO zspr_bwaheader_trl( zspr_bwaheader_trl_ID, zspr_bwaheader_ID, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy,
                    Name,headertext,subheadertext,footertext)
            values (get_uuid(),'17C2A9EC04F64FAD8593E5FD762F2390','en_US',v_client,v_org,'100','100',
                    'Liabilities and Shareholders’ Equity','Provisional report Liabilities and Shareholders’ Equity (beta)',':','Sum ');
    end if;
    if (select count(*) from zspr_bwaheader_trl where zspr_bwaheader_id='4B316936DD0F4C6E9E83CFDC642C3868' and ad_language='en_US')=0 and
        (select count(*) from zspr_bwaheader where zspr_bwaheader_id='4B316936DD0F4C6E9E83CFDC642C3868')=1 then
        INSERT INTO zspr_bwaheader_trl( zspr_bwaheader_trl_ID, zspr_bwaheader_ID, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy,
                    Name,headertext,subheadertext,footertext)
            values (get_uuid(),'4B316936DD0F4C6E9E83CFDC642C3868','en_US',v_client,v_org,'100','100',
                    'Profit and Loss Account (short version)','Profit and Loss Account',':','Annual profit / loss');
    end if;
    if (select count(*) from zspr_bwaheader_trl where zspr_bwaheader_id='7E29B8CED9B34DA1A9879750BB728AFA' and ad_language='en_US')=0 and
        (select count(*) from zspr_bwaheader where zspr_bwaheader_id='7E29B8CED9B34DA1A9879750BB728AFA')=1 then
        INSERT INTO zspr_bwaheader_trl( zspr_bwaheader_trl_ID, zspr_bwaheader_ID, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy,
                    Name,headertext,subheadertext,footertext)
            values (get_uuid(),'7E29B8CED9B34DA1A9879750BB728AFA','en_US',v_client,v_org,'100','100',
                    'Profit and Loss Account','Profit and Loss Account',':','Annual profit / loss');
    end if;
    if (select count(*) from zspr_bwaheader_trl where zspr_bwaheader_id='E9CBD78C18504A0AA7A9161E95DF3ADC' and ad_language='en_US')=0 and
        (select count(*) from zspr_bwaheader where zspr_bwaheader_id='E9CBD78C18504A0AA7A9161E95DF3ADC')=1 then
        INSERT INTO zspr_bwaheader_trl( zspr_bwaheader_trl_ID, zspr_bwaheader_ID, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy,
                    Name,headertext,subheadertext,footertext)
            values (get_uuid(),'E9CBD78C18504A0AA7A9161E95DF3ADC','en_US',v_client,v_org,'100','100',
                    'Turnover Tax','Turnover Tax',':','To discharge (+) / excess (-)');
    end if;
    for v_cur2 in (select * from i_bwaprefstrlimport)
    LOOP
       select zspr_bwaprefs_id,name into v_account,v_oname from zspr_bwaprefs where zspr_bwaheader_id=v_cur2.bwaheaderid_key and name=v_cur2.accounttext;
       if v_account is not null then
        if (select count(*) from zspr_bwaprefs_trl where zspr_bwaprefs_id=v_account and ad_language=v_cur2.language and name!=v_oname)=0 then
            delete from zspr_bwaprefs_trl where zspr_bwaprefs_id=v_account and ad_language=v_cur2.language;
            INSERT INTO zspr_bwaprefs_trl( zspr_bwaprefs_trl_ID, zspr_bwaprefs_id, AD_Language, AD_Client_ID, AD_Org_ID,CreatedBy, UpdatedBy, Name, IsTranslated)
            values (get_uuid(),v_account,v_cur2.language,v_client,v_org,'100','100',v_cur2.accounttext_trl,'Y');
            v_i:=v_i+1;
        end if;
       end if;
    END LOOP;
    return v_i||' Konten Übersetzungen importiert.';  
END;
$_$  LANGUAGE 'plpgsql';

--New Overview for Product Translation Imports

select zsse_DropView ('i_product_trl_v');
CREATE OR REPLACE VIeW i_product_trl_v as
select  t.M_PRODUCT_ID as m_product_id,
        t.m_product_trl_id as i_product_trl_v_id,
        t.m_product_trl_id as m_product_trl_id,
        t.ad_org_id as ad_org_id,
        p.value as value,
        t.name as name,
        t.description as description,
        t.documentnote as documentnote,
        ad_language as ad_language, 
        t.isactive as isactive,
        t.CREATEDBY, t.created, t.UPDATEDBY, t.updated,t.ad_client_id
        from m_product p left join m_product_trl t on t.m_product_id=p.m_product_id;
        
        
CREATE or replace FUNCTION  i_import_producttrl(p_filename varchar,p_user varchar, p_delimiter varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_masterproduct character varying;
v_trlproduct character varying;
v_newproduct character varying;
v_org character varying;
v_value character varying;
v_name character varying;
v_description character varying;
v_documentnote character varying;
v_lang character varying;
v_isactive character;
v_cur2 RECORD;
v_i numeric:=0;
v_u numeric:=0;
v_count numeric;
v_cmd varchar;

BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_producttrlimport;
  -- Datei in Tabelle
  v_cmd := 'COPY i_producttrlimport (Value,Name,Description,Documentnote,AD_Language) FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||p_delimiter||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
    for v_cur2 in (select * from i_producttrlimport)
    LOOP
       
v_masterproduct:=(select m_product_id from m_product where value=v_cur2.value);
v_trlproduct:=(select m_product_trl_id from m_product_trl where m_product_id=v_masterproduct and ad_language=v_cur2.ad_language);
v_org:='0';
v_name:=coalesce(v_cur2.name,'');
v_description:=coalesce(v_cur2.description,'');
v_documentnote:=coalesce(v_cur2.documentnote,'');
v_lang:=v_cur2.ad_language;
v_isactive:='Y';
       if (v_trlproduct is null ) then
            v_newproduct:=get_uuid();
            Insert into m_product_trl (
            m_product_trl_id,
            m_product_id,
            ad_language,
            ad_client_id,
            ad_org_id,
            isactive,
            created,
            createdBy,
            updated,
            updatedby,
            name,
            documentnote,
            IsTranslated,
            description)
            values(
            v_newproduct,
            v_masterproduct,
            v_lang,
            v_client,
            v_org,
            v_isactive,
            now(),
            p_user,
            now(),
            p_user,
            v_name,
            coalesce(v_documentnote,''),
            'Y',
            coalesce(v_description,''));
            v_i:=v_i+1;
       else
            update m_product_trl set updated=now(),updatedby=p_user,isactive=v_isactive,name=v_name,documentnote=v_documentnote,description=v_description,ad_org_id=v_org where m_product_trl_id=v_trlproduct and ad_language=v_lang;
            v_u:=v_u+1;
        end if;
    END LOOP;
    return v_i||' Artikelübersetzungen eingefügt. '||v_u||' Artikelübersetzungen aktualisiert.';  
END;
$_$  LANGUAGE 'plpgsql';

select zsse_DropView ('i_costing_v');
CREATE OR REPLACE VIeW i_costing_v as

  select a.m_product_id as m_product_id,a.datefrom as datefrom,(select value from m_product where m_product_id=a.m_product_id) as value,(select name from m_product where m_product_id=a.m_product_id) as name, m_costing_id as i_costing_v_id , cast('Y' as character(1)) as isactive,ad_org_id,ad_client_id,m_costing_id,created,createdby,updated,updatedby,dateto,ismanual,qty,price,cumqty,ispermanent,cost,isproduction,costtype 
      from m_costing, 
      (select m_product_id,max(datefrom) as datefrom from m_costing group by m_product_id) a
      where m_costing.m_product_id=a.m_product_id and a.datefrom=m_costing.datefrom;
      
CREATE or replace FUNCTION  i_import_costing(p_filename varchar,p_user varchar, p_delimiter varchar) RETURNS varchar
AS $_$
DECLARE

v_client character varying:='C726FEC915A54A0995C568555DA5BB3C';
v_count numeric;
v_cmd varchar;
v_masterproduct varchar;
v_u numeric:=0;
v_i numeric:=0;
v_cur2 RECORD;
v_date Date;

BEGIN
 if p_filename is null then return 'ERROR'; end if;
  delete from i_import_costing;
  -- Datei in Tabelle
  v_cmd := 'COPY i_import_costing (Org,productvalue,ProductName,costtype,datefrom,dateto, qty, price, cost, production, ismanual, ispermanent, isactive) FROM ''' || p_filename ||''' CSV DELIMITER as '||chr(39)||p_delimiter||chr(39)||' HEADER ;';
  RAISE notice '%', v_cmd;
  EXECUTE(v_cmd);
    for v_cur2 in (select * from i_import_costing)
    LOOP
       
v_masterproduct:=(select m_product_id from m_product where value=v_cur2.productvalue and name=v_cur2.productname);
select count(*) into v_count from m_costing where m_product_id=v_masterproduct and dateto::date = v_cur2.dateto::date and ad_org_id = (select ad_org_id from ad_org where name =v_cur2.Org) and (price=v_cur2.price or v_cur2.price is null);
    if v_count=0 then 

            Insert into m_costing (
            m_costing_id,
            created,
            createdby,
            updated,
            updatedby,
            ad_client_id,
            ad_org_id,
            m_product_id,
            datefrom,
            dateto,
            ismanual,
            qty,
            price,
            costtype,
            ispermanent,
            cost,
            isproduction)
            values(
            get_uuid(),
            now(),
            p_user,
            now(),
            p_user,
            v_client,
            (select ad_org_id from ad_org where name =v_cur2.Org),
            v_masterproduct,
            to_date(v_cur2.datefrom),
            to_date(v_cur2.dateto),
            v_cur2.ismanual,
            to_number(v_cur2.qty),
            to_number(v_cur2.price),
            v_cur2.costtype,
            v_cur2.ispermanent,
            to_number(v_cur2.cost),
            v_cur2.production);

           v_i:=v_i+1; 
           raise notice '%', v_masterproduct;
    else

	select datefrom::date into v_date from m_costing where m_product_id=v_masterproduct and dateto::date = v_cur2.dateto::date and ad_org_id = (select ad_org_id from ad_org where name =v_cur2.Org) and (price=v_cur2.price or v_cur2.price is null);

	    if v_date != v_cur2.datefrom::date then

		    update m_costing set updated=now(), dateto=to_date(v_cur2.datefrom), ismanual=v_cur2.ismanual,qty=to_number(v_cur2.qty),cost=to_number(v_cur2.cost),costtype=v_cur2.costtype,ispermanent=v_cur2.ispermanent where m_product_id=v_masterproduct and dateto::date = v_cur2.dateto::date and ad_org_id = (select ad_org_id from ad_org where name =v_cur2.Org) and price=v_cur2.price;

		    Insert into m_costing (
		    m_costing_id,
		    created,
		    createdby,
		    updated,
		    updatedby,
		    ad_client_id,
		    ad_org_id,
		    m_product_id,
		    datefrom,
		    dateto,
		    ismanual,
		    qty,
		    price,
		    costtype,
		    ispermanent,
		    cost,
		    isproduction)
		    values(
		    get_uuid(),
		    now(),
		    p_user,
		    now(),
		    p_user,
		    v_client,
		    (select ad_org_id from ad_org where name =v_cur2.Org),
		    v_masterproduct,
		    to_date(v_cur2.datefrom),
		    to_date(v_cur2.dateto),
		    v_cur2.ismanual,
		    to_number(v_cur2.qty),
		    to_number(v_cur2.price),
		    v_cur2.costtype,
		    v_cur2.ispermanent,
		    to_number(v_cur2.cost),
		    v_cur2.production);

		    v_i:=v_i+1; 
           	    v_u:=v_u+1; 

       	    end if;
    end if;
    
    END LOOP;
    return v_i||' Datensätze in Kalkulation eingefügt und '||v_u||' Datensätze aktualisiert.';  
END;
$_$  LANGUAGE 'plpgsql';

/*
create table i_import_costing(
Org character varying(250),
ProductName character varying(250),
productvalue character varying(250),
price character varying(250),
cost character varying(250),
costtype character varying(250),
datefrom character varying(250),
dateto character varying(250),
qty character varying(250),
production character varying(250),
ismanual character varying(250),
ispermanent character varying(250),
isactive character varying(250)
);*/
