CREATE TABLE BANK.T_COMPANY_TAX (
  TAXID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  COMPANYNAME	VARCHAR(80),
  ORGANCODE	VARCHAR(20),
  CREDITCODE	VARCHAR(20),
  TAXCODE	VARCHAR(30),
  OCCURTIME	VARCHAR(10),
  COLLECTUNIT	VARCHAR(100),
  TAXITEMS	VARCHAR(6),
  CURRENCY	INTEGER,
  MONTH_PAYMENT	INTEGER,
  YEAR_PAYMENT	INTEGER,
  TAX_ARREARTIME	VARCHAR(10),
  TAX_ARREARAMOUNT	INTEGER,
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COMPANY_TAX
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON TABLE BANK.T_COMPANY_TAX IS '企业纳税信息';

COMMENT ON BANK.T_COMPANY_TAX ( 
	TAXID IS '企业纳税信息表主键',
	COMPANYNAME IS '企业名称',
	ORGANCODE IS '组织机构编码',
	CREDITCODE IS '机构信用编码',
	TAXCODE IS '税收编码',
	OCCURTIME IS '数据时间',
	COLLECTUNIT IS '征收单位',
	TAXITEMS IS '税收科目',
	CURRENCY IS '币种',
	MONTH_PAYMENT IS '本月缴纳金额',
	YEAR_PAYMENT IS '本年累计缴纳金额',
	TAX_ARREARTIME IS '欠税日期',
	TAX_ARREARAMOUNT IS '欠税总金额',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COMPANY_TAX
	ALLOW WRITE ACCESS;

