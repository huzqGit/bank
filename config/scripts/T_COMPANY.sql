CREATE TABLE BANK.T_COMPANY (
  COMPANYID	INTEGER	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  COMPANYNAME	VARCHAR(80),
  COMPANYCATEGORY	VARCHAR(10),
  COMPANYFEATURE	INTEGER,
  COMPANYNATURE	INTEGER,
  MAILINGADDRESS	VARCHAR(80),
  REGISTERADDRESS	VARCHAR(80),
  REGISTERDATE	DATE,
  REGISTERTYPE	INTEGER,
  POSTCODE	INTEGER,
  TELEPHONE	VARCHAR(35),
  FAX	VARCHAR(35),
  EMAIL	VARCHAR(30),
  EMPLOYEES	INTEGER,
  PRODUCTS	VARCHAR(50),
  BUSINESSSCOPE	VARCHAR(100),
  LOCATIONAREA	INTEGER,
  LOCALTIONOWNERSHIP	INTEGER,
  DEPOSITBANK	VARCHAR(50),
  REGIONALISM	INTEGER,
  TAXIDENTIFER	VARCHAR(20),
  LOCALIDENTIFER	VARCHAR(10),
  ORGANCODE	VARCHAR(10),
  CREDITCODE	VARCHAR(20),
  LOANCARDCODE	VARCHAR(16),
  BUSINESSCODE	VARCHAR(20),
  BUSINESSISSUER	VARCHAR(80),
  BUSINESSCHKDATE	DATE,
  BUSINESSLICENCEEND	DATE,
  LOCALTAXCODE	VARCHAR(20),
  LOCALTAXISSUER	VARCHAR(80),
  LOCALTAXEND	DATE,
  CHINATAXCODE	VARCHAR(20),
  CHINATAXISSUER	VARCHAR(80),
  CHINATAXEND	DATE,
  RECORDER	VARCHAR(15),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COMPANY
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_COMPANY ( 
	COMPANYID IS '主键',
	COMPANYNAME IS '企业名称',
	COMPANYCATEGORY IS '行业分类',
	COMPANYFEATURE IS '企业特征',
	COMPANYNATURE IS '企业性质',
	MAILINGADDRESS IS '企业通信地址',
	REGISTERADDRESS IS '企业注册地址',
	REGISTERDATE IS '企业注册等级日期',
	REGISTERTYPE IS '等级注册类型',
	POSTCODE IS '邮政编码',
	TELEPHONE IS '联系电话',
	FAX IS '传真号码',
	EMAIL IS '电子邮箱',
	EMPLOYEES IS '从业人数',
	PRODUCTS IS '经营产品',
	BUSINESSSCOPE IS '经营范围',
	LOCATIONAREA IS '经营场地面积',
	LOCALTIONOWNERSHIP IS '经营场地房产所有权',
	DEPOSITBANK IS '基本户开户行',
	REGIONALISM IS '行政区划',
	TAXIDENTIFER IS '税务识别码',
	LOCALIDENTIFER IS '地区识别码',
	ORGANCODE IS '组织机构代码',
	CREDITCODE IS '机构信用代码',
	LOANCARDCODE IS '贷款卡编码',
	BUSINESSCODE IS '工商登记注册号',
	BUSINESSISSUER IS '工商登记注册号发证机构',
	BUSINESSCHKDATE IS '工商登记注册号上次年检时间',
	BUSINESSLICENCEEND IS '营业执照到期日',
	LOCALTAXCODE IS '地税登记证号码',
	LOCALTAXISSUER IS '地税登记证发证机构',
	LOCALTAXEND IS '地税登记证到期日',
	CHINATAXCODE IS '国税登记证号码',
	CHINATAXISSUER IS '国税登记证发证机构',
	CHINATAXEND IS '国税登记证到期日',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COMPANY
	ALLOW WRITE ACCESS;
