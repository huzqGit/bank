package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmerIncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerIncomeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIncomeidIsNull() {
            addCriterion("INCOMEID is null");
            return (Criteria) this;
        }

        public Criteria andIncomeidIsNotNull() {
            addCriterion("INCOMEID is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeidEqualTo(Long value) {
            addCriterion("INCOMEID =", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidNotEqualTo(Long value) {
            addCriterion("INCOMEID <>", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidGreaterThan(Long value) {
            addCriterion("INCOMEID >", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidGreaterThanOrEqualTo(Long value) {
            addCriterion("INCOMEID >=", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidLessThan(Long value) {
            addCriterion("INCOMEID <", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidLessThanOrEqualTo(Long value) {
            addCriterion("INCOMEID <=", value, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidIn(List<Long> values) {
            addCriterion("INCOMEID in", values, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidNotIn(List<Long> values) {
            addCriterion("INCOMEID not in", values, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidBetween(Long value1, Long value2) {
            addCriterion("INCOMEID between", value1, value2, "incomeid");
            return (Criteria) this;
        }

        public Criteria andIncomeidNotBetween(Long value1, Long value2) {
            addCriterion("INCOMEID not between", value1, value2, "incomeid");
            return (Criteria) this;
        }

        public Criteria andPayidIsNull() {
            addCriterion("PAYID is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("PAYID is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(Long value) {
            addCriterion("PAYID =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(Long value) {
            addCriterion("PAYID <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(Long value) {
            addCriterion("PAYID >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(Long value) {
            addCriterion("PAYID >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(Long value) {
            addCriterion("PAYID <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(Long value) {
            addCriterion("PAYID <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<Long> values) {
            addCriterion("PAYID in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<Long> values) {
            addCriterion("PAYID not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(Long value1, Long value2) {
            addCriterion("PAYID between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(Long value1, Long value2) {
            addCriterion("PAYID not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andIncomenameIsNull() {
            addCriterion("INCOMENAME is null");
            return (Criteria) this;
        }

        public Criteria andIncomenameIsNotNull() {
            addCriterion("INCOMENAME is not null");
            return (Criteria) this;
        }

        public Criteria andIncomenameEqualTo(String value) {
            addCriterion("INCOMENAME =", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameNotEqualTo(String value) {
            addCriterion("INCOMENAME <>", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameGreaterThan(String value) {
            addCriterion("INCOMENAME >", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameGreaterThanOrEqualTo(String value) {
            addCriterion("INCOMENAME >=", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameLessThan(String value) {
            addCriterion("INCOMENAME <", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameLessThanOrEqualTo(String value) {
            addCriterion("INCOMENAME <=", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameLike(String value) {
            addCriterion("INCOMENAME like", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameNotLike(String value) {
            addCriterion("INCOMENAME not like", value, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameIn(List<String> values) {
            addCriterion("INCOMENAME in", values, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameNotIn(List<String> values) {
            addCriterion("INCOMENAME not in", values, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameBetween(String value1, String value2) {
            addCriterion("INCOMENAME between", value1, value2, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncomenameNotBetween(String value1, String value2) {
            addCriterion("INCOMENAME not between", value1, value2, "incomename");
            return (Criteria) this;
        }

        public Criteria andIncometypeIsNull() {
            addCriterion("INCOMETYPE is null");
            return (Criteria) this;
        }

        public Criteria andIncometypeIsNotNull() {
            addCriterion("INCOMETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIncometypeEqualTo(Integer value) {
            addCriterion("INCOMETYPE =", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotEqualTo(Integer value) {
            addCriterion("INCOMETYPE <>", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeGreaterThan(Integer value) {
            addCriterion("INCOMETYPE >", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("INCOMETYPE >=", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeLessThan(Integer value) {
            addCriterion("INCOMETYPE <", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeLessThanOrEqualTo(Integer value) {
            addCriterion("INCOMETYPE <=", value, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeIn(List<Integer> values) {
            addCriterion("INCOMETYPE in", values, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotIn(List<Integer> values) {
            addCriterion("INCOMETYPE not in", values, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeBetween(Integer value1, Integer value2) {
            addCriterion("INCOMETYPE between", value1, value2, "incometype");
            return (Criteria) this;
        }

        public Criteria andIncometypeNotBetween(Integer value1, Integer value2) {
            addCriterion("INCOMETYPE not between", value1, value2, "incometype");
            return (Criteria) this;
        }

        public Criteria andNetincomeIsNull() {
            addCriterion("NETINCOME is null");
            return (Criteria) this;
        }

        public Criteria andNetincomeIsNotNull() {
            addCriterion("NETINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andNetincomeEqualTo(String value) {
            addCriterion("NETINCOME =", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotEqualTo(String value) {
            addCriterion("NETINCOME <>", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeGreaterThan(String value) {
            addCriterion("NETINCOME >", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeGreaterThanOrEqualTo(String value) {
            addCriterion("NETINCOME >=", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeLessThan(String value) {
            addCriterion("NETINCOME <", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeLessThanOrEqualTo(String value) {
            addCriterion("NETINCOME <=", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeLike(String value) {
            addCriterion("NETINCOME like", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotLike(String value) {
            addCriterion("NETINCOME not like", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeIn(List<String> values) {
            addCriterion("NETINCOME in", values, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotIn(List<String> values) {
            addCriterion("NETINCOME not in", values, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeBetween(String value1, String value2) {
            addCriterion("NETINCOME between", value1, value2, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotBetween(String value1, String value2) {
            addCriterion("NETINCOME not between", value1, value2, "netincome");
            return (Criteria) this;
        }

        public Criteria andSourcecodeIsNull() {
            addCriterion("SOURCECODE is null");
            return (Criteria) this;
        }

        public Criteria andSourcecodeIsNotNull() {
            addCriterion("SOURCECODE is not null");
            return (Criteria) this;
        }

        public Criteria andSourcecodeEqualTo(String value) {
            addCriterion("SOURCECODE =", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotEqualTo(String value) {
            addCriterion("SOURCECODE <>", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeGreaterThan(String value) {
            addCriterion("SOURCECODE >", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCECODE >=", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeLessThan(String value) {
            addCriterion("SOURCECODE <", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeLessThanOrEqualTo(String value) {
            addCriterion("SOURCECODE <=", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeLike(String value) {
            addCriterion("SOURCECODE like", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotLike(String value) {
            addCriterion("SOURCECODE not like", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeIn(List<String> values) {
            addCriterion("SOURCECODE in", values, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotIn(List<String> values) {
            addCriterion("SOURCECODE not in", values, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeBetween(String value1, String value2) {
            addCriterion("SOURCECODE between", value1, value2, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotBetween(String value1, String value2) {
            addCriterion("SOURCECODE not between", value1, value2, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcenameIsNull() {
            addCriterion("SOURCENAME is null");
            return (Criteria) this;
        }

        public Criteria andSourcenameIsNotNull() {
            addCriterion("SOURCENAME is not null");
            return (Criteria) this;
        }

        public Criteria andSourcenameEqualTo(String value) {
            addCriterion("SOURCENAME =", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameNotEqualTo(String value) {
            addCriterion("SOURCENAME <>", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameGreaterThan(String value) {
            addCriterion("SOURCENAME >", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCENAME >=", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameLessThan(String value) {
            addCriterion("SOURCENAME <", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameLessThanOrEqualTo(String value) {
            addCriterion("SOURCENAME <=", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameLike(String value) {
            addCriterion("SOURCENAME like", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameNotLike(String value) {
            addCriterion("SOURCENAME not like", value, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameIn(List<String> values) {
            addCriterion("SOURCENAME in", values, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameNotIn(List<String> values) {
            addCriterion("SOURCENAME not in", values, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameBetween(String value1, String value2) {
            addCriterion("SOURCENAME between", value1, value2, "sourcename");
            return (Criteria) this;
        }

        public Criteria andSourcenameNotBetween(String value1, String value2) {
            addCriterion("SOURCENAME not between", value1, value2, "sourcename");
            return (Criteria) this;
        }

        public Criteria andRunitidIsNull() {
            addCriterion("RUNITID is null");
            return (Criteria) this;
        }

        public Criteria andRunitidIsNotNull() {
            addCriterion("RUNITID is not null");
            return (Criteria) this;
        }

        public Criteria andRunitidEqualTo(String value) {
            addCriterion("RUNITID =", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidNotEqualTo(String value) {
            addCriterion("RUNITID <>", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidGreaterThan(String value) {
            addCriterion("RUNITID >", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidGreaterThanOrEqualTo(String value) {
            addCriterion("RUNITID >=", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidLessThan(String value) {
            addCriterion("RUNITID <", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidLessThanOrEqualTo(String value) {
            addCriterion("RUNITID <=", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidLike(String value) {
            addCriterion("RUNITID like", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidNotLike(String value) {
            addCriterion("RUNITID not like", value, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidIn(List<String> values) {
            addCriterion("RUNITID in", values, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidNotIn(List<String> values) {
            addCriterion("RUNITID not in", values, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidBetween(String value1, String value2) {
            addCriterion("RUNITID between", value1, value2, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitidNotBetween(String value1, String value2) {
            addCriterion("RUNITID not between", value1, value2, "runitid");
            return (Criteria) this;
        }

        public Criteria andRunitnameIsNull() {
            addCriterion("RUNITNAME is null");
            return (Criteria) this;
        }

        public Criteria andRunitnameIsNotNull() {
            addCriterion("RUNITNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRunitnameEqualTo(String value) {
            addCriterion("RUNITNAME =", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameNotEqualTo(String value) {
            addCriterion("RUNITNAME <>", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameGreaterThan(String value) {
            addCriterion("RUNITNAME >", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameGreaterThanOrEqualTo(String value) {
            addCriterion("RUNITNAME >=", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameLessThan(String value) {
            addCriterion("RUNITNAME <", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameLessThanOrEqualTo(String value) {
            addCriterion("RUNITNAME <=", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameLike(String value) {
            addCriterion("RUNITNAME like", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameNotLike(String value) {
            addCriterion("RUNITNAME not like", value, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameIn(List<String> values) {
            addCriterion("RUNITNAME in", values, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameNotIn(List<String> values) {
            addCriterion("RUNITNAME not in", values, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameBetween(String value1, String value2) {
            addCriterion("RUNITNAME between", value1, value2, "runitname");
            return (Criteria) this;
        }

        public Criteria andRunitnameNotBetween(String value1, String value2) {
            addCriterion("RUNITNAME not between", value1, value2, "runitname");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNull() {
            addCriterion("RECORDER is null");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNotNull() {
            addCriterion("RECORDER is not null");
            return (Criteria) this;
        }

        public Criteria andRecorderEqualTo(String value) {
            addCriterion("RECORDER =", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotEqualTo(String value) {
            addCriterion("RECORDER <>", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThan(String value) {
            addCriterion("RECORDER >", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThanOrEqualTo(String value) {
            addCriterion("RECORDER >=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThan(String value) {
            addCriterion("RECORDER <", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThanOrEqualTo(String value) {
            addCriterion("RECORDER <=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLike(String value) {
            addCriterion("RECORDER like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotLike(String value) {
            addCriterion("RECORDER not like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderIn(List<String> values) {
            addCriterion("RECORDER in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotIn(List<String> values) {
            addCriterion("RECORDER not in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderBetween(String value1, String value2) {
            addCriterion("RECORDER between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotBetween(String value1, String value2) {
            addCriterion("RECORDER not between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIsNull() {
            addCriterion("RECORDTIME is null");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIsNotNull() {
            addCriterion("RECORDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecordtimeEqualTo(Date value) {
            addCriterion("RECORDTIME =", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotEqualTo(Date value) {
            addCriterion("RECORDTIME <>", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeGreaterThan(Date value) {
            addCriterion("RECORDTIME >", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RECORDTIME >=", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeLessThan(Date value) {
            addCriterion("RECORDTIME <", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeLessThanOrEqualTo(Date value) {
            addCriterion("RECORDTIME <=", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIn(List<Date> values) {
            addCriterion("RECORDTIME in", values, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotIn(List<Date> values) {
            addCriterion("RECORDTIME not in", values, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeBetween(Date value1, Date value2) {
            addCriterion("RECORDTIME between", value1, value2, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotBetween(Date value1, Date value2) {
            addCriterion("RECORDTIME not between", value1, value2, "recordtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}