package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmerForestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerForestExample() {
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

        public Criteria andForestidIsNull() {
            addCriterion("FORESTID is null");
            return (Criteria) this;
        }

        public Criteria andForestidIsNotNull() {
            addCriterion("FORESTID is not null");
            return (Criteria) this;
        }

        public Criteria andForestidEqualTo(Long value) {
            addCriterion("FORESTID =", value, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidNotEqualTo(Long value) {
            addCriterion("FORESTID <>", value, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidGreaterThan(Long value) {
            addCriterion("FORESTID >", value, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidGreaterThanOrEqualTo(Long value) {
            addCriterion("FORESTID >=", value, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidLessThan(Long value) {
            addCriterion("FORESTID <", value, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidLessThanOrEqualTo(Long value) {
            addCriterion("FORESTID <=", value, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidIn(List<Long> values) {
            addCriterion("FORESTID in", values, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidNotIn(List<Long> values) {
            addCriterion("FORESTID not in", values, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidBetween(Long value1, Long value2) {
            addCriterion("FORESTID between", value1, value2, "forestid");
            return (Criteria) this;
        }

        public Criteria andForestidNotBetween(Long value1, Long value2) {
            addCriterion("FORESTID not between", value1, value2, "forestid");
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

        public Criteria andCardnumIsNull() {
            addCriterion("CARDNUM is null");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNotNull() {
            addCriterion("CARDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumEqualTo(String value) {
            addCriterion("CARDNUM =", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotEqualTo(String value) {
            addCriterion("CARDNUM <>", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThan(String value) {
            addCriterion("CARDNUM >", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("CARDNUM >=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThan(String value) {
            addCriterion("CARDNUM <", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThanOrEqualTo(String value) {
            addCriterion("CARDNUM <=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLike(String value) {
            addCriterion("CARDNUM like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotLike(String value) {
            addCriterion("CARDNUM not like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumIn(List<String> values) {
            addCriterion("CARDNUM in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotIn(List<String> values) {
            addCriterion("CARDNUM not in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumBetween(String value1, String value2) {
            addCriterion("CARDNUM between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotBetween(String value1, String value2) {
            addCriterion("CARDNUM not between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andWordnumIsNull() {
            addCriterion("WORDNUM is null");
            return (Criteria) this;
        }

        public Criteria andWordnumIsNotNull() {
            addCriterion("WORDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andWordnumEqualTo(String value) {
            addCriterion("WORDNUM =", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotEqualTo(String value) {
            addCriterion("WORDNUM <>", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumGreaterThan(String value) {
            addCriterion("WORDNUM >", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumGreaterThanOrEqualTo(String value) {
            addCriterion("WORDNUM >=", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumLessThan(String value) {
            addCriterion("WORDNUM <", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumLessThanOrEqualTo(String value) {
            addCriterion("WORDNUM <=", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumLike(String value) {
            addCriterion("WORDNUM like", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotLike(String value) {
            addCriterion("WORDNUM not like", value, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumIn(List<String> values) {
            addCriterion("WORDNUM in", values, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotIn(List<String> values) {
            addCriterion("WORDNUM not in", values, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumBetween(String value1, String value2) {
            addCriterion("WORDNUM between", value1, value2, "wordnum");
            return (Criteria) this;
        }

        public Criteria andWordnumNotBetween(String value1, String value2) {
            addCriterion("WORDNUM not between", value1, value2, "wordnum");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("OWNER is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("OWNER =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("OWNER <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("OWNER >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("OWNER <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("OWNER <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("OWNER like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("OWNER not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("OWNER in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("OWNER not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("OWNER between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("OWNER not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andUsetypeIsNull() {
            addCriterion("USETYPE is null");
            return (Criteria) this;
        }

        public Criteria andUsetypeIsNotNull() {
            addCriterion("USETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUsetypeEqualTo(String value) {
            addCriterion("USETYPE =", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeNotEqualTo(String value) {
            addCriterion("USETYPE <>", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeGreaterThan(String value) {
            addCriterion("USETYPE >", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeGreaterThanOrEqualTo(String value) {
            addCriterion("USETYPE >=", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeLessThan(String value) {
            addCriterion("USETYPE <", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeLessThanOrEqualTo(String value) {
            addCriterion("USETYPE <=", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeLike(String value) {
            addCriterion("USETYPE like", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeNotLike(String value) {
            addCriterion("USETYPE not like", value, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeIn(List<String> values) {
            addCriterion("USETYPE in", values, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeNotIn(List<String> values) {
            addCriterion("USETYPE not in", values, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeBetween(String value1, String value2) {
            addCriterion("USETYPE between", value1, value2, "usetype");
            return (Criteria) this;
        }

        public Criteria andUsetypeNotBetween(String value1, String value2) {
            addCriterion("USETYPE not between", value1, value2, "usetype");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("AREA =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("AREA <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("AREA >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("AREA >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("AREA <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("AREA <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("AREA like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("AREA not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("AREA in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("AREA not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("AREA between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("AREA not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andStorenumIsNull() {
            addCriterion("STORENUM is null");
            return (Criteria) this;
        }

        public Criteria andStorenumIsNotNull() {
            addCriterion("STORENUM is not null");
            return (Criteria) this;
        }

        public Criteria andStorenumEqualTo(String value) {
            addCriterion("STORENUM =", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumNotEqualTo(String value) {
            addCriterion("STORENUM <>", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumGreaterThan(String value) {
            addCriterion("STORENUM >", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumGreaterThanOrEqualTo(String value) {
            addCriterion("STORENUM >=", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumLessThan(String value) {
            addCriterion("STORENUM <", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumLessThanOrEqualTo(String value) {
            addCriterion("STORENUM <=", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumLike(String value) {
            addCriterion("STORENUM like", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumNotLike(String value) {
            addCriterion("STORENUM not like", value, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumIn(List<String> values) {
            addCriterion("STORENUM in", values, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumNotIn(List<String> values) {
            addCriterion("STORENUM not in", values, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumBetween(String value1, String value2) {
            addCriterion("STORENUM between", value1, value2, "storenum");
            return (Criteria) this;
        }

        public Criteria andStorenumNotBetween(String value1, String value2) {
            addCriterion("STORENUM not between", value1, value2, "storenum");
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