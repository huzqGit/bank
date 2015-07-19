package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CooperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CooperationExample() {
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

        public Criteria andCooperationidIsNull() {
            addCriterion("COOPERATIONID is null");
            return (Criteria) this;
        }

        public Criteria andCooperationidIsNotNull() {
            addCriterion("COOPERATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationidEqualTo(Long value) {
            addCriterion("COOPERATIONID =", value, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidNotEqualTo(Long value) {
            addCriterion("COOPERATIONID <>", value, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidGreaterThan(Long value) {
            addCriterion("COOPERATIONID >", value, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidGreaterThanOrEqualTo(Long value) {
            addCriterion("COOPERATIONID >=", value, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidLessThan(Long value) {
            addCriterion("COOPERATIONID <", value, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidLessThanOrEqualTo(Long value) {
            addCriterion("COOPERATIONID <=", value, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidIn(List<Long> values) {
            addCriterion("COOPERATIONID in", values, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidNotIn(List<Long> values) {
            addCriterion("COOPERATIONID not in", values, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidBetween(Long value1, Long value2) {
            addCriterion("COOPERATIONID between", value1, value2, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationidNotBetween(Long value1, Long value2) {
            addCriterion("COOPERATIONID not between", value1, value2, "cooperationid");
            return (Criteria) this;
        }

        public Criteria andCooperationnameIsNull() {
            addCriterion("COOPERATIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andCooperationnameIsNotNull() {
            addCriterion("COOPERATIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationnameEqualTo(String value) {
            addCriterion("COOPERATIONNAME =", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameNotEqualTo(String value) {
            addCriterion("COOPERATIONNAME <>", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameGreaterThan(String value) {
            addCriterion("COOPERATIONNAME >", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameGreaterThanOrEqualTo(String value) {
            addCriterion("COOPERATIONNAME >=", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameLessThan(String value) {
            addCriterion("COOPERATIONNAME <", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameLessThanOrEqualTo(String value) {
            addCriterion("COOPERATIONNAME <=", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameLike(String value) {
            addCriterion("COOPERATIONNAME like", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameNotLike(String value) {
            addCriterion("COOPERATIONNAME not like", value, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameIn(List<String> values) {
            addCriterion("COOPERATIONNAME in", values, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameNotIn(List<String> values) {
            addCriterion("COOPERATIONNAME not in", values, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameBetween(String value1, String value2) {
            addCriterion("COOPERATIONNAME between", value1, value2, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andCooperationnameNotBetween(String value1, String value2) {
            addCriterion("COOPERATIONNAME not between", value1, value2, "cooperationname");
            return (Criteria) this;
        }

        public Criteria andOrgacodeIsNull() {
            addCriterion("ORGACODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgacodeIsNotNull() {
            addCriterion("ORGACODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgacodeEqualTo(String value) {
            addCriterion("ORGACODE =", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeNotEqualTo(String value) {
            addCriterion("ORGACODE <>", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeGreaterThan(String value) {
            addCriterion("ORGACODE >", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGACODE >=", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeLessThan(String value) {
            addCriterion("ORGACODE <", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeLessThanOrEqualTo(String value) {
            addCriterion("ORGACODE <=", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeLike(String value) {
            addCriterion("ORGACODE like", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeNotLike(String value) {
            addCriterion("ORGACODE not like", value, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeIn(List<String> values) {
            addCriterion("ORGACODE in", values, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeNotIn(List<String> values) {
            addCriterion("ORGACODE not in", values, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeBetween(String value1, String value2) {
            addCriterion("ORGACODE between", value1, value2, "orgacode");
            return (Criteria) this;
        }

        public Criteria andOrgacodeNotBetween(String value1, String value2) {
            addCriterion("ORGACODE not between", value1, value2, "orgacode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeIsNull() {
            addCriterion("TAXCODE is null");
            return (Criteria) this;
        }

        public Criteria andTaxcodeIsNotNull() {
            addCriterion("TAXCODE is not null");
            return (Criteria) this;
        }

        public Criteria andTaxcodeEqualTo(String value) {
            addCriterion("TAXCODE =", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotEqualTo(String value) {
            addCriterion("TAXCODE <>", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeGreaterThan(String value) {
            addCriterion("TAXCODE >", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("TAXCODE >=", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeLessThan(String value) {
            addCriterion("TAXCODE <", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeLessThanOrEqualTo(String value) {
            addCriterion("TAXCODE <=", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeLike(String value) {
            addCriterion("TAXCODE like", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotLike(String value) {
            addCriterion("TAXCODE not like", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeIn(List<String> values) {
            addCriterion("TAXCODE in", values, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotIn(List<String> values) {
            addCriterion("TAXCODE not in", values, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeBetween(String value1, String value2) {
            addCriterion("TAXCODE between", value1, value2, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotBetween(String value1, String value2) {
            addCriterion("TAXCODE not between", value1, value2, "taxcode");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceIsNull() {
            addCriterion("BUSINESSLICENCE is null");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceIsNotNull() {
            addCriterion("BUSINESSLICENCE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceEqualTo(String value) {
            addCriterion("BUSINESSLICENCE =", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceNotEqualTo(String value) {
            addCriterion("BUSINESSLICENCE <>", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceGreaterThan(String value) {
            addCriterion("BUSINESSLICENCE >", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSLICENCE >=", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceLessThan(String value) {
            addCriterion("BUSINESSLICENCE <", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSLICENCE <=", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceLike(String value) {
            addCriterion("BUSINESSLICENCE like", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceNotLike(String value) {
            addCriterion("BUSINESSLICENCE not like", value, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceIn(List<String> values) {
            addCriterion("BUSINESSLICENCE in", values, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceNotIn(List<String> values) {
            addCriterion("BUSINESSLICENCE not in", values, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceBetween(String value1, String value2) {
            addCriterion("BUSINESSLICENCE between", value1, value2, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andBusinesslicenceNotBetween(String value1, String value2) {
            addCriterion("BUSINESSLICENCE not between", value1, value2, "businesslicence");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressIsNull() {
            addCriterion("REGISTERADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressIsNotNull() {
            addCriterion("REGISTERADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressEqualTo(String value) {
            addCriterion("REGISTERADDRESS =", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotEqualTo(String value) {
            addCriterion("REGISTERADDRESS <>", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressGreaterThan(String value) {
            addCriterion("REGISTERADDRESS >", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTERADDRESS >=", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressLessThan(String value) {
            addCriterion("REGISTERADDRESS <", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressLessThanOrEqualTo(String value) {
            addCriterion("REGISTERADDRESS <=", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressLike(String value) {
            addCriterion("REGISTERADDRESS like", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotLike(String value) {
            addCriterion("REGISTERADDRESS not like", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressIn(List<String> values) {
            addCriterion("REGISTERADDRESS in", values, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotIn(List<String> values) {
            addCriterion("REGISTERADDRESS not in", values, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressBetween(String value1, String value2) {
            addCriterion("REGISTERADDRESS between", value1, value2, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotBetween(String value1, String value2) {
            addCriterion("REGISTERADDRESS not between", value1, value2, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressIsNull() {
            addCriterion("MAILADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMailaddressIsNotNull() {
            addCriterion("MAILADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMailaddressEqualTo(String value) {
            addCriterion("MAILADDRESS =", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotEqualTo(String value) {
            addCriterion("MAILADDRESS <>", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressGreaterThan(String value) {
            addCriterion("MAILADDRESS >", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressGreaterThanOrEqualTo(String value) {
            addCriterion("MAILADDRESS >=", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressLessThan(String value) {
            addCriterion("MAILADDRESS <", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressLessThanOrEqualTo(String value) {
            addCriterion("MAILADDRESS <=", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressLike(String value) {
            addCriterion("MAILADDRESS like", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotLike(String value) {
            addCriterion("MAILADDRESS not like", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressIn(List<String> values) {
            addCriterion("MAILADDRESS in", values, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotIn(List<String> values) {
            addCriterion("MAILADDRESS not in", values, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressBetween(String value1, String value2) {
            addCriterion("MAILADDRESS between", value1, value2, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotBetween(String value1, String value2) {
            addCriterion("MAILADDRESS not between", value1, value2, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNull() {
            addCriterion("REGISTERDATE is null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNotNull() {
            addCriterion("REGISTERDATE is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateEqualTo(Date value) {
            addCriterionForJDBCDate("REGISTERDATE =", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("REGISTERDATE <>", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThan(Date value) {
            addCriterionForJDBCDate("REGISTERDATE >", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("REGISTERDATE >=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThan(Date value) {
            addCriterionForJDBCDate("REGISTERDATE <", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("REGISTERDATE <=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIn(List<Date> values) {
            addCriterionForJDBCDate("REGISTERDATE in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("REGISTERDATE not in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("REGISTERDATE between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("REGISTERDATE not between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalIsNull() {
            addCriterion("REGISTERCAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalIsNotNull() {
            addCriterion("REGISTERCAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalEqualTo(String value) {
            addCriterion("REGISTERCAPITAL =", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalNotEqualTo(String value) {
            addCriterion("REGISTERCAPITAL <>", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalGreaterThan(String value) {
            addCriterion("REGISTERCAPITAL >", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTERCAPITAL >=", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalLessThan(String value) {
            addCriterion("REGISTERCAPITAL <", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalLessThanOrEqualTo(String value) {
            addCriterion("REGISTERCAPITAL <=", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalLike(String value) {
            addCriterion("REGISTERCAPITAL like", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalNotLike(String value) {
            addCriterion("REGISTERCAPITAL not like", value, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalIn(List<String> values) {
            addCriterion("REGISTERCAPITAL in", values, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalNotIn(List<String> values) {
            addCriterion("REGISTERCAPITAL not in", values, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalBetween(String value1, String value2) {
            addCriterion("REGISTERCAPITAL between", value1, value2, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRegistercapitalNotBetween(String value1, String value2) {
            addCriterion("REGISTERCAPITAL not between", value1, value2, "registercapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalIsNull() {
            addCriterion("REALCAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andRealcapitalIsNotNull() {
            addCriterion("REALCAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andRealcapitalEqualTo(String value) {
            addCriterion("REALCAPITAL =", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalNotEqualTo(String value) {
            addCriterion("REALCAPITAL <>", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalGreaterThan(String value) {
            addCriterion("REALCAPITAL >", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalGreaterThanOrEqualTo(String value) {
            addCriterion("REALCAPITAL >=", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalLessThan(String value) {
            addCriterion("REALCAPITAL <", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalLessThanOrEqualTo(String value) {
            addCriterion("REALCAPITAL <=", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalLike(String value) {
            addCriterion("REALCAPITAL like", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalNotLike(String value) {
            addCriterion("REALCAPITAL not like", value, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalIn(List<String> values) {
            addCriterion("REALCAPITAL in", values, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalNotIn(List<String> values) {
            addCriterion("REALCAPITAL not in", values, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalBetween(String value1, String value2) {
            addCriterion("REALCAPITAL between", value1, value2, "realcapital");
            return (Criteria) this;
        }

        public Criteria andRealcapitalNotBetween(String value1, String value2) {
            addCriterion("REALCAPITAL not between", value1, value2, "realcapital");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIsNull() {
            addCriterion("LEGALPERSON is null");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIsNotNull() {
            addCriterion("LEGALPERSON is not null");
            return (Criteria) this;
        }

        public Criteria andLegalpersonEqualTo(String value) {
            addCriterion("LEGALPERSON =", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotEqualTo(String value) {
            addCriterion("LEGALPERSON <>", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonGreaterThan(String value) {
            addCriterion("LEGALPERSON >", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonGreaterThanOrEqualTo(String value) {
            addCriterion("LEGALPERSON >=", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLessThan(String value) {
            addCriterion("LEGALPERSON <", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLessThanOrEqualTo(String value) {
            addCriterion("LEGALPERSON <=", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLike(String value) {
            addCriterion("LEGALPERSON like", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotLike(String value) {
            addCriterion("LEGALPERSON not like", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIn(List<String> values) {
            addCriterion("LEGALPERSON in", values, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotIn(List<String> values) {
            addCriterion("LEGALPERSON not in", values, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonBetween(String value1, String value2) {
            addCriterion("LEGALPERSON between", value1, value2, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotBetween(String value1, String value2) {
            addCriterion("LEGALPERSON not between", value1, value2, "legalperson");
            return (Criteria) this;
        }

        public Criteria andIdnumIsNull() {
            addCriterion("IDNUM is null");
            return (Criteria) this;
        }

        public Criteria andIdnumIsNotNull() {
            addCriterion("IDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andIdnumEqualTo(String value) {
            addCriterion("IDNUM =", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumNotEqualTo(String value) {
            addCriterion("IDNUM <>", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumGreaterThan(String value) {
            addCriterion("IDNUM >", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("IDNUM >=", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumLessThan(String value) {
            addCriterion("IDNUM <", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumLessThanOrEqualTo(String value) {
            addCriterion("IDNUM <=", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumLike(String value) {
            addCriterion("IDNUM like", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumNotLike(String value) {
            addCriterion("IDNUM not like", value, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumIn(List<String> values) {
            addCriterion("IDNUM in", values, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumNotIn(List<String> values) {
            addCriterion("IDNUM not in", values, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumBetween(String value1, String value2) {
            addCriterion("IDNUM between", value1, value2, "idnum");
            return (Criteria) this;
        }

        public Criteria andIdnumNotBetween(String value1, String value2) {
            addCriterion("IDNUM not between", value1, value2, "idnum");
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

        public Criteria andMembersIsNull() {
            addCriterion("MEMBERS is null");
            return (Criteria) this;
        }

        public Criteria andMembersIsNotNull() {
            addCriterion("MEMBERS is not null");
            return (Criteria) this;
        }

        public Criteria andMembersEqualTo(Integer value) {
            addCriterion("MEMBERS =", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotEqualTo(Integer value) {
            addCriterion("MEMBERS <>", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersGreaterThan(Integer value) {
            addCriterion("MEMBERS >", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEMBERS >=", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersLessThan(Integer value) {
            addCriterion("MEMBERS <", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersLessThanOrEqualTo(Integer value) {
            addCriterion("MEMBERS <=", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersIn(List<Integer> values) {
            addCriterion("MEMBERS in", values, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotIn(List<Integer> values) {
            addCriterion("MEMBERS not in", values, "members");
            return (Criteria) this;
        }

        public Criteria andMembersBetween(Integer value1, Integer value2) {
            addCriterion("MEMBERS between", value1, value2, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotBetween(Integer value1, Integer value2) {
            addCriterion("MEMBERS not between", value1, value2, "members");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeIsNull() {
            addCriterion("BUSINESSCOPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeIsNotNull() {
            addCriterion("BUSINESSCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeEqualTo(String value) {
            addCriterion("BUSINESSCOPE =", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeNotEqualTo(String value) {
            addCriterion("BUSINESSCOPE <>", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeGreaterThan(String value) {
            addCriterion("BUSINESSCOPE >", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSCOPE >=", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeLessThan(String value) {
            addCriterion("BUSINESSCOPE <", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSCOPE <=", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeLike(String value) {
            addCriterion("BUSINESSCOPE like", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeNotLike(String value) {
            addCriterion("BUSINESSCOPE not like", value, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeIn(List<String> values) {
            addCriterion("BUSINESSCOPE in", values, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeNotIn(List<String> values) {
            addCriterion("BUSINESSCOPE not in", values, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeBetween(String value1, String value2) {
            addCriterion("BUSINESSCOPE between", value1, value2, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinesscopeNotBetween(String value1, String value2) {
            addCriterion("BUSINESSCOPE not between", value1, value2, "businesscope");
            return (Criteria) this;
        }

        public Criteria andBusinessareaIsNull() {
            addCriterion("BUSINESSAREA is null");
            return (Criteria) this;
        }

        public Criteria andBusinessareaIsNotNull() {
            addCriterion("BUSINESSAREA is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessareaEqualTo(Integer value) {
            addCriterion("BUSINESSAREA =", value, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaNotEqualTo(Integer value) {
            addCriterion("BUSINESSAREA <>", value, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaGreaterThan(Integer value) {
            addCriterion("BUSINESSAREA >", value, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUSINESSAREA >=", value, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaLessThan(Integer value) {
            addCriterion("BUSINESSAREA <", value, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaLessThanOrEqualTo(Integer value) {
            addCriterion("BUSINESSAREA <=", value, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaIn(List<Integer> values) {
            addCriterion("BUSINESSAREA in", values, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaNotIn(List<Integer> values) {
            addCriterion("BUSINESSAREA not in", values, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaBetween(Integer value1, Integer value2) {
            addCriterion("BUSINESSAREA between", value1, value2, "businessarea");
            return (Criteria) this;
        }

        public Criteria andBusinessareaNotBetween(Integer value1, Integer value2) {
            addCriterion("BUSINESSAREA not between", value1, value2, "businessarea");
            return (Criteria) this;
        }

        public Criteria andFarmersIsNull() {
            addCriterion("FARMERS is null");
            return (Criteria) this;
        }

        public Criteria andFarmersIsNotNull() {
            addCriterion("FARMERS is not null");
            return (Criteria) this;
        }

        public Criteria andFarmersEqualTo(Integer value) {
            addCriterion("FARMERS =", value, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersNotEqualTo(Integer value) {
            addCriterion("FARMERS <>", value, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersGreaterThan(Integer value) {
            addCriterion("FARMERS >", value, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersGreaterThanOrEqualTo(Integer value) {
            addCriterion("FARMERS >=", value, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersLessThan(Integer value) {
            addCriterion("FARMERS <", value, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersLessThanOrEqualTo(Integer value) {
            addCriterion("FARMERS <=", value, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersIn(List<Integer> values) {
            addCriterion("FARMERS in", values, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersNotIn(List<Integer> values) {
            addCriterion("FARMERS not in", values, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersBetween(Integer value1, Integer value2) {
            addCriterion("FARMERS between", value1, value2, "farmers");
            return (Criteria) this;
        }

        public Criteria andFarmersNotBetween(Integer value1, Integer value2) {
            addCriterion("FARMERS not between", value1, value2, "farmers");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseIsNull() {
            addCriterion("CONNECTIONBASE is null");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseIsNotNull() {
            addCriterion("CONNECTIONBASE is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseEqualTo(String value) {
            addCriterion("CONNECTIONBASE =", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseNotEqualTo(String value) {
            addCriterion("CONNECTIONBASE <>", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseGreaterThan(String value) {
            addCriterion("CONNECTIONBASE >", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseGreaterThanOrEqualTo(String value) {
            addCriterion("CONNECTIONBASE >=", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseLessThan(String value) {
            addCriterion("CONNECTIONBASE <", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseLessThanOrEqualTo(String value) {
            addCriterion("CONNECTIONBASE <=", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseLike(String value) {
            addCriterion("CONNECTIONBASE like", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseNotLike(String value) {
            addCriterion("CONNECTIONBASE not like", value, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseIn(List<String> values) {
            addCriterion("CONNECTIONBASE in", values, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseNotIn(List<String> values) {
            addCriterion("CONNECTIONBASE not in", values, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseBetween(String value1, String value2) {
            addCriterion("CONNECTIONBASE between", value1, value2, "connectionbase");
            return (Criteria) this;
        }

        public Criteria andConnectionbaseNotBetween(String value1, String value2) {
            addCriterion("CONNECTIONBASE not between", value1, value2, "connectionbase");
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

        public Criteria andOrganIdIsNull() {
            addCriterion("ORGAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNotNull() {
            addCriterion("ORGAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrganIdEqualTo(String value) {
            addCriterion("ORGAN_ID =", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotEqualTo(String value) {
            addCriterion("ORGAN_ID <>", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThan(String value) {
            addCriterion("ORGAN_ID >", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_ID >=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThan(String value) {
            addCriterion("ORGAN_ID <", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_ID <=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLike(String value) {
            addCriterion("ORGAN_ID like", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotLike(String value) {
            addCriterion("ORGAN_ID not like", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdIn(List<String> values) {
            addCriterion("ORGAN_ID in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotIn(List<String> values) {
            addCriterion("ORGAN_ID not in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdBetween(String value1, String value2) {
            addCriterion("ORGAN_ID between", value1, value2, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotBetween(String value1, String value2) {
            addCriterion("ORGAN_ID not between", value1, value2, "organId");
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