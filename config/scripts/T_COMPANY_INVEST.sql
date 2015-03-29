CREATE TABLE BANK.T_COMPANY_INVEST (
  INVESTID	INTEGER	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  COMPANYID	INTEGER,
  COMPANYNAME	VARCHAR(80),
  ORGANCODE	VARCHAR(20),
  CREDITCODE	VARCHAR(20),
  INVESTEDCOMPANYNAME	VARCHAR(80),
  INVESTEDORGANCODE	VARCHAR(20),
  INVESTEDLOANCARDCODE	VARCHAR(20),
  INVESTEDREGISTERCODE	VARCHAR(20),
  INVESTCURRENCY	VARCHAR(6),
  INVESTAMOUNT	VARCHAR(8),
  EQUITYSHARE	DECIMAL(7, 4),
  RECORDER	VARCHAR(10),
  RECORDTIME	DATE
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COMPANY_INVEST
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_COMPANY_INVEST ( 
	INVESTID IS '投资表主键',
	COMPANYID IS '企业表主键',
	COMPANYNAME IS '企业名称',
	ORGANCODE IS '组织机构编码',
	CREDITCODE IS '机构信用编码',
	INVESTEDCOMPANYNAME IS '被投资单位名称',
	INVESTEDORGANCODE IS '被投资单位组织机构代码',
	INVESTEDLOANCARDCODE IS '被投资单位贷款卡编码',
	INVESTEDREGISTERCODE IS '被投资单位等级注册号',
	INVESTCURRENCY IS '投资币种',
	INVESTAMOUNT IS '投资金额',
	EQUITYSHARE IS '股权比例',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COMPANY_INVEST
	ALLOW WRITE ACCESS;
