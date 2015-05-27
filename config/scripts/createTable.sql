CREATE TABLE BANK.T_MENU_PRIVILEGE (
  PKID	VARCHAR(40)	NOT NULL,
  ROLE_ID	VARCHAR(40),
  MENU_ID	VARCHAR(40),
  PRIVILEGE_ID	VARCHAR(40)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_MENU_PRIVILEGE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMIT;

RUNSTATS ON TABLE BANK.T_MENU_PRIVILEGE
	ALLOW WRITE ACCESS;

RUNSTATS ON TABLE BANK.T_ORGAN
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_PRIVILEGE (
  PRIVILEGE_ID	VARCHAR(40)	NOT NULL,
  PRIVILEGE_TYPE	VARCHAR(40)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_PRIVILEGE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMIT;

RUNSTATS ON TABLE BANK.T_PRIVILEGE
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_ROLE (
  ROLE_ID	VARCHAR(40)	NOT NULL,
  ROLE_DESCR	VARCHAR(200),
  ROLE_NAME	VARCHAR(40)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_ROLE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMIT;

RUNSTATS ON TABLE BANK.T_ROLE
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_SYS_MENU (
  MENU_ID	INTEGER	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  MENU_DESCR	VARCHAR(200),
  MENU_URL	VARCHAR(400),
  MENU_PID	INTEGER,
  MENU_NAME	VARCHAR(40),
  ISLEAF	CHARACTER(10),
  ISSYSTEM	CHARACTER(10),
  SEQ	INTEGER
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_SYS_MENU
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMIT;

RUNSTATS ON TABLE BANK.T_SYS_MENU
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_USER (
  USER_ID	VARCHAR(40)	NOT NULL,
  USER_NAME	VARCHAR(40),
  PASSWORD	VARCHAR(40),
  SEX	INTEGER,
  BIRTHDAY	DATE,
  ADDRESS	VARCHAR(100),
  ORGAN_ID	VARCHAR(40),
  USER_CNNAME	VARCHAR(40)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_USER
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_USER ( 
	USER_ID IS '用户ID',
	USER_NAME IS '用户名',
	USER_CNNAME IS '员工姓名' );

COMMIT;

RUNSTATS ON TABLE BANK.T_USER
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_USER_ROLE (
  USER_ID	VARCHAR(40)	NOT NULL,
  ROLE_ID	VARCHAR(40)	NOT NULL
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_USER_ROLE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMIT;

RUNSTATS ON TABLE BANK.T_USER_ROLE
	ALLOW WRITE ACCESS;
	
CREATE TABLE BANK.T_ORGAN (
  ORGAN_ID	VARCHAR(40)	NOT NULL,
  ORGAN_NAME	VARCHAR(40),
  ORGAN_PID	VARCHAR(40),
  ORGAN_SHORT	VARCHAR(40)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_ORGAN
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMIT;

RUNSTATS ON TABLE BANK.T_ORGAN
	ALLOW WRITE ACCESS;
	
CREATE TABLE BANK.T_COOPERATION (
  COOPERATIONID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  COOPERATIONNAME	VARCHAR(80),
  ORGACODE	VARCHAR(10),
  TAXCODE	VARCHAR(35),
  REGISTERADDRESS	VARCHAR(80),
  MAILADDRESS	VARCHAR(80),
  REGISTERDATE	DATE,
  REGISTERCAPITAL	VARCHAR(30),
  REALCAPITAL	VARCHAR(30),
  LEGALPERSON	VARCHAR(50),
  IDNUM	VARCHAR(20),
  PHONE	VARCHAR(15),
  MEMBERS	INTEGER,
  BUSINESSCOPE	VARCHAR(100),
  BUSINESSAREA	INTEGER,
  FARMERS	INTEGER,
  CONNECTIONBASE	VARCHAR(10),
  RECORDER	VARCHAR(10),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COOPERATION
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_COOPERATION ( 
	COOPERATIONID IS '农民专业经济合作组织表主键',
	COOPERATIONNAME IS '农民专业经济合作组织名称',
	ORGACODE IS '组织机构编号',
	TAXCODE IS '税务登记号',
	REGISTERADDRESS IS '注册地址',
	MAILADDRESS IS '通信地址',
	REGISTERDATE IS '注册时间',
	REGISTERCAPITAL IS '注册资本',
	REALCAPITAL IS '实收资本',
	LEGALPERSON IS '法定代表人',
	IDNUM IS '身份证号',
	PHONE IS '联系电话',
	MEMBERS IS '社员人数',
	BUSINESSCOPE IS '经营范围',
	BUSINESSAREA IS '经营场地面积',
	FARMERS IS '带动农户(户)',
	CONNECTIONBASE IS '连接基地',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COOPERATION
	ALLOW WRITE ACCESS;
CREATE TABLE BANK.T_COOPERATION_DEBT (
  DEBTID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  COOPERATIONNAME	VARCHAR(10),
  ORGANCODE	VARCHAR(10),
  CASHCAPITAL	VARCHAR(20),
  SHORTINVEST	VARCHAR(20),
  RECEIVABLES	VARCHAR(20),
  PREPAYMENT	VARCHAR(20),
  INVENTORY	VARCHAR(20),
  FLOATASSET	VARCHAR(10),
  FLOATASSETALL	VARCHAR(20),
  FIXEDASSET	VARCHAR(20),
  DEPRECICATION	VARCHAR(20),
  NETVALUE	VARCHAR(20),
  BUILDINGPROJECT	VARCHAR(20),
  FIXEDASSETALL	VARCHAR(20),
  INVISIBLEASSET	VARCHAR(20),
  ASSETALL	VARCHAR(20),
  SHORTLOAN	VARCHAR(20),
  BANKLOAN	VARCHAR(20),
  ACCOUNTSPAYABLE	VARCHAR(20),
  DEPOSITRECEIVED	VARCHAR(20),
  UNPAIDTAX	VARCHAR(20),
  FLOATDEBT	VARCHAR(20),
  FLOATDEBTALL	VARCHAR(20),
  LONGDEBTALL	VARCHAR(20),
  REGISTERCAPITAL	VARCHAR(20),
  REALCAPITAL	VARCHAR(20),
  CAPITALRESERVE	VARCHAR(20),
  SURPLUSRESERVE	VARCHAR(20),
  UNALLOTPROFIT	VARCHAR(20),
  TOTALEQUITY	VARCHAR(20),
  TOTALEQUITY1	VARCHAR(20),
  HANDINGCOST	VARCHAR(20),
  FINANCIALCOST	VARCHAR(20),
  INTERESTEXPENSE	VARCHAR(20),
  BUSINESSPROFIT	VARCHAR(20),
  INVESTINCOME	VARCHAR(20),
  SUBSIDYINCOME	VARCHAR(20),
  UNBUSINESSINCOME	VARCHAR(20),
  UNBUSINESSEXPENSE	VARCHAR(20),
  PROFITLOSS	VARCHAR(20),
  TOTALPROFIT	VARCHAR(20),
  PAYABLEINCOMETAX	VARCHAR(20),
  PAYABLEADDEDTAX	VARCHAR(20),
  PAIDADDEDTAX	VARCHAR(20),
  NETPROFIT	VARCHAR(20),
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COOPERATION_DEBT
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_COOPERATION_DEBT ( 
	DEBTID IS '农村经济合作组织资产负债表主键',
	COOPERATIONNAME IS '农村经济合作组织名称',
	ORGANCODE IS '组织机构编码',
	CASHCAPITAL IS '货币资金',
	SHORTINVEST IS '短期投资',
	RECEIVABLES IS '应收账款',
	PREPAYMENT IS '预付账款',
	INVENTORY IS '存货',
	FLOATASSET IS '其他流动资产',
	FLOATASSETALL IS '流动资产合计',
	FIXEDASSET IS '固定资产原价',
	DEPRECICATION IS '其中折旧',
	NETVALUE IS '固定资产净值',
	BUILDINGPROJECT IS '在建项目',
	FIXEDASSETALL IS '固定资产合计',
	INVISIBLEASSET IS '无形及递延资产合计',
	ASSETALL IS '资产合计',
	SHORTLOAN IS '短期借款',
	BANKLOAN IS '银行借款',
	ACCOUNTSPAYABLE IS '应付账款',
	DEPOSITRECEIVED IS '预收账款',
	UNPAIDTAX IS '未缴税金',
	FLOATDEBT IS '其他流动负债',
	FLOATDEBTALL IS '流动负债合计',
	LONGDEBTALL IS '长期负债合计',
	REGISTERCAPITAL IS '注册资本',
	REALCAPITAL IS '实收资本',
	CAPITALRESERVE IS '资本公积',
	SURPLUSRESERVE IS '盈余公积',
	UNALLOTPROFIT IS '未分配利润',
	TOTALEQUITY IS '所有者权益合计',
	TOTALEQUITY1 IS '负债和所有者权益合计',
	HANDINGCOST IS '管理费用',
	FINANCIALCOST IS '财务费用',
	INTERESTEXPENSE IS '其中利息支出',
	BUSINESSPROFIT IS '营业利润',
	INVESTINCOME IS '投资收益',
	SUBSIDYINCOME IS '国家补贴收入',
	UNBUSINESSINCOME IS '营业外收入',
	UNBUSINESSEXPENSE IS '营业外支出',
	PROFITLOSS IS '以前年度损益调整',
	TOTALPROFIT IS '利润总和',
	PAYABLEINCOMETAX IS '应交所得税',
	PAYABLEADDEDTAX IS '应交增值税',
	PAIDADDEDTAX IS '实交增值税',
	NETPROFIT IS '利润净额',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COOPERATION_DEBT
	ALLOW WRITE ACCESS;


CREATE TABLE BANK.T_FARMER (
  FARMERID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERNAME	VARCHAR(20),
  FARMERIDNUM	VARCHAR(30)	NOT NULL,
  POLITICSTATUS	INTEGER,
  FAMILYNUM	INTEGER,
  PHONE	VARCHAR(200),
  ADDRESS	VARCHAR(500),
  MARRYSTATUS	VARCHAR(10),
  LABORNUM	INTEGER,
  POSTCODE	INTEGER,
  NYNETINCOME	DOUBLE,
  FNNETINCOME	DOUBLE,
  GSNETINCOME	DOUBLE,
  DGNETINCOME	DOUBLE,
  QTNETINCOME	DOUBLE,
  ALLNETINCOME	DOUBLE,
  RECORDER	VARCHAR(15),
  RECORDTIME	TIMESTAMP(12),
  EDUCATION	INTEGER,
  EDUCATION1	VARCHAR(50),
  SEX	INTEGER,
  SEX1	VARCHAR(10),
  IDTYPE	VARCHAR(50),
  CLIENTTYPE	VARCHAR(50),
  OCCUPATION	VARCHAR(50),
  VILLAGES	VARCHAR(50)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER ( 
	FARMERID IS '农户基本信息表主键',
	FARMERNAME IS '农户姓名',
	FARMERIDNUM IS '身份证编号',
	POLITICSTATUS IS '政治面貌',
	FAMILYNUM IS '家庭人数',
	PHONE IS '联系电话',
	ADDRESS IS '现住址',
	MARRYSTATUS IS '婚姻状况',
	LABORNUM IS '劳动力人数',
	POSTCODE IS '邮政编码',
	NYNETINCOME IS '家庭农业年度净收入合计',
	FNNETINCOME IS '家庭林、牧、副、渔业年度净收入合计',
	GSNETINCOME IS '家庭工商业年度净收入合计',
	DGNETINCOME IS '外出工作你年度净收入合计',
	QTNETINCOME IS '其他收入年度净收入合计',
	ALLNETINCOME IS '家庭年度总收入合计',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_BREED (
  BREEDID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT,
  VARIETY	VARCHAR(100),
  FLOORAREA	VARCHAR(20),
  OUTPUTVALUE	DOUBLE,
  ASSESSPRICE	DOUBLE,
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12),
  OUTPUT	VARCHAR(10)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_BREED
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_BREED ( 
	BREEDID IS '种养殖表主表主键',
	FARMERID IS '农户主键',
	VARIETY IS '种养殖品种',
	FLOORAREA IS '占地面积',
	OUTPUTVALUE IS '年产值',
	ASSESSPRICE IS '当前评估价格',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_BREED
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_COMPUNISH (
  COMPUNISHID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT,
  ORGAN	VARCHAR(80),
  DETAIL	VARCHAR(1000),
  OCCURTIME	TIMESTAMP(12),
  TYPE	INTEGER
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_COMPUNISH
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_COMPUNISH ( 
	COMPUNISHID IS '农户受处罚信息表主键',
	FARMERID IS '农户姓名',
	ORGAN IS '处罚部门',
	DETAIL IS '处罚内容',
	OCCURTIME IS '处罚时间',
	TYPE IS '表彰或处罚' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_COMPUNISH
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_CREDIT (
  CREDITID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERNAME	VARCHAR(10),
  FARMERIDNUM	VARCHAR(20),
  ASSESSDATE	DATE,
  ASSESSRANK	VARCHAR(10),
  ASSESSORGAN	VARCHAR(80),
  TIMELIMIT	VARCHAR(10),
  RECORDER	VARCHAR(10),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_CREDIT
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_CREDIT ( 
	CREDITID IS '农户信用参保情况表主键',
	FARMERNAME IS '农户姓名',
	FARMERIDNUM IS '农户身份证号码',
	ASSESSDATE IS '信用户评定时间',
	ASSESSRANK IS '信用户级别',
	ASSESSORGAN IS '信用户评定部门',
	TIMELIMIT IS '有效期限',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_CREDIT
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_DEVICE (
  DEVICEID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT	NOT NULL,
  NAME	VARCHAR(100),
  BRAND	VARCHAR(80),
  BUYINGPRICE	VARCHAR(20),
  BUYINGDATE	VARCHAR(50),
  ASSESSPRICE	VARCHAR(20),
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_DEVICE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_DEVICE ( 
	DEVICEID IS '农户设备表主键',
	FARMERID IS '农户身份证号',
	NAME IS '设备名称',
	BRAND IS '设备品牌型号',
	BUYINGPRICE IS '购建价格',
	BUYINGDATE IS '购进年份',
	ASSESSPRICE IS '当前评估价格',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_DEVICE
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_EVALUATE (
  EVALUATEID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT,
  PERSONALITY	VARCHAR(500),
  HARMONYSTATUS	VARCHAR(500),
  RESPECTSTATUS	VARCHAR(500),
  NEIGHBORSTATUS	VARCHAR(500),
  LEGALSTATUS	INTEGER,
  WELFARESTATUS	VARCHAR(500),
  HONESTSTATUS	INTEGER,
  OTHERSTATUS	VARCHAR(500)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_EVALUATE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_EVALUATE ( 
	EVALUATEID IS '村民居委会对农户家庭评价情况',
	PERSONALITY IS '人品综合评价',
	HARMONYSTATUS IS '家庭和睦情况',
	RESPECTSTATUS IS '尊老爱幼情况',
	NEIGHBORSTATUS IS '邻里团结情况',
	LEGALSTATUS IS '是否遵纪守法',
	WELFARESTATUS IS '对公益事业关心程度',
	HONESTSTATUS IS '是否诚实守信',
	OTHERSTATUS IS '其他' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_EVALUATE
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_FOREST (
  FORESTID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT,
  CARDNUM	VARCHAR(20),
  WORDNUM	VARCHAR(20),
  USER	VARCHAR(20),
  USETYPE	VARCHAR(20),
  AREA	VARCHAR(20),
  STORENUM	VARCHAR(20),
  TIMELIMIT	VARCHAR(20),
  ASSESSPRICE	VARCHAR(20)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_FOREST
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_FOREST ( 
	FORESTID IS '林权情况表主键',
	FARMERID IS '农户姓名',
	CARDNUM IS '林权证编号',
	WORDNUM IS '林权字号',
	USER IS '林权使用人',
	USETYPE IS 'l林权使用种类',
	AREA IS '面积',
	STORENUM IS '蓄积量',
	TIMELIMIT IS '使用权期限',
	ASSESSPRICE IS '当前评估价格' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_FOREST
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_HOUSE (
  HOUSEID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT,
  HOUSEPROPERTY	VARCHAR(30),
  HOUSETYPE	VARCHAR(30),
  HOUSEADDRESS	VARCHAR(50),
  BUILDAREA	VARCHAR(30),
  BUILDDATE	VARCHAR(50),
  BUILDPRICE	VARCHAR(30),
  FLOORAREA	VARCHAR(30),
  ASSESSPRICE	VARCHAR(30)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_HOUSE
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_HOUSE ( 
	HOUSEID IS '房产情况表主键',
	FARMERID IS '农户姓名',
	HOUSEPROPERTY IS '房产性质',
	HOUSETYPE IS '房产类型',
	HOUSEADDRESS IS '房屋地址',
	BUILDAREA IS '建筑面积',
	BUILDDATE IS '购建年份',
	BUILDPRICE IS '购建价格',
	FLOORAREA IS '占地面积',
	ASSESSPRICE IS '当前评估价格' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_HOUSE
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_INCOME (
  INCOMEID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  PAYID	BIGINT,
  INCOMENAME	VARCHAR(80),
  INCOMETYPE	INTEGER,
  NETINCOME	VARCHAR(30)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_INCOME
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_INCOME ( 
	INCOMEID IS '农户收入表主键',
	PAYID IS '农户姓名',
	INCOMENAME IS '收入项目名称',
	INCOMETYPE IS '收入项目类型',
	NETINCOME IS '年度净收入' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_INCOME
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_INSURED (
  INSUREDID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	BIGINT,
  NAME	VARCHAR(20),
  TYPE	INTEGER,
  AMOUNT	DOUBLE,
  INSURETIME	DATE,
  LIMITTIME	DATE,
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_INSURED
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_INSURED ( 
	INSUREDID IS '农户参保情况表主键',
	FARMERID IS '农户身份证号码',
	NAME IS '参保人姓名',
	TYPE IS '参加保险种类',
	AMOUNT IS '参保金额',
	INSURETIME IS '参保时间',
	LIMITTIME IS '参保到期日',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_INSURED
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_MEMBER (
  MEMBERID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  FARMERID	VARCHAR(10),
  NAME	VARCHAR(10),
  RELATION	VARCHAR(10),
  IDNUM	VARCHAR(20),
  EDUCATION	INTEGER,
  MARRYSTATUS	VARCHAR(10),
  OCCUPATION	VARCHAR(100),
  JOB	VARCHAR(100),
  SEX	INTEGER,
  PHONE	VARCHAR(20),
  ADDRESS	VARCHAR(300)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_MEMBER
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_MEMBER ( 
	MEMBERID IS '农户家庭成员信息表主键',
	FARMERID IS '农户姓名',
	NAME IS '家庭成员姓名',
	RELATION IS '与户主关系',
	IDNUM IS '身份证号',
	EDUCATION IS '文化程度',
	MARRYSTATUS IS '婚姻状况',
	OCCUPATION IS '职业',
	JOB IS '职务',
	SEX IS '性别',
	PHONE IS '联系电话',
	ADDRESS IS '地址' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_MEMBER
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_FARMER_PAY (
  PAYID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  PRODUCTPAY	DOUBLE,
  LIVINGPAY	DOUBLE,
  MEDICALPAY	DOUBLE,
  EDUCATEPAY	DOUBLE,
  INSUREDPAY	DOUBLE,
  OTHERPAY	DOUBLE,
  TOTALPAY	DOUBLE,
  RECORDER	VARCHAR(10),
  RECORDTIME	TIMESTAMP(12),
  FARMINGINCOME	DOUBLE,
  AVOCATIONINCOME	DOUBLE,
  BUSINESSINCOME	DOUBLE,
  OTHERINCOME	DOUBLE,
  TOTALINCOME	DOUBLE,
  YEAR	VARCHAR(4),
  FARMERID	BIGINT
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_FARMER_PAY
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_FARMER_PAY ( 
	PAYID IS '家庭支出情况表主键',
	PRODUCTPAY IS '生产支出',
	LIVINGPAY IS '生活支出',
	MEDICALPAY IS '医疗支出',
	EDUCATEPAY IS '教育支出',
	INSUREDPAY IS '参保支出',
	OTHERPAY IS '其他支出',
	TOTALPAY IS '总支出',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间',
	FARMINGINCOME IS '主要农作物年度净收入合计',
	AVOCATIONINCOME IS '家庭林、牧、副、渔业收入年度净收入合计',
	BUSINESSINCOME IS '家庭工商业收入年度净收入',
	OTHERINCOME IS '其他收入年度净收入',
	TOTALINCOME IS '家庭年度总收入合计',
	YEAR IS '年份',
	FARMERID IS '户主表主键' );

COMMIT;

RUNSTATS ON TABLE BANK.T_FARMER_PAY
	ALLOW WRITE ACCESS;

CREATE TABLE BANK.T_LOAN (
  LOANID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  CLIENTNUM	VARCHAR(50),
  NOTENUM	VARCHAR(50),
  COMPACTNUM	VARCHAR(50),
  LOANDATE	VARCHAR(80),
  LIMITDATE	VARCHAR(80),
  LIMITDATE1	VARCHAR(80),
  CURRENCY	VARCHAR(80),
  AMOUNT	VARCHAR(50),
  BALANCE	VARCHAR(50),
  OWEINTEREST	VARCHAR(50),
  CURRENTRATE	VARCHAR(50),
  CLIENTID	BIGINT,
  CLIENTNAME	VARCHAR(200),
  CLIENTTYPE	VARCHAR(50),
  IDTYPE	VARCHAR(50),
  IDNUM	VARCHAR(50),
  PHONE	VARCHAR(50),
  ADDRESS	VARCHAR(200),
  RATETYPE	VARCHAR(20),
  LOANUSE	VARCHAR(400),
  GUARANTEETYPE1	VARCHAR(50),
  GRADE	VARCHAR(50),
  GRADE1	VARCHAR(50),
  SETTLETYPE	VARCHAR(50),
  CHARGEPERSON	VARCHAR(50),
  ORGANCODE	VARCHAR(50),
  ORGANNAME	VARCHAR(100),
  BUSINESSTYPE	VARCHAR(80),
  BUSINESSBODY	VARCHAR(50),
  PROVIDETYPE	VARCHAR(80),
  INVEST	VARCHAR(200),
  TERMTYPE	VARCHAR(80),
  GUARANTEETYPE	VARCHAR(80),
  FLOATSCOPE	VARCHAR(50),
  ADJUSTTYPE	VARCHAR(80),
  RUNTYPE	VARCHAR(80),
  FREQUEENCY	VARCHAR(50),
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_LOAN
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_LOAN ( 
	CLIENTNUM IS '客户号',
	NOTENUM IS '借据号',
	COMPACTNUM IS '合同号',
	LOANDATE IS '贷款日期',
	LIMITDATE IS '到期日期',
	LIMITDATE1 IS '原到期日期',
	CURRENCY IS '币种',
	AMOUNT IS '贷款金额',
	BALANCE IS '贷款余额',
	OWEINTEREST IS '节欠利息',
	CURRENTRATE IS '当前利率',
	CLIENTTYPE IS '客户类型',
	IDTYPE IS '证件类型',
	PHONE IS '联系电话',
	ADDRESS IS '地址',
	RATETYPE IS '利率类型',
	LOANUSE IS '贷款用途',
	GUARANTEETYPE1 IS '担保方式',
	GRADE IS '贷款五级分类形态',
	GRADE1 IS '贷款十级分类形态',
	SETTLETYPE IS '结息方式',
	CHARGEPERSON IS '管理负责人',
	BUSINESSTYPE IS '业务种类',
	BUSINESSBODY IS '业务主体',
	PROVIDETYPE IS '贷款发放类型',
	INVEST IS '贷款投向',
	TERMTYPE IS '贷款期限种类',
	GUARANTEETYPE IS '担保方式',
	FLOATSCOPE IS '利率浮动范围',
	ADJUSTTYPE IS '利率浮动范围',
	RUNTYPE IS '利率执行方式',
	FREQUEENCY IS '还款频率',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_LOAN
	ALLOW WRITE ACCESS;


