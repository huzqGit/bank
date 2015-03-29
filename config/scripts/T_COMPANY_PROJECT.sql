CREATE TABLE BANK.T_COMPANY_PROJECT (
  PROJECTID	BIGINT,
  COMPANYNAME	VARCHAR(80),
  ORGANCODE	VARCHAR(20),
  CREDITCODE	VARCHAR(20),
  PROJECTNAME	VARCHAR(40),
  FINISHDATE	DATE,
  INVESTAMOUNT	VARCHAR(10),
  CAPITALSOURCE	INTEGER,
  PAYBACKPERIOD	INTEGER,
  RETURNRATE	INTEGER,
  RECORDER	VARCHAR(20),
  RECORDTIME	TIMESTAMP(12)
  ) 
  IN USERSPACE1
  ORGANIZE BY ROW;

ALTER TABLE BANK.T_COMPANY_PROJECT
  DATA CAPTURE NONE
  PCTFREE 0
  LOCKSIZE ROW
  APPEND OFF
  NOT VOLATILE;

COMMENT ON BANK.T_COMPANY_PROJECT ( 
	PROJECTID IS '企业在建项目主表',
	COMPANYNAME IS '企业名称',
	ORGANCODE IS '组织机构编码',
	CREDITCODE IS '机构信用编码',
	PROJECTNAME IS '项目名称',
	FINISHDATE IS '预计完成时间',
	INVESTAMOUNT IS '项目总投资',
	CAPITALSOURCE IS '项目资金来源',
	PAYBACKPERIOD IS '预计资金回收期',
	RETURNRATE IS '预计资金回报率',
	RECORDER IS '记录人',
	RECORDTIME IS '记录时间' );

COMMIT;

RUNSTATS ON TABLE BANK.T_COMPANY_PROJECT
	ALLOW WRITE ACCESS;
