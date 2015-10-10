package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CooperationDebtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CooperationDebtExample() {
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

        public Criteria andDebtidIsNull() {
            addCriterion("DEBTID is null");
            return (Criteria) this;
        }

        public Criteria andDebtidIsNotNull() {
            addCriterion("DEBTID is not null");
            return (Criteria) this;
        }

        public Criteria andDebtidEqualTo(Long value) {
            addCriterion("DEBTID =", value, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidNotEqualTo(Long value) {
            addCriterion("DEBTID <>", value, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidGreaterThan(Long value) {
            addCriterion("DEBTID >", value, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidGreaterThanOrEqualTo(Long value) {
            addCriterion("DEBTID >=", value, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidLessThan(Long value) {
            addCriterion("DEBTID <", value, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidLessThanOrEqualTo(Long value) {
            addCriterion("DEBTID <=", value, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidIn(List<Long> values) {
            addCriterion("DEBTID in", values, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidNotIn(List<Long> values) {
            addCriterion("DEBTID not in", values, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidBetween(Long value1, Long value2) {
            addCriterion("DEBTID between", value1, value2, "debtid");
            return (Criteria) this;
        }

        public Criteria andDebtidNotBetween(Long value1, Long value2) {
            addCriterion("DEBTID not between", value1, value2, "debtid");
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

        public Criteria andYearmonthIsNull() {
            addCriterion("YEARMONTH is null");
            return (Criteria) this;
        }

        public Criteria andYearmonthIsNotNull() {
            addCriterion("YEARMONTH is not null");
            return (Criteria) this;
        }

        public Criteria andYearmonthEqualTo(String value) {
            addCriterion("YEARMONTH =", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotEqualTo(String value) {
            addCriterion("YEARMONTH <>", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthGreaterThan(String value) {
            addCriterion("YEARMONTH >", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthGreaterThanOrEqualTo(String value) {
            addCriterion("YEARMONTH >=", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLessThan(String value) {
            addCriterion("YEARMONTH <", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLessThanOrEqualTo(String value) {
            addCriterion("YEARMONTH <=", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthLike(String value) {
            addCriterion("YEARMONTH like", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotLike(String value) {
            addCriterion("YEARMONTH not like", value, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthIn(List<String> values) {
            addCriterion("YEARMONTH in", values, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotIn(List<String> values) {
            addCriterion("YEARMONTH not in", values, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthBetween(String value1, String value2) {
            addCriterion("YEARMONTH between", value1, value2, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andYearmonthNotBetween(String value1, String value2) {
            addCriterion("YEARMONTH not between", value1, value2, "yearmonth");
            return (Criteria) this;
        }

        public Criteria andCashcapitalIsNull() {
            addCriterion("CASHCAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andCashcapitalIsNotNull() {
            addCriterion("CASHCAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andCashcapitalEqualTo(String value) {
            addCriterion("CASHCAPITAL =", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalNotEqualTo(String value) {
            addCriterion("CASHCAPITAL <>", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalGreaterThan(String value) {
            addCriterion("CASHCAPITAL >", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalGreaterThanOrEqualTo(String value) {
            addCriterion("CASHCAPITAL >=", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalLessThan(String value) {
            addCriterion("CASHCAPITAL <", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalLessThanOrEqualTo(String value) {
            addCriterion("CASHCAPITAL <=", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalLike(String value) {
            addCriterion("CASHCAPITAL like", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalNotLike(String value) {
            addCriterion("CASHCAPITAL not like", value, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalIn(List<String> values) {
            addCriterion("CASHCAPITAL in", values, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalNotIn(List<String> values) {
            addCriterion("CASHCAPITAL not in", values, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalBetween(String value1, String value2) {
            addCriterion("CASHCAPITAL between", value1, value2, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andCashcapitalNotBetween(String value1, String value2) {
            addCriterion("CASHCAPITAL not between", value1, value2, "cashcapital");
            return (Criteria) this;
        }

        public Criteria andShortinvestIsNull() {
            addCriterion("SHORTINVEST is null");
            return (Criteria) this;
        }

        public Criteria andShortinvestIsNotNull() {
            addCriterion("SHORTINVEST is not null");
            return (Criteria) this;
        }

        public Criteria andShortinvestEqualTo(String value) {
            addCriterion("SHORTINVEST =", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestNotEqualTo(String value) {
            addCriterion("SHORTINVEST <>", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestGreaterThan(String value) {
            addCriterion("SHORTINVEST >", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestGreaterThanOrEqualTo(String value) {
            addCriterion("SHORTINVEST >=", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestLessThan(String value) {
            addCriterion("SHORTINVEST <", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestLessThanOrEqualTo(String value) {
            addCriterion("SHORTINVEST <=", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestLike(String value) {
            addCriterion("SHORTINVEST like", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestNotLike(String value) {
            addCriterion("SHORTINVEST not like", value, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestIn(List<String> values) {
            addCriterion("SHORTINVEST in", values, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestNotIn(List<String> values) {
            addCriterion("SHORTINVEST not in", values, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestBetween(String value1, String value2) {
            addCriterion("SHORTINVEST between", value1, value2, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andShortinvestNotBetween(String value1, String value2) {
            addCriterion("SHORTINVEST not between", value1, value2, "shortinvest");
            return (Criteria) this;
        }

        public Criteria andReceivablesIsNull() {
            addCriterion("RECEIVABLES is null");
            return (Criteria) this;
        }

        public Criteria andReceivablesIsNotNull() {
            addCriterion("RECEIVABLES is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablesEqualTo(String value) {
            addCriterion("RECEIVABLES =", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotEqualTo(String value) {
            addCriterion("RECEIVABLES <>", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesGreaterThan(String value) {
            addCriterion("RECEIVABLES >", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVABLES >=", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLessThan(String value) {
            addCriterion("RECEIVABLES <", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLessThanOrEqualTo(String value) {
            addCriterion("RECEIVABLES <=", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLike(String value) {
            addCriterion("RECEIVABLES like", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotLike(String value) {
            addCriterion("RECEIVABLES not like", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesIn(List<String> values) {
            addCriterion("RECEIVABLES in", values, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotIn(List<String> values) {
            addCriterion("RECEIVABLES not in", values, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesBetween(String value1, String value2) {
            addCriterion("RECEIVABLES between", value1, value2, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotBetween(String value1, String value2) {
            addCriterion("RECEIVABLES not between", value1, value2, "receivables");
            return (Criteria) this;
        }

        public Criteria andPrepaymentIsNull() {
            addCriterion("PREPAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andPrepaymentIsNotNull() {
            addCriterion("PREPAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andPrepaymentEqualTo(String value) {
            addCriterion("PREPAYMENT =", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentNotEqualTo(String value) {
            addCriterion("PREPAYMENT <>", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentGreaterThan(String value) {
            addCriterion("PREPAYMENT >", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentGreaterThanOrEqualTo(String value) {
            addCriterion("PREPAYMENT >=", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentLessThan(String value) {
            addCriterion("PREPAYMENT <", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentLessThanOrEqualTo(String value) {
            addCriterion("PREPAYMENT <=", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentLike(String value) {
            addCriterion("PREPAYMENT like", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentNotLike(String value) {
            addCriterion("PREPAYMENT not like", value, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentIn(List<String> values) {
            addCriterion("PREPAYMENT in", values, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentNotIn(List<String> values) {
            addCriterion("PREPAYMENT not in", values, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentBetween(String value1, String value2) {
            addCriterion("PREPAYMENT between", value1, value2, "prepayment");
            return (Criteria) this;
        }

        public Criteria andPrepaymentNotBetween(String value1, String value2) {
            addCriterion("PREPAYMENT not between", value1, value2, "prepayment");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("INVENTORY is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("INVENTORY is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(String value) {
            addCriterion("INVENTORY =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(String value) {
            addCriterion("INVENTORY <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(String value) {
            addCriterion("INVENTORY >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(String value) {
            addCriterion("INVENTORY >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(String value) {
            addCriterion("INVENTORY <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(String value) {
            addCriterion("INVENTORY <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLike(String value) {
            addCriterion("INVENTORY like", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotLike(String value) {
            addCriterion("INVENTORY not like", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<String> values) {
            addCriterion("INVENTORY in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<String> values) {
            addCriterion("INVENTORY not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(String value1, String value2) {
            addCriterion("INVENTORY between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(String value1, String value2) {
            addCriterion("INVENTORY not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andFloatassetIsNull() {
            addCriterion("FLOATASSET is null");
            return (Criteria) this;
        }

        public Criteria andFloatassetIsNotNull() {
            addCriterion("FLOATASSET is not null");
            return (Criteria) this;
        }

        public Criteria andFloatassetEqualTo(String value) {
            addCriterion("FLOATASSET =", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetNotEqualTo(String value) {
            addCriterion("FLOATASSET <>", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetGreaterThan(String value) {
            addCriterion("FLOATASSET >", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetGreaterThanOrEqualTo(String value) {
            addCriterion("FLOATASSET >=", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetLessThan(String value) {
            addCriterion("FLOATASSET <", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetLessThanOrEqualTo(String value) {
            addCriterion("FLOATASSET <=", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetLike(String value) {
            addCriterion("FLOATASSET like", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetNotLike(String value) {
            addCriterion("FLOATASSET not like", value, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetIn(List<String> values) {
            addCriterion("FLOATASSET in", values, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetNotIn(List<String> values) {
            addCriterion("FLOATASSET not in", values, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetBetween(String value1, String value2) {
            addCriterion("FLOATASSET between", value1, value2, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetNotBetween(String value1, String value2) {
            addCriterion("FLOATASSET not between", value1, value2, "floatasset");
            return (Criteria) this;
        }

        public Criteria andFloatassetallIsNull() {
            addCriterion("FLOATASSETALL is null");
            return (Criteria) this;
        }

        public Criteria andFloatassetallIsNotNull() {
            addCriterion("FLOATASSETALL is not null");
            return (Criteria) this;
        }

        public Criteria andFloatassetallEqualTo(String value) {
            addCriterion("FLOATASSETALL =", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallNotEqualTo(String value) {
            addCriterion("FLOATASSETALL <>", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallGreaterThan(String value) {
            addCriterion("FLOATASSETALL >", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallGreaterThanOrEqualTo(String value) {
            addCriterion("FLOATASSETALL >=", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallLessThan(String value) {
            addCriterion("FLOATASSETALL <", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallLessThanOrEqualTo(String value) {
            addCriterion("FLOATASSETALL <=", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallLike(String value) {
            addCriterion("FLOATASSETALL like", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallNotLike(String value) {
            addCriterion("FLOATASSETALL not like", value, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallIn(List<String> values) {
            addCriterion("FLOATASSETALL in", values, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallNotIn(List<String> values) {
            addCriterion("FLOATASSETALL not in", values, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallBetween(String value1, String value2) {
            addCriterion("FLOATASSETALL between", value1, value2, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFloatassetallNotBetween(String value1, String value2) {
            addCriterion("FLOATASSETALL not between", value1, value2, "floatassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetIsNull() {
            addCriterion("FIXEDASSET is null");
            return (Criteria) this;
        }

        public Criteria andFixedassetIsNotNull() {
            addCriterion("FIXEDASSET is not null");
            return (Criteria) this;
        }

        public Criteria andFixedassetEqualTo(String value) {
            addCriterion("FIXEDASSET =", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetNotEqualTo(String value) {
            addCriterion("FIXEDASSET <>", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetGreaterThan(String value) {
            addCriterion("FIXEDASSET >", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetGreaterThanOrEqualTo(String value) {
            addCriterion("FIXEDASSET >=", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetLessThan(String value) {
            addCriterion("FIXEDASSET <", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetLessThanOrEqualTo(String value) {
            addCriterion("FIXEDASSET <=", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetLike(String value) {
            addCriterion("FIXEDASSET like", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetNotLike(String value) {
            addCriterion("FIXEDASSET not like", value, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetIn(List<String> values) {
            addCriterion("FIXEDASSET in", values, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetNotIn(List<String> values) {
            addCriterion("FIXEDASSET not in", values, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetBetween(String value1, String value2) {
            addCriterion("FIXEDASSET between", value1, value2, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andFixedassetNotBetween(String value1, String value2) {
            addCriterion("FIXEDASSET not between", value1, value2, "fixedasset");
            return (Criteria) this;
        }

        public Criteria andDeprecicationIsNull() {
            addCriterion("DEPRECICATION is null");
            return (Criteria) this;
        }

        public Criteria andDeprecicationIsNotNull() {
            addCriterion("DEPRECICATION is not null");
            return (Criteria) this;
        }

        public Criteria andDeprecicationEqualTo(String value) {
            addCriterion("DEPRECICATION =", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationNotEqualTo(String value) {
            addCriterion("DEPRECICATION <>", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationGreaterThan(String value) {
            addCriterion("DEPRECICATION >", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationGreaterThanOrEqualTo(String value) {
            addCriterion("DEPRECICATION >=", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationLessThan(String value) {
            addCriterion("DEPRECICATION <", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationLessThanOrEqualTo(String value) {
            addCriterion("DEPRECICATION <=", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationLike(String value) {
            addCriterion("DEPRECICATION like", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationNotLike(String value) {
            addCriterion("DEPRECICATION not like", value, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationIn(List<String> values) {
            addCriterion("DEPRECICATION in", values, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationNotIn(List<String> values) {
            addCriterion("DEPRECICATION not in", values, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationBetween(String value1, String value2) {
            addCriterion("DEPRECICATION between", value1, value2, "deprecication");
            return (Criteria) this;
        }

        public Criteria andDeprecicationNotBetween(String value1, String value2) {
            addCriterion("DEPRECICATION not between", value1, value2, "deprecication");
            return (Criteria) this;
        }

        public Criteria andNetvalueIsNull() {
            addCriterion("NETVALUE is null");
            return (Criteria) this;
        }

        public Criteria andNetvalueIsNotNull() {
            addCriterion("NETVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andNetvalueEqualTo(String value) {
            addCriterion("NETVALUE =", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueNotEqualTo(String value) {
            addCriterion("NETVALUE <>", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueGreaterThan(String value) {
            addCriterion("NETVALUE >", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueGreaterThanOrEqualTo(String value) {
            addCriterion("NETVALUE >=", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueLessThan(String value) {
            addCriterion("NETVALUE <", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueLessThanOrEqualTo(String value) {
            addCriterion("NETVALUE <=", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueLike(String value) {
            addCriterion("NETVALUE like", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueNotLike(String value) {
            addCriterion("NETVALUE not like", value, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueIn(List<String> values) {
            addCriterion("NETVALUE in", values, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueNotIn(List<String> values) {
            addCriterion("NETVALUE not in", values, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueBetween(String value1, String value2) {
            addCriterion("NETVALUE between", value1, value2, "netvalue");
            return (Criteria) this;
        }

        public Criteria andNetvalueNotBetween(String value1, String value2) {
            addCriterion("NETVALUE not between", value1, value2, "netvalue");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectIsNull() {
            addCriterion("BUILDINGPROJECT is null");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectIsNotNull() {
            addCriterion("BUILDINGPROJECT is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectEqualTo(String value) {
            addCriterion("BUILDINGPROJECT =", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectNotEqualTo(String value) {
            addCriterion("BUILDINGPROJECT <>", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectGreaterThan(String value) {
            addCriterion("BUILDINGPROJECT >", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDINGPROJECT >=", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectLessThan(String value) {
            addCriterion("BUILDINGPROJECT <", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectLessThanOrEqualTo(String value) {
            addCriterion("BUILDINGPROJECT <=", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectLike(String value) {
            addCriterion("BUILDINGPROJECT like", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectNotLike(String value) {
            addCriterion("BUILDINGPROJECT not like", value, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectIn(List<String> values) {
            addCriterion("BUILDINGPROJECT in", values, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectNotIn(List<String> values) {
            addCriterion("BUILDINGPROJECT not in", values, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectBetween(String value1, String value2) {
            addCriterion("BUILDINGPROJECT between", value1, value2, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andBuildingprojectNotBetween(String value1, String value2) {
            addCriterion("BUILDINGPROJECT not between", value1, value2, "buildingproject");
            return (Criteria) this;
        }

        public Criteria andFixedassetallIsNull() {
            addCriterion("FIXEDASSETALL is null");
            return (Criteria) this;
        }

        public Criteria andFixedassetallIsNotNull() {
            addCriterion("FIXEDASSETALL is not null");
            return (Criteria) this;
        }

        public Criteria andFixedassetallEqualTo(String value) {
            addCriterion("FIXEDASSETALL =", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallNotEqualTo(String value) {
            addCriterion("FIXEDASSETALL <>", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallGreaterThan(String value) {
            addCriterion("FIXEDASSETALL >", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallGreaterThanOrEqualTo(String value) {
            addCriterion("FIXEDASSETALL >=", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallLessThan(String value) {
            addCriterion("FIXEDASSETALL <", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallLessThanOrEqualTo(String value) {
            addCriterion("FIXEDASSETALL <=", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallLike(String value) {
            addCriterion("FIXEDASSETALL like", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallNotLike(String value) {
            addCriterion("FIXEDASSETALL not like", value, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallIn(List<String> values) {
            addCriterion("FIXEDASSETALL in", values, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallNotIn(List<String> values) {
            addCriterion("FIXEDASSETALL not in", values, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallBetween(String value1, String value2) {
            addCriterion("FIXEDASSETALL between", value1, value2, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andFixedassetallNotBetween(String value1, String value2) {
            addCriterion("FIXEDASSETALL not between", value1, value2, "fixedassetall");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetIsNull() {
            addCriterion("INVISIBLEASSET is null");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetIsNotNull() {
            addCriterion("INVISIBLEASSET is not null");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetEqualTo(String value) {
            addCriterion("INVISIBLEASSET =", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetNotEqualTo(String value) {
            addCriterion("INVISIBLEASSET <>", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetGreaterThan(String value) {
            addCriterion("INVISIBLEASSET >", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetGreaterThanOrEqualTo(String value) {
            addCriterion("INVISIBLEASSET >=", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetLessThan(String value) {
            addCriterion("INVISIBLEASSET <", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetLessThanOrEqualTo(String value) {
            addCriterion("INVISIBLEASSET <=", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetLike(String value) {
            addCriterion("INVISIBLEASSET like", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetNotLike(String value) {
            addCriterion("INVISIBLEASSET not like", value, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetIn(List<String> values) {
            addCriterion("INVISIBLEASSET in", values, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetNotIn(List<String> values) {
            addCriterion("INVISIBLEASSET not in", values, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetBetween(String value1, String value2) {
            addCriterion("INVISIBLEASSET between", value1, value2, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andInvisibleassetNotBetween(String value1, String value2) {
            addCriterion("INVISIBLEASSET not between", value1, value2, "invisibleasset");
            return (Criteria) this;
        }

        public Criteria andAssetallIsNull() {
            addCriterion("ASSETALL is null");
            return (Criteria) this;
        }

        public Criteria andAssetallIsNotNull() {
            addCriterion("ASSETALL is not null");
            return (Criteria) this;
        }

        public Criteria andAssetallEqualTo(String value) {
            addCriterion("ASSETALL =", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallNotEqualTo(String value) {
            addCriterion("ASSETALL <>", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallGreaterThan(String value) {
            addCriterion("ASSETALL >", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallGreaterThanOrEqualTo(String value) {
            addCriterion("ASSETALL >=", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallLessThan(String value) {
            addCriterion("ASSETALL <", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallLessThanOrEqualTo(String value) {
            addCriterion("ASSETALL <=", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallLike(String value) {
            addCriterion("ASSETALL like", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallNotLike(String value) {
            addCriterion("ASSETALL not like", value, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallIn(List<String> values) {
            addCriterion("ASSETALL in", values, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallNotIn(List<String> values) {
            addCriterion("ASSETALL not in", values, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallBetween(String value1, String value2) {
            addCriterion("ASSETALL between", value1, value2, "assetall");
            return (Criteria) this;
        }

        public Criteria andAssetallNotBetween(String value1, String value2) {
            addCriterion("ASSETALL not between", value1, value2, "assetall");
            return (Criteria) this;
        }

        public Criteria andShortloanIsNull() {
            addCriterion("SHORTLOAN is null");
            return (Criteria) this;
        }

        public Criteria andShortloanIsNotNull() {
            addCriterion("SHORTLOAN is not null");
            return (Criteria) this;
        }

        public Criteria andShortloanEqualTo(String value) {
            addCriterion("SHORTLOAN =", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanNotEqualTo(String value) {
            addCriterion("SHORTLOAN <>", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanGreaterThan(String value) {
            addCriterion("SHORTLOAN >", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanGreaterThanOrEqualTo(String value) {
            addCriterion("SHORTLOAN >=", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanLessThan(String value) {
            addCriterion("SHORTLOAN <", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanLessThanOrEqualTo(String value) {
            addCriterion("SHORTLOAN <=", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanLike(String value) {
            addCriterion("SHORTLOAN like", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanNotLike(String value) {
            addCriterion("SHORTLOAN not like", value, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanIn(List<String> values) {
            addCriterion("SHORTLOAN in", values, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanNotIn(List<String> values) {
            addCriterion("SHORTLOAN not in", values, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanBetween(String value1, String value2) {
            addCriterion("SHORTLOAN between", value1, value2, "shortloan");
            return (Criteria) this;
        }

        public Criteria andShortloanNotBetween(String value1, String value2) {
            addCriterion("SHORTLOAN not between", value1, value2, "shortloan");
            return (Criteria) this;
        }

        public Criteria andBankloanIsNull() {
            addCriterion("BANKLOAN is null");
            return (Criteria) this;
        }

        public Criteria andBankloanIsNotNull() {
            addCriterion("BANKLOAN is not null");
            return (Criteria) this;
        }

        public Criteria andBankloanEqualTo(String value) {
            addCriterion("BANKLOAN =", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanNotEqualTo(String value) {
            addCriterion("BANKLOAN <>", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanGreaterThan(String value) {
            addCriterion("BANKLOAN >", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanGreaterThanOrEqualTo(String value) {
            addCriterion("BANKLOAN >=", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanLessThan(String value) {
            addCriterion("BANKLOAN <", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanLessThanOrEqualTo(String value) {
            addCriterion("BANKLOAN <=", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanLike(String value) {
            addCriterion("BANKLOAN like", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanNotLike(String value) {
            addCriterion("BANKLOAN not like", value, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanIn(List<String> values) {
            addCriterion("BANKLOAN in", values, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanNotIn(List<String> values) {
            addCriterion("BANKLOAN not in", values, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanBetween(String value1, String value2) {
            addCriterion("BANKLOAN between", value1, value2, "bankloan");
            return (Criteria) this;
        }

        public Criteria andBankloanNotBetween(String value1, String value2) {
            addCriterion("BANKLOAN not between", value1, value2, "bankloan");
            return (Criteria) this;
        }

        public Criteria andAccountspayableIsNull() {
            addCriterion("ACCOUNTSPAYABLE is null");
            return (Criteria) this;
        }

        public Criteria andAccountspayableIsNotNull() {
            addCriterion("ACCOUNTSPAYABLE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountspayableEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE =", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableNotEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE <>", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableGreaterThan(String value) {
            addCriterion("ACCOUNTSPAYABLE >", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE >=", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableLessThan(String value) {
            addCriterion("ACCOUNTSPAYABLE <", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE <=", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableLike(String value) {
            addCriterion("ACCOUNTSPAYABLE like", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableNotLike(String value) {
            addCriterion("ACCOUNTSPAYABLE not like", value, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableIn(List<String> values) {
            addCriterion("ACCOUNTSPAYABLE in", values, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableNotIn(List<String> values) {
            addCriterion("ACCOUNTSPAYABLE not in", values, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableBetween(String value1, String value2) {
            addCriterion("ACCOUNTSPAYABLE between", value1, value2, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andAccountspayableNotBetween(String value1, String value2) {
            addCriterion("ACCOUNTSPAYABLE not between", value1, value2, "accountspayable");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedIsNull() {
            addCriterion("DEPOSITRECEIVED is null");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedIsNotNull() {
            addCriterion("DEPOSITRECEIVED is not null");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED =", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedNotEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED <>", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedGreaterThan(String value) {
            addCriterion("DEPOSITRECEIVED >", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED >=", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedLessThan(String value) {
            addCriterion("DEPOSITRECEIVED <", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedLessThanOrEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED <=", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedLike(String value) {
            addCriterion("DEPOSITRECEIVED like", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedNotLike(String value) {
            addCriterion("DEPOSITRECEIVED not like", value, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedIn(List<String> values) {
            addCriterion("DEPOSITRECEIVED in", values, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedNotIn(List<String> values) {
            addCriterion("DEPOSITRECEIVED not in", values, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedBetween(String value1, String value2) {
            addCriterion("DEPOSITRECEIVED between", value1, value2, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andDepositreceivedNotBetween(String value1, String value2) {
            addCriterion("DEPOSITRECEIVED not between", value1, value2, "depositreceived");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxIsNull() {
            addCriterion("UNPAIDTAX is null");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxIsNotNull() {
            addCriterion("UNPAIDTAX is not null");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxEqualTo(String value) {
            addCriterion("UNPAIDTAX =", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxNotEqualTo(String value) {
            addCriterion("UNPAIDTAX <>", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxGreaterThan(String value) {
            addCriterion("UNPAIDTAX >", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxGreaterThanOrEqualTo(String value) {
            addCriterion("UNPAIDTAX >=", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxLessThan(String value) {
            addCriterion("UNPAIDTAX <", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxLessThanOrEqualTo(String value) {
            addCriterion("UNPAIDTAX <=", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxLike(String value) {
            addCriterion("UNPAIDTAX like", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxNotLike(String value) {
            addCriterion("UNPAIDTAX not like", value, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxIn(List<String> values) {
            addCriterion("UNPAIDTAX in", values, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxNotIn(List<String> values) {
            addCriterion("UNPAIDTAX not in", values, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxBetween(String value1, String value2) {
            addCriterion("UNPAIDTAX between", value1, value2, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andUnpaidtaxNotBetween(String value1, String value2) {
            addCriterion("UNPAIDTAX not between", value1, value2, "unpaidtax");
            return (Criteria) this;
        }

        public Criteria andFloatdebtIsNull() {
            addCriterion("FLOATDEBT is null");
            return (Criteria) this;
        }

        public Criteria andFloatdebtIsNotNull() {
            addCriterion("FLOATDEBT is not null");
            return (Criteria) this;
        }

        public Criteria andFloatdebtEqualTo(String value) {
            addCriterion("FLOATDEBT =", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtNotEqualTo(String value) {
            addCriterion("FLOATDEBT <>", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtGreaterThan(String value) {
            addCriterion("FLOATDEBT >", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtGreaterThanOrEqualTo(String value) {
            addCriterion("FLOATDEBT >=", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtLessThan(String value) {
            addCriterion("FLOATDEBT <", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtLessThanOrEqualTo(String value) {
            addCriterion("FLOATDEBT <=", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtLike(String value) {
            addCriterion("FLOATDEBT like", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtNotLike(String value) {
            addCriterion("FLOATDEBT not like", value, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtIn(List<String> values) {
            addCriterion("FLOATDEBT in", values, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtNotIn(List<String> values) {
            addCriterion("FLOATDEBT not in", values, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtBetween(String value1, String value2) {
            addCriterion("FLOATDEBT between", value1, value2, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtNotBetween(String value1, String value2) {
            addCriterion("FLOATDEBT not between", value1, value2, "floatdebt");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallIsNull() {
            addCriterion("FLOATDEBTALL is null");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallIsNotNull() {
            addCriterion("FLOATDEBTALL is not null");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallEqualTo(String value) {
            addCriterion("FLOATDEBTALL =", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallNotEqualTo(String value) {
            addCriterion("FLOATDEBTALL <>", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallGreaterThan(String value) {
            addCriterion("FLOATDEBTALL >", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallGreaterThanOrEqualTo(String value) {
            addCriterion("FLOATDEBTALL >=", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallLessThan(String value) {
            addCriterion("FLOATDEBTALL <", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallLessThanOrEqualTo(String value) {
            addCriterion("FLOATDEBTALL <=", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallLike(String value) {
            addCriterion("FLOATDEBTALL like", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallNotLike(String value) {
            addCriterion("FLOATDEBTALL not like", value, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallIn(List<String> values) {
            addCriterion("FLOATDEBTALL in", values, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallNotIn(List<String> values) {
            addCriterion("FLOATDEBTALL not in", values, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallBetween(String value1, String value2) {
            addCriterion("FLOATDEBTALL between", value1, value2, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andFloatdebtallNotBetween(String value1, String value2) {
            addCriterion("FLOATDEBTALL not between", value1, value2, "floatdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallIsNull() {
            addCriterion("LONGDEBTALL is null");
            return (Criteria) this;
        }

        public Criteria andLongdebtallIsNotNull() {
            addCriterion("LONGDEBTALL is not null");
            return (Criteria) this;
        }

        public Criteria andLongdebtallEqualTo(String value) {
            addCriterion("LONGDEBTALL =", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallNotEqualTo(String value) {
            addCriterion("LONGDEBTALL <>", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallGreaterThan(String value) {
            addCriterion("LONGDEBTALL >", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallGreaterThanOrEqualTo(String value) {
            addCriterion("LONGDEBTALL >=", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallLessThan(String value) {
            addCriterion("LONGDEBTALL <", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallLessThanOrEqualTo(String value) {
            addCriterion("LONGDEBTALL <=", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallLike(String value) {
            addCriterion("LONGDEBTALL like", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallNotLike(String value) {
            addCriterion("LONGDEBTALL not like", value, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallIn(List<String> values) {
            addCriterion("LONGDEBTALL in", values, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallNotIn(List<String> values) {
            addCriterion("LONGDEBTALL not in", values, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallBetween(String value1, String value2) {
            addCriterion("LONGDEBTALL between", value1, value2, "longdebtall");
            return (Criteria) this;
        }

        public Criteria andLongdebtallNotBetween(String value1, String value2) {
            addCriterion("LONGDEBTALL not between", value1, value2, "longdebtall");
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

        public Criteria andCapitalreserveIsNull() {
            addCriterion("CAPITALRESERVE is null");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveIsNotNull() {
            addCriterion("CAPITALRESERVE is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveEqualTo(String value) {
            addCriterion("CAPITALRESERVE =", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveNotEqualTo(String value) {
            addCriterion("CAPITALRESERVE <>", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveGreaterThan(String value) {
            addCriterion("CAPITALRESERVE >", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveGreaterThanOrEqualTo(String value) {
            addCriterion("CAPITALRESERVE >=", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveLessThan(String value) {
            addCriterion("CAPITALRESERVE <", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveLessThanOrEqualTo(String value) {
            addCriterion("CAPITALRESERVE <=", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveLike(String value) {
            addCriterion("CAPITALRESERVE like", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveNotLike(String value) {
            addCriterion("CAPITALRESERVE not like", value, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveIn(List<String> values) {
            addCriterion("CAPITALRESERVE in", values, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveNotIn(List<String> values) {
            addCriterion("CAPITALRESERVE not in", values, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveBetween(String value1, String value2) {
            addCriterion("CAPITALRESERVE between", value1, value2, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andCapitalreserveNotBetween(String value1, String value2) {
            addCriterion("CAPITALRESERVE not between", value1, value2, "capitalreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveIsNull() {
            addCriterion("SURPLUSRESERVE is null");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveIsNotNull() {
            addCriterion("SURPLUSRESERVE is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveEqualTo(String value) {
            addCriterion("SURPLUSRESERVE =", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveNotEqualTo(String value) {
            addCriterion("SURPLUSRESERVE <>", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveGreaterThan(String value) {
            addCriterion("SURPLUSRESERVE >", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveGreaterThanOrEqualTo(String value) {
            addCriterion("SURPLUSRESERVE >=", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveLessThan(String value) {
            addCriterion("SURPLUSRESERVE <", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveLessThanOrEqualTo(String value) {
            addCriterion("SURPLUSRESERVE <=", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveLike(String value) {
            addCriterion("SURPLUSRESERVE like", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveNotLike(String value) {
            addCriterion("SURPLUSRESERVE not like", value, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveIn(List<String> values) {
            addCriterion("SURPLUSRESERVE in", values, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveNotIn(List<String> values) {
            addCriterion("SURPLUSRESERVE not in", values, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveBetween(String value1, String value2) {
            addCriterion("SURPLUSRESERVE between", value1, value2, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andSurplusreserveNotBetween(String value1, String value2) {
            addCriterion("SURPLUSRESERVE not between", value1, value2, "surplusreserve");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitIsNull() {
            addCriterion("UNALLOTPROFIT is null");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitIsNotNull() {
            addCriterion("UNALLOTPROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitEqualTo(String value) {
            addCriterion("UNALLOTPROFIT =", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitNotEqualTo(String value) {
            addCriterion("UNALLOTPROFIT <>", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitGreaterThan(String value) {
            addCriterion("UNALLOTPROFIT >", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitGreaterThanOrEqualTo(String value) {
            addCriterion("UNALLOTPROFIT >=", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitLessThan(String value) {
            addCriterion("UNALLOTPROFIT <", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitLessThanOrEqualTo(String value) {
            addCriterion("UNALLOTPROFIT <=", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitLike(String value) {
            addCriterion("UNALLOTPROFIT like", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitNotLike(String value) {
            addCriterion("UNALLOTPROFIT not like", value, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitIn(List<String> values) {
            addCriterion("UNALLOTPROFIT in", values, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitNotIn(List<String> values) {
            addCriterion("UNALLOTPROFIT not in", values, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitBetween(String value1, String value2) {
            addCriterion("UNALLOTPROFIT between", value1, value2, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andUnallotprofitNotBetween(String value1, String value2) {
            addCriterion("UNALLOTPROFIT not between", value1, value2, "unallotprofit");
            return (Criteria) this;
        }

        public Criteria andTotalequityIsNull() {
            addCriterion("TOTALEQUITY is null");
            return (Criteria) this;
        }

        public Criteria andTotalequityIsNotNull() {
            addCriterion("TOTALEQUITY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalequityEqualTo(String value) {
            addCriterion("TOTALEQUITY =", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityNotEqualTo(String value) {
            addCriterion("TOTALEQUITY <>", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityGreaterThan(String value) {
            addCriterion("TOTALEQUITY >", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityGreaterThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY >=", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityLessThan(String value) {
            addCriterion("TOTALEQUITY <", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityLessThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY <=", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityLike(String value) {
            addCriterion("TOTALEQUITY like", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityNotLike(String value) {
            addCriterion("TOTALEQUITY not like", value, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityIn(List<String> values) {
            addCriterion("TOTALEQUITY in", values, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityNotIn(List<String> values) {
            addCriterion("TOTALEQUITY not in", values, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityBetween(String value1, String value2) {
            addCriterion("TOTALEQUITY between", value1, value2, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequityNotBetween(String value1, String value2) {
            addCriterion("TOTALEQUITY not between", value1, value2, "totalequity");
            return (Criteria) this;
        }

        public Criteria andTotalequity1IsNull() {
            addCriterion("TOTALEQUITY1 is null");
            return (Criteria) this;
        }

        public Criteria andTotalequity1IsNotNull() {
            addCriterion("TOTALEQUITY1 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalequity1EqualTo(String value) {
            addCriterion("TOTALEQUITY1 =", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1NotEqualTo(String value) {
            addCriterion("TOTALEQUITY1 <>", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1GreaterThan(String value) {
            addCriterion("TOTALEQUITY1 >", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1GreaterThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY1 >=", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1LessThan(String value) {
            addCriterion("TOTALEQUITY1 <", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1LessThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY1 <=", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1Like(String value) {
            addCriterion("TOTALEQUITY1 like", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1NotLike(String value) {
            addCriterion("TOTALEQUITY1 not like", value, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1In(List<String> values) {
            addCriterion("TOTALEQUITY1 in", values, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1NotIn(List<String> values) {
            addCriterion("TOTALEQUITY1 not in", values, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1Between(String value1, String value2) {
            addCriterion("TOTALEQUITY1 between", value1, value2, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andTotalequity1NotBetween(String value1, String value2) {
            addCriterion("TOTALEQUITY1 not between", value1, value2, "totalequity1");
            return (Criteria) this;
        }

        public Criteria andHandingcostIsNull() {
            addCriterion("HANDINGCOST is null");
            return (Criteria) this;
        }

        public Criteria andHandingcostIsNotNull() {
            addCriterion("HANDINGCOST is not null");
            return (Criteria) this;
        }

        public Criteria andHandingcostEqualTo(String value) {
            addCriterion("HANDINGCOST =", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostNotEqualTo(String value) {
            addCriterion("HANDINGCOST <>", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostGreaterThan(String value) {
            addCriterion("HANDINGCOST >", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostGreaterThanOrEqualTo(String value) {
            addCriterion("HANDINGCOST >=", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostLessThan(String value) {
            addCriterion("HANDINGCOST <", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostLessThanOrEqualTo(String value) {
            addCriterion("HANDINGCOST <=", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostLike(String value) {
            addCriterion("HANDINGCOST like", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostNotLike(String value) {
            addCriterion("HANDINGCOST not like", value, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostIn(List<String> values) {
            addCriterion("HANDINGCOST in", values, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostNotIn(List<String> values) {
            addCriterion("HANDINGCOST not in", values, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostBetween(String value1, String value2) {
            addCriterion("HANDINGCOST between", value1, value2, "handingcost");
            return (Criteria) this;
        }

        public Criteria andHandingcostNotBetween(String value1, String value2) {
            addCriterion("HANDINGCOST not between", value1, value2, "handingcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostIsNull() {
            addCriterion("FINANCIALCOST is null");
            return (Criteria) this;
        }

        public Criteria andFinancialcostIsNotNull() {
            addCriterion("FINANCIALCOST is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialcostEqualTo(String value) {
            addCriterion("FINANCIALCOST =", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostNotEqualTo(String value) {
            addCriterion("FINANCIALCOST <>", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostGreaterThan(String value) {
            addCriterion("FINANCIALCOST >", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostGreaterThanOrEqualTo(String value) {
            addCriterion("FINANCIALCOST >=", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostLessThan(String value) {
            addCriterion("FINANCIALCOST <", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostLessThanOrEqualTo(String value) {
            addCriterion("FINANCIALCOST <=", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostLike(String value) {
            addCriterion("FINANCIALCOST like", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostNotLike(String value) {
            addCriterion("FINANCIALCOST not like", value, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostIn(List<String> values) {
            addCriterion("FINANCIALCOST in", values, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostNotIn(List<String> values) {
            addCriterion("FINANCIALCOST not in", values, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostBetween(String value1, String value2) {
            addCriterion("FINANCIALCOST between", value1, value2, "financialcost");
            return (Criteria) this;
        }

        public Criteria andFinancialcostNotBetween(String value1, String value2) {
            addCriterion("FINANCIALCOST not between", value1, value2, "financialcost");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseIsNull() {
            addCriterion("INTERESTEXPENSE is null");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseIsNotNull() {
            addCriterion("INTERESTEXPENSE is not null");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseEqualTo(String value) {
            addCriterion("INTERESTEXPENSE =", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseNotEqualTo(String value) {
            addCriterion("INTERESTEXPENSE <>", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseGreaterThan(String value) {
            addCriterion("INTERESTEXPENSE >", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseGreaterThanOrEqualTo(String value) {
            addCriterion("INTERESTEXPENSE >=", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseLessThan(String value) {
            addCriterion("INTERESTEXPENSE <", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseLessThanOrEqualTo(String value) {
            addCriterion("INTERESTEXPENSE <=", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseLike(String value) {
            addCriterion("INTERESTEXPENSE like", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseNotLike(String value) {
            addCriterion("INTERESTEXPENSE not like", value, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseIn(List<String> values) {
            addCriterion("INTERESTEXPENSE in", values, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseNotIn(List<String> values) {
            addCriterion("INTERESTEXPENSE not in", values, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseBetween(String value1, String value2) {
            addCriterion("INTERESTEXPENSE between", value1, value2, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andInterestexpenseNotBetween(String value1, String value2) {
            addCriterion("INTERESTEXPENSE not between", value1, value2, "interestexpense");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitIsNull() {
            addCriterion("BUSINESSPROFIT is null");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitIsNotNull() {
            addCriterion("BUSINESSPROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitEqualTo(String value) {
            addCriterion("BUSINESSPROFIT =", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitNotEqualTo(String value) {
            addCriterion("BUSINESSPROFIT <>", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitGreaterThan(String value) {
            addCriterion("BUSINESSPROFIT >", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSPROFIT >=", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitLessThan(String value) {
            addCriterion("BUSINESSPROFIT <", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSPROFIT <=", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitLike(String value) {
            addCriterion("BUSINESSPROFIT like", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitNotLike(String value) {
            addCriterion("BUSINESSPROFIT not like", value, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitIn(List<String> values) {
            addCriterion("BUSINESSPROFIT in", values, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitNotIn(List<String> values) {
            addCriterion("BUSINESSPROFIT not in", values, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitBetween(String value1, String value2) {
            addCriterion("BUSINESSPROFIT between", value1, value2, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andBusinessprofitNotBetween(String value1, String value2) {
            addCriterion("BUSINESSPROFIT not between", value1, value2, "businessprofit");
            return (Criteria) this;
        }

        public Criteria andInvestincomeIsNull() {
            addCriterion("INVESTINCOME is null");
            return (Criteria) this;
        }

        public Criteria andInvestincomeIsNotNull() {
            addCriterion("INVESTINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andInvestincomeEqualTo(String value) {
            addCriterion("INVESTINCOME =", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeNotEqualTo(String value) {
            addCriterion("INVESTINCOME <>", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeGreaterThan(String value) {
            addCriterion("INVESTINCOME >", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeGreaterThanOrEqualTo(String value) {
            addCriterion("INVESTINCOME >=", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeLessThan(String value) {
            addCriterion("INVESTINCOME <", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeLessThanOrEqualTo(String value) {
            addCriterion("INVESTINCOME <=", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeLike(String value) {
            addCriterion("INVESTINCOME like", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeNotLike(String value) {
            addCriterion("INVESTINCOME not like", value, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeIn(List<String> values) {
            addCriterion("INVESTINCOME in", values, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeNotIn(List<String> values) {
            addCriterion("INVESTINCOME not in", values, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeBetween(String value1, String value2) {
            addCriterion("INVESTINCOME between", value1, value2, "investincome");
            return (Criteria) this;
        }

        public Criteria andInvestincomeNotBetween(String value1, String value2) {
            addCriterion("INVESTINCOME not between", value1, value2, "investincome");
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

        public Criteria andSubsidyincomeEqualTo(String value) {
            addCriterion("SUBSIDYINCOME =", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotEqualTo(String value) {
            addCriterion("SUBSIDYINCOME <>", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeGreaterThan(String value) {
            addCriterion("SUBSIDYINCOME >", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBSIDYINCOME >=", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeLessThan(String value) {
            addCriterion("SUBSIDYINCOME <", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeLessThanOrEqualTo(String value) {
            addCriterion("SUBSIDYINCOME <=", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeLike(String value) {
            addCriterion("SUBSIDYINCOME like", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotLike(String value) {
            addCriterion("SUBSIDYINCOME not like", value, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeIn(List<String> values) {
            addCriterion("SUBSIDYINCOME in", values, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotIn(List<String> values) {
            addCriterion("SUBSIDYINCOME not in", values, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBetween(String value1, String value2) {
            addCriterion("SUBSIDYINCOME between", value1, value2, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeNotBetween(String value1, String value2) {
            addCriterion("SUBSIDYINCOME not between", value1, value2, "subsidyincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeIsNull() {
            addCriterion("UNBUSINESSINCOME is null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeIsNotNull() {
            addCriterion("UNBUSINESSINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME =", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeNotEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME <>", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeGreaterThan(String value) {
            addCriterion("UNBUSINESSINCOME >", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeGreaterThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME >=", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeLessThan(String value) {
            addCriterion("UNBUSINESSINCOME <", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeLessThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME <=", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeLike(String value) {
            addCriterion("UNBUSINESSINCOME like", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeNotLike(String value) {
            addCriterion("UNBUSINESSINCOME not like", value, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeIn(List<String> values) {
            addCriterion("UNBUSINESSINCOME in", values, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeNotIn(List<String> values) {
            addCriterion("UNBUSINESSINCOME not in", values, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeBetween(String value1, String value2) {
            addCriterion("UNBUSINESSINCOME between", value1, value2, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincomeNotBetween(String value1, String value2) {
            addCriterion("UNBUSINESSINCOME not between", value1, value2, "unbusinessincome");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseIsNull() {
            addCriterion("UNBUSINESSEXPENSE is null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseIsNotNull() {
            addCriterion("UNBUSINESSEXPENSE is not null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE =", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseNotEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE <>", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseGreaterThan(String value) {
            addCriterion("UNBUSINESSEXPENSE >", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseGreaterThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE >=", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseLessThan(String value) {
            addCriterion("UNBUSINESSEXPENSE <", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseLessThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE <=", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseLike(String value) {
            addCriterion("UNBUSINESSEXPENSE like", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseNotLike(String value) {
            addCriterion("UNBUSINESSEXPENSE not like", value, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseIn(List<String> values) {
            addCriterion("UNBUSINESSEXPENSE in", values, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseNotIn(List<String> values) {
            addCriterion("UNBUSINESSEXPENSE not in", values, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseBetween(String value1, String value2) {
            addCriterion("UNBUSINESSEXPENSE between", value1, value2, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpenseNotBetween(String value1, String value2) {
            addCriterion("UNBUSINESSEXPENSE not between", value1, value2, "unbusinessexpense");
            return (Criteria) this;
        }

        public Criteria andProfitlossIsNull() {
            addCriterion("PROFITLOSS is null");
            return (Criteria) this;
        }

        public Criteria andProfitlossIsNotNull() {
            addCriterion("PROFITLOSS is not null");
            return (Criteria) this;
        }

        public Criteria andProfitlossEqualTo(String value) {
            addCriterion("PROFITLOSS =", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossNotEqualTo(String value) {
            addCriterion("PROFITLOSS <>", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossGreaterThan(String value) {
            addCriterion("PROFITLOSS >", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossGreaterThanOrEqualTo(String value) {
            addCriterion("PROFITLOSS >=", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossLessThan(String value) {
            addCriterion("PROFITLOSS <", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossLessThanOrEqualTo(String value) {
            addCriterion("PROFITLOSS <=", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossLike(String value) {
            addCriterion("PROFITLOSS like", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossNotLike(String value) {
            addCriterion("PROFITLOSS not like", value, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossIn(List<String> values) {
            addCriterion("PROFITLOSS in", values, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossNotIn(List<String> values) {
            addCriterion("PROFITLOSS not in", values, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossBetween(String value1, String value2) {
            addCriterion("PROFITLOSS between", value1, value2, "profitloss");
            return (Criteria) this;
        }

        public Criteria andProfitlossNotBetween(String value1, String value2) {
            addCriterion("PROFITLOSS not between", value1, value2, "profitloss");
            return (Criteria) this;
        }

        public Criteria andTotalprofitIsNull() {
            addCriterion("TOTALPROFIT is null");
            return (Criteria) this;
        }

        public Criteria andTotalprofitIsNotNull() {
            addCriterion("TOTALPROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalprofitEqualTo(String value) {
            addCriterion("TOTALPROFIT =", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitNotEqualTo(String value) {
            addCriterion("TOTALPROFIT <>", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitGreaterThan(String value) {
            addCriterion("TOTALPROFIT >", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitGreaterThanOrEqualTo(String value) {
            addCriterion("TOTALPROFIT >=", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitLessThan(String value) {
            addCriterion("TOTALPROFIT <", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitLessThanOrEqualTo(String value) {
            addCriterion("TOTALPROFIT <=", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitLike(String value) {
            addCriterion("TOTALPROFIT like", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitNotLike(String value) {
            addCriterion("TOTALPROFIT not like", value, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitIn(List<String> values) {
            addCriterion("TOTALPROFIT in", values, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitNotIn(List<String> values) {
            addCriterion("TOTALPROFIT not in", values, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitBetween(String value1, String value2) {
            addCriterion("TOTALPROFIT between", value1, value2, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andTotalprofitNotBetween(String value1, String value2) {
            addCriterion("TOTALPROFIT not between", value1, value2, "totalprofit");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxIsNull() {
            addCriterion("PAYABLEINCOMETAX is null");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxIsNotNull() {
            addCriterion("PAYABLEINCOMETAX is not null");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX =", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxNotEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX <>", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxGreaterThan(String value) {
            addCriterion("PAYABLEINCOMETAX >", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxGreaterThanOrEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX >=", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxLessThan(String value) {
            addCriterion("PAYABLEINCOMETAX <", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxLessThanOrEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX <=", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxLike(String value) {
            addCriterion("PAYABLEINCOMETAX like", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxNotLike(String value) {
            addCriterion("PAYABLEINCOMETAX not like", value, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxIn(List<String> values) {
            addCriterion("PAYABLEINCOMETAX in", values, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxNotIn(List<String> values) {
            addCriterion("PAYABLEINCOMETAX not in", values, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxBetween(String value1, String value2) {
            addCriterion("PAYABLEINCOMETAX between", value1, value2, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableincometaxNotBetween(String value1, String value2) {
            addCriterion("PAYABLEINCOMETAX not between", value1, value2, "payableincometax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxIsNull() {
            addCriterion("PAYABLEADDEDTAX is null");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxIsNotNull() {
            addCriterion("PAYABLEADDEDTAX is not null");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX =", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxNotEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX <>", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxGreaterThan(String value) {
            addCriterion("PAYABLEADDEDTAX >", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxGreaterThanOrEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX >=", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxLessThan(String value) {
            addCriterion("PAYABLEADDEDTAX <", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxLessThanOrEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX <=", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxLike(String value) {
            addCriterion("PAYABLEADDEDTAX like", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxNotLike(String value) {
            addCriterion("PAYABLEADDEDTAX not like", value, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxIn(List<String> values) {
            addCriterion("PAYABLEADDEDTAX in", values, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxNotIn(List<String> values) {
            addCriterion("PAYABLEADDEDTAX not in", values, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxBetween(String value1, String value2) {
            addCriterion("PAYABLEADDEDTAX between", value1, value2, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtaxNotBetween(String value1, String value2) {
            addCriterion("PAYABLEADDEDTAX not between", value1, value2, "payableaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxIsNull() {
            addCriterion("PAIDADDEDTAX is null");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxIsNotNull() {
            addCriterion("PAIDADDEDTAX is not null");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxEqualTo(String value) {
            addCriterion("PAIDADDEDTAX =", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxNotEqualTo(String value) {
            addCriterion("PAIDADDEDTAX <>", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxGreaterThan(String value) {
            addCriterion("PAIDADDEDTAX >", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxGreaterThanOrEqualTo(String value) {
            addCriterion("PAIDADDEDTAX >=", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxLessThan(String value) {
            addCriterion("PAIDADDEDTAX <", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxLessThanOrEqualTo(String value) {
            addCriterion("PAIDADDEDTAX <=", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxLike(String value) {
            addCriterion("PAIDADDEDTAX like", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxNotLike(String value) {
            addCriterion("PAIDADDEDTAX not like", value, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxIn(List<String> values) {
            addCriterion("PAIDADDEDTAX in", values, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxNotIn(List<String> values) {
            addCriterion("PAIDADDEDTAX not in", values, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxBetween(String value1, String value2) {
            addCriterion("PAIDADDEDTAX between", value1, value2, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtaxNotBetween(String value1, String value2) {
            addCriterion("PAIDADDEDTAX not between", value1, value2, "paidaddedtax");
            return (Criteria) this;
        }

        public Criteria andNetprofitIsNull() {
            addCriterion("NETPROFIT is null");
            return (Criteria) this;
        }

        public Criteria andNetprofitIsNotNull() {
            addCriterion("NETPROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andNetprofitEqualTo(String value) {
            addCriterion("NETPROFIT =", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitNotEqualTo(String value) {
            addCriterion("NETPROFIT <>", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitGreaterThan(String value) {
            addCriterion("NETPROFIT >", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitGreaterThanOrEqualTo(String value) {
            addCriterion("NETPROFIT >=", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitLessThan(String value) {
            addCriterion("NETPROFIT <", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitLessThanOrEqualTo(String value) {
            addCriterion("NETPROFIT <=", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitLike(String value) {
            addCriterion("NETPROFIT like", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitNotLike(String value) {
            addCriterion("NETPROFIT not like", value, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitIn(List<String> values) {
            addCriterion("NETPROFIT in", values, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitNotIn(List<String> values) {
            addCriterion("NETPROFIT not in", values, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitBetween(String value1, String value2) {
            addCriterion("NETPROFIT between", value1, value2, "netprofit");
            return (Criteria) this;
        }

        public Criteria andNetprofitNotBetween(String value1, String value2) {
            addCriterion("NETPROFIT not between", value1, value2, "netprofit");
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

        public Criteria andCashcapital2IsNull() {
            addCriterion("CASHCAPITAL2 is null");
            return (Criteria) this;
        }

        public Criteria andCashcapital2IsNotNull() {
            addCriterion("CASHCAPITAL2 is not null");
            return (Criteria) this;
        }

        public Criteria andCashcapital2EqualTo(String value) {
            addCriterion("CASHCAPITAL2 =", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2NotEqualTo(String value) {
            addCriterion("CASHCAPITAL2 <>", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2GreaterThan(String value) {
            addCriterion("CASHCAPITAL2 >", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2GreaterThanOrEqualTo(String value) {
            addCriterion("CASHCAPITAL2 >=", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2LessThan(String value) {
            addCriterion("CASHCAPITAL2 <", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2LessThanOrEqualTo(String value) {
            addCriterion("CASHCAPITAL2 <=", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2Like(String value) {
            addCriterion("CASHCAPITAL2 like", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2NotLike(String value) {
            addCriterion("CASHCAPITAL2 not like", value, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2In(List<String> values) {
            addCriterion("CASHCAPITAL2 in", values, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2NotIn(List<String> values) {
            addCriterion("CASHCAPITAL2 not in", values, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2Between(String value1, String value2) {
            addCriterion("CASHCAPITAL2 between", value1, value2, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andCashcapital2NotBetween(String value1, String value2) {
            addCriterion("CASHCAPITAL2 not between", value1, value2, "cashcapital2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2IsNull() {
            addCriterion("SHORTINVEST2 is null");
            return (Criteria) this;
        }

        public Criteria andShortinvest2IsNotNull() {
            addCriterion("SHORTINVEST2 is not null");
            return (Criteria) this;
        }

        public Criteria andShortinvest2EqualTo(String value) {
            addCriterion("SHORTINVEST2 =", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2NotEqualTo(String value) {
            addCriterion("SHORTINVEST2 <>", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2GreaterThan(String value) {
            addCriterion("SHORTINVEST2 >", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2GreaterThanOrEqualTo(String value) {
            addCriterion("SHORTINVEST2 >=", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2LessThan(String value) {
            addCriterion("SHORTINVEST2 <", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2LessThanOrEqualTo(String value) {
            addCriterion("SHORTINVEST2 <=", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2Like(String value) {
            addCriterion("SHORTINVEST2 like", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2NotLike(String value) {
            addCriterion("SHORTINVEST2 not like", value, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2In(List<String> values) {
            addCriterion("SHORTINVEST2 in", values, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2NotIn(List<String> values) {
            addCriterion("SHORTINVEST2 not in", values, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2Between(String value1, String value2) {
            addCriterion("SHORTINVEST2 between", value1, value2, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andShortinvest2NotBetween(String value1, String value2) {
            addCriterion("SHORTINVEST2 not between", value1, value2, "shortinvest2");
            return (Criteria) this;
        }

        public Criteria andReceivables2IsNull() {
            addCriterion("RECEIVABLES2 is null");
            return (Criteria) this;
        }

        public Criteria andReceivables2IsNotNull() {
            addCriterion("RECEIVABLES2 is not null");
            return (Criteria) this;
        }

        public Criteria andReceivables2EqualTo(String value) {
            addCriterion("RECEIVABLES2 =", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2NotEqualTo(String value) {
            addCriterion("RECEIVABLES2 <>", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2GreaterThan(String value) {
            addCriterion("RECEIVABLES2 >", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2GreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVABLES2 >=", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2LessThan(String value) {
            addCriterion("RECEIVABLES2 <", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2LessThanOrEqualTo(String value) {
            addCriterion("RECEIVABLES2 <=", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2Like(String value) {
            addCriterion("RECEIVABLES2 like", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2NotLike(String value) {
            addCriterion("RECEIVABLES2 not like", value, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2In(List<String> values) {
            addCriterion("RECEIVABLES2 in", values, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2NotIn(List<String> values) {
            addCriterion("RECEIVABLES2 not in", values, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2Between(String value1, String value2) {
            addCriterion("RECEIVABLES2 between", value1, value2, "receivables2");
            return (Criteria) this;
        }

        public Criteria andReceivables2NotBetween(String value1, String value2) {
            addCriterion("RECEIVABLES2 not between", value1, value2, "receivables2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2IsNull() {
            addCriterion("PREPAYMENT2 is null");
            return (Criteria) this;
        }

        public Criteria andPrepayment2IsNotNull() {
            addCriterion("PREPAYMENT2 is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayment2EqualTo(String value) {
            addCriterion("PREPAYMENT2 =", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2NotEqualTo(String value) {
            addCriterion("PREPAYMENT2 <>", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2GreaterThan(String value) {
            addCriterion("PREPAYMENT2 >", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2GreaterThanOrEqualTo(String value) {
            addCriterion("PREPAYMENT2 >=", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2LessThan(String value) {
            addCriterion("PREPAYMENT2 <", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2LessThanOrEqualTo(String value) {
            addCriterion("PREPAYMENT2 <=", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2Like(String value) {
            addCriterion("PREPAYMENT2 like", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2NotLike(String value) {
            addCriterion("PREPAYMENT2 not like", value, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2In(List<String> values) {
            addCriterion("PREPAYMENT2 in", values, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2NotIn(List<String> values) {
            addCriterion("PREPAYMENT2 not in", values, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2Between(String value1, String value2) {
            addCriterion("PREPAYMENT2 between", value1, value2, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andPrepayment2NotBetween(String value1, String value2) {
            addCriterion("PREPAYMENT2 not between", value1, value2, "prepayment2");
            return (Criteria) this;
        }

        public Criteria andInventory2IsNull() {
            addCriterion("INVENTORY2 is null");
            return (Criteria) this;
        }

        public Criteria andInventory2IsNotNull() {
            addCriterion("INVENTORY2 is not null");
            return (Criteria) this;
        }

        public Criteria andInventory2EqualTo(String value) {
            addCriterion("INVENTORY2 =", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2NotEqualTo(String value) {
            addCriterion("INVENTORY2 <>", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2GreaterThan(String value) {
            addCriterion("INVENTORY2 >", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2GreaterThanOrEqualTo(String value) {
            addCriterion("INVENTORY2 >=", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2LessThan(String value) {
            addCriterion("INVENTORY2 <", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2LessThanOrEqualTo(String value) {
            addCriterion("INVENTORY2 <=", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2Like(String value) {
            addCriterion("INVENTORY2 like", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2NotLike(String value) {
            addCriterion("INVENTORY2 not like", value, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2In(List<String> values) {
            addCriterion("INVENTORY2 in", values, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2NotIn(List<String> values) {
            addCriterion("INVENTORY2 not in", values, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2Between(String value1, String value2) {
            addCriterion("INVENTORY2 between", value1, value2, "inventory2");
            return (Criteria) this;
        }

        public Criteria andInventory2NotBetween(String value1, String value2) {
            addCriterion("INVENTORY2 not between", value1, value2, "inventory2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2IsNull() {
            addCriterion("FLOATASSET2 is null");
            return (Criteria) this;
        }

        public Criteria andFloatasset2IsNotNull() {
            addCriterion("FLOATASSET2 is not null");
            return (Criteria) this;
        }

        public Criteria andFloatasset2EqualTo(String value) {
            addCriterion("FLOATASSET2 =", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2NotEqualTo(String value) {
            addCriterion("FLOATASSET2 <>", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2GreaterThan(String value) {
            addCriterion("FLOATASSET2 >", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2GreaterThanOrEqualTo(String value) {
            addCriterion("FLOATASSET2 >=", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2LessThan(String value) {
            addCriterion("FLOATASSET2 <", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2LessThanOrEqualTo(String value) {
            addCriterion("FLOATASSET2 <=", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2Like(String value) {
            addCriterion("FLOATASSET2 like", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2NotLike(String value) {
            addCriterion("FLOATASSET2 not like", value, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2In(List<String> values) {
            addCriterion("FLOATASSET2 in", values, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2NotIn(List<String> values) {
            addCriterion("FLOATASSET2 not in", values, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2Between(String value1, String value2) {
            addCriterion("FLOATASSET2 between", value1, value2, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatasset2NotBetween(String value1, String value2) {
            addCriterion("FLOATASSET2 not between", value1, value2, "floatasset2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2IsNull() {
            addCriterion("FLOATASSETALL2 is null");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2IsNotNull() {
            addCriterion("FLOATASSETALL2 is not null");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2EqualTo(String value) {
            addCriterion("FLOATASSETALL2 =", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2NotEqualTo(String value) {
            addCriterion("FLOATASSETALL2 <>", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2GreaterThan(String value) {
            addCriterion("FLOATASSETALL2 >", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2GreaterThanOrEqualTo(String value) {
            addCriterion("FLOATASSETALL2 >=", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2LessThan(String value) {
            addCriterion("FLOATASSETALL2 <", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2LessThanOrEqualTo(String value) {
            addCriterion("FLOATASSETALL2 <=", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2Like(String value) {
            addCriterion("FLOATASSETALL2 like", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2NotLike(String value) {
            addCriterion("FLOATASSETALL2 not like", value, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2In(List<String> values) {
            addCriterion("FLOATASSETALL2 in", values, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2NotIn(List<String> values) {
            addCriterion("FLOATASSETALL2 not in", values, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2Between(String value1, String value2) {
            addCriterion("FLOATASSETALL2 between", value1, value2, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFloatassetall2NotBetween(String value1, String value2) {
            addCriterion("FLOATASSETALL2 not between", value1, value2, "floatassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2IsNull() {
            addCriterion("FIXEDASSET2 is null");
            return (Criteria) this;
        }

        public Criteria andFixedasset2IsNotNull() {
            addCriterion("FIXEDASSET2 is not null");
            return (Criteria) this;
        }

        public Criteria andFixedasset2EqualTo(String value) {
            addCriterion("FIXEDASSET2 =", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2NotEqualTo(String value) {
            addCriterion("FIXEDASSET2 <>", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2GreaterThan(String value) {
            addCriterion("FIXEDASSET2 >", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2GreaterThanOrEqualTo(String value) {
            addCriterion("FIXEDASSET2 >=", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2LessThan(String value) {
            addCriterion("FIXEDASSET2 <", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2LessThanOrEqualTo(String value) {
            addCriterion("FIXEDASSET2 <=", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2Like(String value) {
            addCriterion("FIXEDASSET2 like", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2NotLike(String value) {
            addCriterion("FIXEDASSET2 not like", value, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2In(List<String> values) {
            addCriterion("FIXEDASSET2 in", values, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2NotIn(List<String> values) {
            addCriterion("FIXEDASSET2 not in", values, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2Between(String value1, String value2) {
            addCriterion("FIXEDASSET2 between", value1, value2, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andFixedasset2NotBetween(String value1, String value2) {
            addCriterion("FIXEDASSET2 not between", value1, value2, "fixedasset2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2IsNull() {
            addCriterion("DEPRECICATION2 is null");
            return (Criteria) this;
        }

        public Criteria andDeprecication2IsNotNull() {
            addCriterion("DEPRECICATION2 is not null");
            return (Criteria) this;
        }

        public Criteria andDeprecication2EqualTo(String value) {
            addCriterion("DEPRECICATION2 =", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2NotEqualTo(String value) {
            addCriterion("DEPRECICATION2 <>", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2GreaterThan(String value) {
            addCriterion("DEPRECICATION2 >", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2GreaterThanOrEqualTo(String value) {
            addCriterion("DEPRECICATION2 >=", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2LessThan(String value) {
            addCriterion("DEPRECICATION2 <", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2LessThanOrEqualTo(String value) {
            addCriterion("DEPRECICATION2 <=", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2Like(String value) {
            addCriterion("DEPRECICATION2 like", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2NotLike(String value) {
            addCriterion("DEPRECICATION2 not like", value, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2In(List<String> values) {
            addCriterion("DEPRECICATION2 in", values, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2NotIn(List<String> values) {
            addCriterion("DEPRECICATION2 not in", values, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2Between(String value1, String value2) {
            addCriterion("DEPRECICATION2 between", value1, value2, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andDeprecication2NotBetween(String value1, String value2) {
            addCriterion("DEPRECICATION2 not between", value1, value2, "deprecication2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2IsNull() {
            addCriterion("NETVALUE2 is null");
            return (Criteria) this;
        }

        public Criteria andNetvalue2IsNotNull() {
            addCriterion("NETVALUE2 is not null");
            return (Criteria) this;
        }

        public Criteria andNetvalue2EqualTo(String value) {
            addCriterion("NETVALUE2 =", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2NotEqualTo(String value) {
            addCriterion("NETVALUE2 <>", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2GreaterThan(String value) {
            addCriterion("NETVALUE2 >", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2GreaterThanOrEqualTo(String value) {
            addCriterion("NETVALUE2 >=", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2LessThan(String value) {
            addCriterion("NETVALUE2 <", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2LessThanOrEqualTo(String value) {
            addCriterion("NETVALUE2 <=", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2Like(String value) {
            addCriterion("NETVALUE2 like", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2NotLike(String value) {
            addCriterion("NETVALUE2 not like", value, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2In(List<String> values) {
            addCriterion("NETVALUE2 in", values, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2NotIn(List<String> values) {
            addCriterion("NETVALUE2 not in", values, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2Between(String value1, String value2) {
            addCriterion("NETVALUE2 between", value1, value2, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andNetvalue2NotBetween(String value1, String value2) {
            addCriterion("NETVALUE2 not between", value1, value2, "netvalue2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2IsNull() {
            addCriterion("BUILDINGPROJECT2 is null");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2IsNotNull() {
            addCriterion("BUILDINGPROJECT2 is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2EqualTo(String value) {
            addCriterion("BUILDINGPROJECT2 =", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2NotEqualTo(String value) {
            addCriterion("BUILDINGPROJECT2 <>", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2GreaterThan(String value) {
            addCriterion("BUILDINGPROJECT2 >", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2GreaterThanOrEqualTo(String value) {
            addCriterion("BUILDINGPROJECT2 >=", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2LessThan(String value) {
            addCriterion("BUILDINGPROJECT2 <", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2LessThanOrEqualTo(String value) {
            addCriterion("BUILDINGPROJECT2 <=", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2Like(String value) {
            addCriterion("BUILDINGPROJECT2 like", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2NotLike(String value) {
            addCriterion("BUILDINGPROJECT2 not like", value, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2In(List<String> values) {
            addCriterion("BUILDINGPROJECT2 in", values, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2NotIn(List<String> values) {
            addCriterion("BUILDINGPROJECT2 not in", values, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2Between(String value1, String value2) {
            addCriterion("BUILDINGPROJECT2 between", value1, value2, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andBuildingproject2NotBetween(String value1, String value2) {
            addCriterion("BUILDINGPROJECT2 not between", value1, value2, "buildingproject2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2IsNull() {
            addCriterion("FIXEDASSETALL2 is null");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2IsNotNull() {
            addCriterion("FIXEDASSETALL2 is not null");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2EqualTo(String value) {
            addCriterion("FIXEDASSETALL2 =", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2NotEqualTo(String value) {
            addCriterion("FIXEDASSETALL2 <>", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2GreaterThan(String value) {
            addCriterion("FIXEDASSETALL2 >", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2GreaterThanOrEqualTo(String value) {
            addCriterion("FIXEDASSETALL2 >=", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2LessThan(String value) {
            addCriterion("FIXEDASSETALL2 <", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2LessThanOrEqualTo(String value) {
            addCriterion("FIXEDASSETALL2 <=", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2Like(String value) {
            addCriterion("FIXEDASSETALL2 like", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2NotLike(String value) {
            addCriterion("FIXEDASSETALL2 not like", value, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2In(List<String> values) {
            addCriterion("FIXEDASSETALL2 in", values, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2NotIn(List<String> values) {
            addCriterion("FIXEDASSETALL2 not in", values, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2Between(String value1, String value2) {
            addCriterion("FIXEDASSETALL2 between", value1, value2, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andFixedassetall2NotBetween(String value1, String value2) {
            addCriterion("FIXEDASSETALL2 not between", value1, value2, "fixedassetall2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2IsNull() {
            addCriterion("INVISIBLEASSET2 is null");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2IsNotNull() {
            addCriterion("INVISIBLEASSET2 is not null");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2EqualTo(String value) {
            addCriterion("INVISIBLEASSET2 =", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2NotEqualTo(String value) {
            addCriterion("INVISIBLEASSET2 <>", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2GreaterThan(String value) {
            addCriterion("INVISIBLEASSET2 >", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2GreaterThanOrEqualTo(String value) {
            addCriterion("INVISIBLEASSET2 >=", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2LessThan(String value) {
            addCriterion("INVISIBLEASSET2 <", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2LessThanOrEqualTo(String value) {
            addCriterion("INVISIBLEASSET2 <=", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2Like(String value) {
            addCriterion("INVISIBLEASSET2 like", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2NotLike(String value) {
            addCriterion("INVISIBLEASSET2 not like", value, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2In(List<String> values) {
            addCriterion("INVISIBLEASSET2 in", values, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2NotIn(List<String> values) {
            addCriterion("INVISIBLEASSET2 not in", values, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2Between(String value1, String value2) {
            addCriterion("INVISIBLEASSET2 between", value1, value2, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andInvisibleasset2NotBetween(String value1, String value2) {
            addCriterion("INVISIBLEASSET2 not between", value1, value2, "invisibleasset2");
            return (Criteria) this;
        }

        public Criteria andAssetall2IsNull() {
            addCriterion("ASSETALL2 is null");
            return (Criteria) this;
        }

        public Criteria andAssetall2IsNotNull() {
            addCriterion("ASSETALL2 is not null");
            return (Criteria) this;
        }

        public Criteria andAssetall2EqualTo(String value) {
            addCriterion("ASSETALL2 =", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2NotEqualTo(String value) {
            addCriterion("ASSETALL2 <>", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2GreaterThan(String value) {
            addCriterion("ASSETALL2 >", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2GreaterThanOrEqualTo(String value) {
            addCriterion("ASSETALL2 >=", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2LessThan(String value) {
            addCriterion("ASSETALL2 <", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2LessThanOrEqualTo(String value) {
            addCriterion("ASSETALL2 <=", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2Like(String value) {
            addCriterion("ASSETALL2 like", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2NotLike(String value) {
            addCriterion("ASSETALL2 not like", value, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2In(List<String> values) {
            addCriterion("ASSETALL2 in", values, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2NotIn(List<String> values) {
            addCriterion("ASSETALL2 not in", values, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2Between(String value1, String value2) {
            addCriterion("ASSETALL2 between", value1, value2, "assetall2");
            return (Criteria) this;
        }

        public Criteria andAssetall2NotBetween(String value1, String value2) {
            addCriterion("ASSETALL2 not between", value1, value2, "assetall2");
            return (Criteria) this;
        }

        public Criteria andShortloan2IsNull() {
            addCriterion("SHORTLOAN2 is null");
            return (Criteria) this;
        }

        public Criteria andShortloan2IsNotNull() {
            addCriterion("SHORTLOAN2 is not null");
            return (Criteria) this;
        }

        public Criteria andShortloan2EqualTo(String value) {
            addCriterion("SHORTLOAN2 =", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2NotEqualTo(String value) {
            addCriterion("SHORTLOAN2 <>", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2GreaterThan(String value) {
            addCriterion("SHORTLOAN2 >", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2GreaterThanOrEqualTo(String value) {
            addCriterion("SHORTLOAN2 >=", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2LessThan(String value) {
            addCriterion("SHORTLOAN2 <", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2LessThanOrEqualTo(String value) {
            addCriterion("SHORTLOAN2 <=", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2Like(String value) {
            addCriterion("SHORTLOAN2 like", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2NotLike(String value) {
            addCriterion("SHORTLOAN2 not like", value, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2In(List<String> values) {
            addCriterion("SHORTLOAN2 in", values, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2NotIn(List<String> values) {
            addCriterion("SHORTLOAN2 not in", values, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2Between(String value1, String value2) {
            addCriterion("SHORTLOAN2 between", value1, value2, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andShortloan2NotBetween(String value1, String value2) {
            addCriterion("SHORTLOAN2 not between", value1, value2, "shortloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2IsNull() {
            addCriterion("BANKLOAN2 is null");
            return (Criteria) this;
        }

        public Criteria andBankloan2IsNotNull() {
            addCriterion("BANKLOAN2 is not null");
            return (Criteria) this;
        }

        public Criteria andBankloan2EqualTo(String value) {
            addCriterion("BANKLOAN2 =", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2NotEqualTo(String value) {
            addCriterion("BANKLOAN2 <>", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2GreaterThan(String value) {
            addCriterion("BANKLOAN2 >", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2GreaterThanOrEqualTo(String value) {
            addCriterion("BANKLOAN2 >=", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2LessThan(String value) {
            addCriterion("BANKLOAN2 <", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2LessThanOrEqualTo(String value) {
            addCriterion("BANKLOAN2 <=", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2Like(String value) {
            addCriterion("BANKLOAN2 like", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2NotLike(String value) {
            addCriterion("BANKLOAN2 not like", value, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2In(List<String> values) {
            addCriterion("BANKLOAN2 in", values, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2NotIn(List<String> values) {
            addCriterion("BANKLOAN2 not in", values, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2Between(String value1, String value2) {
            addCriterion("BANKLOAN2 between", value1, value2, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andBankloan2NotBetween(String value1, String value2) {
            addCriterion("BANKLOAN2 not between", value1, value2, "bankloan2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2IsNull() {
            addCriterion("ACCOUNTSPAYABLE2 is null");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2IsNotNull() {
            addCriterion("ACCOUNTSPAYABLE2 is not null");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2EqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE2 =", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2NotEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE2 <>", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2GreaterThan(String value) {
            addCriterion("ACCOUNTSPAYABLE2 >", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2GreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE2 >=", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2LessThan(String value) {
            addCriterion("ACCOUNTSPAYABLE2 <", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2LessThanOrEqualTo(String value) {
            addCriterion("ACCOUNTSPAYABLE2 <=", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2Like(String value) {
            addCriterion("ACCOUNTSPAYABLE2 like", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2NotLike(String value) {
            addCriterion("ACCOUNTSPAYABLE2 not like", value, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2In(List<String> values) {
            addCriterion("ACCOUNTSPAYABLE2 in", values, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2NotIn(List<String> values) {
            addCriterion("ACCOUNTSPAYABLE2 not in", values, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2Between(String value1, String value2) {
            addCriterion("ACCOUNTSPAYABLE2 between", value1, value2, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andAccountspayable2NotBetween(String value1, String value2) {
            addCriterion("ACCOUNTSPAYABLE2 not between", value1, value2, "accountspayable2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2IsNull() {
            addCriterion("DEPOSITRECEIVED2 is null");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2IsNotNull() {
            addCriterion("DEPOSITRECEIVED2 is not null");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2EqualTo(String value) {
            addCriterion("DEPOSITRECEIVED2 =", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2NotEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED2 <>", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2GreaterThan(String value) {
            addCriterion("DEPOSITRECEIVED2 >", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2GreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED2 >=", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2LessThan(String value) {
            addCriterion("DEPOSITRECEIVED2 <", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2LessThanOrEqualTo(String value) {
            addCriterion("DEPOSITRECEIVED2 <=", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2Like(String value) {
            addCriterion("DEPOSITRECEIVED2 like", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2NotLike(String value) {
            addCriterion("DEPOSITRECEIVED2 not like", value, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2In(List<String> values) {
            addCriterion("DEPOSITRECEIVED2 in", values, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2NotIn(List<String> values) {
            addCriterion("DEPOSITRECEIVED2 not in", values, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2Between(String value1, String value2) {
            addCriterion("DEPOSITRECEIVED2 between", value1, value2, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andDepositreceived2NotBetween(String value1, String value2) {
            addCriterion("DEPOSITRECEIVED2 not between", value1, value2, "depositreceived2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2IsNull() {
            addCriterion("UNPAIDTAX2 is null");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2IsNotNull() {
            addCriterion("UNPAIDTAX2 is not null");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2EqualTo(String value) {
            addCriterion("UNPAIDTAX2 =", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2NotEqualTo(String value) {
            addCriterion("UNPAIDTAX2 <>", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2GreaterThan(String value) {
            addCriterion("UNPAIDTAX2 >", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2GreaterThanOrEqualTo(String value) {
            addCriterion("UNPAIDTAX2 >=", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2LessThan(String value) {
            addCriterion("UNPAIDTAX2 <", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2LessThanOrEqualTo(String value) {
            addCriterion("UNPAIDTAX2 <=", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2Like(String value) {
            addCriterion("UNPAIDTAX2 like", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2NotLike(String value) {
            addCriterion("UNPAIDTAX2 not like", value, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2In(List<String> values) {
            addCriterion("UNPAIDTAX2 in", values, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2NotIn(List<String> values) {
            addCriterion("UNPAIDTAX2 not in", values, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2Between(String value1, String value2) {
            addCriterion("UNPAIDTAX2 between", value1, value2, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andUnpaidtax2NotBetween(String value1, String value2) {
            addCriterion("UNPAIDTAX2 not between", value1, value2, "unpaidtax2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2IsNull() {
            addCriterion("FLOATDEBT2 is null");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2IsNotNull() {
            addCriterion("FLOATDEBT2 is not null");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2EqualTo(String value) {
            addCriterion("FLOATDEBT2 =", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2NotEqualTo(String value) {
            addCriterion("FLOATDEBT2 <>", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2GreaterThan(String value) {
            addCriterion("FLOATDEBT2 >", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2GreaterThanOrEqualTo(String value) {
            addCriterion("FLOATDEBT2 >=", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2LessThan(String value) {
            addCriterion("FLOATDEBT2 <", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2LessThanOrEqualTo(String value) {
            addCriterion("FLOATDEBT2 <=", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2Like(String value) {
            addCriterion("FLOATDEBT2 like", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2NotLike(String value) {
            addCriterion("FLOATDEBT2 not like", value, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2In(List<String> values) {
            addCriterion("FLOATDEBT2 in", values, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2NotIn(List<String> values) {
            addCriterion("FLOATDEBT2 not in", values, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2Between(String value1, String value2) {
            addCriterion("FLOATDEBT2 between", value1, value2, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebt2NotBetween(String value1, String value2) {
            addCriterion("FLOATDEBT2 not between", value1, value2, "floatdebt2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2IsNull() {
            addCriterion("FLOATDEBTALL2 is null");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2IsNotNull() {
            addCriterion("FLOATDEBTALL2 is not null");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2EqualTo(String value) {
            addCriterion("FLOATDEBTALL2 =", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2NotEqualTo(String value) {
            addCriterion("FLOATDEBTALL2 <>", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2GreaterThan(String value) {
            addCriterion("FLOATDEBTALL2 >", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2GreaterThanOrEqualTo(String value) {
            addCriterion("FLOATDEBTALL2 >=", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2LessThan(String value) {
            addCriterion("FLOATDEBTALL2 <", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2LessThanOrEqualTo(String value) {
            addCriterion("FLOATDEBTALL2 <=", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2Like(String value) {
            addCriterion("FLOATDEBTALL2 like", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2NotLike(String value) {
            addCriterion("FLOATDEBTALL2 not like", value, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2In(List<String> values) {
            addCriterion("FLOATDEBTALL2 in", values, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2NotIn(List<String> values) {
            addCriterion("FLOATDEBTALL2 not in", values, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2Between(String value1, String value2) {
            addCriterion("FLOATDEBTALL2 between", value1, value2, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andFloatdebtall2NotBetween(String value1, String value2) {
            addCriterion("FLOATDEBTALL2 not between", value1, value2, "floatdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2IsNull() {
            addCriterion("LONGDEBTALL2 is null");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2IsNotNull() {
            addCriterion("LONGDEBTALL2 is not null");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2EqualTo(String value) {
            addCriterion("LONGDEBTALL2 =", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2NotEqualTo(String value) {
            addCriterion("LONGDEBTALL2 <>", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2GreaterThan(String value) {
            addCriterion("LONGDEBTALL2 >", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2GreaterThanOrEqualTo(String value) {
            addCriterion("LONGDEBTALL2 >=", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2LessThan(String value) {
            addCriterion("LONGDEBTALL2 <", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2LessThanOrEqualTo(String value) {
            addCriterion("LONGDEBTALL2 <=", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2Like(String value) {
            addCriterion("LONGDEBTALL2 like", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2NotLike(String value) {
            addCriterion("LONGDEBTALL2 not like", value, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2In(List<String> values) {
            addCriterion("LONGDEBTALL2 in", values, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2NotIn(List<String> values) {
            addCriterion("LONGDEBTALL2 not in", values, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2Between(String value1, String value2) {
            addCriterion("LONGDEBTALL2 between", value1, value2, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andLongdebtall2NotBetween(String value1, String value2) {
            addCriterion("LONGDEBTALL2 not between", value1, value2, "longdebtall2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2IsNull() {
            addCriterion("REGISTERCAPITAL2 is null");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2IsNotNull() {
            addCriterion("REGISTERCAPITAL2 is not null");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2EqualTo(String value) {
            addCriterion("REGISTERCAPITAL2 =", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2NotEqualTo(String value) {
            addCriterion("REGISTERCAPITAL2 <>", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2GreaterThan(String value) {
            addCriterion("REGISTERCAPITAL2 >", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2GreaterThanOrEqualTo(String value) {
            addCriterion("REGISTERCAPITAL2 >=", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2LessThan(String value) {
            addCriterion("REGISTERCAPITAL2 <", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2LessThanOrEqualTo(String value) {
            addCriterion("REGISTERCAPITAL2 <=", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2Like(String value) {
            addCriterion("REGISTERCAPITAL2 like", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2NotLike(String value) {
            addCriterion("REGISTERCAPITAL2 not like", value, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2In(List<String> values) {
            addCriterion("REGISTERCAPITAL2 in", values, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2NotIn(List<String> values) {
            addCriterion("REGISTERCAPITAL2 not in", values, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2Between(String value1, String value2) {
            addCriterion("REGISTERCAPITAL2 between", value1, value2, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRegistercapital2NotBetween(String value1, String value2) {
            addCriterion("REGISTERCAPITAL2 not between", value1, value2, "registercapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2IsNull() {
            addCriterion("REALCAPITAL2 is null");
            return (Criteria) this;
        }

        public Criteria andRealcapital2IsNotNull() {
            addCriterion("REALCAPITAL2 is not null");
            return (Criteria) this;
        }

        public Criteria andRealcapital2EqualTo(String value) {
            addCriterion("REALCAPITAL2 =", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2NotEqualTo(String value) {
            addCriterion("REALCAPITAL2 <>", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2GreaterThan(String value) {
            addCriterion("REALCAPITAL2 >", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2GreaterThanOrEqualTo(String value) {
            addCriterion("REALCAPITAL2 >=", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2LessThan(String value) {
            addCriterion("REALCAPITAL2 <", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2LessThanOrEqualTo(String value) {
            addCriterion("REALCAPITAL2 <=", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2Like(String value) {
            addCriterion("REALCAPITAL2 like", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2NotLike(String value) {
            addCriterion("REALCAPITAL2 not like", value, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2In(List<String> values) {
            addCriterion("REALCAPITAL2 in", values, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2NotIn(List<String> values) {
            addCriterion("REALCAPITAL2 not in", values, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2Between(String value1, String value2) {
            addCriterion("REALCAPITAL2 between", value1, value2, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andRealcapital2NotBetween(String value1, String value2) {
            addCriterion("REALCAPITAL2 not between", value1, value2, "realcapital2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2IsNull() {
            addCriterion("CAPITALRESERVE2 is null");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2IsNotNull() {
            addCriterion("CAPITALRESERVE2 is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2EqualTo(String value) {
            addCriterion("CAPITALRESERVE2 =", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2NotEqualTo(String value) {
            addCriterion("CAPITALRESERVE2 <>", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2GreaterThan(String value) {
            addCriterion("CAPITALRESERVE2 >", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2GreaterThanOrEqualTo(String value) {
            addCriterion("CAPITALRESERVE2 >=", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2LessThan(String value) {
            addCriterion("CAPITALRESERVE2 <", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2LessThanOrEqualTo(String value) {
            addCriterion("CAPITALRESERVE2 <=", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2Like(String value) {
            addCriterion("CAPITALRESERVE2 like", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2NotLike(String value) {
            addCriterion("CAPITALRESERVE2 not like", value, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2In(List<String> values) {
            addCriterion("CAPITALRESERVE2 in", values, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2NotIn(List<String> values) {
            addCriterion("CAPITALRESERVE2 not in", values, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2Between(String value1, String value2) {
            addCriterion("CAPITALRESERVE2 between", value1, value2, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andCapitalreserve2NotBetween(String value1, String value2) {
            addCriterion("CAPITALRESERVE2 not between", value1, value2, "capitalreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2IsNull() {
            addCriterion("SURPLUSRESERVE2 is null");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2IsNotNull() {
            addCriterion("SURPLUSRESERVE2 is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2EqualTo(String value) {
            addCriterion("SURPLUSRESERVE2 =", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2NotEqualTo(String value) {
            addCriterion("SURPLUSRESERVE2 <>", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2GreaterThan(String value) {
            addCriterion("SURPLUSRESERVE2 >", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2GreaterThanOrEqualTo(String value) {
            addCriterion("SURPLUSRESERVE2 >=", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2LessThan(String value) {
            addCriterion("SURPLUSRESERVE2 <", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2LessThanOrEqualTo(String value) {
            addCriterion("SURPLUSRESERVE2 <=", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2Like(String value) {
            addCriterion("SURPLUSRESERVE2 like", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2NotLike(String value) {
            addCriterion("SURPLUSRESERVE2 not like", value, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2In(List<String> values) {
            addCriterion("SURPLUSRESERVE2 in", values, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2NotIn(List<String> values) {
            addCriterion("SURPLUSRESERVE2 not in", values, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2Between(String value1, String value2) {
            addCriterion("SURPLUSRESERVE2 between", value1, value2, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andSurplusreserve2NotBetween(String value1, String value2) {
            addCriterion("SURPLUSRESERVE2 not between", value1, value2, "surplusreserve2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2IsNull() {
            addCriterion("UNALLOTPROFIT2 is null");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2IsNotNull() {
            addCriterion("UNALLOTPROFIT2 is not null");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2EqualTo(String value) {
            addCriterion("UNALLOTPROFIT2 =", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2NotEqualTo(String value) {
            addCriterion("UNALLOTPROFIT2 <>", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2GreaterThan(String value) {
            addCriterion("UNALLOTPROFIT2 >", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2GreaterThanOrEqualTo(String value) {
            addCriterion("UNALLOTPROFIT2 >=", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2LessThan(String value) {
            addCriterion("UNALLOTPROFIT2 <", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2LessThanOrEqualTo(String value) {
            addCriterion("UNALLOTPROFIT2 <=", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2Like(String value) {
            addCriterion("UNALLOTPROFIT2 like", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2NotLike(String value) {
            addCriterion("UNALLOTPROFIT2 not like", value, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2In(List<String> values) {
            addCriterion("UNALLOTPROFIT2 in", values, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2NotIn(List<String> values) {
            addCriterion("UNALLOTPROFIT2 not in", values, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2Between(String value1, String value2) {
            addCriterion("UNALLOTPROFIT2 between", value1, value2, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andUnallotprofit2NotBetween(String value1, String value2) {
            addCriterion("UNALLOTPROFIT2 not between", value1, value2, "unallotprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2IsNull() {
            addCriterion("TOTALEQUITY2 is null");
            return (Criteria) this;
        }

        public Criteria andTotalequity2IsNotNull() {
            addCriterion("TOTALEQUITY2 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalequity2EqualTo(String value) {
            addCriterion("TOTALEQUITY2 =", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2NotEqualTo(String value) {
            addCriterion("TOTALEQUITY2 <>", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2GreaterThan(String value) {
            addCriterion("TOTALEQUITY2 >", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2GreaterThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY2 >=", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2LessThan(String value) {
            addCriterion("TOTALEQUITY2 <", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2LessThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY2 <=", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2Like(String value) {
            addCriterion("TOTALEQUITY2 like", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2NotLike(String value) {
            addCriterion("TOTALEQUITY2 not like", value, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2In(List<String> values) {
            addCriterion("TOTALEQUITY2 in", values, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2NotIn(List<String> values) {
            addCriterion("TOTALEQUITY2 not in", values, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2Between(String value1, String value2) {
            addCriterion("TOTALEQUITY2 between", value1, value2, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity2NotBetween(String value1, String value2) {
            addCriterion("TOTALEQUITY2 not between", value1, value2, "totalequity2");
            return (Criteria) this;
        }

        public Criteria andTotalequity12IsNull() {
            addCriterion("TOTALEQUITY12 is null");
            return (Criteria) this;
        }

        public Criteria andTotalequity12IsNotNull() {
            addCriterion("TOTALEQUITY12 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalequity12EqualTo(String value) {
            addCriterion("TOTALEQUITY12 =", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12NotEqualTo(String value) {
            addCriterion("TOTALEQUITY12 <>", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12GreaterThan(String value) {
            addCriterion("TOTALEQUITY12 >", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12GreaterThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY12 >=", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12LessThan(String value) {
            addCriterion("TOTALEQUITY12 <", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12LessThanOrEqualTo(String value) {
            addCriterion("TOTALEQUITY12 <=", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12Like(String value) {
            addCriterion("TOTALEQUITY12 like", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12NotLike(String value) {
            addCriterion("TOTALEQUITY12 not like", value, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12In(List<String> values) {
            addCriterion("TOTALEQUITY12 in", values, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12NotIn(List<String> values) {
            addCriterion("TOTALEQUITY12 not in", values, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12Between(String value1, String value2) {
            addCriterion("TOTALEQUITY12 between", value1, value2, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andTotalequity12NotBetween(String value1, String value2) {
            addCriterion("TOTALEQUITY12 not between", value1, value2, "totalequity12");
            return (Criteria) this;
        }

        public Criteria andHandingcost2IsNull() {
            addCriterion("HANDINGCOST2 is null");
            return (Criteria) this;
        }

        public Criteria andHandingcost2IsNotNull() {
            addCriterion("HANDINGCOST2 is not null");
            return (Criteria) this;
        }

        public Criteria andHandingcost2EqualTo(String value) {
            addCriterion("HANDINGCOST2 =", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2NotEqualTo(String value) {
            addCriterion("HANDINGCOST2 <>", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2GreaterThan(String value) {
            addCriterion("HANDINGCOST2 >", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2GreaterThanOrEqualTo(String value) {
            addCriterion("HANDINGCOST2 >=", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2LessThan(String value) {
            addCriterion("HANDINGCOST2 <", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2LessThanOrEqualTo(String value) {
            addCriterion("HANDINGCOST2 <=", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2Like(String value) {
            addCriterion("HANDINGCOST2 like", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2NotLike(String value) {
            addCriterion("HANDINGCOST2 not like", value, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2In(List<String> values) {
            addCriterion("HANDINGCOST2 in", values, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2NotIn(List<String> values) {
            addCriterion("HANDINGCOST2 not in", values, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2Between(String value1, String value2) {
            addCriterion("HANDINGCOST2 between", value1, value2, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andHandingcost2NotBetween(String value1, String value2) {
            addCriterion("HANDINGCOST2 not between", value1, value2, "handingcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2IsNull() {
            addCriterion("FINANCIALCOST2 is null");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2IsNotNull() {
            addCriterion("FINANCIALCOST2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2EqualTo(String value) {
            addCriterion("FINANCIALCOST2 =", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2NotEqualTo(String value) {
            addCriterion("FINANCIALCOST2 <>", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2GreaterThan(String value) {
            addCriterion("FINANCIALCOST2 >", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2GreaterThanOrEqualTo(String value) {
            addCriterion("FINANCIALCOST2 >=", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2LessThan(String value) {
            addCriterion("FINANCIALCOST2 <", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2LessThanOrEqualTo(String value) {
            addCriterion("FINANCIALCOST2 <=", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2Like(String value) {
            addCriterion("FINANCIALCOST2 like", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2NotLike(String value) {
            addCriterion("FINANCIALCOST2 not like", value, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2In(List<String> values) {
            addCriterion("FINANCIALCOST2 in", values, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2NotIn(List<String> values) {
            addCriterion("FINANCIALCOST2 not in", values, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2Between(String value1, String value2) {
            addCriterion("FINANCIALCOST2 between", value1, value2, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andFinancialcost2NotBetween(String value1, String value2) {
            addCriterion("FINANCIALCOST2 not between", value1, value2, "financialcost2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2IsNull() {
            addCriterion("INTERESTEXPENSE2 is null");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2IsNotNull() {
            addCriterion("INTERESTEXPENSE2 is not null");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2EqualTo(String value) {
            addCriterion("INTERESTEXPENSE2 =", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2NotEqualTo(String value) {
            addCriterion("INTERESTEXPENSE2 <>", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2GreaterThan(String value) {
            addCriterion("INTERESTEXPENSE2 >", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2GreaterThanOrEqualTo(String value) {
            addCriterion("INTERESTEXPENSE2 >=", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2LessThan(String value) {
            addCriterion("INTERESTEXPENSE2 <", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2LessThanOrEqualTo(String value) {
            addCriterion("INTERESTEXPENSE2 <=", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2Like(String value) {
            addCriterion("INTERESTEXPENSE2 like", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2NotLike(String value) {
            addCriterion("INTERESTEXPENSE2 not like", value, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2In(List<String> values) {
            addCriterion("INTERESTEXPENSE2 in", values, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2NotIn(List<String> values) {
            addCriterion("INTERESTEXPENSE2 not in", values, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2Between(String value1, String value2) {
            addCriterion("INTERESTEXPENSE2 between", value1, value2, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andInterestexpense2NotBetween(String value1, String value2) {
            addCriterion("INTERESTEXPENSE2 not between", value1, value2, "interestexpense2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2IsNull() {
            addCriterion("BUSINESSPROFIT2 is null");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2IsNotNull() {
            addCriterion("BUSINESSPROFIT2 is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2EqualTo(String value) {
            addCriterion("BUSINESSPROFIT2 =", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2NotEqualTo(String value) {
            addCriterion("BUSINESSPROFIT2 <>", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2GreaterThan(String value) {
            addCriterion("BUSINESSPROFIT2 >", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2GreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSPROFIT2 >=", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2LessThan(String value) {
            addCriterion("BUSINESSPROFIT2 <", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2LessThanOrEqualTo(String value) {
            addCriterion("BUSINESSPROFIT2 <=", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2Like(String value) {
            addCriterion("BUSINESSPROFIT2 like", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2NotLike(String value) {
            addCriterion("BUSINESSPROFIT2 not like", value, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2In(List<String> values) {
            addCriterion("BUSINESSPROFIT2 in", values, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2NotIn(List<String> values) {
            addCriterion("BUSINESSPROFIT2 not in", values, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2Between(String value1, String value2) {
            addCriterion("BUSINESSPROFIT2 between", value1, value2, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andBusinessprofit2NotBetween(String value1, String value2) {
            addCriterion("BUSINESSPROFIT2 not between", value1, value2, "businessprofit2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2IsNull() {
            addCriterion("INVESTINCOME2 is null");
            return (Criteria) this;
        }

        public Criteria andInvestincome2IsNotNull() {
            addCriterion("INVESTINCOME2 is not null");
            return (Criteria) this;
        }

        public Criteria andInvestincome2EqualTo(String value) {
            addCriterion("INVESTINCOME2 =", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2NotEqualTo(String value) {
            addCriterion("INVESTINCOME2 <>", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2GreaterThan(String value) {
            addCriterion("INVESTINCOME2 >", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2GreaterThanOrEqualTo(String value) {
            addCriterion("INVESTINCOME2 >=", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2LessThan(String value) {
            addCriterion("INVESTINCOME2 <", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2LessThanOrEqualTo(String value) {
            addCriterion("INVESTINCOME2 <=", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2Like(String value) {
            addCriterion("INVESTINCOME2 like", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2NotLike(String value) {
            addCriterion("INVESTINCOME2 not like", value, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2In(List<String> values) {
            addCriterion("INVESTINCOME2 in", values, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2NotIn(List<String> values) {
            addCriterion("INVESTINCOME2 not in", values, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2Between(String value1, String value2) {
            addCriterion("INVESTINCOME2 between", value1, value2, "investincome2");
            return (Criteria) this;
        }

        public Criteria andInvestincome2NotBetween(String value1, String value2) {
            addCriterion("INVESTINCOME2 not between", value1, value2, "investincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2IsNull() {
            addCriterion("SUBSIDYINCOME2 is null");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2IsNotNull() {
            addCriterion("SUBSIDYINCOME2 is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2EqualTo(String value) {
            addCriterion("SUBSIDYINCOME2 =", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2NotEqualTo(String value) {
            addCriterion("SUBSIDYINCOME2 <>", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2GreaterThan(String value) {
            addCriterion("SUBSIDYINCOME2 >", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2GreaterThanOrEqualTo(String value) {
            addCriterion("SUBSIDYINCOME2 >=", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2LessThan(String value) {
            addCriterion("SUBSIDYINCOME2 <", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2LessThanOrEqualTo(String value) {
            addCriterion("SUBSIDYINCOME2 <=", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2Like(String value) {
            addCriterion("SUBSIDYINCOME2 like", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2NotLike(String value) {
            addCriterion("SUBSIDYINCOME2 not like", value, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2In(List<String> values) {
            addCriterion("SUBSIDYINCOME2 in", values, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2NotIn(List<String> values) {
            addCriterion("SUBSIDYINCOME2 not in", values, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2Between(String value1, String value2) {
            addCriterion("SUBSIDYINCOME2 between", value1, value2, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andSubsidyincome2NotBetween(String value1, String value2) {
            addCriterion("SUBSIDYINCOME2 not between", value1, value2, "subsidyincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2IsNull() {
            addCriterion("UNBUSINESSINCOME2 is null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2IsNotNull() {
            addCriterion("UNBUSINESSINCOME2 is not null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2EqualTo(String value) {
            addCriterion("UNBUSINESSINCOME2 =", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2NotEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME2 <>", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2GreaterThan(String value) {
            addCriterion("UNBUSINESSINCOME2 >", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2GreaterThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME2 >=", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2LessThan(String value) {
            addCriterion("UNBUSINESSINCOME2 <", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2LessThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSINCOME2 <=", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2Like(String value) {
            addCriterion("UNBUSINESSINCOME2 like", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2NotLike(String value) {
            addCriterion("UNBUSINESSINCOME2 not like", value, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2In(List<String> values) {
            addCriterion("UNBUSINESSINCOME2 in", values, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2NotIn(List<String> values) {
            addCriterion("UNBUSINESSINCOME2 not in", values, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2Between(String value1, String value2) {
            addCriterion("UNBUSINESSINCOME2 between", value1, value2, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessincome2NotBetween(String value1, String value2) {
            addCriterion("UNBUSINESSINCOME2 not between", value1, value2, "unbusinessincome2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2IsNull() {
            addCriterion("UNBUSINESSEXPENSE2 is null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2IsNotNull() {
            addCriterion("UNBUSINESSEXPENSE2 is not null");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2EqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE2 =", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2NotEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE2 <>", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2GreaterThan(String value) {
            addCriterion("UNBUSINESSEXPENSE2 >", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2GreaterThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE2 >=", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2LessThan(String value) {
            addCriterion("UNBUSINESSEXPENSE2 <", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2LessThanOrEqualTo(String value) {
            addCriterion("UNBUSINESSEXPENSE2 <=", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2Like(String value) {
            addCriterion("UNBUSINESSEXPENSE2 like", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2NotLike(String value) {
            addCriterion("UNBUSINESSEXPENSE2 not like", value, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2In(List<String> values) {
            addCriterion("UNBUSINESSEXPENSE2 in", values, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2NotIn(List<String> values) {
            addCriterion("UNBUSINESSEXPENSE2 not in", values, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2Between(String value1, String value2) {
            addCriterion("UNBUSINESSEXPENSE2 between", value1, value2, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andUnbusinessexpense2NotBetween(String value1, String value2) {
            addCriterion("UNBUSINESSEXPENSE2 not between", value1, value2, "unbusinessexpense2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2IsNull() {
            addCriterion("PROFITLOSS2 is null");
            return (Criteria) this;
        }

        public Criteria andProfitloss2IsNotNull() {
            addCriterion("PROFITLOSS2 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitloss2EqualTo(String value) {
            addCriterion("PROFITLOSS2 =", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2NotEqualTo(String value) {
            addCriterion("PROFITLOSS2 <>", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2GreaterThan(String value) {
            addCriterion("PROFITLOSS2 >", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2GreaterThanOrEqualTo(String value) {
            addCriterion("PROFITLOSS2 >=", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2LessThan(String value) {
            addCriterion("PROFITLOSS2 <", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2LessThanOrEqualTo(String value) {
            addCriterion("PROFITLOSS2 <=", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2Like(String value) {
            addCriterion("PROFITLOSS2 like", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2NotLike(String value) {
            addCriterion("PROFITLOSS2 not like", value, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2In(List<String> values) {
            addCriterion("PROFITLOSS2 in", values, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2NotIn(List<String> values) {
            addCriterion("PROFITLOSS2 not in", values, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2Between(String value1, String value2) {
            addCriterion("PROFITLOSS2 between", value1, value2, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andProfitloss2NotBetween(String value1, String value2) {
            addCriterion("PROFITLOSS2 not between", value1, value2, "profitloss2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2IsNull() {
            addCriterion("TOTALPROFIT2 is null");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2IsNotNull() {
            addCriterion("TOTALPROFIT2 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2EqualTo(String value) {
            addCriterion("TOTALPROFIT2 =", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2NotEqualTo(String value) {
            addCriterion("TOTALPROFIT2 <>", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2GreaterThan(String value) {
            addCriterion("TOTALPROFIT2 >", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2GreaterThanOrEqualTo(String value) {
            addCriterion("TOTALPROFIT2 >=", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2LessThan(String value) {
            addCriterion("TOTALPROFIT2 <", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2LessThanOrEqualTo(String value) {
            addCriterion("TOTALPROFIT2 <=", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2Like(String value) {
            addCriterion("TOTALPROFIT2 like", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2NotLike(String value) {
            addCriterion("TOTALPROFIT2 not like", value, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2In(List<String> values) {
            addCriterion("TOTALPROFIT2 in", values, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2NotIn(List<String> values) {
            addCriterion("TOTALPROFIT2 not in", values, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2Between(String value1, String value2) {
            addCriterion("TOTALPROFIT2 between", value1, value2, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andTotalprofit2NotBetween(String value1, String value2) {
            addCriterion("TOTALPROFIT2 not between", value1, value2, "totalprofit2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2IsNull() {
            addCriterion("PAYABLEINCOMETAX2 is null");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2IsNotNull() {
            addCriterion("PAYABLEINCOMETAX2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2EqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX2 =", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2NotEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX2 <>", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2GreaterThan(String value) {
            addCriterion("PAYABLEINCOMETAX2 >", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2GreaterThanOrEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX2 >=", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2LessThan(String value) {
            addCriterion("PAYABLEINCOMETAX2 <", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2LessThanOrEqualTo(String value) {
            addCriterion("PAYABLEINCOMETAX2 <=", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2Like(String value) {
            addCriterion("PAYABLEINCOMETAX2 like", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2NotLike(String value) {
            addCriterion("PAYABLEINCOMETAX2 not like", value, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2In(List<String> values) {
            addCriterion("PAYABLEINCOMETAX2 in", values, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2NotIn(List<String> values) {
            addCriterion("PAYABLEINCOMETAX2 not in", values, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2Between(String value1, String value2) {
            addCriterion("PAYABLEINCOMETAX2 between", value1, value2, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableincometax2NotBetween(String value1, String value2) {
            addCriterion("PAYABLEINCOMETAX2 not between", value1, value2, "payableincometax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2IsNull() {
            addCriterion("PAYABLEADDEDTAX2 is null");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2IsNotNull() {
            addCriterion("PAYABLEADDEDTAX2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2EqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX2 =", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2NotEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX2 <>", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2GreaterThan(String value) {
            addCriterion("PAYABLEADDEDTAX2 >", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2GreaterThanOrEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX2 >=", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2LessThan(String value) {
            addCriterion("PAYABLEADDEDTAX2 <", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2LessThanOrEqualTo(String value) {
            addCriterion("PAYABLEADDEDTAX2 <=", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2Like(String value) {
            addCriterion("PAYABLEADDEDTAX2 like", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2NotLike(String value) {
            addCriterion("PAYABLEADDEDTAX2 not like", value, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2In(List<String> values) {
            addCriterion("PAYABLEADDEDTAX2 in", values, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2NotIn(List<String> values) {
            addCriterion("PAYABLEADDEDTAX2 not in", values, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2Between(String value1, String value2) {
            addCriterion("PAYABLEADDEDTAX2 between", value1, value2, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPayableaddedtax2NotBetween(String value1, String value2) {
            addCriterion("PAYABLEADDEDTAX2 not between", value1, value2, "payableaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2IsNull() {
            addCriterion("PAIDADDEDTAX2 is null");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2IsNotNull() {
            addCriterion("PAIDADDEDTAX2 is not null");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2EqualTo(String value) {
            addCriterion("PAIDADDEDTAX2 =", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2NotEqualTo(String value) {
            addCriterion("PAIDADDEDTAX2 <>", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2GreaterThan(String value) {
            addCriterion("PAIDADDEDTAX2 >", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2GreaterThanOrEqualTo(String value) {
            addCriterion("PAIDADDEDTAX2 >=", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2LessThan(String value) {
            addCriterion("PAIDADDEDTAX2 <", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2LessThanOrEqualTo(String value) {
            addCriterion("PAIDADDEDTAX2 <=", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2Like(String value) {
            addCriterion("PAIDADDEDTAX2 like", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2NotLike(String value) {
            addCriterion("PAIDADDEDTAX2 not like", value, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2In(List<String> values) {
            addCriterion("PAIDADDEDTAX2 in", values, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2NotIn(List<String> values) {
            addCriterion("PAIDADDEDTAX2 not in", values, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2Between(String value1, String value2) {
            addCriterion("PAIDADDEDTAX2 between", value1, value2, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andPaidaddedtax2NotBetween(String value1, String value2) {
            addCriterion("PAIDADDEDTAX2 not between", value1, value2, "paidaddedtax2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2IsNull() {
            addCriterion("NETPROFIT2 is null");
            return (Criteria) this;
        }

        public Criteria andNetprofit2IsNotNull() {
            addCriterion("NETPROFIT2 is not null");
            return (Criteria) this;
        }

        public Criteria andNetprofit2EqualTo(String value) {
            addCriterion("NETPROFIT2 =", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2NotEqualTo(String value) {
            addCriterion("NETPROFIT2 <>", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2GreaterThan(String value) {
            addCriterion("NETPROFIT2 >", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2GreaterThanOrEqualTo(String value) {
            addCriterion("NETPROFIT2 >=", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2LessThan(String value) {
            addCriterion("NETPROFIT2 <", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2LessThanOrEqualTo(String value) {
            addCriterion("NETPROFIT2 <=", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2Like(String value) {
            addCriterion("NETPROFIT2 like", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2NotLike(String value) {
            addCriterion("NETPROFIT2 not like", value, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2In(List<String> values) {
            addCriterion("NETPROFIT2 in", values, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2NotIn(List<String> values) {
            addCriterion("NETPROFIT2 not in", values, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2Between(String value1, String value2) {
            addCriterion("NETPROFIT2 between", value1, value2, "netprofit2");
            return (Criteria) this;
        }

        public Criteria andNetprofit2NotBetween(String value1, String value2) {
            addCriterion("NETPROFIT2 not between", value1, value2, "netprofit2");
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