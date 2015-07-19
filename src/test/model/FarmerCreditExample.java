package test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FarmerCreditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerCreditExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCreditidIsNull() {
            addCriterion("CREDITID is null");
            return (Criteria) this;
        }

        public Criteria andCreditidIsNotNull() {
            addCriterion("CREDITID is not null");
            return (Criteria) this;
        }

        public Criteria andCreditidEqualTo(Long value) {
            addCriterion("CREDITID =", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidNotEqualTo(Long value) {
            addCriterion("CREDITID <>", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidGreaterThan(Long value) {
            addCriterion("CREDITID >", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDITID >=", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidLessThan(Long value) {
            addCriterion("CREDITID <", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidLessThanOrEqualTo(Long value) {
            addCriterion("CREDITID <=", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidIn(List<Long> values) {
            addCriterion("CREDITID in", values, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidNotIn(List<Long> values) {
            addCriterion("CREDITID not in", values, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidBetween(Long value1, Long value2) {
            addCriterion("CREDITID between", value1, value2, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidNotBetween(Long value1, Long value2) {
            addCriterion("CREDITID not between", value1, value2, "creditid");
            return (Criteria) this;
        }

        public Criteria andFarmeridIsNull() {
            addCriterion("FARMERID is null");
            return (Criteria) this;
        }

        public Criteria andFarmeridIsNotNull() {
            addCriterion("FARMERID is not null");
            return (Criteria) this;
        }

        public Criteria andFarmeridEqualTo(Long value) {
            addCriterion("FARMERID =", value, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridNotEqualTo(Long value) {
            addCriterion("FARMERID <>", value, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridGreaterThan(Long value) {
            addCriterion("FARMERID >", value, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridGreaterThanOrEqualTo(Long value) {
            addCriterion("FARMERID >=", value, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridLessThan(Long value) {
            addCriterion("FARMERID <", value, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridLessThanOrEqualTo(Long value) {
            addCriterion("FARMERID <=", value, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridIn(List<Long> values) {
            addCriterion("FARMERID in", values, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridNotIn(List<Long> values) {
            addCriterion("FARMERID not in", values, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridBetween(Long value1, Long value2) {
            addCriterion("FARMERID between", value1, value2, "farmerid");
            return (Criteria) this;
        }

        public Criteria andFarmeridNotBetween(Long value1, Long value2) {
            addCriterion("FARMERID not between", value1, value2, "farmerid");
            return (Criteria) this;
        }

        public Criteria andAssessdateIsNull() {
            addCriterion("ASSESSDATE is null");
            return (Criteria) this;
        }

        public Criteria andAssessdateIsNotNull() {
            addCriterion("ASSESSDATE is not null");
            return (Criteria) this;
        }

        public Criteria andAssessdateEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESSDATE =", value, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESSDATE <>", value, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateGreaterThan(Date value) {
            addCriterionForJDBCDate("ASSESSDATE >", value, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESSDATE >=", value, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateLessThan(Date value) {
            addCriterionForJDBCDate("ASSESSDATE <", value, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESSDATE <=", value, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateIn(List<Date> values) {
            addCriterionForJDBCDate("ASSESSDATE in", values, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ASSESSDATE not in", values, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ASSESSDATE between", value1, value2, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ASSESSDATE not between", value1, value2, "assessdate");
            return (Criteria) this;
        }

        public Criteria andAssessrankIsNull() {
            addCriterion("ASSESSRANK is null");
            return (Criteria) this;
        }

        public Criteria andAssessrankIsNotNull() {
            addCriterion("ASSESSRANK is not null");
            return (Criteria) this;
        }

        public Criteria andAssessrankEqualTo(String value) {
            addCriterion("ASSESSRANK =", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankNotEqualTo(String value) {
            addCriterion("ASSESSRANK <>", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankGreaterThan(String value) {
            addCriterion("ASSESSRANK >", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankGreaterThanOrEqualTo(String value) {
            addCriterion("ASSESSRANK >=", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankLessThan(String value) {
            addCriterion("ASSESSRANK <", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankLessThanOrEqualTo(String value) {
            addCriterion("ASSESSRANK <=", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankLike(String value) {
            addCriterion("ASSESSRANK like", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankNotLike(String value) {
            addCriterion("ASSESSRANK not like", value, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankIn(List<String> values) {
            addCriterion("ASSESSRANK in", values, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankNotIn(List<String> values) {
            addCriterion("ASSESSRANK not in", values, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankBetween(String value1, String value2) {
            addCriterion("ASSESSRANK between", value1, value2, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessrankNotBetween(String value1, String value2) {
            addCriterion("ASSESSRANK not between", value1, value2, "assessrank");
            return (Criteria) this;
        }

        public Criteria andAssessorganIsNull() {
            addCriterion("ASSESSORGAN is null");
            return (Criteria) this;
        }

        public Criteria andAssessorganIsNotNull() {
            addCriterion("ASSESSORGAN is not null");
            return (Criteria) this;
        }

        public Criteria andAssessorganEqualTo(String value) {
            addCriterion("ASSESSORGAN =", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganNotEqualTo(String value) {
            addCriterion("ASSESSORGAN <>", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganGreaterThan(String value) {
            addCriterion("ASSESSORGAN >", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganGreaterThanOrEqualTo(String value) {
            addCriterion("ASSESSORGAN >=", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganLessThan(String value) {
            addCriterion("ASSESSORGAN <", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganLessThanOrEqualTo(String value) {
            addCriterion("ASSESSORGAN <=", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganLike(String value) {
            addCriterion("ASSESSORGAN like", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganNotLike(String value) {
            addCriterion("ASSESSORGAN not like", value, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganIn(List<String> values) {
            addCriterion("ASSESSORGAN in", values, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganNotIn(List<String> values) {
            addCriterion("ASSESSORGAN not in", values, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganBetween(String value1, String value2) {
            addCriterion("ASSESSORGAN between", value1, value2, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andAssessorganNotBetween(String value1, String value2) {
            addCriterion("ASSESSORGAN not between", value1, value2, "assessorgan");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNull() {
            addCriterion("TIMELIMIT is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNotNull() {
            addCriterion("TIMELIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitEqualTo(String value) {
            addCriterion("TIMELIMIT =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(String value) {
            addCriterion("TIMELIMIT <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(String value) {
            addCriterion("TIMELIMIT >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(String value) {
            addCriterion("TIMELIMIT >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(String value) {
            addCriterion("TIMELIMIT <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(String value) {
            addCriterion("TIMELIMIT <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLike(String value) {
            addCriterion("TIMELIMIT like", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotLike(String value) {
            addCriterion("TIMELIMIT not like", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<String> values) {
            addCriterion("TIMELIMIT in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<String> values) {
            addCriterion("TIMELIMIT not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(String value1, String value2) {
            addCriterion("TIMELIMIT between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(String value1, String value2) {
            addCriterion("TIMELIMIT not between", value1, value2, "timelimit");
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