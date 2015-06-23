package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FarmerPayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerPayExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("YEAR is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Date value) {
            addCriterion("YEAR =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterion("YEAR <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterion("YEAR >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterion("YEAR >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterion("YEAR <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterion("YEAR <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterion("YEAR in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterion("YEAR not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterion("YEAR between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterion("YEAR not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeIsNull() {
            addCriterion("FARMINGINCOME is null");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeIsNotNull() {
            addCriterion("FARMINGINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeEqualTo(Double value) {
            addCriterion("FARMINGINCOME =", value, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeNotEqualTo(Double value) {
            addCriterion("FARMINGINCOME <>", value, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeGreaterThan(Double value) {
            addCriterion("FARMINGINCOME >", value, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("FARMINGINCOME >=", value, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeLessThan(Double value) {
            addCriterion("FARMINGINCOME <", value, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeLessThanOrEqualTo(Double value) {
            addCriterion("FARMINGINCOME <=", value, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeIn(List<Double> values) {
            addCriterion("FARMINGINCOME in", values, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeNotIn(List<Double> values) {
            addCriterion("FARMINGINCOME not in", values, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeBetween(Double value1, Double value2) {
            addCriterion("FARMINGINCOME between", value1, value2, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andFarmingincomeNotBetween(Double value1, Double value2) {
            addCriterion("FARMINGINCOME not between", value1, value2, "farmingincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeIsNull() {
            addCriterion("AVOCATIONINCOME is null");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeIsNotNull() {
            addCriterion("AVOCATIONINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeEqualTo(Double value) {
            addCriterion("AVOCATIONINCOME =", value, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeNotEqualTo(Double value) {
            addCriterion("AVOCATIONINCOME <>", value, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeGreaterThan(Double value) {
            addCriterion("AVOCATIONINCOME >", value, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("AVOCATIONINCOME >=", value, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeLessThan(Double value) {
            addCriterion("AVOCATIONINCOME <", value, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeLessThanOrEqualTo(Double value) {
            addCriterion("AVOCATIONINCOME <=", value, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeIn(List<Double> values) {
            addCriterion("AVOCATIONINCOME in", values, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeNotIn(List<Double> values) {
            addCriterion("AVOCATIONINCOME not in", values, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeBetween(Double value1, Double value2) {
            addCriterion("AVOCATIONINCOME between", value1, value2, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andAvocationincomeNotBetween(Double value1, Double value2) {
            addCriterion("AVOCATIONINCOME not between", value1, value2, "avocationincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeIsNull() {
            addCriterion("BUSINESSINCOME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeIsNotNull() {
            addCriterion("BUSINESSINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeEqualTo(Double value) {
            addCriterion("BUSINESSINCOME =", value, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeNotEqualTo(Double value) {
            addCriterion("BUSINESSINCOME <>", value, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeGreaterThan(Double value) {
            addCriterion("BUSINESSINCOME >", value, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("BUSINESSINCOME >=", value, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeLessThan(Double value) {
            addCriterion("BUSINESSINCOME <", value, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeLessThanOrEqualTo(Double value) {
            addCriterion("BUSINESSINCOME <=", value, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeIn(List<Double> values) {
            addCriterion("BUSINESSINCOME in", values, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeNotIn(List<Double> values) {
            addCriterion("BUSINESSINCOME not in", values, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeBetween(Double value1, Double value2) {
            addCriterion("BUSINESSINCOME between", value1, value2, "businessincome");
            return (Criteria) this;
        }

        public Criteria andBusinessincomeNotBetween(Double value1, Double value2) {
            addCriterion("BUSINESSINCOME not between", value1, value2, "businessincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeIsNull() {
            addCriterion("WORKINCOME is null");
            return (Criteria) this;
        }

        public Criteria andWorkincomeIsNotNull() {
            addCriterion("WORKINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkincomeEqualTo(Double value) {
            addCriterion("WORKINCOME =", value, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeNotEqualTo(Double value) {
            addCriterion("WORKINCOME <>", value, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeGreaterThan(Double value) {
            addCriterion("WORKINCOME >", value, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("WORKINCOME >=", value, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeLessThan(Double value) {
            addCriterion("WORKINCOME <", value, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeLessThanOrEqualTo(Double value) {
            addCriterion("WORKINCOME <=", value, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeIn(List<Double> values) {
            addCriterion("WORKINCOME in", values, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeNotIn(List<Double> values) {
            addCriterion("WORKINCOME not in", values, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeBetween(Double value1, Double value2) {
            addCriterion("WORKINCOME between", value1, value2, "workincome");
            return (Criteria) this;
        }

        public Criteria andWorkincomeNotBetween(Double value1, Double value2) {
            addCriterion("WORKINCOME not between", value1, value2, "workincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeIsNull() {
            addCriterion("OTHERINCOME is null");
            return (Criteria) this;
        }

        public Criteria andOtherincomeIsNotNull() {
            addCriterion("OTHERINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andOtherincomeEqualTo(Double value) {
            addCriterion("OTHERINCOME =", value, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeNotEqualTo(Double value) {
            addCriterion("OTHERINCOME <>", value, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeGreaterThan(Double value) {
            addCriterion("OTHERINCOME >", value, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("OTHERINCOME >=", value, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeLessThan(Double value) {
            addCriterion("OTHERINCOME <", value, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeLessThanOrEqualTo(Double value) {
            addCriterion("OTHERINCOME <=", value, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeIn(List<Double> values) {
            addCriterion("OTHERINCOME in", values, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeNotIn(List<Double> values) {
            addCriterion("OTHERINCOME not in", values, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeBetween(Double value1, Double value2) {
            addCriterion("OTHERINCOME between", value1, value2, "otherincome");
            return (Criteria) this;
        }

        public Criteria andOtherincomeNotBetween(Double value1, Double value2) {
            addCriterion("OTHERINCOME not between", value1, value2, "otherincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeIsNull() {
            addCriterion("TOTALINCOME is null");
            return (Criteria) this;
        }

        public Criteria andTotalincomeIsNotNull() {
            addCriterion("TOTALINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andTotalincomeEqualTo(Double value) {
            addCriterion("TOTALINCOME =", value, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeNotEqualTo(Double value) {
            addCriterion("TOTALINCOME <>", value, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeGreaterThan(Double value) {
            addCriterion("TOTALINCOME >", value, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTALINCOME >=", value, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeLessThan(Double value) {
            addCriterion("TOTALINCOME <", value, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeLessThanOrEqualTo(Double value) {
            addCriterion("TOTALINCOME <=", value, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeIn(List<Double> values) {
            addCriterion("TOTALINCOME in", values, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeNotIn(List<Double> values) {
            addCriterion("TOTALINCOME not in", values, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeBetween(Double value1, Double value2) {
            addCriterion("TOTALINCOME between", value1, value2, "totalincome");
            return (Criteria) this;
        }

        public Criteria andTotalincomeNotBetween(Double value1, Double value2) {
            addCriterion("TOTALINCOME not between", value1, value2, "totalincome");
            return (Criteria) this;
        }

        public Criteria andProductpayIsNull() {
            addCriterion("PRODUCTPAY is null");
            return (Criteria) this;
        }

        public Criteria andProductpayIsNotNull() {
            addCriterion("PRODUCTPAY is not null");
            return (Criteria) this;
        }

        public Criteria andProductpayEqualTo(Double value) {
            addCriterion("PRODUCTPAY =", value, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayNotEqualTo(Double value) {
            addCriterion("PRODUCTPAY <>", value, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayGreaterThan(Double value) {
            addCriterion("PRODUCTPAY >", value, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayGreaterThanOrEqualTo(Double value) {
            addCriterion("PRODUCTPAY >=", value, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayLessThan(Double value) {
            addCriterion("PRODUCTPAY <", value, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayLessThanOrEqualTo(Double value) {
            addCriterion("PRODUCTPAY <=", value, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayIn(List<Double> values) {
            addCriterion("PRODUCTPAY in", values, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayNotIn(List<Double> values) {
            addCriterion("PRODUCTPAY not in", values, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayBetween(Double value1, Double value2) {
            addCriterion("PRODUCTPAY between", value1, value2, "productpay");
            return (Criteria) this;
        }

        public Criteria andProductpayNotBetween(Double value1, Double value2) {
            addCriterion("PRODUCTPAY not between", value1, value2, "productpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayIsNull() {
            addCriterion("LIVINGPAY is null");
            return (Criteria) this;
        }

        public Criteria andLivingpayIsNotNull() {
            addCriterion("LIVINGPAY is not null");
            return (Criteria) this;
        }

        public Criteria andLivingpayEqualTo(Double value) {
            addCriterion("LIVINGPAY =", value, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayNotEqualTo(Double value) {
            addCriterion("LIVINGPAY <>", value, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayGreaterThan(Double value) {
            addCriterion("LIVINGPAY >", value, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayGreaterThanOrEqualTo(Double value) {
            addCriterion("LIVINGPAY >=", value, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayLessThan(Double value) {
            addCriterion("LIVINGPAY <", value, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayLessThanOrEqualTo(Double value) {
            addCriterion("LIVINGPAY <=", value, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayIn(List<Double> values) {
            addCriterion("LIVINGPAY in", values, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayNotIn(List<Double> values) {
            addCriterion("LIVINGPAY not in", values, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayBetween(Double value1, Double value2) {
            addCriterion("LIVINGPAY between", value1, value2, "livingpay");
            return (Criteria) this;
        }

        public Criteria andLivingpayNotBetween(Double value1, Double value2) {
            addCriterion("LIVINGPAY not between", value1, value2, "livingpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayIsNull() {
            addCriterion("MEDICALPAY is null");
            return (Criteria) this;
        }

        public Criteria andMedicalpayIsNotNull() {
            addCriterion("MEDICALPAY is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalpayEqualTo(Double value) {
            addCriterion("MEDICALPAY =", value, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayNotEqualTo(Double value) {
            addCriterion("MEDICALPAY <>", value, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayGreaterThan(Double value) {
            addCriterion("MEDICALPAY >", value, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayGreaterThanOrEqualTo(Double value) {
            addCriterion("MEDICALPAY >=", value, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayLessThan(Double value) {
            addCriterion("MEDICALPAY <", value, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayLessThanOrEqualTo(Double value) {
            addCriterion("MEDICALPAY <=", value, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayIn(List<Double> values) {
            addCriterion("MEDICALPAY in", values, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayNotIn(List<Double> values) {
            addCriterion("MEDICALPAY not in", values, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayBetween(Double value1, Double value2) {
            addCriterion("MEDICALPAY between", value1, value2, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andMedicalpayNotBetween(Double value1, Double value2) {
            addCriterion("MEDICALPAY not between", value1, value2, "medicalpay");
            return (Criteria) this;
        }

        public Criteria andEducatepayIsNull() {
            addCriterion("EDUCATEPAY is null");
            return (Criteria) this;
        }

        public Criteria andEducatepayIsNotNull() {
            addCriterion("EDUCATEPAY is not null");
            return (Criteria) this;
        }

        public Criteria andEducatepayEqualTo(Double value) {
            addCriterion("EDUCATEPAY =", value, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayNotEqualTo(Double value) {
            addCriterion("EDUCATEPAY <>", value, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayGreaterThan(Double value) {
            addCriterion("EDUCATEPAY >", value, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayGreaterThanOrEqualTo(Double value) {
            addCriterion("EDUCATEPAY >=", value, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayLessThan(Double value) {
            addCriterion("EDUCATEPAY <", value, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayLessThanOrEqualTo(Double value) {
            addCriterion("EDUCATEPAY <=", value, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayIn(List<Double> values) {
            addCriterion("EDUCATEPAY in", values, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayNotIn(List<Double> values) {
            addCriterion("EDUCATEPAY not in", values, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayBetween(Double value1, Double value2) {
            addCriterion("EDUCATEPAY between", value1, value2, "educatepay");
            return (Criteria) this;
        }

        public Criteria andEducatepayNotBetween(Double value1, Double value2) {
            addCriterion("EDUCATEPAY not between", value1, value2, "educatepay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayIsNull() {
            addCriterion("INSUREDPAY is null");
            return (Criteria) this;
        }

        public Criteria andInsuredpayIsNotNull() {
            addCriterion("INSUREDPAY is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredpayEqualTo(Double value) {
            addCriterion("INSUREDPAY =", value, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayNotEqualTo(Double value) {
            addCriterion("INSUREDPAY <>", value, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayGreaterThan(Double value) {
            addCriterion("INSUREDPAY >", value, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayGreaterThanOrEqualTo(Double value) {
            addCriterion("INSUREDPAY >=", value, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayLessThan(Double value) {
            addCriterion("INSUREDPAY <", value, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayLessThanOrEqualTo(Double value) {
            addCriterion("INSUREDPAY <=", value, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayIn(List<Double> values) {
            addCriterion("INSUREDPAY in", values, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayNotIn(List<Double> values) {
            addCriterion("INSUREDPAY not in", values, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayBetween(Double value1, Double value2) {
            addCriterion("INSUREDPAY between", value1, value2, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andInsuredpayNotBetween(Double value1, Double value2) {
            addCriterion("INSUREDPAY not between", value1, value2, "insuredpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayIsNull() {
            addCriterion("OTHERPAY is null");
            return (Criteria) this;
        }

        public Criteria andOtherpayIsNotNull() {
            addCriterion("OTHERPAY is not null");
            return (Criteria) this;
        }

        public Criteria andOtherpayEqualTo(Double value) {
            addCriterion("OTHERPAY =", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotEqualTo(Double value) {
            addCriterion("OTHERPAY <>", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayGreaterThan(Double value) {
            addCriterion("OTHERPAY >", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayGreaterThanOrEqualTo(Double value) {
            addCriterion("OTHERPAY >=", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayLessThan(Double value) {
            addCriterion("OTHERPAY <", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayLessThanOrEqualTo(Double value) {
            addCriterion("OTHERPAY <=", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayIn(List<Double> values) {
            addCriterion("OTHERPAY in", values, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotIn(List<Double> values) {
            addCriterion("OTHERPAY not in", values, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayBetween(Double value1, Double value2) {
            addCriterion("OTHERPAY between", value1, value2, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotBetween(Double value1, Double value2) {
            addCriterion("OTHERPAY not between", value1, value2, "otherpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayIsNull() {
            addCriterion("TOTALPAY is null");
            return (Criteria) this;
        }

        public Criteria andTotalpayIsNotNull() {
            addCriterion("TOTALPAY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpayEqualTo(Double value) {
            addCriterion("TOTALPAY =", value, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayNotEqualTo(Double value) {
            addCriterion("TOTALPAY <>", value, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayGreaterThan(Double value) {
            addCriterion("TOTALPAY >", value, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTALPAY >=", value, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayLessThan(Double value) {
            addCriterion("TOTALPAY <", value, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayLessThanOrEqualTo(Double value) {
            addCriterion("TOTALPAY <=", value, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayIn(List<Double> values) {
            addCriterion("TOTALPAY in", values, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayNotIn(List<Double> values) {
            addCriterion("TOTALPAY not in", values, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayBetween(Double value1, Double value2) {
            addCriterion("TOTALPAY between", value1, value2, "totalpay");
            return (Criteria) this;
        }

        public Criteria andTotalpayNotBetween(Double value1, Double value2) {
            addCriterion("TOTALPAY not between", value1, value2, "totalpay");
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