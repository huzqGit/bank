CREATE TABLE BANK.T_COMPANY_PATENT (
  PATENTID	BIGINT	NOT NULL	GENERATED ALWAYS
    AS IDENTITY (START WITH 0, INCREMENT BY 1, CACHE 20,
       NO MINVALUE, NO MAXVALUE, NO CYCLE, NO ORDER),
  COMPANYNAME	VARCHAR(80),
  ORGANCODE	VARCHAR(20),
  CREDITCODE	VARCHAR(20),
  PATENTNAME	VARCHAR(40),
  PATENTNUMBER	VARCHAR(20),
  PATENTCLAIM_DATE	DATE,
  PATENTGRANT_DATE	DATE,
  PATENTINDATE	VARCHAR(2),
  MSGPROVIDER	VARCHAR(100),
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COMPANY_PATENT
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON TABLE BANK.T_COMPANY_PATENT IS '企业拥有专利情况';

COMMENT ON BANK.T_COMPANY_PATENT ( 
	PATENTID IS '企业拥有专利情况主表',
	COMPANYNAME IS '企业名称',
	ORGANCODE IS '组织机构编码',
	CREDITCODE IS '机构信用编码',
	PATENTNAME IS '专利名称',
	PATENTNUMBER IS '专利号',
	PATENTCLAIM_DATE IS '专利申请日',
	PATENTGRANT_DATE IS '授予专利权日期',
	PATENTINDATE IS '专利有效期',
	MSGPROVIDER IS '信息提供部门',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COMPANY_PATENT
	ALLOW WRITE ACCESS;

