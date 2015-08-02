package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FarmerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerExample() {
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

        public Criteria andFarmernameIsNull() {
            addCriterion("FARMERNAME is null");
            return (Criteria) this;
        }

        public Criteria andFarmernameIsNotNull() {
            addCriterion("FARMERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFarmernameEqualTo(String value) {
            addCriterion("FARMERNAME =", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameNotEqualTo(String value) {
            addCriterion("FARMERNAME <>", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameGreaterThan(String value) {
            addCriterion("FARMERNAME >", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameGreaterThanOrEqualTo(String value) {
            addCriterion("FARMERNAME >=", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameLessThan(String value) {
            addCriterion("FARMERNAME <", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameLessThanOrEqualTo(String value) {
            addCriterion("FARMERNAME <=", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameLike(String value) {
            addCriterion("FARMERNAME like", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameNotLike(String value) {
            addCriterion("FARMERNAME not like", value, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameIn(List<String> values) {
            addCriterion("FARMERNAME in", values, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameNotIn(List<String> values) {
            addCriterion("FARMERNAME not in", values, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameBetween(String value1, String value2) {
            addCriterion("FARMERNAME between", value1, value2, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmernameNotBetween(String value1, String value2) {
            addCriterion("FARMERNAME not between", value1, value2, "farmername");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumIsNull() {
            addCriterion("FARMERIDNUM is null");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumIsNotNull() {
            addCriterion("FARMERIDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumEqualTo(String value) {
            addCriterion("FARMERIDNUM =", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumNotEqualTo(String value) {
            addCriterion("FARMERIDNUM <>", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumGreaterThan(String value) {
            addCriterion("FARMERIDNUM >", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumGreaterThanOrEqualTo(String value) {
            addCriterion("FARMERIDNUM >=", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumLessThan(String value) {
            addCriterion("FARMERIDNUM <", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumLessThanOrEqualTo(String value) {
            addCriterion("FARMERIDNUM <=", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumLike(String value) {
            addCriterion("FARMERIDNUM like", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumNotLike(String value) {
            addCriterion("FARMERIDNUM not like", value, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumIn(List<String> values) {
            addCriterion("FARMERIDNUM in", values, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumNotIn(List<String> values) {
            addCriterion("FARMERIDNUM not in", values, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumBetween(String value1, String value2) {
            addCriterion("FARMERIDNUM between", value1, value2, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andFarmeridnumNotBetween(String value1, String value2) {
            addCriterion("FARMERIDNUM not between", value1, value2, "farmeridnum");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNull() {
            addCriterion("BIRTHDATE is null");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNotNull() {
            addCriterion("BIRTHDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdateEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDATE =", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDATE <>", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThan(Date value) {
            addCriterionForJDBCDate("BIRTHDATE >", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDATE >=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThan(Date value) {
            addCriterionForJDBCDate("BIRTHDATE <", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDATE <=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTHDATE in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTHDATE not in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTHDATE between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTHDATE not between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("AGE like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andMarrystatusIsNull() {
            addCriterion("MARRYSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andMarrystatusIsNotNull() {
            addCriterion("MARRYSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMarrystatusEqualTo(String value) {
            addCriterion("MARRYSTATUS =", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusNotEqualTo(String value) {
            addCriterion("MARRYSTATUS <>", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusGreaterThan(String value) {
            addCriterion("MARRYSTATUS >", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusGreaterThanOrEqualTo(String value) {
            addCriterion("MARRYSTATUS >=", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusLessThan(String value) {
            addCriterion("MARRYSTATUS <", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusLessThanOrEqualTo(String value) {
            addCriterion("MARRYSTATUS <=", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusLike(String value) {
            addCriterion("MARRYSTATUS like", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusNotLike(String value) {
            addCriterion("MARRYSTATUS not like", value, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusIn(List<String> values) {
            addCriterion("MARRYSTATUS in", values, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusNotIn(List<String> values) {
            addCriterion("MARRYSTATUS not in", values, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusBetween(String value1, String value2) {
            addCriterion("MARRYSTATUS between", value1, value2, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andMarrystatusNotBetween(String value1, String value2) {
            addCriterion("MARRYSTATUS not between", value1, value2, "marrystatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusIsNull() {
            addCriterion("POLITICSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusIsNotNull() {
            addCriterion("POLITICSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusEqualTo(Integer value) {
            addCriterion("POLITICSTATUS =", value, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusNotEqualTo(Integer value) {
            addCriterion("POLITICSTATUS <>", value, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusGreaterThan(Integer value) {
            addCriterion("POLITICSTATUS >", value, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("POLITICSTATUS >=", value, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusLessThan(Integer value) {
            addCriterion("POLITICSTATUS <", value, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusLessThanOrEqualTo(Integer value) {
            addCriterion("POLITICSTATUS <=", value, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusIn(List<Integer> values) {
            addCriterion("POLITICSTATUS in", values, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusNotIn(List<Integer> values) {
            addCriterion("POLITICSTATUS not in", values, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusBetween(Integer value1, Integer value2) {
            addCriterion("POLITICSTATUS between", value1, value2, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andPoliticstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("POLITICSTATUS not between", value1, value2, "politicstatus");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(Integer value) {
            addCriterion("EDUCATION =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(Integer value) {
            addCriterion("EDUCATION <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(Integer value) {
            addCriterion("EDUCATION >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("EDUCATION >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(Integer value) {
            addCriterion("EDUCATION <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(Integer value) {
            addCriterion("EDUCATION <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<Integer> values) {
            addCriterion("EDUCATION in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<Integer> values) {
            addCriterion("EDUCATION not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(Integer value1, Integer value2) {
            addCriterion("EDUCATION between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("EDUCATION not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("BANK is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("BANK is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("BANK =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("BANK <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("BANK >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("BANK >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("BANK <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("BANK <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("BANK like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("BANK not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("BANK in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("BANK not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("BANK between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("BANK not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andFamilynumIsNull() {
            addCriterion("FAMILYNUM is null");
            return (Criteria) this;
        }

        public Criteria andFamilynumIsNotNull() {
            addCriterion("FAMILYNUM is not null");
            return (Criteria) this;
        }

        public Criteria andFamilynumEqualTo(Integer value) {
            addCriterion("FAMILYNUM =", value, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumNotEqualTo(Integer value) {
            addCriterion("FAMILYNUM <>", value, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumGreaterThan(Integer value) {
            addCriterion("FAMILYNUM >", value, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAMILYNUM >=", value, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumLessThan(Integer value) {
            addCriterion("FAMILYNUM <", value, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumLessThanOrEqualTo(Integer value) {
            addCriterion("FAMILYNUM <=", value, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumIn(List<Integer> values) {
            addCriterion("FAMILYNUM in", values, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumNotIn(List<Integer> values) {
            addCriterion("FAMILYNUM not in", values, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumBetween(Integer value1, Integer value2) {
            addCriterion("FAMILYNUM between", value1, value2, "familynum");
            return (Criteria) this;
        }

        public Criteria andFamilynumNotBetween(Integer value1, Integer value2) {
            addCriterion("FAMILYNUM not between", value1, value2, "familynum");
            return (Criteria) this;
        }

        public Criteria andLabornumIsNull() {
            addCriterion("LABORNUM is null");
            return (Criteria) this;
        }

        public Criteria andLabornumIsNotNull() {
            addCriterion("LABORNUM is not null");
            return (Criteria) this;
        }

        public Criteria andLabornumEqualTo(Integer value) {
            addCriterion("LABORNUM =", value, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumNotEqualTo(Integer value) {
            addCriterion("LABORNUM <>", value, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumGreaterThan(Integer value) {
            addCriterion("LABORNUM >", value, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumGreaterThanOrEqualTo(Integer value) {
            addCriterion("LABORNUM >=", value, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumLessThan(Integer value) {
            addCriterion("LABORNUM <", value, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumLessThanOrEqualTo(Integer value) {
            addCriterion("LABORNUM <=", value, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumIn(List<Integer> values) {
            addCriterion("LABORNUM in", values, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumNotIn(List<Integer> values) {
            addCriterion("LABORNUM not in", values, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumBetween(Integer value1, Integer value2) {
            addCriterion("LABORNUM between", value1, value2, "labornum");
            return (Criteria) this;
        }

        public Criteria andLabornumNotBetween(Integer value1, Integer value2) {
            addCriterion("LABORNUM not between", value1, value2, "labornum");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(Integer value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(Integer value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(Integer value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(Integer value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(Integer value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<Integer> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<Integer> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(Integer value1, Integer value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andIdtypeIsNull() {
            addCriterion("IDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andIdtypeIsNotNull() {
            addCriterion("IDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIdtypeEqualTo(String value) {
            addCriterion("IDTYPE =", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotEqualTo(String value) {
            addCriterion("IDTYPE <>", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeGreaterThan(String value) {
            addCriterion("IDTYPE >", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeGreaterThanOrEqualTo(String value) {
            addCriterion("IDTYPE >=", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLessThan(String value) {
            addCriterion("IDTYPE <", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLessThanOrEqualTo(String value) {
            addCriterion("IDTYPE <=", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeLike(String value) {
            addCriterion("IDTYPE like", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotLike(String value) {
            addCriterion("IDTYPE not like", value, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeIn(List<String> values) {
            addCriterion("IDTYPE in", values, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotIn(List<String> values) {
            addCriterion("IDTYPE not in", values, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeBetween(String value1, String value2) {
            addCriterion("IDTYPE between", value1, value2, "idtype");
            return (Criteria) this;
        }

        public Criteria andIdtypeNotBetween(String value1, String value2) {
            addCriterion("IDTYPE not between", value1, value2, "idtype");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNull() {
            addCriterion("OCCUPATION is null");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNotNull() {
            addCriterion("OCCUPATION is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationEqualTo(String value) {
            addCriterion("OCCUPATION =", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotEqualTo(String value) {
            addCriterion("OCCUPATION <>", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThan(String value) {
            addCriterion("OCCUPATION >", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("OCCUPATION >=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThan(String value) {
            addCriterion("OCCUPATION <", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThanOrEqualTo(String value) {
            addCriterion("OCCUPATION <=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLike(String value) {
            addCriterion("OCCUPATION like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotLike(String value) {
            addCriterion("OCCUPATION not like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationIn(List<String> values) {
            addCriterion("OCCUPATION in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotIn(List<String> values) {
            addCriterion("OCCUPATION not in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationBetween(String value1, String value2) {
            addCriterion("OCCUPATION between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotBetween(String value1, String value2) {
            addCriterion("OCCUPATION not between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andVillagesIsNull() {
            addCriterion("VILLAGES is null");
            return (Criteria) this;
        }

        public Criteria andVillagesIsNotNull() {
            addCriterion("VILLAGES is not null");
            return (Criteria) this;
        }

        public Criteria andVillagesEqualTo(String value) {
            addCriterion("VILLAGES =", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesNotEqualTo(String value) {
            addCriterion("VILLAGES <>", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesGreaterThan(String value) {
            addCriterion("VILLAGES >", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesGreaterThanOrEqualTo(String value) {
            addCriterion("VILLAGES >=", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesLessThan(String value) {
            addCriterion("VILLAGES <", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesLessThanOrEqualTo(String value) {
            addCriterion("VILLAGES <=", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesLike(String value) {
            addCriterion("VILLAGES like", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesNotLike(String value) {
            addCriterion("VILLAGES not like", value, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesIn(List<String> values) {
            addCriterion("VILLAGES in", values, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesNotIn(List<String> values) {
            addCriterion("VILLAGES not in", values, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesBetween(String value1, String value2) {
            addCriterion("VILLAGES between", value1, value2, "villages");
            return (Criteria) this;
        }

        public Criteria andVillagesNotBetween(String value1, String value2) {
            addCriterion("VILLAGES not between", value1, value2, "villages");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andFarmertypeIsNull() {
            addCriterion("FARMERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFarmertypeIsNotNull() {
            addCriterion("FARMERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFarmertypeEqualTo(Integer value) {
            addCriterion("FARMERTYPE =", value, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeNotEqualTo(Integer value) {
            addCriterion("FARMERTYPE <>", value, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeGreaterThan(Integer value) {
            addCriterion("FARMERTYPE >", value, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FARMERTYPE >=", value, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeLessThan(Integer value) {
            addCriterion("FARMERTYPE <", value, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeLessThanOrEqualTo(Integer value) {
            addCriterion("FARMERTYPE <=", value, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeIn(List<Integer> values) {
            addCriterion("FARMERTYPE in", values, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeNotIn(List<Integer> values) {
            addCriterion("FARMERTYPE not in", values, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeBetween(Integer value1, Integer value2) {
            addCriterion("FARMERTYPE between", value1, value2, "farmertype");
            return (Criteria) this;
        }

        public Criteria andFarmertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FARMERTYPE not between", value1, value2, "farmertype");
            return (Criteria) this;
        }

        public Criteria andPoortypeIsNull() {
            addCriterion("POORTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPoortypeIsNotNull() {
            addCriterion("POORTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPoortypeEqualTo(Integer value) {
            addCriterion("POORTYPE =", value, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeNotEqualTo(Integer value) {
            addCriterion("POORTYPE <>", value, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeGreaterThan(Integer value) {
            addCriterion("POORTYPE >", value, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("POORTYPE >=", value, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeLessThan(Integer value) {
            addCriterion("POORTYPE <", value, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeLessThanOrEqualTo(Integer value) {
            addCriterion("POORTYPE <=", value, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeIn(List<Integer> values) {
            addCriterion("POORTYPE in", values, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeNotIn(List<Integer> values) {
            addCriterion("POORTYPE not in", values, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeBetween(Integer value1, Integer value2) {
            addCriterion("POORTYPE between", value1, value2, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoortypeNotBetween(Integer value1, Integer value2) {
            addCriterion("POORTYPE not between", value1, value2, "poortype");
            return (Criteria) this;
        }

        public Criteria andPoorreasonIsNull() {
            addCriterion("POORREASON is null");
            return (Criteria) this;
        }

        public Criteria andPoorreasonIsNotNull() {
            addCriterion("POORREASON is not null");
            return (Criteria) this;
        }

        public Criteria andPoorreasonEqualTo(Integer value) {
            addCriterion("POORREASON =", value, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonNotEqualTo(Integer value) {
            addCriterion("POORREASON <>", value, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonGreaterThan(Integer value) {
            addCriterion("POORREASON >", value, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("POORREASON >=", value, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonLessThan(Integer value) {
            addCriterion("POORREASON <", value, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonLessThanOrEqualTo(Integer value) {
            addCriterion("POORREASON <=", value, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonIn(List<Integer> values) {
            addCriterion("POORREASON in", values, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonNotIn(List<Integer> values) {
            addCriterion("POORREASON not in", values, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonBetween(Integer value1, Integer value2) {
            addCriterion("POORREASON between", value1, value2, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPoorreasonNotBetween(Integer value1, Integer value2) {
            addCriterion("POORREASON not between", value1, value2, "poorreason");
            return (Criteria) this;
        }

        public Criteria andPloughareaIsNull() {
            addCriterion("PLOUGHAREA is null");
            return (Criteria) this;
        }

        public Criteria andPloughareaIsNotNull() {
            addCriterion("PLOUGHAREA is not null");
            return (Criteria) this;
        }

        public Criteria andPloughareaEqualTo(Double value) {
            addCriterion("PLOUGHAREA =", value, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaNotEqualTo(Double value) {
            addCriterion("PLOUGHAREA <>", value, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaGreaterThan(Double value) {
            addCriterion("PLOUGHAREA >", value, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaGreaterThanOrEqualTo(Double value) {
            addCriterion("PLOUGHAREA >=", value, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaLessThan(Double value) {
            addCriterion("PLOUGHAREA <", value, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaLessThanOrEqualTo(Double value) {
            addCriterion("PLOUGHAREA <=", value, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaIn(List<Double> values) {
            addCriterion("PLOUGHAREA in", values, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaNotIn(List<Double> values) {
            addCriterion("PLOUGHAREA not in", values, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaBetween(Double value1, Double value2) {
            addCriterion("PLOUGHAREA between", value1, value2, "plougharea");
            return (Criteria) this;
        }

        public Criteria andPloughareaNotBetween(Double value1, Double value2) {
            addCriterion("PLOUGHAREA not between", value1, value2, "plougharea");
            return (Criteria) this;
        }

        public Criteria andWateringareaIsNull() {
            addCriterion("WATERINGAREA is null");
            return (Criteria) this;
        }

        public Criteria andWateringareaIsNotNull() {
            addCriterion("WATERINGAREA is not null");
            return (Criteria) this;
        }

        public Criteria andWateringareaEqualTo(Double value) {
            addCriterion("WATERINGAREA =", value, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaNotEqualTo(Double value) {
            addCriterion("WATERINGAREA <>", value, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaGreaterThan(Double value) {
            addCriterion("WATERINGAREA >", value, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaGreaterThanOrEqualTo(Double value) {
            addCriterion("WATERINGAREA >=", value, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaLessThan(Double value) {
            addCriterion("WATERINGAREA <", value, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaLessThanOrEqualTo(Double value) {
            addCriterion("WATERINGAREA <=", value, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaIn(List<Double> values) {
            addCriterion("WATERINGAREA in", values, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaNotIn(List<Double> values) {
            addCriterion("WATERINGAREA not in", values, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaBetween(Double value1, Double value2) {
            addCriterion("WATERINGAREA between", value1, value2, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andWateringareaNotBetween(Double value1, Double value2) {
            addCriterion("WATERINGAREA not between", value1, value2, "wateringarea");
            return (Criteria) this;
        }

        public Criteria andForestareaIsNull() {
            addCriterion("FORESTAREA is null");
            return (Criteria) this;
        }

        public Criteria andForestareaIsNotNull() {
            addCriterion("FORESTAREA is not null");
            return (Criteria) this;
        }

        public Criteria andForestareaEqualTo(Double value) {
            addCriterion("FORESTAREA =", value, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaNotEqualTo(Double value) {
            addCriterion("FORESTAREA <>", value, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaGreaterThan(Double value) {
            addCriterion("FORESTAREA >", value, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaGreaterThanOrEqualTo(Double value) {
            addCriterion("FORESTAREA >=", value, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaLessThan(Double value) {
            addCriterion("FORESTAREA <", value, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaLessThanOrEqualTo(Double value) {
            addCriterion("FORESTAREA <=", value, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaIn(List<Double> values) {
            addCriterion("FORESTAREA in", values, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaNotIn(List<Double> values) {
            addCriterion("FORESTAREA not in", values, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaBetween(Double value1, Double value2) {
            addCriterion("FORESTAREA between", value1, value2, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestareaNotBetween(Double value1, Double value2) {
            addCriterion("FORESTAREA not between", value1, value2, "forestarea");
            return (Criteria) this;
        }

        public Criteria andForestarea1IsNull() {
            addCriterion("FORESTAREA1 is null");
            return (Criteria) this;
        }

        public Criteria andForestarea1IsNotNull() {
            addCriterion("FORESTAREA1 is not null");
            return (Criteria) this;
        }

        public Criteria andForestarea1EqualTo(Double value) {
            addCriterion("FORESTAREA1 =", value, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1NotEqualTo(Double value) {
            addCriterion("FORESTAREA1 <>", value, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1GreaterThan(Double value) {
            addCriterion("FORESTAREA1 >", value, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1GreaterThanOrEqualTo(Double value) {
            addCriterion("FORESTAREA1 >=", value, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1LessThan(Double value) {
            addCriterion("FORESTAREA1 <", value, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1LessThanOrEqualTo(Double value) {
            addCriterion("FORESTAREA1 <=", value, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1In(List<Double> values) {
            addCriterion("FORESTAREA1 in", values, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1NotIn(List<Double> values) {
            addCriterion("FORESTAREA1 not in", values, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1Between(Double value1, Double value2) {
            addCriterion("FORESTAREA1 between", value1, value2, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andForestarea1NotBetween(Double value1, Double value2) {
            addCriterion("FORESTAREA1 not between", value1, value2, "forestarea1");
            return (Criteria) this;
        }

        public Criteria andFruitareaIsNull() {
            addCriterion("FRUITAREA is null");
            return (Criteria) this;
        }

        public Criteria andFruitareaIsNotNull() {
            addCriterion("FRUITAREA is not null");
            return (Criteria) this;
        }

        public Criteria andFruitareaEqualTo(Double value) {
            addCriterion("FRUITAREA =", value, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaNotEqualTo(Double value) {
            addCriterion("FRUITAREA <>", value, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaGreaterThan(Double value) {
            addCriterion("FRUITAREA >", value, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaGreaterThanOrEqualTo(Double value) {
            addCriterion("FRUITAREA >=", value, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaLessThan(Double value) {
            addCriterion("FRUITAREA <", value, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaLessThanOrEqualTo(Double value) {
            addCriterion("FRUITAREA <=", value, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaIn(List<Double> values) {
            addCriterion("FRUITAREA in", values, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaNotIn(List<Double> values) {
            addCriterion("FRUITAREA not in", values, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaBetween(Double value1, Double value2) {
            addCriterion("FRUITAREA between", value1, value2, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andFruitareaNotBetween(Double value1, Double value2) {
            addCriterion("FRUITAREA not between", value1, value2, "fruitarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaIsNull() {
            addCriterion("MEADOWAREA is null");
            return (Criteria) this;
        }

        public Criteria andMeadowareaIsNotNull() {
            addCriterion("MEADOWAREA is not null");
            return (Criteria) this;
        }

        public Criteria andMeadowareaEqualTo(Double value) {
            addCriterion("MEADOWAREA =", value, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaNotEqualTo(Double value) {
            addCriterion("MEADOWAREA <>", value, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaGreaterThan(Double value) {
            addCriterion("MEADOWAREA >", value, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaGreaterThanOrEqualTo(Double value) {
            addCriterion("MEADOWAREA >=", value, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaLessThan(Double value) {
            addCriterion("MEADOWAREA <", value, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaLessThanOrEqualTo(Double value) {
            addCriterion("MEADOWAREA <=", value, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaIn(List<Double> values) {
            addCriterion("MEADOWAREA in", values, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaNotIn(List<Double> values) {
            addCriterion("MEADOWAREA not in", values, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaBetween(Double value1, Double value2) {
            addCriterion("MEADOWAREA between", value1, value2, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andMeadowareaNotBetween(Double value1, Double value2) {
            addCriterion("MEADOWAREA not between", value1, value2, "meadowarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaIsNull() {
            addCriterion("WATERAREA is null");
            return (Criteria) this;
        }

        public Criteria andWaterareaIsNotNull() {
            addCriterion("WATERAREA is not null");
            return (Criteria) this;
        }

        public Criteria andWaterareaEqualTo(Double value) {
            addCriterion("WATERAREA =", value, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaNotEqualTo(Double value) {
            addCriterion("WATERAREA <>", value, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaGreaterThan(Double value) {
            addCriterion("WATERAREA >", value, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaGreaterThanOrEqualTo(Double value) {
            addCriterion("WATERAREA >=", value, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaLessThan(Double value) {
            addCriterion("WATERAREA <", value, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaLessThanOrEqualTo(Double value) {
            addCriterion("WATERAREA <=", value, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaIn(List<Double> values) {
            addCriterion("WATERAREA in", values, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaNotIn(List<Double> values) {
            addCriterion("WATERAREA not in", values, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaBetween(Double value1, Double value2) {
            addCriterion("WATERAREA between", value1, value2, "waterarea");
            return (Criteria) this;
        }

        public Criteria andWaterareaNotBetween(Double value1, Double value2) {
            addCriterion("WATERAREA not between", value1, value2, "waterarea");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardIsNull() {
            addCriterion("DRINKINGHARD is null");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardIsNotNull() {
            addCriterion("DRINKINGHARD is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardEqualTo(Integer value) {
            addCriterion("DRINKINGHARD =", value, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardNotEqualTo(Integer value) {
            addCriterion("DRINKINGHARD <>", value, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardGreaterThan(Integer value) {
            addCriterion("DRINKINGHARD >", value, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardGreaterThanOrEqualTo(Integer value) {
            addCriterion("DRINKINGHARD >=", value, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardLessThan(Integer value) {
            addCriterion("DRINKINGHARD <", value, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardLessThanOrEqualTo(Integer value) {
            addCriterion("DRINKINGHARD <=", value, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardIn(List<Integer> values) {
            addCriterion("DRINKINGHARD in", values, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardNotIn(List<Integer> values) {
            addCriterion("DRINKINGHARD not in", values, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardBetween(Integer value1, Integer value2) {
            addCriterion("DRINKINGHARD between", value1, value2, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkinghardNotBetween(Integer value1, Integer value2) {
            addCriterion("DRINKINGHARD not between", value1, value2, "drinkinghard");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeIsNull() {
            addCriterion("DRINKINGSAFE is null");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeIsNotNull() {
            addCriterion("DRINKINGSAFE is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeEqualTo(Integer value) {
            addCriterion("DRINKINGSAFE =", value, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeNotEqualTo(Integer value) {
            addCriterion("DRINKINGSAFE <>", value, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeGreaterThan(Integer value) {
            addCriterion("DRINKINGSAFE >", value, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DRINKINGSAFE >=", value, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeLessThan(Integer value) {
            addCriterion("DRINKINGSAFE <", value, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeLessThanOrEqualTo(Integer value) {
            addCriterion("DRINKINGSAFE <=", value, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeIn(List<Integer> values) {
            addCriterion("DRINKINGSAFE in", values, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeNotIn(List<Integer> values) {
            addCriterion("DRINKINGSAFE not in", values, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeBetween(Integer value1, Integer value2) {
            addCriterion("DRINKINGSAFE between", value1, value2, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andDrinkingsafeNotBetween(Integer value1, Integer value2) {
            addCriterion("DRINKINGSAFE not between", value1, value2, "drinkingsafe");
            return (Criteria) this;
        }

        public Criteria andUsingelectricIsNull() {
            addCriterion("USINGELECTRIC is null");
            return (Criteria) this;
        }

        public Criteria andUsingelectricIsNotNull() {
            addCriterion("USINGELECTRIC is not null");
            return (Criteria) this;
        }

        public Criteria andUsingelectricEqualTo(Integer value) {
            addCriterion("USINGELECTRIC =", value, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricNotEqualTo(Integer value) {
            addCriterion("USINGELECTRIC <>", value, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricGreaterThan(Integer value) {
            addCriterion("USINGELECTRIC >", value, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricGreaterThanOrEqualTo(Integer value) {
            addCriterion("USINGELECTRIC >=", value, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricLessThan(Integer value) {
            addCriterion("USINGELECTRIC <", value, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricLessThanOrEqualTo(Integer value) {
            addCriterion("USINGELECTRIC <=", value, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricIn(List<Integer> values) {
            addCriterion("USINGELECTRIC in", values, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricNotIn(List<Integer> values) {
            addCriterion("USINGELECTRIC not in", values, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricBetween(Integer value1, Integer value2) {
            addCriterion("USINGELECTRIC between", value1, value2, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingelectricNotBetween(Integer value1, Integer value2) {
            addCriterion("USINGELECTRIC not between", value1, value2, "usingelectric");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletIsNull() {
            addCriterion("USINGTOILET is null");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletIsNotNull() {
            addCriterion("USINGTOILET is not null");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletEqualTo(Integer value) {
            addCriterion("USINGTOILET =", value, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletNotEqualTo(Integer value) {
            addCriterion("USINGTOILET <>", value, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletGreaterThan(Integer value) {
            addCriterion("USINGTOILET >", value, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletGreaterThanOrEqualTo(Integer value) {
            addCriterion("USINGTOILET >=", value, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletLessThan(Integer value) {
            addCriterion("USINGTOILET <", value, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletLessThanOrEqualTo(Integer value) {
            addCriterion("USINGTOILET <=", value, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletIn(List<Integer> values) {
            addCriterion("USINGTOILET in", values, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletNotIn(List<Integer> values) {
            addCriterion("USINGTOILET not in", values, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletBetween(Integer value1, Integer value2) {
            addCriterion("USINGTOILET between", value1, value2, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andUsingtoiletNotBetween(Integer value1, Integer value2) {
            addCriterion("USINGTOILET not between", value1, value2, "usingtoilet");
            return (Criteria) this;
        }

        public Criteria andFueltypeIsNull() {
            addCriterion("FUELTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFueltypeIsNotNull() {
            addCriterion("FUELTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFueltypeEqualTo(Integer value) {
            addCriterion("FUELTYPE =", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotEqualTo(Integer value) {
            addCriterion("FUELTYPE <>", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeGreaterThan(Integer value) {
            addCriterion("FUELTYPE >", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUELTYPE >=", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeLessThan(Integer value) {
            addCriterion("FUELTYPE <", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeLessThanOrEqualTo(Integer value) {
            addCriterion("FUELTYPE <=", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeIn(List<Integer> values) {
            addCriterion("FUELTYPE in", values, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotIn(List<Integer> values) {
            addCriterion("FUELTYPE not in", values, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeBetween(Integer value1, Integer value2) {
            addCriterion("FUELTYPE between", value1, value2, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FUELTYPE not between", value1, value2, "fueltype");
            return (Criteria) this;
        }

        public Criteria andUsingartelIsNull() {
            addCriterion("USINGARTEL is null");
            return (Criteria) this;
        }

        public Criteria andUsingartelIsNotNull() {
            addCriterion("USINGARTEL is not null");
            return (Criteria) this;
        }

        public Criteria andUsingartelEqualTo(Integer value) {
            addCriterion("USINGARTEL =", value, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelNotEqualTo(Integer value) {
            addCriterion("USINGARTEL <>", value, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelGreaterThan(Integer value) {
            addCriterion("USINGARTEL >", value, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelGreaterThanOrEqualTo(Integer value) {
            addCriterion("USINGARTEL >=", value, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelLessThan(Integer value) {
            addCriterion("USINGARTEL <", value, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelLessThanOrEqualTo(Integer value) {
            addCriterion("USINGARTEL <=", value, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelIn(List<Integer> values) {
            addCriterion("USINGARTEL in", values, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelNotIn(List<Integer> values) {
            addCriterion("USINGARTEL not in", values, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelBetween(Integer value1, Integer value2) {
            addCriterion("USINGARTEL between", value1, value2, "usingartel");
            return (Criteria) this;
        }

        public Criteria andUsingartelNotBetween(Integer value1, Integer value2) {
            addCriterion("USINGARTEL not between", value1, value2, "usingartel");
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

        public Criteria andNetincomeEqualTo(Double value) {
            addCriterion("NETINCOME =", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotEqualTo(Double value) {
            addCriterion("NETINCOME <>", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeGreaterThan(Double value) {
            addCriterion("NETINCOME >", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("NETINCOME >=", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeLessThan(Double value) {
            addCriterion("NETINCOME <", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeLessThanOrEqualTo(Double value) {
            addCriterion("NETINCOME <=", value, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeIn(List<Double> values) {
            addCriterion("NETINCOME in", values, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotIn(List<Double> values) {
            addCriterion("NETINCOME not in", values, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeBetween(Double value1, Double value2) {
            addCriterion("NETINCOME between", value1, value2, "netincome");
            return (Criteria) this;
        }

        public Criteria andNetincomeNotBetween(Double value1, Double value2) {
            addCriterion("NETINCOME not between", value1, value2, "netincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeIsNull() {
            addCriterion("WAGESINCOME is null");
            return (Criteria) this;
        }

        public Criteria andWagesincomeIsNotNull() {
            addCriterion("WAGESINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andWagesincomeEqualTo(Double value) {
            addCriterion("WAGESINCOME =", value, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeNotEqualTo(Double value) {
            addCriterion("WAGESINCOME <>", value, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeGreaterThan(Double value) {
            addCriterion("WAGESINCOME >", value, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("WAGESINCOME >=", value, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeLessThan(Double value) {
            addCriterion("WAGESINCOME <", value, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeLessThanOrEqualTo(Double value) {
            addCriterion("WAGESINCOME <=", value, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeIn(List<Double> values) {
            addCriterion("WAGESINCOME in", values, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeNotIn(List<Double> values) {
            addCriterion("WAGESINCOME not in", values, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeBetween(Double value1, Double value2) {
            addCriterion("WAGESINCOME between", value1, value2, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andWagesincomeNotBetween(Double value1, Double value2) {
            addCriterion("WAGESINCOME not between", value1, value2, "wagesincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeIsNull() {
            addCriterion("OPERATEINCOME is null");
            return (Criteria) this;
        }

        public Criteria andOperateincomeIsNotNull() {
            addCriterion("OPERATEINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andOperateincomeEqualTo(Double value) {
            addCriterion("OPERATEINCOME =", value, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeNotEqualTo(Double value) {
            addCriterion("OPERATEINCOME <>", value, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeGreaterThan(Double value) {
            addCriterion("OPERATEINCOME >", value, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("OPERATEINCOME >=", value, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeLessThan(Double value) {
            addCriterion("OPERATEINCOME <", value, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeLessThanOrEqualTo(Double value) {
            addCriterion("OPERATEINCOME <=", value, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeIn(List<Double> values) {
            addCriterion("OPERATEINCOME in", values, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeNotIn(List<Double> values) {
            addCriterion("OPERATEINCOME not in", values, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeBetween(Double value1, Double value2) {
            addCriterion("OPERATEINCOME between", value1, value2, "operateincome");
            return (Criteria) this;
        }

        public Criteria andOperateincomeNotBetween(Double value1, Double value2) {
            addCriterion("OPERATEINCOME not between", value1, value2, "operateincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeIsNull() {
            addCriterion("SUBSIDYINCOME is null");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeIsNotNull() {
            addCriterion("SUBSIDYINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeEqualTo(Double value) {
            addCriterion("SUBSIDYINCOME =", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotEqualTo(Double value) {
            addCriterion("SUBSIDYINCOME <>", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeGreaterThan(Double value) {
            addCriterion("SUBSIDYINCOME >", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("SUBSIDYINCOME >=", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeLessThan(Double value) {
            addCriterion("SUBSIDYINCOME <", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeLessThanOrEqualTo(Double value) {
            addCriterion("SUBSIDYINCOME <=", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeIn(List<Double> values) {
            addCriterion("SUBSIDYINCOME in", values, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotIn(List<Double> values) {
            addCriterion("SUBSIDYINCOME not in", values, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBetween(Double value1, Double value2) {
            addCriterion("SUBSIDYINCOME between", value1, value2, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotBetween(Double value1, Double value2) {
            addCriterion("SUBSIDYINCOME not between", value1, value2, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionIsNull() {
            addCriterion("USINGTELEVISION is null");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionIsNotNull() {
            addCriterion("USINGTELEVISION is not null");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionEqualTo(Integer value) {
            addCriterion("USINGTELEVISION =", value, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionNotEqualTo(Integer value) {
            addCriterion("USINGTELEVISION <>", value, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionGreaterThan(Integer value) {
            addCriterion("USINGTELEVISION >", value, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("USINGTELEVISION >=", value, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionLessThan(Integer value) {
            addCriterion("USINGTELEVISION <", value, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionLessThanOrEqualTo(Integer value) {
            addCriterion("USINGTELEVISION <=", value, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionIn(List<Integer> values) {
            addCriterion("USINGTELEVISION in", values, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionNotIn(List<Integer> values) {
            addCriterion("USINGTELEVISION not in", values, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionBetween(Integer value1, Integer value2) {
            addCriterion("USINGTELEVISION between", value1, value2, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andUsingtelevisionNotBetween(Integer value1, Integer value2) {
            addCriterion("USINGTELEVISION not between", value1, value2, "usingtelevision");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceIsNull() {
            addCriterion("ROADDISTANCE is null");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceIsNotNull() {
            addCriterion("ROADDISTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceEqualTo(Double value) {
            addCriterion("ROADDISTANCE =", value, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceNotEqualTo(Double value) {
            addCriterion("ROADDISTANCE <>", value, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceGreaterThan(Double value) {
            addCriterion("ROADDISTANCE >", value, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceGreaterThanOrEqualTo(Double value) {
            addCriterion("ROADDISTANCE >=", value, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceLessThan(Double value) {
            addCriterion("ROADDISTANCE <", value, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceLessThanOrEqualTo(Double value) {
            addCriterion("ROADDISTANCE <=", value, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceIn(List<Double> values) {
            addCriterion("ROADDISTANCE in", values, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceNotIn(List<Double> values) {
            addCriterion("ROADDISTANCE not in", values, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceBetween(Double value1, Double value2) {
            addCriterion("ROADDISTANCE between", value1, value2, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoaddistanceNotBetween(Double value1, Double value2) {
            addCriterion("ROADDISTANCE not between", value1, value2, "roaddistance");
            return (Criteria) this;
        }

        public Criteria andRoadtypeIsNull() {
            addCriterion("ROADTYPE is null");
            return (Criteria) this;
        }

        public Criteria andRoadtypeIsNotNull() {
            addCriterion("ROADTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRoadtypeEqualTo(Integer value) {
            addCriterion("ROADTYPE =", value, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeNotEqualTo(Integer value) {
            addCriterion("ROADTYPE <>", value, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeGreaterThan(Integer value) {
            addCriterion("ROADTYPE >", value, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROADTYPE >=", value, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeLessThan(Integer value) {
            addCriterion("ROADTYPE <", value, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeLessThanOrEqualTo(Integer value) {
            addCriterion("ROADTYPE <=", value, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeIn(List<Integer> values) {
            addCriterion("ROADTYPE in", values, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeNotIn(List<Integer> values) {
            addCriterion("ROADTYPE not in", values, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeBetween(Integer value1, Integer value2) {
            addCriterion("ROADTYPE between", value1, value2, "roadtype");
            return (Criteria) this;
        }

        public Criteria andRoadtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ROADTYPE not between", value1, value2, "roadtype");
            return (Criteria) this;
        }

        public Criteria andHouseareaIsNull() {
            addCriterion("HOUSEAREA is null");
            return (Criteria) this;
        }

        public Criteria andHouseareaIsNotNull() {
            addCriterion("HOUSEAREA is not null");
            return (Criteria) this;
        }

        public Criteria andHouseareaEqualTo(Double value) {
            addCriterion("HOUSEAREA =", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaNotEqualTo(Double value) {
            addCriterion("HOUSEAREA <>", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaGreaterThan(Double value) {
            addCriterion("HOUSEAREA >", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaGreaterThanOrEqualTo(Double value) {
            addCriterion("HOUSEAREA >=", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaLessThan(Double value) {
            addCriterion("HOUSEAREA <", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaLessThanOrEqualTo(Double value) {
            addCriterion("HOUSEAREA <=", value, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaIn(List<Double> values) {
            addCriterion("HOUSEAREA in", values, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaNotIn(List<Double> values) {
            addCriterion("HOUSEAREA not in", values, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaBetween(Double value1, Double value2) {
            addCriterion("HOUSEAREA between", value1, value2, "housearea");
            return (Criteria) this;
        }

        public Criteria andHouseareaNotBetween(Double value1, Double value2) {
            addCriterion("HOUSEAREA not between", value1, value2, "housearea");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseIsNull() {
            addCriterion("UNSAFEHOUSE is null");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseIsNotNull() {
            addCriterion("UNSAFEHOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseEqualTo(Integer value) {
            addCriterion("UNSAFEHOUSE =", value, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseNotEqualTo(Integer value) {
            addCriterion("UNSAFEHOUSE <>", value, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseGreaterThan(Integer value) {
            addCriterion("UNSAFEHOUSE >", value, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNSAFEHOUSE >=", value, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseLessThan(Integer value) {
            addCriterion("UNSAFEHOUSE <", value, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseLessThanOrEqualTo(Integer value) {
            addCriterion("UNSAFEHOUSE <=", value, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseIn(List<Integer> values) {
            addCriterion("UNSAFEHOUSE in", values, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseNotIn(List<Integer> values) {
            addCriterion("UNSAFEHOUSE not in", values, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseBetween(Integer value1, Integer value2) {
            addCriterion("UNSAFEHOUSE between", value1, value2, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andUnsafehouseNotBetween(Integer value1, Integer value2) {
            addCriterion("UNSAFEHOUSE not between", value1, value2, "unsafehouse");
            return (Criteria) this;
        }

        public Criteria andLowinsureIsNull() {
            addCriterion("LOWINSURE is null");
            return (Criteria) this;
        }

        public Criteria andLowinsureIsNotNull() {
            addCriterion("LOWINSURE is not null");
            return (Criteria) this;
        }

        public Criteria andLowinsureEqualTo(Double value) {
            addCriterion("LOWINSURE =", value, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureNotEqualTo(Double value) {
            addCriterion("LOWINSURE <>", value, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureGreaterThan(Double value) {
            addCriterion("LOWINSURE >", value, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureGreaterThanOrEqualTo(Double value) {
            addCriterion("LOWINSURE >=", value, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureLessThan(Double value) {
            addCriterion("LOWINSURE <", value, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureLessThanOrEqualTo(Double value) {
            addCriterion("LOWINSURE <=", value, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureIn(List<Double> values) {
            addCriterion("LOWINSURE in", values, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureNotIn(List<Double> values) {
            addCriterion("LOWINSURE not in", values, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureBetween(Double value1, Double value2) {
            addCriterion("LOWINSURE between", value1, value2, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andLowinsureNotBetween(Double value1, Double value2) {
            addCriterion("LOWINSURE not between", value1, value2, "lowinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureIsNull() {
            addCriterion("AGEDINSURE is null");
            return (Criteria) this;
        }

        public Criteria andAgedinsureIsNotNull() {
            addCriterion("AGEDINSURE is not null");
            return (Criteria) this;
        }

        public Criteria andAgedinsureEqualTo(Double value) {
            addCriterion("AGEDINSURE =", value, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureNotEqualTo(Double value) {
            addCriterion("AGEDINSURE <>", value, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureGreaterThan(Double value) {
            addCriterion("AGEDINSURE >", value, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureGreaterThanOrEqualTo(Double value) {
            addCriterion("AGEDINSURE >=", value, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureLessThan(Double value) {
            addCriterion("AGEDINSURE <", value, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureLessThanOrEqualTo(Double value) {
            addCriterion("AGEDINSURE <=", value, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureIn(List<Double> values) {
            addCriterion("AGEDINSURE in", values, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureNotIn(List<Double> values) {
            addCriterion("AGEDINSURE not in", values, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureBetween(Double value1, Double value2) {
            addCriterion("AGEDINSURE between", value1, value2, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andAgedinsureNotBetween(Double value1, Double value2) {
            addCriterion("AGEDINSURE not between", value1, value2, "agedinsure");
            return (Criteria) this;
        }

        public Criteria andEcoamountIsNull() {
            addCriterion("ECOAMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andEcoamountIsNotNull() {
            addCriterion("ECOAMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andEcoamountEqualTo(Double value) {
            addCriterion("ECOAMOUNT =", value, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountNotEqualTo(Double value) {
            addCriterion("ECOAMOUNT <>", value, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountGreaterThan(Double value) {
            addCriterion("ECOAMOUNT >", value, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountGreaterThanOrEqualTo(Double value) {
            addCriterion("ECOAMOUNT >=", value, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountLessThan(Double value) {
            addCriterion("ECOAMOUNT <", value, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountLessThanOrEqualTo(Double value) {
            addCriterion("ECOAMOUNT <=", value, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountIn(List<Double> values) {
            addCriterion("ECOAMOUNT in", values, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountNotIn(List<Double> values) {
            addCriterion("ECOAMOUNT not in", values, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountBetween(Double value1, Double value2) {
            addCriterion("ECOAMOUNT between", value1, value2, "ecoamount");
            return (Criteria) this;
        }

        public Criteria andEcoamountNotBetween(Double value1, Double value2) {
            addCriterion("ECOAMOUNT not between", value1, value2, "ecoamount");
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

        public Criteria andStandardIsNull() {
            addCriterion("STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(Integer value) {
            addCriterion("STANDARD =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(Integer value) {
            addCriterion("STANDARD <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(Integer value) {
            addCriterion("STANDARD >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(Integer value) {
            addCriterion("STANDARD >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(Integer value) {
            addCriterion("STANDARD <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(Integer value) {
            addCriterion("STANDARD <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<Integer> values) {
            addCriterion("STANDARD in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<Integer> values) {
            addCriterion("STANDARD not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(Integer value1, Integer value2) {
            addCriterion("STANDARD between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(Integer value1, Integer value2) {
            addCriterion("STANDARD not between", value1, value2, "standard");
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