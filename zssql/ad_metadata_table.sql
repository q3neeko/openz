0B45105EF7A64CBEA2B3B8711DB7CCCB	0	0	Y	2012-04-05 13:16:56.343242	100	2015-08-19 18:06:39.766518	100	ad_table_access	6	6	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF') and ad_table_id in (select ad_table_id from ad_table where ad_package_id in (select ad_package_id from ad_package where ad_module_id in (@selectedmodules@)))	0
1089969602E34D0A8969DF356376EECC	0	0	Y	2017-06-20 18:52:51.410931	100	2017-06-20 18:52:51.410931	100	ad_ref_gridcolumninstance	0	0	50	\N	0
110796241B134CAE8723CEC38F224E29	0	0	Y	2012-04-05 13:18:16.837036	100	2015-08-19 18:05:10.894395	100	ad_preference_access	10	10	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  and '0' in (@selectedmodules@)	0
124C3EE0CEE743D1967C8C3424A0B650	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:08:12.991867	100	ad_field	12	5015	1	ad_module_id in (@selectedmodules@)	0
15D280FC62D14B56B70A79C9A0EF242D	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:44:10.000271	100	ad_fieldgroup	14	2040	1	ad_module_id in (@selectedmodules@)	0
1CC76981EBED4046B50F7315EA43C4B8	0	0	Y	2012-04-05 13:14:13.354984	100	2015-08-19 18:05:20.101425	100	ad_role	1	1	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  and '0' in (@selectedmodules@)	0
1E12A56E8878406BA9DB7EBF38D7B6B2	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:44:46.470708	100	ad_message	19	2060	1	ad_module_id in (@selectedmodules@)	0
221080C45B5B461BAC29E5B39AB11D1A	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:46:02.237077	100	ad_module_trl	27	2095	1	ad_module_id in (@selectedmodules@)	0
289539F2A3B34D92B18A580953BB8A68	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 19:47:04.600946	100	ad_wf_node	48	5060	1	ad_workflow_id  in (select ad_workflow_id from ad_workflow where ad_module_id in (@selectedmodules@))	0
2B8322799A7B4C118D8EA1DF0A0C4C46	0	0	Y	2017-06-20 18:52:09.783427	100	2017-06-20 18:52:09.783427	100	ad_message_trl_instance	0	0	50	\N	0
2D5CC73CD24A4729B7D3EA681F68FD63	0	0	Y	2012-10-13 10:52:57.365997	100	2014-05-24 01:30:08.901873	100	ad_labellinkdispatcher	4	4030	1	ad_column_V_id in (select ad_column.ad_column_id from ad_column,ad_labellinkdispatcher where ad_column.ad_column_id=ad_labellinkdispatcher.ad_column_V_id and ad_column.ad_module_id in (@selectedmodules@))	0
3222E93F7B344FB98BB4646B13B41D4B	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 17:48:45.473527	100	ad_auxiliarinput	2	5005	1	ad_module_id in (@selectedmodules@)	0
32FC74EADD5C4AFEB76DF1E0BFE06D46	0	0	Y	2017-06-20 18:51:34.7815	100	2017-06-20 18:51:34.7815	100	ad_element_trl_instance	0	0	50	\N	0
35962F6C3E4A4D18AA83A3E8B843FCE4	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:03:55.773223	100	ad_process_para_trl	31	4030	1	ad_process_para_id in (select ad_process_para_id from ad_process_para  where ad_process_id in (select ad_process_id from ad_process  where ad_module_id in (@selectedmodules@)))	0
36E91E8C156F4FDC96691345FE1A0D3B	0	0	Y	2017-06-20 19:12:09.432621	100	2017-06-20 19:13:21.785146	100	AD_Role_Tabaccess	20	20	50	\N	0
395338646F7847928FB5949725FC1E2A	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:31:21.67203	100	ad_model_object_para	23	6010	1	ad_model_object_id  in (select ad_model_object_id from ad_model_object where ad_module_id in (@selectedmodules@))	0
3CE64EBE26484210942D6A9253025A40	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:31:15.105371	100	ad_model_object_mapping	22	6005	1	ad_model_object_id  in (select ad_model_object_id from ad_model_object where ad_module_id in (@selectedmodules@))	0
3F124CC7D06841E1B1246D6114030C1A	0	0	Y	2012-04-05 13:02:07.15243	100	2012-05-22 11:20:56.633235	100	ad_treenode	0	0	2	ad_tree_id='10'  and node_id in (select ad_menu_id from ad_menu where ad_module_id in (@selectedmodules@))	0
40ECD9D42F934408A5036A5F99633117	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:46:20.090897	100	ad_package	28	2100	1	ad_module_id in (@selectedmodules@)	0
457B7BD3BBA040F4ABBE57B4A914C96A	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 19:45:09.044435	100	ad_workflow	53	4070	1	ad_module_id in (@selectedmodules@)	0
4616B9712DAA487FB21D3E13B7C13684	0	0	Y	2012-01-13 16:05:38.508	tad	2012-04-18 16:55:41.171373	100	ad_task	44	1015	0	\N	0
462EF463762C4D8D86E752CFB8CC636D	0	0	Y	2017-06-21 14:48:37.945062	100	2017-06-21 14:49:11.350532	100	AD_Role_OrgAccess	5	5	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
480D920047664623A8BBA1331C132837	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:07:45.515725	100	ad_model_object	21	5010	1	ad_module_id in (@selectedmodules@)	0
4A85D1C7CA9D49BE881A994296402BAB	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 17:55:32.450371	100	ad_dataset_column	6	6020	1	ad_dataset_table_id in (select ad_dataset_table_id from ad_dataset_table where ad_dataset_id in (select ad_dataset_id from ad_dataset where ad_module_id in (@selectedmodules@)))	0
4D4DB0824F8548ECB037894BDEF03D34	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:29:16.467009	100	ad_wf_node_trl	49	5085	1	ad_wf_node_id in (select ad_wf_node_id from ad_wf_node where ad_workflow_id  in (select ad_workflow_id from ad_workflow where ad_module_id in (@selectedmodules@)))	0
4D5B345388204F5B8CFCA87AF869368E	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:46:58.996143	100	ad_reference	39	2115	1	ad_module_id in (@selectedmodules@)	0
4F05004238014554945D52D73265C334	0	0	Y	2017-06-20 18:53:06.636726	100	2017-06-20 18:53:06.636726	100	ad_ref_groupinstance	0	0	50	\N	0
517356B60C67427380A0456CC6474B2F	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 19:47:16.376172	100	ad_wf_nodenext	50	5070	1	ad_wf_node_id in (select ad_wf_node_id from ad_wf_node where ad_workflow_id  in (select ad_workflow_id from ad_workflow where ad_module_id in (@selectedmodules@)))	0
5275C9C53C9B428CA48532B33A533CCA	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:26:37.637474	100	ad_ref_search	36	5040	1	ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@))	0
53395DA7AD6C4AA68E7290A85F1DAB23	0	0	Y	2017-06-20 18:53:47.36399	100	2017-06-20 18:53:47.36399	100	ad_tab_instance	0	0	50	\N	0
534CEEB4F9344BBD82E2E0669143A350	0	0	Y	2017-06-20 18:53:59.748731	100	2017-06-20 18:53:59.748731	100	ad_tab_trl_instance	0	0	50	\N	0
538C3CEFE5E344ADB459B553EB5B5C7A	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 19:46:38.099298	100	ad_window_trl	52	6030	1	ad_window_id in (select ad_window_id from ad_window where ad_module_id in (@selectedmodules@))	0
59E0C34DE37D444292202CE51D7D7E84	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:42:45.536946	100	ad_callout	3	2010	1	ad_module_id in (@selectedmodules@)	0
5C1F0A58C7E04343A299AF219F6B8C85	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 14:18:20.910661	100	ad_textinterfaces_trl	46	3065	1	ad_textinterfaces_id in (select ad_textinterfaces_id from ad_textinterfaces where ad_module_id in (@selectedmodules@))	0
5E284CA7422945128EBC376F21C1391F	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 14:12:07.402468	100	ad_message_trl	20	3040	1	ad_message_id in (select ad_message_id from ad_message  where ad_module_id in (@selectedmodules@))	0
64954A7AF3A04CD8931159AF834FEA38	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:44:27.082098	100	ad_form	16	2050	1	ad_module_id in (@selectedmodules@)	0
66E8D1C449E0438592E889A384373F18	0	0	Y	2017-06-20 19:11:43.637545	100	2017-06-20 19:11:43.637545	100	ad_workflow_access	2	2	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
67C551253EDB469B982F93A729BBEBA0	0	0	Y	2012-09-10 09:53:15.835231	100	2012-09-10 09:53:50.34105	100	ad_ref_fieldcolumn	72	5120	1	ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@))	0
6C5F301E19A64D688178AD06F922CE5C	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:17:15.673992	100	ad_tab_trl	42	5020	1	ad_tab_id in (select ad_tab_id from ad_tab where ad_module_id in (@selectedmodules@))	0
7022F2E8A65F4BFB9CA5A23A9C1B8DDD	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:18:19.992042	100	ad_menu_trl	18	5095	1	ad_menu_id in (select ad_menu_id from ad_menu where ad_module_id in (@selectedmodules@))	0
702C5706BFF24F2D91526B2B60A1A1EF	0	0	Y	2017-06-20 18:54:57.92618	100	2017-06-20 18:54:57.92618	100	zsse_executeondeploy	0	0	50	isstandard='N'	0
7053E98DE56B42A3B82845990AA78212	0	0	Y	2012-07-09 16:53:50.717432	100	2012-07-09 17:02:30.573069	100	zsse_executeondeploy	1	1	1	isstandard='Y' and ad_module_id in (@selectedmodules@)	0
7265C6D95E434B90ACA5F6979579BD4A	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 19:39:50.752606	100	ad_val_rule	47	2130	1	ad_module_id in (@selectedmodules@)	0
73736B73555C451CA7FF62FAEB59046C	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:55:03.394839	100	ad_process_para	30	3015	1	ad_process_id in (select ad_process_id from ad_process  where ad_module_id in (@selectedmodules@))	0
74F5EBD728CF4ACD8FB18A3EFDED8828	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 14:59:09.408263	100	ad_table	43	4005	1	ad_package_id in (select ad_package_id from ad_package where ad_module_id in (@selectedmodules@))	0
797FEBADED8749D3BCAD52EE21016C06	0	0	Y	2017-06-20 18:53:20.255341	100	2017-06-20 18:53:20.255341	100	ad_ref_listinstance	0	0	50	\N	0
7A4FE37F4ED243928631F55C01423B58	0	0	Y	2017-06-20 18:51:01.318608	100	2017-06-20 18:51:01.318608	100	ad_field_trl_instance	0	0	50	\N	0
7D7CA5927E3B44CB8CAD1E4C94AC667A	0	0	Y	2012-04-04 09:35:05.623475	100	2012-04-10 11:07:59.707096	100	ad_metadata_table	0	1	-9	ad_module_id in (@selectedmodules@)	0
80A9801B4F18475F8D9D8C1FF6172724	0	0	Y	2012-04-05 13:15:59.660954	100	2015-08-19 18:06:49.996297	100	ad_window_access	3	3	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF') and ad_window_id in (select ad_window_id from ad_window where ad_module_id in (@selectedmodules@))	0
80CDBEAAE0194DAE95792A49C40D4174	0	0	Y	2012-09-04 16:28:11.847472	100	2012-09-04 16:30:03.192547	100	ad_ref_group	70	5100	1	ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@))	0
839476FC5D204C0F85B63283B6D936A8	0	0	Y	2017-06-20 19:12:18.681403	100	2017-06-20 19:13:31.529075	100	AD_Role_Tabaccess_Field	30	30	50	\N	0
8AEC1A824F5F4391A6AFDAD1057179E4	0	0	Y	2012-04-05 16:59:15.981466	100	2012-04-18 16:55:08.299804	100	ad_module_scriptorder	0	1008	1	ad_module_id in (@selectedmodules@)	0
8EE426D3117C4F91A76005A0D132CCB5	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:50:02.395397	100	ad_window	51	2135	1	ad_module_id in (@selectedmodules@)	0
941D2AD7925943E8A64C13C72C23386A	0	0	Y	2017-06-20 18:52:37.045762	100	2017-06-20 18:52:37.045762	100	ad_ref_fieldcolumninstance	0	0	50	\N	0
961AFE9CFAAD42B39E24919FCB1FC782	0	0	Y	2013-08-21 10:23:02.244065	100	2013-08-21 10:23:02.244065	100	ad_ref_radiogroup	73	5130	1	ad_ref_fieldcolumn_id in (select ad_ref_fieldcolumn_id from ad_ref_fieldcolumn where ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@)))	0
97D990987E784FB0A3ECAC8239AF30B4	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-18 16:55:49.670696	100	ad_exceptions	11	2030	0	\N	0
983B74A435144F6BB431F860281DAF93	0	0	Y	2012-01-05 11:03:21.915	tad	2017-03-09 12:56:50.127041	100	ad_ref_list	34	2120	1	ad_module_id in (@selectedmodules@)	0
99B604D427EF4A0390AD2CCB9717B932	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:56:56.662895	100	ad_fieldgroup_trl	15	3020	1	ad_fieldgroup_id in (select ad_fieldgroup_id from ad_fieldgroup  where ad_module_id in (@selectedmodules@))	0
9CB80A8CCBD443A5B8F165D3F9460C00	0	0	Y	2012-01-12 20:42:18.837	0	2012-04-04 09:35:15.348359	100	ad_module	24	1005	1	ad_module_id in (@selectedmodules@)	0
9D1FB480669B42049092E86AB9D8E816	0	0	Y	2012-10-11 15:04:06.366186	100	2012-10-11 15:07:44.994702	100	ad_toolbar	10	1000	1	ad_module_id in (@selectedmodules@)	0
9E674EBC808C4405A09AECE0297D4A76	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:36:37.919046	100	ad_workflow_trl	54	6030	1	ad_workflow_id  in (select ad_workflow_id from ad_workflow where ad_module_id in (@selectedmodules@))	0
9FE76B5B02FE4BFF9A2D27C0EADC3970	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:36:26.584693	100	ad_ref_search_column	37	6025	1	ad_ref_search_id in (select ad_ref_search_id from ad_ref_search where ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@)))	0
A16676823F8F4A6CA103E8BAD8425F44	0	0	Y	2012-04-05 13:15:17.137044	100	2015-08-19 18:06:58.62199	100	ad_workflow_access	2	2	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF') and ad_workflow_id in (select ad_workflow_id from ad_workflow where ad_module_id in (@selectedmodules@))	0
AB53CA1FCDAE474F93F5526ED08F4399	0	0	Y	2017-06-20 18:53:32.632058	100	2017-06-20 18:53:32.632058	100	ad_ref_listinstance_trl	0	0	50	\N	0
AD89759C3F0F483284DAC5499F24189F	0	0	Y	2017-06-20 19:10:38.729189	100	2017-06-20 19:10:50.066299	100	ad_table_access	6	6	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
AF25310420E246C494BAF058A32A9DB8	0	0	Y	2012-04-05 13:17:27.021821	100	2015-08-19 18:06:14.093334	100	ad_form_access	7	7	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF') and ad_form_id in (select ad_form_id from ad_form where ad_module_id in (@selectedmodules@))	0
B0B3AFC1F6B84A88A8E64A16F88564DD	0	0	Y	2012-01-17 13:30:23.43	tad	2012-04-04 15:29:36.792752	100	ad_menu	55	5090	1	ad_module_id in (@selectedmodules@)	0
B0EEBED282A04813B70CB0FF44D907A5	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-19 17:52:50.920937	100	ad_dataset_table	7	5030	1	ad_dataset_id in (select ad_dataset_id from ad_dataset where ad_module_id in (@selectedmodules@))	0
B6839D2782804504992635437AB5E7DF	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 14:13:31.873579	100	ad_process_trl	32	3045	1	ad_process_id in (select ad_process_id from ad_process  where ad_module_id in (@selectedmodules@))	0
B84A14F681A043FE869C113E3FD3152C	0	0	Y	2012-04-05 13:17:43.861077	100	2015-08-19 18:05:15.641934	100	ad_task_access	8	8	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  and '0' in (@selectedmodules@)	0
BA639228E1A04FFEACBC302C5FBF8070	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-18 16:55:54.603573	100	ad_ref_data_loaded	33	5035	0	\N	0
BAD81EFF6D48447BBFBAE6CEEA1CECB8	0	0	Y	2017-06-20 19:03:41.044814	100	2017-06-20 19:08:59.035575	100	ad_task_access	8	8	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
BBC298841F9E4E5C9B15A84C3CBC5029	0	0	Y	2012-09-04 16:28:43.292713	100	2012-09-04 16:32:23.541038	100	ad_ref_gridcolumn	71	5110	1	ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@)) or  ad_ref_group_id in (select ad_ref_group_id from ad_ref_group where ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@)))	0
BD7D2820AF7847CF84257A19AA0544F9	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:49:36.496605	100	ad_textinterfaces	45	2125	1	ad_module_id in (@selectedmodules@)	0
C152153CF6E74425B018ABA6930E5F6B	0	0	Y	2017-06-20 18:52:24.884697	100	2017-06-20 18:52:24.884697	100	ad_process_para_instance	0	0	50	\N	0
C489990A88DC4F6E8E7436B5A76719CE	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-10 11:06:47.275874	100	ad_dataset	5	2015	1	ad_module_id in (@selectedmodules@)	0
C7BE1C16D4754B15A82404F6E6F5775F	0	0	Y	2017-06-20 19:08:16.922724	100	2017-06-20 19:14:00.656645	100	ad_form_access	7	7	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
C97807FCE3FE43E1A1E496BF0BED15D4	0	0	Y	2012-01-05 11:03:21.915	tad	2014-11-06 19:26:14.02185	100	ad_tab	41	4025	1	ad_module_id in (@selectedmodules@)	0
CA486D80231845CBA502C4C6B8C06B12	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-05 12:34:33.784935	100	ad_column	4	4020	1	ad_module_id in (@selectedmodules@)	0
CC0E47D6432E4FF486328F0149630B0B	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-18 16:55:57.908073	100	ad_attachment	1	5025	0	\N	0
CD2769C26BCA45D48B787A610FC29D19	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 14:16:29.11819	100	ad_ref_list_trl	35	3050	1	ad_ref_list_id in (select ad_ref_list_id from ad_ref_list  where ad_module_id in (@selectedmodules@))	0
CE568C509D2C414DB3DAB045E41444B1	0	0	Y	2012-04-05 11:08:55.945076	100	2012-04-19 20:30:31.03628	100	ad_module_sql	1	1	10	ad_module_id in (@selectedmodules@)	0
CF2DDF2A6FDB414295D5D9BECAB2EB25	0	0	Y	2017-06-20 19:00:08.995578	100	2017-06-20 19:00:08.995578	100	ad_preference_access	10	10	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')	0
D637C261E4B2450C828C6077980CC54B	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:27:08.699432	100	ad_ref_table	38	5045	1	ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@))	0
D9B734B587C34295B4F88366DB23CF95	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:45:14.728685	100	ad_module_dbprefix	25	2070	1	ad_module_id in (@selectedmodules@)	0
D9C7EEFED9724887B971A86D5D0C14F8	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:43:16.811067	100	ad_element	9	2025	1	ad_module_id in (@selectedmodules@)	0
DA102956448A463BBC1BE248104C647E	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 15:32:44.131478	100	ad_field_trl	13	6015	1	ad_field_id in (select ad_field_id from ad_field  where ad_module_id in (@selectedmodules@))	0
DA55F5B3291641B3B114ADECF40DAB62	0	0	Y	2017-06-20 19:10:09.427575	100	2017-06-20 19:10:09.427575	100	ad_process_access	9	9	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
DB3000E6E9C6479B85C956E214B4E863	0	0	Y	2017-06-20 18:50:42.975622	100	2017-06-20 18:50:42.975622	100	ad_fieldinstance	0	0	50	\N	0
DBB1D7A7BEEE4B00B06A98F6151FD88B	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:58:29.877052	100	ad_form_trl	17	3025	1	ad_form_id in (select ad_form_id from ad_form  where ad_module_id in (@selectedmodules@))	0
E20C2196DB7D42CE973657BA07C69885	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:45:58.056173	100	ad_module_dependency	26	2080	1	ad_module_id in (@selectedmodules@)	0
E4955AFEB85B4C939EC09FD043D0CA3F	0	0	Y	2012-10-11 15:09:14.31204	100	2012-10-11 15:09:14.31204	100	ad_toolbaritems	11	1010	1	ad_toolbar_id in (select ad_toolbar_id from ad_toolbar where ad_module_id in (@selectedmodules@))	0
E5AF969B87E146BCA7BFB7454151FE45	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 14:16:57.582501	100	ad_reference_trl	40	3060	1	ad_reference_id in (select ad_reference_id from ad_reference where ad_module_id in (@selectedmodules@))	0
E629D69B26744749ACDE465AF7F00395	0	0	Y	2012-04-05 13:18:02.548428	100	2015-08-19 18:06:29.485774	100	ad_process_access	9	9	2	ad_role_id IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF') and ad_process_id in (select ad_process_id from ad_process where ad_module_id in (@selectedmodules@))	0
E7C33A52F8444585875A6C38E132E436	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:41:09.761536	100	ad_datatype	8	1010	1	ad_module_id in (@selectedmodules@)	0
EAF45E9A5F564B638A8550978EFF9BAC	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:46:46.041733	100	ad_process	29	2105	1	ad_module_id in (@selectedmodules@)	0
EC93F449C968485F9827564E1CA7FFDA	0	0	Y	2017-06-20 19:11:15.622337	100	2017-06-20 19:11:15.622337	100	ad_window_access	3	3	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
F26C2989623C4AEF8CD54CC9A1DBC84E	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-18 16:56:00.797322	100	ad_task_trl	44	2140	0	\N	0
F3374B7F4FE74A9CBE2482B2C8693829	0	0	Y	2017-06-20 18:59:51.492388	100	2017-06-20 18:59:51.492388	100	ad_role	1	1	50	ad_role_id NOT IN ('32BB190E7B4846E8AA0F1847BD4444BE','0','80B12F63EE224C6CB6975132A3163AAF')  	0
F5DA465329374F88BA1C9F7B229F75F3	0	0	Y	2012-01-05 11:03:21.915	tad	2012-04-04 09:53:18.091311	100	ad_element_trl	10	3010	1	ad_element_id in (select ad_element_id from ad_element  where ad_module_id in (@selectedmodules@))	0
FBA372152D8C4CF9807C8C4BCBF2532D	0	0	Y	2017-06-20 18:51:52.68295	100	2017-06-20 18:51:52.68295	100	ad_menu_trl_instance	0	0	50	\N	0
