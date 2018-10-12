/**
* 事件类型
*/
public interface EventType { 
   /**
    * 婚恋家庭纠纷
    */
   String MARRIAGE_FAMILY_DISPUTES = "01";
   /**
    * 邻里纠纷
    */
   String NEIGHBOURHOOD_DISPUTE = "02";
   /**
    * 人格权纠纷
    */
   String PERSONALITY_RIGHT_DISPUTE = "03";
   /**
    * 物权相关纠纷
    */
   String DISPUTES_CONCERNING_PROPERTY_RIGHTS = "04";
   /**
    * 侵权相关纠纷
    */
   String INFRINGEMENT_RELATED_DISPUTES = "05";
   /**
    * 合同及相关纠纷
    */
   String CONTRACTS_RELATED_DISPUTES = "06";
   /**
    * 劳动人事争议
    */
   String LABOR_PERSONNEL_DISPUTES = "07";
   /**
    * 金融借贷纠纷
    */
   String FINANCIAL_LENDING_DISPUTES = "08";
   /**
    * 土地及资源权属纠纷
    */
   String DISPUTES_OVER_LAND_RESOURCES_OWNERSHIP = "09";
   /**
    * 其他民商事纠纷
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES = "10";
   /**
    * 城乡建设发展纠纷
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES = "11";
   /**
    * 涉民政纠纷
    */
   String DISPUTES_INVOLVING_CIVIL_ADMINISTRATION = "12";
   /**
    * 其他行政执法纠纷
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES = "13";
   /**
    * 涉法涉诉纠纷
    */
   String DISPUTES_INVOLVING_LAW_LITIGATION = "14";
   /**
    * 涉组织涉纪检纠纷
    */
   String DISPUTES_INVOLVING_DISCIPLINE_INSPECTION_INVOLVING_ORGANIZATIONS = "15";
   /**
    * 涉民族宗教纠纷
    */
   String ETHNIC_RELIGIOUS_DISPUTES = "16";
   /**
    * 其他
    */
   String OTHER = "99";
   /**
    * 婚恋家庭纠纷-恋爱及婚姻
    */
   String MARRIAGE_FAMILY_DISPUTES_LOVE_MARRIAGE = "0101";
   /**
    * 婚恋家庭纠纷-抚养赡养监护
    */
   String MARRIAGE_FAMILY_DISPUTES_MAINTENANCE_CARE = "0102";
   /**
    * 婚恋家庭纠纷-分家与继承
    */
   String MARRIAGE_FAMILY_DISPUTES_SEPARATION_INHERITANCE = "0103";
   /**
    * 婚恋家庭纠纷-其他
    */
   String MARRIAGE_FAMILY_DISPUTES_OTHER = "0199";
   /**
    * 邻里纠纷-用水排水通行通风采光
    */
   String NEIGHBOURHOOD_DISPUTE_WATER_DRAINAGE_VENTILATION_LIGHTING = "0201";
   /**
    * 邻里纠纷-相邻土地建筑利用
    */
   String NEIGHBOURHOOD_DISPUTE_ADJACENT_LAND_CONSTRUCTION = "0202";
   /**
    * 邻里纠纷-相邻污染损害防止
    */
   String NEIGHBOURHOOD_DISPUTE_ADJACENT_POLLUTION_DAMAGE_PREVENTION = "0203";
   /**
    * 邻里纠纷-其他
    */
   String NEIGHBOURHOOD_DISPUTE_OTHER = "0299";
   /**
    * 人格权纠纷-姓名肖像
    */
   String PERSONALITY_RIGHT_DISPUTE_NAME_PORTRAITS = "0301";
   /**
    * 人格权纠纷-名誉隐私
    */
   String PERSONALITY_RIGHT_DISPUTE_REPUTATION_PRIVACY = "0302";
   /**
    * 人格权纠纷-身体健康及人身自由
    */
   String PERSONALITY_RIGHT_DISPUTE_PHYSICAL_HEALTH_PERSONAL_FREEDOM = "0303";
   /**
    * 人格权纠纷-其他
    */
   String PERSONALITY_RIGHT_DISPUTE_OTHER = "0399";
   /**
    * 物权相关纠纷-财物返还及损害赔偿
    */
   String DISPUTES_CONCERNING_PROPERTY_RIGHTS_PROPERTY_RESTITUTION_DAMAGE_COMPENSATION = "0401";
   /**
    * 物权相关纠纷-物业及其管理
    */
   String DISPUTES_CONCERNING_PROPERTY_RIGHTS_PROPERTY_ITS_MANAGEMENT = "0402";
   /**
    * 物权相关纠纷-房屋等不动产登记
    */
   String DISPUTES_CONCERNING_PROPERTY_RIGHTS_HOUSING_OTHER_REAL_ESTATE_REGISTRATION = "0403";
   /**
    * 物权相关纠纷-其他
    */
   String DISPUTES_CONCERNING_PROPERTY_RIGHTS_OTHER = "0499";
   /**
    * 侵权相关纠纷-教育机构
    */
   String INFRINGEMENT_RELATED_DISPUTES_EDUCATIONAL_SERVICES = "0501";
   /**
    * 侵权相关纠纷-医疗损害
    */
   String INFRINGEMENT_RELATED_DISPUTES_MEDICAL_DAMAGE = "0502";
   /**
    * 侵权相关纠纷-交通事故
    */
   String INFRINGEMENT_RELATED_DISPUTES_TRAFFIC_ACCIDENT = "0503";
   /**
    * 侵权相关纠纷-环境污染
    */
   String INFRINGEMENT_RELATED_DISPUTES_ENVIRONMENTAL_POLLUTION = "0504";
   /**
    * 侵权相关纠纷-产品责任
    */
   String INFRINGEMENT_RELATED_DISPUTES_PRODUCT_LIABILITY = "0505";
   /**
    * 侵权相关纠纷-网络侵权
    */
   String INFRINGEMENT_RELATED_DISPUTES_NETWORK_INFRINGEMENT = "0506";
   /**
    * 侵权相关纠纷-劳务损害
    */
   String INFRINGEMENT_RELATED_DISPUTES_LABOR_DAMAGE = "0507";
   /**
    * 侵权相关纠纷-其他
    */
   String INFRINGEMENT_RELATED_DISPUTES_OTHER = "0599";
   /**
    * 合同及相关纠纷-消费及服务
    */
   String CONTRACTS_RELATED_DISPUTES_CONSUMPTION_SERVICES = "0601";
   /**
    * 合同及相关纠纷-房产买卖租赁
    */
   String CONTRACTS_RELATED_DISPUTES_REAL_ESTATE_SALE_LEASE = "0602";
   /**
    * 合同及相关纠纷-交易贸易
    */
   String CONTRACTS_RELATED_DISPUTES_TRADE_TRADE = "0603";
   /**
    * 合同及相关纠纷-运输仓储
    */
   String CONTRACTS_RELATED_DISPUTES_TRANSPORTATION_STORAGE = "0604";
   /**
    * 合同及相关纠纷-其他
    */
   String CONTRACTS_RELATED_DISPUTES_OTHER = "0699";
   /**
    * 劳动人事争议-劳动合同、劳务派遣
    */
   String LABOR_PERSONNEL_DISPUTES_LABOR_CONTRACT = "0701";
   /**
    * 劳动人事争议-社会保险
    */
   String LABOR_PERSONNEL_DISPUTES_SOCIAL_INSURANCE = "0702";
   /**
    * 劳动人事争议-福利待遇
    */
   String LABOR_PERSONNEL_DISPUTES_FRINGE_BENEFITS = "0703";
   /**
    * 劳动人事争议-人事争议
    */
   String LABOR_PERSONNEL_DISPUTES_PERSONNEL_DISPUTE = "0704";
   /**
    * 劳动人事争议-其他
    */
   String LABOR_PERSONNEL_DISPUTES_OTHER = "0799";
   /**
    * 金融借贷纠纷-证券基金期货
    */
   String FINANCIAL_LENDING_DISPUTES_SECURITIES_FUND_FUTURES = "0801";
   /**
    * 金融借贷纠纷-投资信托理财
    */
   String FINANCIAL_LENDING_DISPUTES_INVESTMENT_TRUST_FINANCING = "0802";
   /**
    * 金融借贷纠纷-保险
    */
   String FINANCIAL_LENDING_DISPUTES_INSURANCE = "0803";
   /**
    * 金融借贷纠纷-借贷及担保
    */
   String FINANCIAL_LENDING_DISPUTES_LOAN_GUARANTEE = "0804";
   /**
    * 金融借贷纠纷-其他
    */
   String FINANCIAL_LENDING_DISPUTES_OTHER = "0899";
   /**
    * 土地及资源权属纠纷-土地承包经营
    */
   String DISPUTES_OVER_LAND_RESOURCES_OWNERSHIP_LAND_CONTRACT_MANAGEMENT = "0901";
   /**
    * 土地及资源权属纠纷-宅基地使用
    */
   String DISPUTES_OVER_LAND_RESOURCES_OWNERSHIP_HOMESTEAD_USE = "0902";
   /**
    * 土地及资源权属纠纷-山林矿产
    */
   String DISPUTES_OVER_LAND_RESOURCES_OWNERSHIP_MOUNTAIN_FOREST_MINERAL = "0903";
   /**
    * 土地及资源权属纠纷-水域水利
    */
   String DISPUTES_OVER_LAND_RESOURCES_OWNERSHIP_WATER_WATER_CONSERVANCY = "0904";
   /**
    * 土地及资源权属纠纷-其他
    */
   String DISPUTES_OVER_LAND_RESOURCES_OWNERSHIP_OTHER = "0999";
   /**
    * 其他民商事纠纷-知识产权
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_INTELLECTUAL_PROPERTY_RIGHT = "1001";
   /**
    * 其他民商事纠纷-公司企业设立解敬
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_COMPANY_ESTABLISHMENT = "1002";
   /**
    * 其他民商事纠纷-海事海商
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_MARITIME_MARITIME_MERCHANT = "1003";
   /**
    * 其他民商事纠纷-竞争纠纷
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_COMPETITION_DISPUTE = "1004";
   /**
    * 其他民商事纠纷-票据与信用证
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_CREDIT_BILL_LETTER = "1005";
   /**
    * 其他民商事纠纷-无因管理与不当得利
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_NO_CAUSE_MANAGEMENT_UNJUST_ENRICHMENT = "1006";
   /**
    * 其他民商事纠纷-其他
    */
   String OTHER_CIVIL_COMMERCIAL_DISPUTES_OTHER = "1099";
   /**
    * 城乡建设发展纠纷-国有土地上房屋征收
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES_HOUSING_LEVY_ON_STATE_OWNED_LAND = "1101";
   /**
    * 城乡建设发展纠纷-农村集体土地征用
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES_RURAL_COLLECTIVE_LAND_REQUISITION = "1102";
   /**
    * 城乡建设发展纠纷-城乡规划及拆违
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES_URBAN_RURAL_PLANNING_DEMOLITION = "1103";
   /**
    * 城乡建设发展纠纷-基础设施建设及市政市容
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES_INFRASTRUCTURE_CITYSCAPE = "1104";
   /**
    * 城乡建设发展纠纷-移民安置
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES_RESETTLEMENT = "1105";
   /**
    * 城乡建设发展纠纷-其他
    */
   String URBAN_RURAL_CONSTRUCTION_DEVELOPMENT_DISPUTES_OTHER = "1199";
   /**
    * 涉民政纠纷-村(社区)选举和管理
    */
   String DISPUTES_INVOLVING_CIVIL_ADMINISTRATION_VILLAGE_ELECTION_MANAGEMENT = "1201";
   /**
    * 涉民政纠纷-优抚救助
    */
   String DISPUTES_INVOLVING_CIVIL_ADMINISTRATION_PREFERENTIAL_TREATMENT = "1202";
   /**
    * 涉民政纠纷-区划边界
    */
   String DISPUTES_INVOLVING_CIVIL_ADMINISTRATION_ZONING_BOUNDARY = "1203";
   /**
    * 涉民政纠纷-其他
    */
   String DISPUTES_INVOLVING_CIVIL_ADMINISTRATION_OTHER = "1299";
   /**
    * 其他行政执法纠纷-城市管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_CITY_MANAGEMENT = "1301";
   /**
    * 其他行政执法纠纷-教育文体管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_EDUCATION_STYLE_MANAGEMENT = "1302";
   /**
    * 其他行政执法纠纷-工商税务管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_INDUSTRIAL_COMMERCIAL_TAX_ADMINISTRATION = "1303";
   /**
    * 其他行政执法纠纷-安全生产管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_SAFETY_PRODUCTION_MANAGEMENT = "1304";
   /**
    * 其他行政执法纠纷-交通运输管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_TRAFFIC_TRANSPORTATION_MANAGEMENT = "1305";
   /**
    * 其他行政执法纠纷-海事渔事管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_MARITIME_FISHERY_MANAGEMENT = "1306";
   /**
    * 其他行政执法纠纷-计划生育管理
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_FAMILY_PLANNING_MANAGEMENT = "1307";
   /**
    * 其他行政执法纠纷-其他
    */
   String OTHER_ADMINISTRATIVE_LAW_ENFORCEMENT_DISPUTES_OTHER = "1399";
   /**
    * 涉法涉诉纠纷-涉公安
    */
   String DISPUTES_INVOLVING_LAW_LITIGATION_INVOLVING_PUBLIC_SECURITY = "1401";
   /**
    * 涉法涉诉纠纷-涉检察院
    */
   String DISPUTES_INVOLVING_LAW_LITIGATION_PROCURATORATE = "1402";
   /**
    * 涉法涉诉纠纷-涉法院
    */
   String DISPUTES_INVOLVING_LAW_LITIGATION_LAW_COURT = "1403";
   /**
    * 涉法涉诉纠纷-涉司法行政机关
    */
   String DISPUTES_INVOLVING_LAW_LITIGATION_JUDICIAL_ADMINISTRATION_ORGANS_CONCERNED = "1404";
   /**
    * 涉组织涉纪检纠纷-组织人事
    */
   String DISPUTES_INVOLVING_DISCIPLINE_INSPECTION_INVOLVING_ORGANIZATIONS_ORGANIZATION_PERSONNEL = "1501";
   /**
    * 涉组织涉纪检纠纷-干部作风
    */
   String DISPUTES_INVOLVING_DISCIPLINE_INSPECTION_INVOLVING_ORGANIZATIONS_CADRES_WORK_STYLE = "1502";
   /**
    * 涉组织涉纪检纠纷-其他
    */
   String DISPUTES_INVOLVING_DISCIPLINE_INSPECTION_INVOLVING_ORGANIZATIONS_OTHER = "1599";
   /**
    * 涉民族宗教纠纷-涉民族问题
    */
   String ETHNIC_RELIGIOUS_DISPUTES_ETHNIC_ISSUES = "1601";
   /**
    * 涉民族宗教纠纷-涉宗教问题
    */
   String ETHNIC_RELIGIOUS_DISPUTES_RELIGIOUS_ISSUES = "1602";
 } 
