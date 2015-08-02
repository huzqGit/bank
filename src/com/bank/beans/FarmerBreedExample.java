package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmerBreedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerBreedExample() {
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

        public Criteria andBreedidIsNull() {
            addCriterion("BREEDID is null");
            return (Criteria) this;
        }

        public Criteria andBreedidIsNotNull() {
            addCriterion("BREEDID is not null");
            return (Criteria) this;
        }

        public Criteria andBreedidEqualTo(Long value) {
            addCriterion("BREEDID =", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidNotEqualTo(Long value) {
            addCriterion("BREEDID <>", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidGreaterThan(Long value) {
            addCriterion("BREEDID >", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidGreaterThanOrEqualTo(Long value) {
            addCriterion("BREEDID >=", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidLessThan(Long value) {
            addCriterion("BREEDID <", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidLessThanOrEqualTo(Long value) {
            addCriterion("BREEDID <=", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidIn(List<Long> values) {
            addCriterion("BREEDID in", values, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidNotIn(List<Long> values) {
            addCriterion("BREEDID not in", values, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidBetween(Long value1, Long value2) {
            addCriterion("BREEDID between", value1, value2, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidNotBetween(Long value1, Long value2) {
            addCriterion("BREEDID not between", value1, value2, "breedid");
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

        public Criteria andVarietyIsNull() {
            addCriterion("VARIETY is null");
            return (Criteria) this;
        }

        public Criteria andVarietyIsNotNull() {
            addCriterion("VARIETY is not null");
            return (Criteria) this;
        }

        public Criteria andVarietyEqualTo(String value) {
            addCriterion("VARIETY =", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotEqualTo(String value) {
            addCriterion("VARIETY <>", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyGreaterThan(String value) {
            addCriterion("VARIETY >", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyGreaterThanOrEqualTo(String value) {
            addCriterion("VARIETY >=", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyLessThan(String value) {
            addCriterion("VARIETY <", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyLessThanOrEqualTo(String value) {
            addCriterion("VARIETY <=", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyLike(String value) {
            addCriterion("VARIETY like", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotLike(String value) {
            addCriterion("VARIETY not like", value, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyIn(List<String> values) {
            addCriterion("VARIETY in", values, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotIn(List<String> values) {
            addCriterion("VARIETY not in", values, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyBetween(String value1, String value2) {
            addCriterion("VARIETY between", value1, value2, "variety");
            return (Criteria) this;
        }

        public Criteria andVarietyNotBetween(String value1, String value2) {
            addCriterion("VARIETY not between", value1, value2, "variety");
            return (Criteria) this;
        }

        public Criteria andFloorareaIsNull() {
            addCriterion("FLOORAREA is null");
            return (Criteria) this;
        }

        public Criteria andFloorareaIsNotNull() {
            addCriterion("FLOORAREA is not null");
            return (Criteria) this;
        }

        public Criteria andFloorareaEqualTo(String value) {
            addCriterion("FLOORAREA =", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaNotEqualTo(String value) {
            addCriterion("FLOORAREA <>", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaGreaterThan(String value) {
            addCriterion("FLOORAREA >", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaGreaterThanOrEqualTo(String value) {
            addCriterion("FLOORAREA >=", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaLessThan(String value) {
            addCriterion("FLOORAREA <", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaLessThanOrEqualTo(String value) {
            addCriterion("FLOORAREA <=", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaLike(String value) {
            addCriterion("FLOORAREA like", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaNotLike(String value) {
            addCriterion("FLOORAREA not like", value, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaIn(List<String> values) {
            addCriterion("FLOORAREA in", values, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaNotIn(List<String> values) {
            addCriterion("FLOORAREA not in", values, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaBetween(String value1, String value2) {
            addCriterion("FLOORAREA between", value1, value2, "floorarea");
            return (Criteria) this;
        }

        public Criteria andFloorareaNotBetween(String value1, String value2) {
            addCriterion("FLOORAREA not between", value1, value2, "floorarea");
            return (Criteria) this;
        }

        public Criteria andOutputIsNull() {
            addCriterion("OUTPUT is null");
            return (Criteria) this;
        }

        public Criteria andOutputIsNotNull() {
            addCriterion("OUTPUT is not null");
            return (Criteria) this;
        }

        public Criteria andOutputEqualTo(String value) {
            addCriterion("OUTPUT =", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotEqualTo(String value) {
            addCriterion("OUTPUT <>", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThan(String value) {
            addCriterion("OUTPUT >", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThanOrEqualTo(String value) {
            addCriterion("OUTPUT >=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThan(String value) {
            addCriterion("OUTPUT <", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThanOrEqualTo(String value) {
            addCriterion("OUTPUT <=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLike(String value) {
            addCriterion("OUTPUT like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotLike(String value) {
            addCriterion("OUTPUT not like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputIn(List<String> values) {
            addCriterion("OUTPUT in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotIn(List<String> values) {
            addCriterion("OUTPUT not in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputBetween(String value1, String value2) {
            addCriterion("OUTPUT between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotBetween(String value1, String value2) {
            addCriterion("OUTPUT not between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andOutputvalueIsNull() {
            addCriterion("OUTPUTVALUE is null");
            return (Criteria) this;
        }

        public Criteria andOutputvalueIsNotNull() {
            addCriterion("OUTPUTVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andOutputvalueEqualTo(Double value) {
            addCriterion("OUTPUTVALUE =", value, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueNotEqualTo(Double value) {
            addCriterion("OUTPUTVALUE <>", value, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueGreaterThan(Double value) {
            addCriterion("OUTPUTVALUE >", value, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueGreaterThanOrEqualTo(Double value) {
            addCriterion("OUTPUTVALUE >=", value, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueLessThan(Double value) {
            addCriterion("OUTPUTVALUE <", value, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueLessThanOrEqualTo(Double value) {
            addCriterion("OUTPUTVALUE <=", value, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueIn(List<Double> values) {
            addCriterion("OUTPUTVALUE in", values, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueNotIn(List<Double> values) {
            addCriterion("OUTPUTVALUE not in", values, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueBetween(Double value1, Double value2) {
            addCriterion("OUTPUTVALUE between", value1, value2, "outputvalue");
            return (Criteria) this;
        }

        public Criteria andOutputvalueNotBetween(Double value1, Double value2) {
            addCriterion("OUTPUTVALUE not between", value1, value2, "outputvalue");
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

        public Criteria andAssesspriceEqualTo(Double value) {
            addCriterion("ASSESSPRICE =", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotEqualTo(Double value) {
            addCriterion("ASSESSPRICE <>", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceGreaterThan(Double value) {
            addCriterion("ASSESSPRICE >", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceGreaterThanOrEqualTo(Double value) {
            addCriterion("ASSESSPRICE >=", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceLessThan(Double value) {
            addCriterion("ASSESSPRICE <", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceLessThanOrEqualTo(Double value) {
            addCriterion("ASSESSPRICE <=", value, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceIn(List<Double> values) {
            addCriterion("ASSESSPRICE in", values, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotIn(List<Double> values) {
            addCriterion("ASSESSPRICE not in", values, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceBetween(Double value1, Double value2) {
            addCriterion("ASSESSPRICE between", value1, value2, "assessprice");
            return (Criteria) this;
        }

        public Criteria andAssesspriceNotBetween(Double value1, Double value2) {
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