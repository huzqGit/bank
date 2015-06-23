package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmerDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerDeviceExample() {
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

        public Criteria andDeviceidIsNull() {
            addCriterion("DEVICEID is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("DEVICEID is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Long value) {
            addCriterion("DEVICEID =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Long value) {
            addCriterion("DEVICEID <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Long value) {
            addCriterion("DEVICEID >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Long value) {
            addCriterion("DEVICEID >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Long value) {
            addCriterion("DEVICEID <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Long value) {
            addCriterion("DEVICEID <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Long> values) {
            addCriterion("DEVICEID in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Long> values) {
            addCriterion("DEVICEID not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Long value1, Long value2) {
            addCriterion("DEVICEID between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Long value1, Long value2) {
            addCriterion("DEVICEID not between", value1, value2, "deviceid");
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("BRAND is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("BRAND is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("BRAND =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("BRAND <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("BRAND >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("BRAND <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("BRAND <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("BRAND like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("BRAND not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("BRAND in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("BRAND not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("BRAND between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("BRAND not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIsNull() {
            addCriterion("BUYINGPRICE is null");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIsNotNull() {
            addCriterion("BUYINGPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceEqualTo(String value) {
            addCriterion("BUYINGPRICE =", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotEqualTo(String value) {
            addCriterion("BUYINGPRICE <>", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceGreaterThan(String value) {
            addCriterion("BUYINGPRICE >", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceGreaterThanOrEqualTo(String value) {
            addCriterion("BUYINGPRICE >=", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLessThan(String value) {
            addCriterion("BUYINGPRICE <", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLessThanOrEqualTo(String value) {
            addCriterion("BUYINGPRICE <=", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLike(String value) {
            addCriterion("BUYINGPRICE like", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotLike(String value) {
            addCriterion("BUYINGPRICE not like", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIn(List<String> values) {
            addCriterion("BUYINGPRICE in", values, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotIn(List<String> values) {
            addCriterion("BUYINGPRICE not in", values, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceBetween(String value1, String value2) {
            addCriterion("BUYINGPRICE between", value1, value2, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotBetween(String value1, String value2) {
            addCriterion("BUYINGPRICE not between", value1, value2, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingdateIsNull() {
            addCriterion("BUYINGDATE is null");
            return (Criteria) this;
        }

        public Criteria andBuyingdateIsNotNull() {
            addCriterion("BUYINGDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyingdateEqualTo(String value) {
            addCriterion("BUYINGDATE =", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateNotEqualTo(String value) {
            addCriterion("BUYINGDATE <>", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateGreaterThan(String value) {
            addCriterion("BUYINGDATE >", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateGreaterThanOrEqualTo(String value) {
            addCriterion("BUYINGDATE >=", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateLessThan(String value) {
            addCriterion("BUYINGDATE <", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateLessThanOrEqualTo(String value) {
            addCriterion("BUYINGDATE <=", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateLike(String value) {
            addCriterion("BUYINGDATE like", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateNotLike(String value) {
            addCriterion("BUYINGDATE not like", value, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateIn(List<String> values) {
            addCriterion("BUYINGDATE in", values, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateNotIn(List<String> values) {
            addCriterion("BUYINGDATE not in", values, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateBetween(String value1, String value2) {
            addCriterion("BUYINGDATE between", value1, value2, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andBuyingdateNotBetween(String value1, String value2) {
            addCriterion("BUYINGDATE not between", value1, value2, "buyingdate");
            return (Criteria) this;
        }

        public Criteria andAssesspriceIsNull() {
            addCriterion("ASSESSPRICE is null");
            return (Criteria) this;
        }

        public Criteria andAssesspriceIsNotNull() {
            addCriterion("ASSESSPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andAssesspriceEqualTo(String value) {
            addCriterion("ASSESSPRICE =", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotEqualTo(String value) {
            addCriterion("ASSESSPRICE <>", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceGreaterThan(String value) {
            addCriterion("ASSESSPRICE >", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceGreaterThanOrEqualTo(String value) {
            addCriterion("ASSESSPRICE >=", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceLessThan(String value) {
            addCriterion("ASSESSPRICE <", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceLessThanOrEqualTo(String value) {
            addCriterion("ASSESSPRICE <=", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceLike(String value) {
            addCriterion("ASSESSPRICE like", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotLike(String value) {
            addCriterion("ASSESSPRICE not like", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceIn(List<String> values) {
            addCriterion("ASSESSPRICE in", values, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotIn(List<String> values) {
            addCriterion("ASSESSPRICE not in", values, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceBetween(String value1, String value2) {
            addCriterion("ASSESSPRICE between", value1, value2, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotBetween(String value1, String value2) {
            addCriterion("ASSESSPRICE not between", value1, value2, "assessprice");
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