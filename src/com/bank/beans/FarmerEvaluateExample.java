package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmerEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerEvaluateExample() {
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

        public Criteria andEvaluateidIsNull() {
            addCriterion("EVALUATEID is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateidIsNotNull() {
            addCriterion("EVALUATEID is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateidEqualTo(Long value) {
            addCriterion("EVALUATEID =", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidNotEqualTo(Long value) {
            addCriterion("EVALUATEID <>", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidGreaterThan(Long value) {
            addCriterion("EVALUATEID >", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidGreaterThanOrEqualTo(Long value) {
            addCriterion("EVALUATEID >=", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidLessThan(Long value) {
            addCriterion("EVALUATEID <", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidLessThanOrEqualTo(Long value) {
            addCriterion("EVALUATEID <=", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidIn(List<Long> values) {
            addCriterion("EVALUATEID in", values, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidNotIn(List<Long> values) {
            addCriterion("EVALUATEID not in", values, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidBetween(Long value1, Long value2) {
            addCriterion("EVALUATEID between", value1, value2, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidNotBetween(Long value1, Long value2) {
            addCriterion("EVALUATEID not between", value1, value2, "evaluateid");
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

        public Criteria andPersonalityIsNull() {
            addCriterion("PERSONALITY is null");
            return (Criteria) this;
        }

        public Criteria andPersonalityIsNotNull() {
            addCriterion("PERSONALITY is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalityEqualTo(String value) {
            addCriterion("PERSONALITY =", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityNotEqualTo(String value) {
            addCriterion("PERSONALITY <>", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityGreaterThan(String value) {
            addCriterion("PERSONALITY >", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityGreaterThanOrEqualTo(String value) {
            addCriterion("PERSONALITY >=", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityLessThan(String value) {
            addCriterion("PERSONALITY <", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityLessThanOrEqualTo(String value) {
            addCriterion("PERSONALITY <=", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityLike(String value) {
            addCriterion("PERSONALITY like", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityNotLike(String value) {
            addCriterion("PERSONALITY not like", value, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityIn(List<String> values) {
            addCriterion("PERSONALITY in", values, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityNotIn(List<String> values) {
            addCriterion("PERSONALITY not in", values, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityBetween(String value1, String value2) {
            addCriterion("PERSONALITY between", value1, value2, "personality");
            return (Criteria) this;
        }

        public Criteria andPersonalityNotBetween(String value1, String value2) {
            addCriterion("PERSONALITY not between", value1, value2, "personality");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusIsNull() {
            addCriterion("HARMONYSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusIsNotNull() {
            addCriterion("HARMONYSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusEqualTo(String value) {
            addCriterion("HARMONYSTATUS =", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusNotEqualTo(String value) {
            addCriterion("HARMONYSTATUS <>", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusGreaterThan(String value) {
            addCriterion("HARMONYSTATUS >", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusGreaterThanOrEqualTo(String value) {
            addCriterion("HARMONYSTATUS >=", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusLessThan(String value) {
            addCriterion("HARMONYSTATUS <", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusLessThanOrEqualTo(String value) {
            addCriterion("HARMONYSTATUS <=", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusLike(String value) {
            addCriterion("HARMONYSTATUS like", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusNotLike(String value) {
            addCriterion("HARMONYSTATUS not like", value, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusIn(List<String> values) {
            addCriterion("HARMONYSTATUS in", values, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusNotIn(List<String> values) {
            addCriterion("HARMONYSTATUS not in", values, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusBetween(String value1, String value2) {
            addCriterion("HARMONYSTATUS between", value1, value2, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andHarmonystatusNotBetween(String value1, String value2) {
            addCriterion("HARMONYSTATUS not between", value1, value2, "harmonystatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusIsNull() {
            addCriterion("RESPECTSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andRespectstatusIsNotNull() {
            addCriterion("RESPECTSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRespectstatusEqualTo(String value) {
            addCriterion("RESPECTSTATUS =", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusNotEqualTo(String value) {
            addCriterion("RESPECTSTATUS <>", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusGreaterThan(String value) {
            addCriterion("RESPECTSTATUS >", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusGreaterThanOrEqualTo(String value) {
            addCriterion("RESPECTSTATUS >=", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusLessThan(String value) {
            addCriterion("RESPECTSTATUS <", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusLessThanOrEqualTo(String value) {
            addCriterion("RESPECTSTATUS <=", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusLike(String value) {
            addCriterion("RESPECTSTATUS like", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusNotLike(String value) {
            addCriterion("RESPECTSTATUS not like", value, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusIn(List<String> values) {
            addCriterion("RESPECTSTATUS in", values, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusNotIn(List<String> values) {
            addCriterion("RESPECTSTATUS not in", values, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusBetween(String value1, String value2) {
            addCriterion("RESPECTSTATUS between", value1, value2, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andRespectstatusNotBetween(String value1, String value2) {
            addCriterion("RESPECTSTATUS not between", value1, value2, "respectstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusIsNull() {
            addCriterion("NEIGHBORSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusIsNotNull() {
            addCriterion("NEIGHBORSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusEqualTo(String value) {
            addCriterion("NEIGHBORSTATUS =", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusNotEqualTo(String value) {
            addCriterion("NEIGHBORSTATUS <>", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusGreaterThan(String value) {
            addCriterion("NEIGHBORSTATUS >", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusGreaterThanOrEqualTo(String value) {
            addCriterion("NEIGHBORSTATUS >=", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusLessThan(String value) {
            addCriterion("NEIGHBORSTATUS <", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusLessThanOrEqualTo(String value) {
            addCriterion("NEIGHBORSTATUS <=", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusLike(String value) {
            addCriterion("NEIGHBORSTATUS like", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusNotLike(String value) {
            addCriterion("NEIGHBORSTATUS not like", value, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusIn(List<String> values) {
            addCriterion("NEIGHBORSTATUS in", values, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusNotIn(List<String> values) {
            addCriterion("NEIGHBORSTATUS not in", values, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusBetween(String value1, String value2) {
            addCriterion("NEIGHBORSTATUS between", value1, value2, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andNeighborstatusNotBetween(String value1, String value2) {
            addCriterion("NEIGHBORSTATUS not between", value1, value2, "neighborstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusIsNull() {
            addCriterion("LEGALSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andLegalstatusIsNotNull() {
            addCriterion("LEGALSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLegalstatusEqualTo(Integer value) {
            addCriterion("LEGALSTATUS =", value, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusNotEqualTo(Integer value) {
            addCriterion("LEGALSTATUS <>", value, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusGreaterThan(Integer value) {
            addCriterion("LEGALSTATUS >", value, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("LEGALSTATUS >=", value, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusLessThan(Integer value) {
            addCriterion("LEGALSTATUS <", value, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusLessThanOrEqualTo(Integer value) {
            addCriterion("LEGALSTATUS <=", value, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusIn(List<Integer> values) {
            addCriterion("LEGALSTATUS in", values, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusNotIn(List<Integer> values) {
            addCriterion("LEGALSTATUS not in", values, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusBetween(Integer value1, Integer value2) {
            addCriterion("LEGALSTATUS between", value1, value2, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andLegalstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("LEGALSTATUS not between", value1, value2, "legalstatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusIsNull() {
            addCriterion("WELFARESTATUS is null");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusIsNotNull() {
            addCriterion("WELFARESTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusEqualTo(String value) {
            addCriterion("WELFARESTATUS =", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusNotEqualTo(String value) {
            addCriterion("WELFARESTATUS <>", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusGreaterThan(String value) {
            addCriterion("WELFARESTATUS >", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusGreaterThanOrEqualTo(String value) {
            addCriterion("WELFARESTATUS >=", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusLessThan(String value) {
            addCriterion("WELFARESTATUS <", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusLessThanOrEqualTo(String value) {
            addCriterion("WELFARESTATUS <=", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusLike(String value) {
            addCriterion("WELFARESTATUS like", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusNotLike(String value) {
            addCriterion("WELFARESTATUS not like", value, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusIn(List<String> values) {
            addCriterion("WELFARESTATUS in", values, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusNotIn(List<String> values) {
            addCriterion("WELFARESTATUS not in", values, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusBetween(String value1, String value2) {
            addCriterion("WELFARESTATUS between", value1, value2, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andWelfarestatusNotBetween(String value1, String value2) {
            addCriterion("WELFARESTATUS not between", value1, value2, "welfarestatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusIsNull() {
            addCriterion("HONESTSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andHoneststatusIsNotNull() {
            addCriterion("HONESTSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andHoneststatusEqualTo(Integer value) {
            addCriterion("HONESTSTATUS =", value, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusNotEqualTo(Integer value) {
            addCriterion("HONESTSTATUS <>", value, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusGreaterThan(Integer value) {
            addCriterion("HONESTSTATUS >", value, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("HONESTSTATUS >=", value, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusLessThan(Integer value) {
            addCriterion("HONESTSTATUS <", value, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusLessThanOrEqualTo(Integer value) {
            addCriterion("HONESTSTATUS <=", value, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusIn(List<Integer> values) {
            addCriterion("HONESTSTATUS in", values, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusNotIn(List<Integer> values) {
            addCriterion("HONESTSTATUS not in", values, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusBetween(Integer value1, Integer value2) {
            addCriterion("HONESTSTATUS between", value1, value2, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andHoneststatusNotBetween(Integer value1, Integer value2) {
            addCriterion("HONESTSTATUS not between", value1, value2, "honeststatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusIsNull() {
            addCriterion("OTHERSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andOtherstatusIsNotNull() {
            addCriterion("OTHERSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOtherstatusEqualTo(String value) {
            addCriterion("OTHERSTATUS =", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusNotEqualTo(String value) {
            addCriterion("OTHERSTATUS <>", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusGreaterThan(String value) {
            addCriterion("OTHERSTATUS >", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERSTATUS >=", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusLessThan(String value) {
            addCriterion("OTHERSTATUS <", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusLessThanOrEqualTo(String value) {
            addCriterion("OTHERSTATUS <=", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusLike(String value) {
            addCriterion("OTHERSTATUS like", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusNotLike(String value) {
            addCriterion("OTHERSTATUS not like", value, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusIn(List<String> values) {
            addCriterion("OTHERSTATUS in", values, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusNotIn(List<String> values) {
            addCriterion("OTHERSTATUS not in", values, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusBetween(String value1, String value2) {
            addCriterion("OTHERSTATUS between", value1, value2, "otherstatus");
            return (Criteria) this;
        }

        public Criteria andOtherstatusNotBetween(String value1, String value2) {
            addCriterion("OTHERSTATUS not between", value1, value2, "otherstatus");
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