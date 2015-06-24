package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FarmerLoanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmerLoanExample() {
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

        public Criteria andLoanidIsNull() {
            addCriterion("LOANID is null");
            return (Criteria) this;
        }

        public Criteria andLoanidIsNotNull() {
            addCriterion("LOANID is not null");
            return (Criteria) this;
        }

        public Criteria andLoanidEqualTo(Long value) {
            addCriterion("LOANID =", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotEqualTo(Long value) {
            addCriterion("LOANID <>", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThan(Long value) {
            addCriterion("LOANID >", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThanOrEqualTo(Long value) {
            addCriterion("LOANID >=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThan(Long value) {
            addCriterion("LOANID <", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThanOrEqualTo(Long value) {
            addCriterion("LOANID <=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidIn(List<Long> values) {
            addCriterion("LOANID in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotIn(List<Long> values) {
            addCriterion("LOANID not in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidBetween(Long value1, Long value2) {
            addCriterion("LOANID between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotBetween(Long value1, Long value2) {
            addCriterion("LOANID not between", value1, value2, "loanid");
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

        public Criteria andClientnumIsNull() {
            addCriterion("CLIENTNUM is null");
            return (Criteria) this;
        }

        public Criteria andClientnumIsNotNull() {
            addCriterion("CLIENTNUM is not null");
            return (Criteria) this;
        }

        public Criteria andClientnumEqualTo(String value) {
            addCriterion("CLIENTNUM =", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumNotEqualTo(String value) {
            addCriterion("CLIENTNUM <>", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumGreaterThan(String value) {
            addCriterion("CLIENTNUM >", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENTNUM >=", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumLessThan(String value) {
            addCriterion("CLIENTNUM <", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumLessThanOrEqualTo(String value) {
            addCriterion("CLIENTNUM <=", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumLike(String value) {
            addCriterion("CLIENTNUM like", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumNotLike(String value) {
            addCriterion("CLIENTNUM not like", value, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumIn(List<String> values) {
            addCriterion("CLIENTNUM in", values, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumNotIn(List<String> values) {
            addCriterion("CLIENTNUM not in", values, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumBetween(String value1, String value2) {
            addCriterion("CLIENTNUM between", value1, value2, "clientnum");
            return (Criteria) this;
        }

        public Criteria andClientnumNotBetween(String value1, String value2) {
            addCriterion("CLIENTNUM not between", value1, value2, "clientnum");
            return (Criteria) this;
        }

        public Criteria andNotenumIsNull() {
            addCriterion("NOTENUM is null");
            return (Criteria) this;
        }

        public Criteria andNotenumIsNotNull() {
            addCriterion("NOTENUM is not null");
            return (Criteria) this;
        }

        public Criteria andNotenumEqualTo(String value) {
            addCriterion("NOTENUM =", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumNotEqualTo(String value) {
            addCriterion("NOTENUM <>", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumGreaterThan(String value) {
            addCriterion("NOTENUM >", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumGreaterThanOrEqualTo(String value) {
            addCriterion("NOTENUM >=", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumLessThan(String value) {
            addCriterion("NOTENUM <", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumLessThanOrEqualTo(String value) {
            addCriterion("NOTENUM <=", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumLike(String value) {
            addCriterion("NOTENUM like", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumNotLike(String value) {
            addCriterion("NOTENUM not like", value, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumIn(List<String> values) {
            addCriterion("NOTENUM in", values, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumNotIn(List<String> values) {
            addCriterion("NOTENUM not in", values, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumBetween(String value1, String value2) {
            addCriterion("NOTENUM between", value1, value2, "notenum");
            return (Criteria) this;
        }

        public Criteria andNotenumNotBetween(String value1, String value2) {
            addCriterion("NOTENUM not between", value1, value2, "notenum");
            return (Criteria) this;
        }

        public Criteria andCompactnumIsNull() {
            addCriterion("COMPACTNUM is null");
            return (Criteria) this;
        }

        public Criteria andCompactnumIsNotNull() {
            addCriterion("COMPACTNUM is not null");
            return (Criteria) this;
        }

        public Criteria andCompactnumEqualTo(String value) {
            addCriterion("COMPACTNUM =", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumNotEqualTo(String value) {
            addCriterion("COMPACTNUM <>", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumGreaterThan(String value) {
            addCriterion("COMPACTNUM >", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumGreaterThanOrEqualTo(String value) {
            addCriterion("COMPACTNUM >=", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumLessThan(String value) {
            addCriterion("COMPACTNUM <", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumLessThanOrEqualTo(String value) {
            addCriterion("COMPACTNUM <=", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumLike(String value) {
            addCriterion("COMPACTNUM like", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumNotLike(String value) {
            addCriterion("COMPACTNUM not like", value, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumIn(List<String> values) {
            addCriterion("COMPACTNUM in", values, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumNotIn(List<String> values) {
            addCriterion("COMPACTNUM not in", values, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumBetween(String value1, String value2) {
            addCriterion("COMPACTNUM between", value1, value2, "compactnum");
            return (Criteria) this;
        }

        public Criteria andCompactnumNotBetween(String value1, String value2) {
            addCriterion("COMPACTNUM not between", value1, value2, "compactnum");
            return (Criteria) this;
        }

        public Criteria andLoandateIsNull() {
            addCriterion("LOANDATE is null");
            return (Criteria) this;
        }

        public Criteria andLoandateIsNotNull() {
            addCriterion("LOANDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoandateEqualTo(String value) {
            addCriterion("LOANDATE =", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateNotEqualTo(String value) {
            addCriterion("LOANDATE <>", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateGreaterThan(String value) {
            addCriterion("LOANDATE >", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateGreaterThanOrEqualTo(String value) {
            addCriterion("LOANDATE >=", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateLessThan(String value) {
            addCriterion("LOANDATE <", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateLessThanOrEqualTo(String value) {
            addCriterion("LOANDATE <=", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateLike(String value) {
            addCriterion("LOANDATE like", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateNotLike(String value) {
            addCriterion("LOANDATE not like", value, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateIn(List<String> values) {
            addCriterion("LOANDATE in", values, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateNotIn(List<String> values) {
            addCriterion("LOANDATE not in", values, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateBetween(String value1, String value2) {
            addCriterion("LOANDATE between", value1, value2, "loandate");
            return (Criteria) this;
        }

        public Criteria andLoandateNotBetween(String value1, String value2) {
            addCriterion("LOANDATE not between", value1, value2, "loandate");
            return (Criteria) this;
        }

        public Criteria andLimitdateIsNull() {
            addCriterion("LIMITDATE is null");
            return (Criteria) this;
        }

        public Criteria andLimitdateIsNotNull() {
            addCriterion("LIMITDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLimitdateEqualTo(String value) {
            addCriterion("LIMITDATE =", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotEqualTo(String value) {
            addCriterion("LIMITDATE <>", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateGreaterThan(String value) {
            addCriterion("LIMITDATE >", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateGreaterThanOrEqualTo(String value) {
            addCriterion("LIMITDATE >=", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateLessThan(String value) {
            addCriterion("LIMITDATE <", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateLessThanOrEqualTo(String value) {
            addCriterion("LIMITDATE <=", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateLike(String value) {
            addCriterion("LIMITDATE like", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotLike(String value) {
            addCriterion("LIMITDATE not like", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateIn(List<String> values) {
            addCriterion("LIMITDATE in", values, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotIn(List<String> values) {
            addCriterion("LIMITDATE not in", values, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateBetween(String value1, String value2) {
            addCriterion("LIMITDATE between", value1, value2, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotBetween(String value1, String value2) {
            addCriterion("LIMITDATE not between", value1, value2, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdate1IsNull() {
            addCriterion("LIMITDATE1 is null");
            return (Criteria) this;
        }

        public Criteria andLimitdate1IsNotNull() {
            addCriterion("LIMITDATE1 is not null");
            return (Criteria) this;
        }

        public Criteria andLimitdate1EqualTo(String value) {
            addCriterion("LIMITDATE1 =", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1NotEqualTo(String value) {
            addCriterion("LIMITDATE1 <>", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1GreaterThan(String value) {
            addCriterion("LIMITDATE1 >", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1GreaterThanOrEqualTo(String value) {
            addCriterion("LIMITDATE1 >=", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1LessThan(String value) {
            addCriterion("LIMITDATE1 <", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1LessThanOrEqualTo(String value) {
            addCriterion("LIMITDATE1 <=", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1Like(String value) {
            addCriterion("LIMITDATE1 like", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1NotLike(String value) {
            addCriterion("LIMITDATE1 not like", value, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1In(List<String> values) {
            addCriterion("LIMITDATE1 in", values, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1NotIn(List<String> values) {
            addCriterion("LIMITDATE1 not in", values, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1Between(String value1, String value2) {
            addCriterion("LIMITDATE1 between", value1, value2, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andLimitdate1NotBetween(String value1, String value2) {
            addCriterion("LIMITDATE1 not between", value1, value2, "limitdate1");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("AMOUNT like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("AMOUNT not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(String value) {
            addCriterion("BALANCE =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(String value) {
            addCriterion("BALANCE <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(String value) {
            addCriterion("BALANCE >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("BALANCE >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(String value) {
            addCriterion("BALANCE <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(String value) {
            addCriterion("BALANCE <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLike(String value) {
            addCriterion("BALANCE like", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotLike(String value) {
            addCriterion("BALANCE not like", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<String> values) {
            addCriterion("BALANCE in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<String> values) {
            addCriterion("BALANCE not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(String value1, String value2) {
            addCriterion("BALANCE between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(String value1, String value2) {
            addCriterion("BALANCE not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andOweinterestIsNull() {
            addCriterion("OWEINTEREST is null");
            return (Criteria) this;
        }

        public Criteria andOweinterestIsNotNull() {
            addCriterion("OWEINTEREST is not null");
            return (Criteria) this;
        }

        public Criteria andOweinterestEqualTo(String value) {
            addCriterion("OWEINTEREST =", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestNotEqualTo(String value) {
            addCriterion("OWEINTEREST <>", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestGreaterThan(String value) {
            addCriterion("OWEINTEREST >", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestGreaterThanOrEqualTo(String value) {
            addCriterion("OWEINTEREST >=", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestLessThan(String value) {
            addCriterion("OWEINTEREST <", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestLessThanOrEqualTo(String value) {
            addCriterion("OWEINTEREST <=", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestLike(String value) {
            addCriterion("OWEINTEREST like", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestNotLike(String value) {
            addCriterion("OWEINTEREST not like", value, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestIn(List<String> values) {
            addCriterion("OWEINTEREST in", values, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestNotIn(List<String> values) {
            addCriterion("OWEINTEREST not in", values, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestBetween(String value1, String value2) {
            addCriterion("OWEINTEREST between", value1, value2, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andOweinterestNotBetween(String value1, String value2) {
            addCriterion("OWEINTEREST not between", value1, value2, "oweinterest");
            return (Criteria) this;
        }

        public Criteria andCurrentrateIsNull() {
            addCriterion("CURRENTRATE is null");
            return (Criteria) this;
        }

        public Criteria andCurrentrateIsNotNull() {
            addCriterion("CURRENTRATE is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentrateEqualTo(String value) {
            addCriterion("CURRENTRATE =", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateNotEqualTo(String value) {
            addCriterion("CURRENTRATE <>", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateGreaterThan(String value) {
            addCriterion("CURRENTRATE >", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENTRATE >=", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateLessThan(String value) {
            addCriterion("CURRENTRATE <", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateLessThanOrEqualTo(String value) {
            addCriterion("CURRENTRATE <=", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateLike(String value) {
            addCriterion("CURRENTRATE like", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateNotLike(String value) {
            addCriterion("CURRENTRATE not like", value, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateIn(List<String> values) {
            addCriterion("CURRENTRATE in", values, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateNotIn(List<String> values) {
            addCriterion("CURRENTRATE not in", values, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateBetween(String value1, String value2) {
            addCriterion("CURRENTRATE between", value1, value2, "currentrate");
            return (Criteria) this;
        }

        public Criteria andCurrentrateNotBetween(String value1, String value2) {
            addCriterion("CURRENTRATE not between", value1, value2, "currentrate");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNull() {
            addCriterion("CLIENTNAME is null");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNotNull() {
            addCriterion("CLIENTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andClientnameEqualTo(String value) {
            addCriterion("CLIENTNAME =", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotEqualTo(String value) {
            addCriterion("CLIENTNAME <>", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThan(String value) {
            addCriterion("CLIENTNAME >", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENTNAME >=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThan(String value) {
            addCriterion("CLIENTNAME <", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThanOrEqualTo(String value) {
            addCriterion("CLIENTNAME <=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLike(String value) {
            addCriterion("CLIENTNAME like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotLike(String value) {
            addCriterion("CLIENTNAME not like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameIn(List<String> values) {
            addCriterion("CLIENTNAME in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotIn(List<String> values) {
            addCriterion("CLIENTNAME not in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameBetween(String value1, String value2) {
            addCriterion("CLIENTNAME between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotBetween(String value1, String value2) {
            addCriterion("CLIENTNAME not between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andClienttypeIsNull() {
            addCriterion("CLIENTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andClienttypeIsNotNull() {
            addCriterion("CLIENTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andClienttypeEqualTo(String value) {
            addCriterion("CLIENTTYPE =", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeNotEqualTo(String value) {
            addCriterion("CLIENTTYPE <>", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeGreaterThan(String value) {
            addCriterion("CLIENTTYPE >", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENTTYPE >=", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeLessThan(String value) {
            addCriterion("CLIENTTYPE <", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeLessThanOrEqualTo(String value) {
            addCriterion("CLIENTTYPE <=", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeLike(String value) {
            addCriterion("CLIENTTYPE like", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeNotLike(String value) {
            addCriterion("CLIENTTYPE not like", value, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeIn(List<String> values) {
            addCriterion("CLIENTTYPE in", values, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeNotIn(List<String> values) {
            addCriterion("CLIENTTYPE not in", values, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeBetween(String value1, String value2) {
            addCriterion("CLIENTTYPE between", value1, value2, "clienttype");
            return (Criteria) this;
        }

        public Criteria andClienttypeNotBetween(String value1, String value2) {
            addCriterion("CLIENTTYPE not between", value1, value2, "clienttype");
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

        public Criteria andRatetypeIsNull() {
            addCriterion("RATETYPE is null");
            return (Criteria) this;
        }

        public Criteria andRatetypeIsNotNull() {
            addCriterion("RATETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRatetypeEqualTo(String value) {
            addCriterion("RATETYPE =", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeNotEqualTo(String value) {
            addCriterion("RATETYPE <>", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeGreaterThan(String value) {
            addCriterion("RATETYPE >", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("RATETYPE >=", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeLessThan(String value) {
            addCriterion("RATETYPE <", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeLessThanOrEqualTo(String value) {
            addCriterion("RATETYPE <=", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeLike(String value) {
            addCriterion("RATETYPE like", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeNotLike(String value) {
            addCriterion("RATETYPE not like", value, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeIn(List<String> values) {
            addCriterion("RATETYPE in", values, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeNotIn(List<String> values) {
            addCriterion("RATETYPE not in", values, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeBetween(String value1, String value2) {
            addCriterion("RATETYPE between", value1, value2, "ratetype");
            return (Criteria) this;
        }

        public Criteria andRatetypeNotBetween(String value1, String value2) {
            addCriterion("RATETYPE not between", value1, value2, "ratetype");
            return (Criteria) this;
        }

        public Criteria andLoanuseIsNull() {
            addCriterion("LOANUSE is null");
            return (Criteria) this;
        }

        public Criteria andLoanuseIsNotNull() {
            addCriterion("LOANUSE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanuseEqualTo(String value) {
            addCriterion("LOANUSE =", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseNotEqualTo(String value) {
            addCriterion("LOANUSE <>", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseGreaterThan(String value) {
            addCriterion("LOANUSE >", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseGreaterThanOrEqualTo(String value) {
            addCriterion("LOANUSE >=", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseLessThan(String value) {
            addCriterion("LOANUSE <", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseLessThanOrEqualTo(String value) {
            addCriterion("LOANUSE <=", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseLike(String value) {
            addCriterion("LOANUSE like", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseNotLike(String value) {
            addCriterion("LOANUSE not like", value, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseIn(List<String> values) {
            addCriterion("LOANUSE in", values, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseNotIn(List<String> values) {
            addCriterion("LOANUSE not in", values, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseBetween(String value1, String value2) {
            addCriterion("LOANUSE between", value1, value2, "loanuse");
            return (Criteria) this;
        }

        public Criteria andLoanuseNotBetween(String value1, String value2) {
            addCriterion("LOANUSE not between", value1, value2, "loanuse");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1IsNull() {
            addCriterion("GUARANTEETYPE1 is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1IsNotNull() {
            addCriterion("GUARANTEETYPE1 is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1EqualTo(String value) {
            addCriterion("GUARANTEETYPE1 =", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1NotEqualTo(String value) {
            addCriterion("GUARANTEETYPE1 <>", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1GreaterThan(String value) {
            addCriterion("GUARANTEETYPE1 >", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1GreaterThanOrEqualTo(String value) {
            addCriterion("GUARANTEETYPE1 >=", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1LessThan(String value) {
            addCriterion("GUARANTEETYPE1 <", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1LessThanOrEqualTo(String value) {
            addCriterion("GUARANTEETYPE1 <=", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1Like(String value) {
            addCriterion("GUARANTEETYPE1 like", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1NotLike(String value) {
            addCriterion("GUARANTEETYPE1 not like", value, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1In(List<String> values) {
            addCriterion("GUARANTEETYPE1 in", values, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1NotIn(List<String> values) {
            addCriterion("GUARANTEETYPE1 not in", values, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1Between(String value1, String value2) {
            addCriterion("GUARANTEETYPE1 between", value1, value2, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGuaranteetype1NotBetween(String value1, String value2) {
            addCriterion("GUARANTEETYPE1 not between", value1, value2, "guaranteetype1");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("GRADE is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("GRADE =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("GRADE <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("GRADE >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("GRADE >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("GRADE <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("GRADE <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("GRADE like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("GRADE not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("GRADE in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("GRADE not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("GRADE between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("GRADE not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGrade1IsNull() {
            addCriterion("GRADE1 is null");
            return (Criteria) this;
        }

        public Criteria andGrade1IsNotNull() {
            addCriterion("GRADE1 is not null");
            return (Criteria) this;
        }

        public Criteria andGrade1EqualTo(String value) {
            addCriterion("GRADE1 =", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1NotEqualTo(String value) {
            addCriterion("GRADE1 <>", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1GreaterThan(String value) {
            addCriterion("GRADE1 >", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1GreaterThanOrEqualTo(String value) {
            addCriterion("GRADE1 >=", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1LessThan(String value) {
            addCriterion("GRADE1 <", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1LessThanOrEqualTo(String value) {
            addCriterion("GRADE1 <=", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1Like(String value) {
            addCriterion("GRADE1 like", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1NotLike(String value) {
            addCriterion("GRADE1 not like", value, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1In(List<String> values) {
            addCriterion("GRADE1 in", values, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1NotIn(List<String> values) {
            addCriterion("GRADE1 not in", values, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1Between(String value1, String value2) {
            addCriterion("GRADE1 between", value1, value2, "grade1");
            return (Criteria) this;
        }

        public Criteria andGrade1NotBetween(String value1, String value2) {
            addCriterion("GRADE1 not between", value1, value2, "grade1");
            return (Criteria) this;
        }

        public Criteria andSettletypeIsNull() {
            addCriterion("SETTLETYPE is null");
            return (Criteria) this;
        }

        public Criteria andSettletypeIsNotNull() {
            addCriterion("SETTLETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSettletypeEqualTo(String value) {
            addCriterion("SETTLETYPE =", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeNotEqualTo(String value) {
            addCriterion("SETTLETYPE <>", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeGreaterThan(String value) {
            addCriterion("SETTLETYPE >", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLETYPE >=", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeLessThan(String value) {
            addCriterion("SETTLETYPE <", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeLessThanOrEqualTo(String value) {
            addCriterion("SETTLETYPE <=", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeLike(String value) {
            addCriterion("SETTLETYPE like", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeNotLike(String value) {
            addCriterion("SETTLETYPE not like", value, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeIn(List<String> values) {
            addCriterion("SETTLETYPE in", values, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeNotIn(List<String> values) {
            addCriterion("SETTLETYPE not in", values, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeBetween(String value1, String value2) {
            addCriterion("SETTLETYPE between", value1, value2, "settletype");
            return (Criteria) this;
        }

        public Criteria andSettletypeNotBetween(String value1, String value2) {
            addCriterion("SETTLETYPE not between", value1, value2, "settletype");
            return (Criteria) this;
        }

        public Criteria andChargepersonIsNull() {
            addCriterion("CHARGEPERSON is null");
            return (Criteria) this;
        }

        public Criteria andChargepersonIsNotNull() {
            addCriterion("CHARGEPERSON is not null");
            return (Criteria) this;
        }

        public Criteria andChargepersonEqualTo(String value) {
            addCriterion("CHARGEPERSON =", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotEqualTo(String value) {
            addCriterion("CHARGEPERSON <>", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonGreaterThan(String value) {
            addCriterion("CHARGEPERSON >", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGEPERSON >=", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonLessThan(String value) {
            addCriterion("CHARGEPERSON <", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonLessThanOrEqualTo(String value) {
            addCriterion("CHARGEPERSON <=", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonLike(String value) {
            addCriterion("CHARGEPERSON like", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotLike(String value) {
            addCriterion("CHARGEPERSON not like", value, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonIn(List<String> values) {
            addCriterion("CHARGEPERSON in", values, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotIn(List<String> values) {
            addCriterion("CHARGEPERSON not in", values, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonBetween(String value1, String value2) {
            addCriterion("CHARGEPERSON between", value1, value2, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andChargepersonNotBetween(String value1, String value2) {
            addCriterion("CHARGEPERSON not between", value1, value2, "chargeperson");
            return (Criteria) this;
        }

        public Criteria andOrgancodeIsNull() {
            addCriterion("ORGANCODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgancodeIsNotNull() {
            addCriterion("ORGANCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgancodeEqualTo(String value) {
            addCriterion("ORGANCODE =", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotEqualTo(String value) {
            addCriterion("ORGANCODE <>", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeGreaterThan(String value) {
            addCriterion("ORGANCODE >", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANCODE >=", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeLessThan(String value) {
            addCriterion("ORGANCODE <", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeLessThanOrEqualTo(String value) {
            addCriterion("ORGANCODE <=", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeLike(String value) {
            addCriterion("ORGANCODE like", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotLike(String value) {
            addCriterion("ORGANCODE not like", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeIn(List<String> values) {
            addCriterion("ORGANCODE in", values, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotIn(List<String> values) {
            addCriterion("ORGANCODE not in", values, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeBetween(String value1, String value2) {
            addCriterion("ORGANCODE between", value1, value2, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotBetween(String value1, String value2) {
            addCriterion("ORGANCODE not between", value1, value2, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgannameIsNull() {
            addCriterion("ORGANNAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgannameIsNotNull() {
            addCriterion("ORGANNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgannameEqualTo(String value) {
            addCriterion("ORGANNAME =", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotEqualTo(String value) {
            addCriterion("ORGANNAME <>", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameGreaterThan(String value) {
            addCriterion("ORGANNAME >", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANNAME >=", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameLessThan(String value) {
            addCriterion("ORGANNAME <", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameLessThanOrEqualTo(String value) {
            addCriterion("ORGANNAME <=", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameLike(String value) {
            addCriterion("ORGANNAME like", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotLike(String value) {
            addCriterion("ORGANNAME not like", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameIn(List<String> values) {
            addCriterion("ORGANNAME in", values, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotIn(List<String> values) {
            addCriterion("ORGANNAME not in", values, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameBetween(String value1, String value2) {
            addCriterion("ORGANNAME between", value1, value2, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotBetween(String value1, String value2) {
            addCriterion("ORGANNAME not between", value1, value2, "organname");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeIsNull() {
            addCriterion("BUSINESSTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeIsNotNull() {
            addCriterion("BUSINESSTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeEqualTo(String value) {
            addCriterion("BUSINESSTYPE =", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotEqualTo(String value) {
            addCriterion("BUSINESSTYPE <>", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeGreaterThan(String value) {
            addCriterion("BUSINESSTYPE >", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSTYPE >=", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeLessThan(String value) {
            addCriterion("BUSINESSTYPE <", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSTYPE <=", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeLike(String value) {
            addCriterion("BUSINESSTYPE like", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotLike(String value) {
            addCriterion("BUSINESSTYPE not like", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeIn(List<String> values) {
            addCriterion("BUSINESSTYPE in", values, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotIn(List<String> values) {
            addCriterion("BUSINESSTYPE not in", values, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeBetween(String value1, String value2) {
            addCriterion("BUSINESSTYPE between", value1, value2, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESSTYPE not between", value1, value2, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyIsNull() {
            addCriterion("BUSINESSBODY is null");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyIsNotNull() {
            addCriterion("BUSINESSBODY is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyEqualTo(String value) {
            addCriterion("BUSINESSBODY =", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyNotEqualTo(String value) {
            addCriterion("BUSINESSBODY <>", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyGreaterThan(String value) {
            addCriterion("BUSINESSBODY >", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSBODY >=", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyLessThan(String value) {
            addCriterion("BUSINESSBODY <", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSBODY <=", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyLike(String value) {
            addCriterion("BUSINESSBODY like", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyNotLike(String value) {
            addCriterion("BUSINESSBODY not like", value, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyIn(List<String> values) {
            addCriterion("BUSINESSBODY in", values, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyNotIn(List<String> values) {
            addCriterion("BUSINESSBODY not in", values, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyBetween(String value1, String value2) {
            addCriterion("BUSINESSBODY between", value1, value2, "businessbody");
            return (Criteria) this;
        }

        public Criteria andBusinessbodyNotBetween(String value1, String value2) {
            addCriterion("BUSINESSBODY not between", value1, value2, "businessbody");
            return (Criteria) this;
        }

        public Criteria andProvidetypeIsNull() {
            addCriterion("PROVIDETYPE is null");
            return (Criteria) this;
        }

        public Criteria andProvidetypeIsNotNull() {
            addCriterion("PROVIDETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProvidetypeEqualTo(String value) {
            addCriterion("PROVIDETYPE =", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeNotEqualTo(String value) {
            addCriterion("PROVIDETYPE <>", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeGreaterThan(String value) {
            addCriterion("PROVIDETYPE >", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDETYPE >=", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeLessThan(String value) {
            addCriterion("PROVIDETYPE <", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeLessThanOrEqualTo(String value) {
            addCriterion("PROVIDETYPE <=", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeLike(String value) {
            addCriterion("PROVIDETYPE like", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeNotLike(String value) {
            addCriterion("PROVIDETYPE not like", value, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeIn(List<String> values) {
            addCriterion("PROVIDETYPE in", values, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeNotIn(List<String> values) {
            addCriterion("PROVIDETYPE not in", values, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeBetween(String value1, String value2) {
            addCriterion("PROVIDETYPE between", value1, value2, "providetype");
            return (Criteria) this;
        }

        public Criteria andProvidetypeNotBetween(String value1, String value2) {
            addCriterion("PROVIDETYPE not between", value1, value2, "providetype");
            return (Criteria) this;
        }

        public Criteria andInvestIsNull() {
            addCriterion("INVEST is null");
            return (Criteria) this;
        }

        public Criteria andInvestIsNotNull() {
            addCriterion("INVEST is not null");
            return (Criteria) this;
        }

        public Criteria andInvestEqualTo(String value) {
            addCriterion("INVEST =", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestNotEqualTo(String value) {
            addCriterion("INVEST <>", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestGreaterThan(String value) {
            addCriterion("INVEST >", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestGreaterThanOrEqualTo(String value) {
            addCriterion("INVEST >=", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestLessThan(String value) {
            addCriterion("INVEST <", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestLessThanOrEqualTo(String value) {
            addCriterion("INVEST <=", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestLike(String value) {
            addCriterion("INVEST like", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestNotLike(String value) {
            addCriterion("INVEST not like", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestIn(List<String> values) {
            addCriterion("INVEST in", values, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestNotIn(List<String> values) {
            addCriterion("INVEST not in", values, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestBetween(String value1, String value2) {
            addCriterion("INVEST between", value1, value2, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestNotBetween(String value1, String value2) {
            addCriterion("INVEST not between", value1, value2, "invest");
            return (Criteria) this;
        }

        public Criteria andTermtypeIsNull() {
            addCriterion("TERMTYPE is null");
            return (Criteria) this;
        }

        public Criteria andTermtypeIsNotNull() {
            addCriterion("TERMTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTermtypeEqualTo(String value) {
            addCriterion("TERMTYPE =", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotEqualTo(String value) {
            addCriterion("TERMTYPE <>", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeGreaterThan(String value) {
            addCriterion("TERMTYPE >", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeGreaterThanOrEqualTo(String value) {
            addCriterion("TERMTYPE >=", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeLessThan(String value) {
            addCriterion("TERMTYPE <", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeLessThanOrEqualTo(String value) {
            addCriterion("TERMTYPE <=", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeLike(String value) {
            addCriterion("TERMTYPE like", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotLike(String value) {
            addCriterion("TERMTYPE not like", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeIn(List<String> values) {
            addCriterion("TERMTYPE in", values, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotIn(List<String> values) {
            addCriterion("TERMTYPE not in", values, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeBetween(String value1, String value2) {
            addCriterion("TERMTYPE between", value1, value2, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotBetween(String value1, String value2) {
            addCriterion("TERMTYPE not between", value1, value2, "termtype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeIsNull() {
            addCriterion("GUARANTEETYPE is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeIsNotNull() {
            addCriterion("GUARANTEETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeEqualTo(String value) {
            addCriterion("GUARANTEETYPE =", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeNotEqualTo(String value) {
            addCriterion("GUARANTEETYPE <>", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeGreaterThan(String value) {
            addCriterion("GUARANTEETYPE >", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeGreaterThanOrEqualTo(String value) {
            addCriterion("GUARANTEETYPE >=", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeLessThan(String value) {
            addCriterion("GUARANTEETYPE <", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeLessThanOrEqualTo(String value) {
            addCriterion("GUARANTEETYPE <=", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeLike(String value) {
            addCriterion("GUARANTEETYPE like", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeNotLike(String value) {
            addCriterion("GUARANTEETYPE not like", value, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeIn(List<String> values) {
            addCriterion("GUARANTEETYPE in", values, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeNotIn(List<String> values) {
            addCriterion("GUARANTEETYPE not in", values, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeBetween(String value1, String value2) {
            addCriterion("GUARANTEETYPE between", value1, value2, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andGuaranteetypeNotBetween(String value1, String value2) {
            addCriterion("GUARANTEETYPE not between", value1, value2, "guaranteetype");
            return (Criteria) this;
        }

        public Criteria andFloatscopeIsNull() {
            addCriterion("FLOATSCOPE is null");
            return (Criteria) this;
        }

        public Criteria andFloatscopeIsNotNull() {
            addCriterion("FLOATSCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andFloatscopeEqualTo(String value) {
            addCriterion("FLOATSCOPE =", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeNotEqualTo(String value) {
            addCriterion("FLOATSCOPE <>", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeGreaterThan(String value) {
            addCriterion("FLOATSCOPE >", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeGreaterThanOrEqualTo(String value) {
            addCriterion("FLOATSCOPE >=", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeLessThan(String value) {
            addCriterion("FLOATSCOPE <", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeLessThanOrEqualTo(String value) {
            addCriterion("FLOATSCOPE <=", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeLike(String value) {
            addCriterion("FLOATSCOPE like", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeNotLike(String value) {
            addCriterion("FLOATSCOPE not like", value, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeIn(List<String> values) {
            addCriterion("FLOATSCOPE in", values, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeNotIn(List<String> values) {
            addCriterion("FLOATSCOPE not in", values, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeBetween(String value1, String value2) {
            addCriterion("FLOATSCOPE between", value1, value2, "floatscope");
            return (Criteria) this;
        }

        public Criteria andFloatscopeNotBetween(String value1, String value2) {
            addCriterion("FLOATSCOPE not between", value1, value2, "floatscope");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeIsNull() {
            addCriterion("ADJUSTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeIsNotNull() {
            addCriterion("ADJUSTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeEqualTo(String value) {
            addCriterion("ADJUSTTYPE =", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeNotEqualTo(String value) {
            addCriterion("ADJUSTTYPE <>", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeGreaterThan(String value) {
            addCriterion("ADJUSTTYPE >", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTTYPE >=", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeLessThan(String value) {
            addCriterion("ADJUSTTYPE <", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTTYPE <=", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeLike(String value) {
            addCriterion("ADJUSTTYPE like", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeNotLike(String value) {
            addCriterion("ADJUSTTYPE not like", value, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeIn(List<String> values) {
            addCriterion("ADJUSTTYPE in", values, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeNotIn(List<String> values) {
            addCriterion("ADJUSTTYPE not in", values, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeBetween(String value1, String value2) {
            addCriterion("ADJUSTTYPE between", value1, value2, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andAdjusttypeNotBetween(String value1, String value2) {
            addCriterion("ADJUSTTYPE not between", value1, value2, "adjusttype");
            return (Criteria) this;
        }

        public Criteria andRuntypeIsNull() {
            addCriterion("RUNTYPE is null");
            return (Criteria) this;
        }

        public Criteria andRuntypeIsNotNull() {
            addCriterion("RUNTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRuntypeEqualTo(String value) {
            addCriterion("RUNTYPE =", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeNotEqualTo(String value) {
            addCriterion("RUNTYPE <>", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeGreaterThan(String value) {
            addCriterion("RUNTYPE >", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeGreaterThanOrEqualTo(String value) {
            addCriterion("RUNTYPE >=", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeLessThan(String value) {
            addCriterion("RUNTYPE <", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeLessThanOrEqualTo(String value) {
            addCriterion("RUNTYPE <=", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeLike(String value) {
            addCriterion("RUNTYPE like", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeNotLike(String value) {
            addCriterion("RUNTYPE not like", value, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeIn(List<String> values) {
            addCriterion("RUNTYPE in", values, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeNotIn(List<String> values) {
            addCriterion("RUNTYPE not in", values, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeBetween(String value1, String value2) {
            addCriterion("RUNTYPE between", value1, value2, "runtype");
            return (Criteria) this;
        }

        public Criteria andRuntypeNotBetween(String value1, String value2) {
            addCriterion("RUNTYPE not between", value1, value2, "runtype");
            return (Criteria) this;
        }

        public Criteria andFrequeencyIsNull() {
            addCriterion("FREQUEENCY is null");
            return (Criteria) this;
        }

        public Criteria andFrequeencyIsNotNull() {
            addCriterion("FREQUEENCY is not null");
            return (Criteria) this;
        }

        public Criteria andFrequeencyEqualTo(String value) {
            addCriterion("FREQUEENCY =", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyNotEqualTo(String value) {
            addCriterion("FREQUEENCY <>", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyGreaterThan(String value) {
            addCriterion("FREQUEENCY >", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyGreaterThanOrEqualTo(String value) {
            addCriterion("FREQUEENCY >=", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyLessThan(String value) {
            addCriterion("FREQUEENCY <", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyLessThanOrEqualTo(String value) {
            addCriterion("FREQUEENCY <=", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyLike(String value) {
            addCriterion("FREQUEENCY like", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyNotLike(String value) {
            addCriterion("FREQUEENCY not like", value, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyIn(List<String> values) {
            addCriterion("FREQUEENCY in", values, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyNotIn(List<String> values) {
            addCriterion("FREQUEENCY not in", values, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyBetween(String value1, String value2) {
            addCriterion("FREQUEENCY between", value1, value2, "frequeency");
            return (Criteria) this;
        }

        public Criteria andFrequeencyNotBetween(String value1, String value2) {
            addCriterion("FREQUEENCY not between", value1, value2, "frequeency");
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
            addCriterionForJDBCDate("RECORDTIME =", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("RECORDTIME <>", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("RECORDTIME >", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RECORDTIME >=", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeLessThan(Date value) {
            addCriterionForJDBCDate("RECORDTIME <", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RECORDTIME <=", value, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeIn(List<Date> values) {
            addCriterionForJDBCDate("RECORDTIME in", values, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("RECORDTIME not in", values, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RECORDTIME between", value1, value2, "recordtime");
            return (Criteria) this;
        }

        public Criteria andRecordtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RECORDTIME not between", value1, value2, "recordtime");
            return (Criteria) this;
        }

        public Criteria andClientidIsNull() {
            addCriterion("CLIENTID is null");
            return (Criteria) this;
        }

        public Criteria andClientidIsNotNull() {
            addCriterion("CLIENTID is not null");
            return (Criteria) this;
        }

        public Criteria andClientidEqualTo(Long value) {
            addCriterion("CLIENTID =", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotEqualTo(Long value) {
            addCriterion("CLIENTID <>", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThan(Long value) {
            addCriterion("CLIENTID >", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThanOrEqualTo(Long value) {
            addCriterion("CLIENTID >=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThan(Long value) {
            addCriterion("CLIENTID <", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThanOrEqualTo(Long value) {
            addCriterion("CLIENTID <=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidIn(List<Long> values) {
            addCriterion("CLIENTID in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotIn(List<Long> values) {
            addCriterion("CLIENTID not in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidBetween(Long value1, Long value2) {
            addCriterion("CLIENTID between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotBetween(Long value1, Long value2) {
            addCriterion("CLIENTID not between", value1, value2, "clientid");
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