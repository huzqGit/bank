package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CooperationProfitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CooperationProfitExample() {
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

        public Criteria andProfitidIsNull() {
            addCriterion("PROFITID is null");
            return (Criteria) this;
        }

        public Criteria andProfitidIsNotNull() {
            addCriterion("PROFITID is not null");
            return (Criteria) this;
        }

        public Criteria andProfitidEqualTo(Long value) {
            addCriterion("PROFITID =", value, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidNotEqualTo(Long value) {
            addCriterion("PROFITID <>", value, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidGreaterThan(Long value) {
            addCriterion("PROFITID >", value, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidGreaterThanOrEqualTo(Long value) {
            addCriterion("PROFITID >=", value, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidLessThan(Long value) {
            addCriterion("PROFITID <", value, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidLessThanOrEqualTo(Long value) {
            addCriterion("PROFITID <=", value, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidIn(List<Long> values) {
            addCriterion("PROFITID in", values, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidNotIn(List<Long> values) {
            addCriterion("PROFITID not in", values, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidBetween(Long value1, Long value2) {
            addCriterion("PROFITID between", value1, value2, "profitid");
            return (Criteria) this;
        }

        public Criteria andProfitidNotBetween(Long value1, Long value2) {
            addCriterion("PROFITID not between", value1, value2, "profitid");
            return (Criteria) this;
        }

        public Criteria andDatasendorganIsNull() {
            addCriterion("DATASENDORGAN is null");
            return (Criteria) this;
        }

        public Criteria andDatasendorganIsNotNull() {
            addCriterion("DATASENDORGAN is not null");
            return (Criteria) this;
        }

        public Criteria andDatasendorganEqualTo(String value) {
            addCriterion("DATASENDORGAN =", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganNotEqualTo(String value) {
            addCriterion("DATASENDORGAN <>", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganGreaterThan(String value) {
            addCriterion("DATASENDORGAN >", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganGreaterThanOrEqualTo(String value) {
            addCriterion("DATASENDORGAN >=", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganLessThan(String value) {
            addCriterion("DATASENDORGAN <", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganLessThanOrEqualTo(String value) {
            addCriterion("DATASENDORGAN <=", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganLike(String value) {
            addCriterion("DATASENDORGAN like", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganNotLike(String value) {
            addCriterion("DATASENDORGAN not like", value, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganIn(List<String> values) {
            addCriterion("DATASENDORGAN in", values, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganNotIn(List<String> values) {
            addCriterion("DATASENDORGAN not in", values, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganBetween(String value1, String value2) {
            addCriterion("DATASENDORGAN between", value1, value2, "datasendorgan");
            return (Criteria) this;
        }

        public Criteria andDatasendorganNotBetween(String value1, String value2) {
            addCriterion("DATASENDORGAN not between", value1, value2, "datasendorgan");
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

        public Criteria andTrustcodeIsNull() {
            addCriterion("TRUSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andTrustcodeIsNotNull() {
            addCriterion("TRUSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andTrustcodeEqualTo(String value) {
            addCriterion("TRUSTCODE =", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeNotEqualTo(String value) {
            addCriterion("TRUSTCODE <>", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeGreaterThan(String value) {
            addCriterion("TRUSTCODE >", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeGreaterThanOrEqualTo(String value) {
            addCriterion("TRUSTCODE >=", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeLessThan(String value) {
            addCriterion("TRUSTCODE <", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeLessThanOrEqualTo(String value) {
            addCriterion("TRUSTCODE <=", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeLike(String value) {
            addCriterion("TRUSTCODE like", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeNotLike(String value) {
            addCriterion("TRUSTCODE not like", value, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeIn(List<String> values) {
            addCriterion("TRUSTCODE in", values, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeNotIn(List<String> values) {
            addCriterion("TRUSTCODE not in", values, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeBetween(String value1, String value2) {
            addCriterion("TRUSTCODE between", value1, value2, "trustcode");
            return (Criteria) this;
        }

        public Criteria andTrustcodeNotBetween(String value1, String value2) {
            addCriterion("TRUSTCODE not between", value1, value2, "trustcode");
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

        public Criteria andMainincomeIsNull() {
            addCriterion("MAININCOME is null");
            return (Criteria) this;
        }

        public Criteria andMainincomeIsNotNull() {
            addCriterion("MAININCOME is not null");
            return (Criteria) this;
        }

        public Criteria andMainincomeEqualTo(String value) {
            addCriterion("MAININCOME =", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeNotEqualTo(String value) {
            addCriterion("MAININCOME <>", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeGreaterThan(String value) {
            addCriterion("MAININCOME >", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeGreaterThanOrEqualTo(String value) {
            addCriterion("MAININCOME >=", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeLessThan(String value) {
            addCriterion("MAININCOME <", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeLessThanOrEqualTo(String value) {
            addCriterion("MAININCOME <=", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeLike(String value) {
            addCriterion("MAININCOME like", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeNotLike(String value) {
            addCriterion("MAININCOME not like", value, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeIn(List<String> values) {
            addCriterion("MAININCOME in", values, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeNotIn(List<String> values) {
            addCriterion("MAININCOME not in", values, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeBetween(String value1, String value2) {
            addCriterion("MAININCOME between", value1, value2, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeNotBetween(String value1, String value2) {
            addCriterion("MAININCOME not between", value1, value2, "mainincome");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportIsNull() {
            addCriterion("MAININCOME_EXPORT is null");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportIsNotNull() {
            addCriterion("MAININCOME_EXPORT is not null");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportEqualTo(String value) {
            addCriterion("MAININCOME_EXPORT =", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportNotEqualTo(String value) {
            addCriterion("MAININCOME_EXPORT <>", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportGreaterThan(String value) {
            addCriterion("MAININCOME_EXPORT >", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportGreaterThanOrEqualTo(String value) {
            addCriterion("MAININCOME_EXPORT >=", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportLessThan(String value) {
            addCriterion("MAININCOME_EXPORT <", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportLessThanOrEqualTo(String value) {
            addCriterion("MAININCOME_EXPORT <=", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportLike(String value) {
            addCriterion("MAININCOME_EXPORT like", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportNotLike(String value) {
            addCriterion("MAININCOME_EXPORT not like", value, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportIn(List<String> values) {
            addCriterion("MAININCOME_EXPORT in", values, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportNotIn(List<String> values) {
            addCriterion("MAININCOME_EXPORT not in", values, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportBetween(String value1, String value2) {
            addCriterion("MAININCOME_EXPORT between", value1, value2, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeExportNotBetween(String value1, String value2) {
            addCriterion("MAININCOME_EXPORT not between", value1, value2, "mainincomeExport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportIsNull() {
            addCriterion("MAININCOME_IMPORT is null");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportIsNotNull() {
            addCriterion("MAININCOME_IMPORT is not null");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportEqualTo(String value) {
            addCriterion("MAININCOME_IMPORT =", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportNotEqualTo(String value) {
            addCriterion("MAININCOME_IMPORT <>", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportGreaterThan(String value) {
            addCriterion("MAININCOME_IMPORT >", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportGreaterThanOrEqualTo(String value) {
            addCriterion("MAININCOME_IMPORT >=", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportLessThan(String value) {
            addCriterion("MAININCOME_IMPORT <", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportLessThanOrEqualTo(String value) {
            addCriterion("MAININCOME_IMPORT <=", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportLike(String value) {
            addCriterion("MAININCOME_IMPORT like", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportNotLike(String value) {
            addCriterion("MAININCOME_IMPORT not like", value, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportIn(List<String> values) {
            addCriterion("MAININCOME_IMPORT in", values, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportNotIn(List<String> values) {
            addCriterion("MAININCOME_IMPORT not in", values, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportBetween(String value1, String value2) {
            addCriterion("MAININCOME_IMPORT between", value1, value2, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andMainincomeImportNotBetween(String value1, String value2) {
            addCriterion("MAININCOME_IMPORT not between", value1, value2, "mainincomeImport");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("DISCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("DISCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(String value) {
            addCriterion("DISCOUNT =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(String value) {
            addCriterion("DISCOUNT <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(String value) {
            addCriterion("DISCOUNT >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("DISCOUNT >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(String value) {
            addCriterion("DISCOUNT <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(String value) {
            addCriterion("DISCOUNT <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLike(String value) {
            addCriterion("DISCOUNT like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotLike(String value) {
            addCriterion("DISCOUNT not like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<String> values) {
            addCriterion("DISCOUNT in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<String> values) {
            addCriterion("DISCOUNT not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(String value1, String value2) {
            addCriterion("DISCOUNT between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(String value1, String value2) {
            addCriterion("DISCOUNT not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginIsNull() {
            addCriterion("MAININCOME_NETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginIsNotNull() {
            addCriterion("MAININCOME_NETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginEqualTo(String value) {
            addCriterion("MAININCOME_NETMARGIN =", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginNotEqualTo(String value) {
            addCriterion("MAININCOME_NETMARGIN <>", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginGreaterThan(String value) {
            addCriterion("MAININCOME_NETMARGIN >", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("MAININCOME_NETMARGIN >=", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginLessThan(String value) {
            addCriterion("MAININCOME_NETMARGIN <", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginLessThanOrEqualTo(String value) {
            addCriterion("MAININCOME_NETMARGIN <=", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginLike(String value) {
            addCriterion("MAININCOME_NETMARGIN like", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginNotLike(String value) {
            addCriterion("MAININCOME_NETMARGIN not like", value, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginIn(List<String> values) {
            addCriterion("MAININCOME_NETMARGIN in", values, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginNotIn(List<String> values) {
            addCriterion("MAININCOME_NETMARGIN not in", values, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginBetween(String value1, String value2) {
            addCriterion("MAININCOME_NETMARGIN between", value1, value2, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMainincomeNetmarginNotBetween(String value1, String value2) {
            addCriterion("MAININCOME_NETMARGIN not between", value1, value2, "mainincomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andMaincostIsNull() {
            addCriterion("MAINCOST is null");
            return (Criteria) this;
        }

        public Criteria andMaincostIsNotNull() {
            addCriterion("MAINCOST is not null");
            return (Criteria) this;
        }

        public Criteria andMaincostEqualTo(String value) {
            addCriterion("MAINCOST =", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostNotEqualTo(String value) {
            addCriterion("MAINCOST <>", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostGreaterThan(String value) {
            addCriterion("MAINCOST >", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostGreaterThanOrEqualTo(String value) {
            addCriterion("MAINCOST >=", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostLessThan(String value) {
            addCriterion("MAINCOST <", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostLessThanOrEqualTo(String value) {
            addCriterion("MAINCOST <=", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostLike(String value) {
            addCriterion("MAINCOST like", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostNotLike(String value) {
            addCriterion("MAINCOST not like", value, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostIn(List<String> values) {
            addCriterion("MAINCOST in", values, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostNotIn(List<String> values) {
            addCriterion("MAINCOST not in", values, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostBetween(String value1, String value2) {
            addCriterion("MAINCOST between", value1, value2, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostNotBetween(String value1, String value2) {
            addCriterion("MAINCOST not between", value1, value2, "maincost");
            return (Criteria) this;
        }

        public Criteria andMaincostExportIsNull() {
            addCriterion("MAINCOST_EXPORT is null");
            return (Criteria) this;
        }

        public Criteria andMaincostExportIsNotNull() {
            addCriterion("MAINCOST_EXPORT is not null");
            return (Criteria) this;
        }

        public Criteria andMaincostExportEqualTo(String value) {
            addCriterion("MAINCOST_EXPORT =", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportNotEqualTo(String value) {
            addCriterion("MAINCOST_EXPORT <>", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportGreaterThan(String value) {
            addCriterion("MAINCOST_EXPORT >", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportGreaterThanOrEqualTo(String value) {
            addCriterion("MAINCOST_EXPORT >=", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportLessThan(String value) {
            addCriterion("MAINCOST_EXPORT <", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportLessThanOrEqualTo(String value) {
            addCriterion("MAINCOST_EXPORT <=", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportLike(String value) {
            addCriterion("MAINCOST_EXPORT like", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportNotLike(String value) {
            addCriterion("MAINCOST_EXPORT not like", value, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportIn(List<String> values) {
            addCriterion("MAINCOST_EXPORT in", values, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportNotIn(List<String> values) {
            addCriterion("MAINCOST_EXPORT not in", values, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportBetween(String value1, String value2) {
            addCriterion("MAINCOST_EXPORT between", value1, value2, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaincostExportNotBetween(String value1, String value2) {
            addCriterion("MAINCOST_EXPORT not between", value1, value2, "maincostExport");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayIsNull() {
            addCriterion("MAINTAXPAY is null");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayIsNotNull() {
            addCriterion("MAINTAXPAY is not null");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayEqualTo(String value) {
            addCriterion("MAINTAXPAY =", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayNotEqualTo(String value) {
            addCriterion("MAINTAXPAY <>", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayGreaterThan(String value) {
            addCriterion("MAINTAXPAY >", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayGreaterThanOrEqualTo(String value) {
            addCriterion("MAINTAXPAY >=", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayLessThan(String value) {
            addCriterion("MAINTAXPAY <", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayLessThanOrEqualTo(String value) {
            addCriterion("MAINTAXPAY <=", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayLike(String value) {
            addCriterion("MAINTAXPAY like", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayNotLike(String value) {
            addCriterion("MAINTAXPAY not like", value, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayIn(List<String> values) {
            addCriterion("MAINTAXPAY in", values, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayNotIn(List<String> values) {
            addCriterion("MAINTAXPAY not in", values, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayBetween(String value1, String value2) {
            addCriterion("MAINTAXPAY between", value1, value2, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andMaintaxpayNotBetween(String value1, String value2) {
            addCriterion("MAINTAXPAY not between", value1, value2, "maintaxpay");
            return (Criteria) this;
        }

        public Criteria andOperationcostIsNull() {
            addCriterion("OPERATIONCOST is null");
            return (Criteria) this;
        }

        public Criteria andOperationcostIsNotNull() {
            addCriterion("OPERATIONCOST is not null");
            return (Criteria) this;
        }

        public Criteria andOperationcostEqualTo(String value) {
            addCriterion("OPERATIONCOST =", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostNotEqualTo(String value) {
            addCriterion("OPERATIONCOST <>", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostGreaterThan(String value) {
            addCriterion("OPERATIONCOST >", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATIONCOST >=", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostLessThan(String value) {
            addCriterion("OPERATIONCOST <", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostLessThanOrEqualTo(String value) {
            addCriterion("OPERATIONCOST <=", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostLike(String value) {
            addCriterion("OPERATIONCOST like", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostNotLike(String value) {
            addCriterion("OPERATIONCOST not like", value, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostIn(List<String> values) {
            addCriterion("OPERATIONCOST in", values, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostNotIn(List<String> values) {
            addCriterion("OPERATIONCOST not in", values, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostBetween(String value1, String value2) {
            addCriterion("OPERATIONCOST between", value1, value2, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOperationcostNotBetween(String value1, String value2) {
            addCriterion("OPERATIONCOST not between", value1, value2, "operationcost");
            return (Criteria) this;
        }

        public Criteria andOthercostIsNull() {
            addCriterion("OTHERCOST is null");
            return (Criteria) this;
        }

        public Criteria andOthercostIsNotNull() {
            addCriterion("OTHERCOST is not null");
            return (Criteria) this;
        }

        public Criteria andOthercostEqualTo(String value) {
            addCriterion("OTHERCOST =", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostNotEqualTo(String value) {
            addCriterion("OTHERCOST <>", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostGreaterThan(String value) {
            addCriterion("OTHERCOST >", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERCOST >=", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostLessThan(String value) {
            addCriterion("OTHERCOST <", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostLessThanOrEqualTo(String value) {
            addCriterion("OTHERCOST <=", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostLike(String value) {
            addCriterion("OTHERCOST like", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostNotLike(String value) {
            addCriterion("OTHERCOST not like", value, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostIn(List<String> values) {
            addCriterion("OTHERCOST in", values, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostNotIn(List<String> values) {
            addCriterion("OTHERCOST not in", values, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostBetween(String value1, String value2) {
            addCriterion("OTHERCOST between", value1, value2, "othercost");
            return (Criteria) this;
        }

        public Criteria andOthercostNotBetween(String value1, String value2) {
            addCriterion("OTHERCOST not between", value1, value2, "othercost");
            return (Criteria) this;
        }

        public Criteria andDelayincomeIsNull() {
            addCriterion("DELAYINCOME is null");
            return (Criteria) this;
        }

        public Criteria andDelayincomeIsNotNull() {
            addCriterion("DELAYINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andDelayincomeEqualTo(String value) {
            addCriterion("DELAYINCOME =", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeNotEqualTo(String value) {
            addCriterion("DELAYINCOME <>", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeGreaterThan(String value) {
            addCriterion("DELAYINCOME >", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeGreaterThanOrEqualTo(String value) {
            addCriterion("DELAYINCOME >=", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeLessThan(String value) {
            addCriterion("DELAYINCOME <", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeLessThanOrEqualTo(String value) {
            addCriterion("DELAYINCOME <=", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeLike(String value) {
            addCriterion("DELAYINCOME like", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeNotLike(String value) {
            addCriterion("DELAYINCOME not like", value, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeIn(List<String> values) {
            addCriterion("DELAYINCOME in", values, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeNotIn(List<String> values) {
            addCriterion("DELAYINCOME not in", values, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeBetween(String value1, String value2) {
            addCriterion("DELAYINCOME between", value1, value2, "delayincome");
            return (Criteria) this;
        }

        public Criteria andDelayincomeNotBetween(String value1, String value2) {
            addCriterion("DELAYINCOME not between", value1, value2, "delayincome");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentIsNull() {
            addCriterion("PURCHASINGAGENT is null");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentIsNotNull() {
            addCriterion("PURCHASINGAGENT is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentEqualTo(String value) {
            addCriterion("PURCHASINGAGENT =", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentNotEqualTo(String value) {
            addCriterion("PURCHASINGAGENT <>", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentGreaterThan(String value) {
            addCriterion("PURCHASINGAGENT >", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentGreaterThanOrEqualTo(String value) {
            addCriterion("PURCHASINGAGENT >=", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentLessThan(String value) {
            addCriterion("PURCHASINGAGENT <", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentLessThanOrEqualTo(String value) {
            addCriterion("PURCHASINGAGENT <=", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentLike(String value) {
            addCriterion("PURCHASINGAGENT like", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentNotLike(String value) {
            addCriterion("PURCHASINGAGENT not like", value, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentIn(List<String> values) {
            addCriterion("PURCHASINGAGENT in", values, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentNotIn(List<String> values) {
            addCriterion("PURCHASINGAGENT not in", values, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentBetween(String value1, String value2) {
            addCriterion("PURCHASINGAGENT between", value1, value2, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andPurchasingagentNotBetween(String value1, String value2) {
            addCriterion("PURCHASINGAGENT not between", value1, value2, "purchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentIsNull() {
            addCriterion("OTHERPURCHASINGAGENT is null");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentIsNotNull() {
            addCriterion("OTHERPURCHASINGAGENT is not null");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentEqualTo(String value) {
            addCriterion("OTHERPURCHASINGAGENT =", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentNotEqualTo(String value) {
            addCriterion("OTHERPURCHASINGAGENT <>", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentGreaterThan(String value) {
            addCriterion("OTHERPURCHASINGAGENT >", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERPURCHASINGAGENT >=", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentLessThan(String value) {
            addCriterion("OTHERPURCHASINGAGENT <", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentLessThanOrEqualTo(String value) {
            addCriterion("OTHERPURCHASINGAGENT <=", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentLike(String value) {
            addCriterion("OTHERPURCHASINGAGENT like", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentNotLike(String value) {
            addCriterion("OTHERPURCHASINGAGENT not like", value, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentIn(List<String> values) {
            addCriterion("OTHERPURCHASINGAGENT in", values, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentNotIn(List<String> values) {
            addCriterion("OTHERPURCHASINGAGENT not in", values, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentBetween(String value1, String value2) {
            addCriterion("OTHERPURCHASINGAGENT between", value1, value2, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andOtherpurchasingagentNotBetween(String value1, String value2) {
            addCriterion("OTHERPURCHASINGAGENT not between", value1, value2, "otherpurchasingagent");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginIsNull() {
            addCriterion("MAINNETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginIsNotNull() {
            addCriterion("MAINNETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginEqualTo(String value) {
            addCriterion("MAINNETMARGIN =", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginNotEqualTo(String value) {
            addCriterion("MAINNETMARGIN <>", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginGreaterThan(String value) {
            addCriterion("MAINNETMARGIN >", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("MAINNETMARGIN >=", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginLessThan(String value) {
            addCriterion("MAINNETMARGIN <", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginLessThanOrEqualTo(String value) {
            addCriterion("MAINNETMARGIN <=", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginLike(String value) {
            addCriterion("MAINNETMARGIN like", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginNotLike(String value) {
            addCriterion("MAINNETMARGIN not like", value, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginIn(List<String> values) {
            addCriterion("MAINNETMARGIN in", values, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginNotIn(List<String> values) {
            addCriterion("MAINNETMARGIN not in", values, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginBetween(String value1, String value2) {
            addCriterion("MAINNETMARGIN between", value1, value2, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andMainnetmarginNotBetween(String value1, String value2) {
            addCriterion("MAINNETMARGIN not between", value1, value2, "mainnetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginIsNull() {
            addCriterion("OTHERNETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginIsNotNull() {
            addCriterion("OTHERNETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginEqualTo(String value) {
            addCriterion("OTHERNETMARGIN =", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginNotEqualTo(String value) {
            addCriterion("OTHERNETMARGIN <>", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginGreaterThan(String value) {
            addCriterion("OTHERNETMARGIN >", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERNETMARGIN >=", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginLessThan(String value) {
            addCriterion("OTHERNETMARGIN <", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginLessThanOrEqualTo(String value) {
            addCriterion("OTHERNETMARGIN <=", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginLike(String value) {
            addCriterion("OTHERNETMARGIN like", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginNotLike(String value) {
            addCriterion("OTHERNETMARGIN not like", value, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginIn(List<String> values) {
            addCriterion("OTHERNETMARGIN in", values, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginNotIn(List<String> values) {
            addCriterion("OTHERNETMARGIN not in", values, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginBetween(String value1, String value2) {
            addCriterion("OTHERNETMARGIN between", value1, value2, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andOthernetmarginNotBetween(String value1, String value2) {
            addCriterion("OTHERNETMARGIN not between", value1, value2, "othernetmargin");
            return (Criteria) this;
        }

        public Criteria andMainexpensesIsNull() {
            addCriterion("MAINEXPENSES is null");
            return (Criteria) this;
        }

        public Criteria andMainexpensesIsNotNull() {
            addCriterion("MAINEXPENSES is not null");
            return (Criteria) this;
        }

        public Criteria andMainexpensesEqualTo(String value) {
            addCriterion("MAINEXPENSES =", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesNotEqualTo(String value) {
            addCriterion("MAINEXPENSES <>", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesGreaterThan(String value) {
            addCriterion("MAINEXPENSES >", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesGreaterThanOrEqualTo(String value) {
            addCriterion("MAINEXPENSES >=", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesLessThan(String value) {
            addCriterion("MAINEXPENSES <", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesLessThanOrEqualTo(String value) {
            addCriterion("MAINEXPENSES <=", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesLike(String value) {
            addCriterion("MAINEXPENSES like", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesNotLike(String value) {
            addCriterion("MAINEXPENSES not like", value, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesIn(List<String> values) {
            addCriterion("MAINEXPENSES in", values, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesNotIn(List<String> values) {
            addCriterion("MAINEXPENSES not in", values, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesBetween(String value1, String value2) {
            addCriterion("MAINEXPENSES between", value1, value2, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andMainexpensesNotBetween(String value1, String value2) {
            addCriterion("MAINEXPENSES not between", value1, value2, "mainexpenses");
            return (Criteria) this;
        }

        public Criteria andManageexpenseIsNull() {
            addCriterion("MANAGEEXPENSE is null");
            return (Criteria) this;
        }

        public Criteria andManageexpenseIsNotNull() {
            addCriterion("MANAGEEXPENSE is not null");
            return (Criteria) this;
        }

        public Criteria andManageexpenseEqualTo(String value) {
            addCriterion("MANAGEEXPENSE =", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseNotEqualTo(String value) {
            addCriterion("MANAGEEXPENSE <>", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseGreaterThan(String value) {
            addCriterion("MANAGEEXPENSE >", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseGreaterThanOrEqualTo(String value) {
            addCriterion("MANAGEEXPENSE >=", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseLessThan(String value) {
            addCriterion("MANAGEEXPENSE <", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseLessThanOrEqualTo(String value) {
            addCriterion("MANAGEEXPENSE <=", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseLike(String value) {
            addCriterion("MANAGEEXPENSE like", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseNotLike(String value) {
            addCriterion("MANAGEEXPENSE not like", value, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseIn(List<String> values) {
            addCriterion("MANAGEEXPENSE in", values, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseNotIn(List<String> values) {
            addCriterion("MANAGEEXPENSE not in", values, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseBetween(String value1, String value2) {
            addCriterion("MANAGEEXPENSE between", value1, value2, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andManageexpenseNotBetween(String value1, String value2) {
            addCriterion("MANAGEEXPENSE not between", value1, value2, "manageexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseIsNull() {
            addCriterion("FINACEEXPENSE is null");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseIsNotNull() {
            addCriterion("FINACEEXPENSE is not null");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseEqualTo(String value) {
            addCriterion("FINACEEXPENSE =", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseNotEqualTo(String value) {
            addCriterion("FINACEEXPENSE <>", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseGreaterThan(String value) {
            addCriterion("FINACEEXPENSE >", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseGreaterThanOrEqualTo(String value) {
            addCriterion("FINACEEXPENSE >=", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseLessThan(String value) {
            addCriterion("FINACEEXPENSE <", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseLessThanOrEqualTo(String value) {
            addCriterion("FINACEEXPENSE <=", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseLike(String value) {
            addCriterion("FINACEEXPENSE like", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseNotLike(String value) {
            addCriterion("FINACEEXPENSE not like", value, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseIn(List<String> values) {
            addCriterion("FINACEEXPENSE in", values, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseNotIn(List<String> values) {
            addCriterion("FINACEEXPENSE not in", values, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseBetween(String value1, String value2) {
            addCriterion("FINACEEXPENSE between", value1, value2, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andFinaceexpenseNotBetween(String value1, String value2) {
            addCriterion("FINACEEXPENSE not between", value1, value2, "finaceexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseIsNull() {
            addCriterion("OTHEREXPENSE is null");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseIsNotNull() {
            addCriterion("OTHEREXPENSE is not null");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseEqualTo(String value) {
            addCriterion("OTHEREXPENSE =", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseNotEqualTo(String value) {
            addCriterion("OTHEREXPENSE <>", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseGreaterThan(String value) {
            addCriterion("OTHEREXPENSE >", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseGreaterThanOrEqualTo(String value) {
            addCriterion("OTHEREXPENSE >=", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseLessThan(String value) {
            addCriterion("OTHEREXPENSE <", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseLessThanOrEqualTo(String value) {
            addCriterion("OTHEREXPENSE <=", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseLike(String value) {
            addCriterion("OTHEREXPENSE like", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseNotLike(String value) {
            addCriterion("OTHEREXPENSE not like", value, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseIn(List<String> values) {
            addCriterion("OTHEREXPENSE in", values, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseNotIn(List<String> values) {
            addCriterion("OTHEREXPENSE not in", values, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseBetween(String value1, String value2) {
            addCriterion("OTHEREXPENSE between", value1, value2, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andOtherexpenseNotBetween(String value1, String value2) {
            addCriterion("OTHEREXPENSE not between", value1, value2, "otherexpense");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginIsNull() {
            addCriterion("INCOME_NETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginIsNotNull() {
            addCriterion("INCOME_NETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginEqualTo(String value) {
            addCriterion("INCOME_NETMARGIN =", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginNotEqualTo(String value) {
            addCriterion("INCOME_NETMARGIN <>", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginGreaterThan(String value) {
            addCriterion("INCOME_NETMARGIN >", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_NETMARGIN >=", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginLessThan(String value) {
            addCriterion("INCOME_NETMARGIN <", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginLessThanOrEqualTo(String value) {
            addCriterion("INCOME_NETMARGIN <=", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginLike(String value) {
            addCriterion("INCOME_NETMARGIN like", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginNotLike(String value) {
            addCriterion("INCOME_NETMARGIN not like", value, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginIn(List<String> values) {
            addCriterion("INCOME_NETMARGIN in", values, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginNotIn(List<String> values) {
            addCriterion("INCOME_NETMARGIN not in", values, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginBetween(String value1, String value2) {
            addCriterion("INCOME_NETMARGIN between", value1, value2, "incomeNetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeNetmarginNotBetween(String value1, String value2) {
            addCriterion("INCOME_NETMARGIN not between", value1, value2, "incomeNetmargin");
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

        public Criteria andFuturesincomeIsNull() {
            addCriterion("FUTURESINCOME is null");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeIsNotNull() {
            addCriterion("FUTURESINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeEqualTo(String value) {
            addCriterion("FUTURESINCOME =", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeNotEqualTo(String value) {
            addCriterion("FUTURESINCOME <>", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeGreaterThan(String value) {
            addCriterion("FUTURESINCOME >", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeGreaterThanOrEqualTo(String value) {
            addCriterion("FUTURESINCOME >=", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeLessThan(String value) {
            addCriterion("FUTURESINCOME <", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeLessThanOrEqualTo(String value) {
            addCriterion("FUTURESINCOME <=", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeLike(String value) {
            addCriterion("FUTURESINCOME like", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeNotLike(String value) {
            addCriterion("FUTURESINCOME not like", value, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeIn(List<String> values) {
            addCriterion("FUTURESINCOME in", values, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeNotIn(List<String> values) {
            addCriterion("FUTURESINCOME not in", values, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeBetween(String value1, String value2) {
            addCriterion("FUTURESINCOME between", value1, value2, "futuresincome");
            return (Criteria) this;
        }

        public Criteria andFuturesincomeNotBetween(String value1, String value2) {
            addCriterion("FUTURESINCOME not between", value1, value2, "futuresincome");
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

        public Criteria andSubsidyincomeBeforeIsNull() {
            addCriterion("SUBSIDYINCOME_BEFORE is null");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeIsNotNull() {
            addCriterion("SUBSIDYINCOME_BEFORE is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeEqualTo(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE =", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeNotEqualTo(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE <>", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeGreaterThan(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE >", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE >=", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeLessThan(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE <", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeLessThanOrEqualTo(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE <=", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeLike(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE like", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeNotLike(String value) {
            addCriterion("SUBSIDYINCOME_BEFORE not like", value, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeIn(List<String> values) {
            addCriterion("SUBSIDYINCOME_BEFORE in", values, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeNotIn(List<String> values) {
            addCriterion("SUBSIDYINCOME_BEFORE not in", values, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeBetween(String value1, String value2) {
            addCriterion("SUBSIDYINCOME_BEFORE between", value1, value2, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andSubsidyincomeBeforeNotBetween(String value1, String value2) {
            addCriterion("SUBSIDYINCOME_BEFORE not between", value1, value2, "subsidyincomeBefore");
            return (Criteria) this;
        }

        public Criteria andIncomeOIsNull() {
            addCriterion("INCOME_O is null");
            return (Criteria) this;
        }

        public Criteria andIncomeOIsNotNull() {
            addCriterion("INCOME_O is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeOEqualTo(String value) {
            addCriterion("INCOME_O =", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeONotEqualTo(String value) {
            addCriterion("INCOME_O <>", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOGreaterThan(String value) {
            addCriterion("INCOME_O >", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O >=", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOLessThan(String value) {
            addCriterion("INCOME_O <", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O <=", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOLike(String value) {
            addCriterion("INCOME_O like", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeONotLike(String value) {
            addCriterion("INCOME_O not like", value, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOIn(List<String> values) {
            addCriterion("INCOME_O in", values, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeONotIn(List<String> values) {
            addCriterion("INCOME_O not in", values, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeOBetween(String value1, String value2) {
            addCriterion("INCOME_O between", value1, value2, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeONotBetween(String value1, String value2) {
            addCriterion("INCOME_O not between", value1, value2, "incomeO");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginIsNull() {
            addCriterion("INCOME_O_NETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginIsNotNull() {
            addCriterion("INCOME_O_NETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginEqualTo(String value) {
            addCriterion("INCOME_O_NETMARGIN =", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginNotEqualTo(String value) {
            addCriterion("INCOME_O_NETMARGIN <>", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginGreaterThan(String value) {
            addCriterion("INCOME_O_NETMARGIN >", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O_NETMARGIN >=", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginLessThan(String value) {
            addCriterion("INCOME_O_NETMARGIN <", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O_NETMARGIN <=", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginLike(String value) {
            addCriterion("INCOME_O_NETMARGIN like", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginNotLike(String value) {
            addCriterion("INCOME_O_NETMARGIN not like", value, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginIn(List<String> values) {
            addCriterion("INCOME_O_NETMARGIN in", values, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginNotIn(List<String> values) {
            addCriterion("INCOME_O_NETMARGIN not in", values, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginBetween(String value1, String value2) {
            addCriterion("INCOME_O_NETMARGIN between", value1, value2, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONetmarginNotBetween(String value1, String value2) {
            addCriterion("INCOME_O_NETMARGIN not between", value1, value2, "incomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyIsNull() {
            addCriterion("INCOME_O_NONEMONEY is null");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyIsNotNull() {
            addCriterion("INCOME_O_NONEMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyEqualTo(String value) {
            addCriterion("INCOME_O_NONEMONEY =", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyNotEqualTo(String value) {
            addCriterion("INCOME_O_NONEMONEY <>", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyGreaterThan(String value) {
            addCriterion("INCOME_O_NONEMONEY >", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O_NONEMONEY >=", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyLessThan(String value) {
            addCriterion("INCOME_O_NONEMONEY <", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O_NONEMONEY <=", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyLike(String value) {
            addCriterion("INCOME_O_NONEMONEY like", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyNotLike(String value) {
            addCriterion("INCOME_O_NONEMONEY not like", value, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyIn(List<String> values) {
            addCriterion("INCOME_O_NONEMONEY in", values, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyNotIn(List<String> values) {
            addCriterion("INCOME_O_NONEMONEY not in", values, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyBetween(String value1, String value2) {
            addCriterion("INCOME_O_NONEMONEY between", value1, value2, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeONonemoneyNotBetween(String value1, String value2) {
            addCriterion("INCOME_O_NONEMONEY not between", value1, value2, "incomeONonemoney");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcIsNull() {
            addCriterion("INCOME_O_WXZC is null");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcIsNotNull() {
            addCriterion("INCOME_O_WXZC is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcEqualTo(String value) {
            addCriterion("INCOME_O_WXZC =", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcNotEqualTo(String value) {
            addCriterion("INCOME_O_WXZC <>", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcGreaterThan(String value) {
            addCriterion("INCOME_O_WXZC >", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O_WXZC >=", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcLessThan(String value) {
            addCriterion("INCOME_O_WXZC <", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O_WXZC <=", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcLike(String value) {
            addCriterion("INCOME_O_WXZC like", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcNotLike(String value) {
            addCriterion("INCOME_O_WXZC not like", value, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcIn(List<String> values) {
            addCriterion("INCOME_O_WXZC in", values, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcNotIn(List<String> values) {
            addCriterion("INCOME_O_WXZC not in", values, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcBetween(String value1, String value2) {
            addCriterion("INCOME_O_WXZC between", value1, value2, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOWxzcNotBetween(String value1, String value2) {
            addCriterion("INCOME_O_WXZC not between", value1, value2, "incomeOWxzc");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkIsNull() {
            addCriterion("INCOME_O_FK is null");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkIsNotNull() {
            addCriterion("INCOME_O_FK is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkEqualTo(String value) {
            addCriterion("INCOME_O_FK =", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkNotEqualTo(String value) {
            addCriterion("INCOME_O_FK <>", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkGreaterThan(String value) {
            addCriterion("INCOME_O_FK >", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O_FK >=", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkLessThan(String value) {
            addCriterion("INCOME_O_FK <", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O_FK <=", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkLike(String value) {
            addCriterion("INCOME_O_FK like", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkNotLike(String value) {
            addCriterion("INCOME_O_FK not like", value, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkIn(List<String> values) {
            addCriterion("INCOME_O_FK in", values, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkNotIn(List<String> values) {
            addCriterion("INCOME_O_FK not in", values, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkBetween(String value1, String value2) {
            addCriterion("INCOME_O_FK between", value1, value2, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOFkNotBetween(String value1, String value2) {
            addCriterion("INCOME_O_FK not between", value1, value2, "incomeOFk");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherIsNull() {
            addCriterion("INCOME_O_OTHER is null");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherIsNotNull() {
            addCriterion("INCOME_O_OTHER is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherEqualTo(String value) {
            addCriterion("INCOME_O_OTHER =", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherNotEqualTo(String value) {
            addCriterion("INCOME_O_OTHER <>", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherGreaterThan(String value) {
            addCriterion("INCOME_O_OTHER >", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O_OTHER >=", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherLessThan(String value) {
            addCriterion("INCOME_O_OTHER <", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O_OTHER <=", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherLike(String value) {
            addCriterion("INCOME_O_OTHER like", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherNotLike(String value) {
            addCriterion("INCOME_O_OTHER not like", value, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherIn(List<String> values) {
            addCriterion("INCOME_O_OTHER in", values, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherNotIn(List<String> values) {
            addCriterion("INCOME_O_OTHER not in", values, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherBetween(String value1, String value2) {
            addCriterion("INCOME_O_OTHER between", value1, value2, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOtherNotBetween(String value1, String value2) {
            addCriterion("INCOME_O_OTHER not between", value1, value2, "incomeOOther");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryIsNull() {
            addCriterion("INCOME_O_OTHERSALARY is null");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryIsNotNull() {
            addCriterion("INCOME_O_OTHERSALARY is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryEqualTo(String value) {
            addCriterion("INCOME_O_OTHERSALARY =", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryNotEqualTo(String value) {
            addCriterion("INCOME_O_OTHERSALARY <>", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryGreaterThan(String value) {
            addCriterion("INCOME_O_OTHERSALARY >", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_O_OTHERSALARY >=", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryLessThan(String value) {
            addCriterion("INCOME_O_OTHERSALARY <", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryLessThanOrEqualTo(String value) {
            addCriterion("INCOME_O_OTHERSALARY <=", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryLike(String value) {
            addCriterion("INCOME_O_OTHERSALARY like", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryNotLike(String value) {
            addCriterion("INCOME_O_OTHERSALARY not like", value, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryIn(List<String> values) {
            addCriterion("INCOME_O_OTHERSALARY in", values, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryNotIn(List<String> values) {
            addCriterion("INCOME_O_OTHERSALARY not in", values, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryBetween(String value1, String value2) {
            addCriterion("INCOME_O_OTHERSALARY between", value1, value2, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andIncomeOOthersalaryNotBetween(String value1, String value2) {
            addCriterion("INCOME_O_OTHERSALARY not between", value1, value2, "incomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOIsNull() {
            addCriterion("OUTCOME_O is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOIsNotNull() {
            addCriterion("OUTCOME_O is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOEqualTo(String value) {
            addCriterion("OUTCOME_O =", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeONotEqualTo(String value) {
            addCriterion("OUTCOME_O <>", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOGreaterThan(String value) {
            addCriterion("OUTCOME_O >", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O >=", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOLessThan(String value) {
            addCriterion("OUTCOME_O <", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O <=", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOLike(String value) {
            addCriterion("OUTCOME_O like", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeONotLike(String value) {
            addCriterion("OUTCOME_O not like", value, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOIn(List<String> values) {
            addCriterion("OUTCOME_O in", values, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeONotIn(List<String> values) {
            addCriterion("OUTCOME_O not in", values, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeOBetween(String value1, String value2) {
            addCriterion("OUTCOME_O between", value1, value2, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeONotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O not between", value1, value2, "outcomeO");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginIsNull() {
            addCriterion("OUTCOME_O_NETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginIsNotNull() {
            addCriterion("OUTCOME_O_NETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginEqualTo(String value) {
            addCriterion("OUTCOME_O_NETMARGIN =", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginNotEqualTo(String value) {
            addCriterion("OUTCOME_O_NETMARGIN <>", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginGreaterThan(String value) {
            addCriterion("OUTCOME_O_NETMARGIN >", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_NETMARGIN >=", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginLessThan(String value) {
            addCriterion("OUTCOME_O_NETMARGIN <", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_NETMARGIN <=", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginLike(String value) {
            addCriterion("OUTCOME_O_NETMARGIN like", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginNotLike(String value) {
            addCriterion("OUTCOME_O_NETMARGIN not like", value, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginIn(List<String> values) {
            addCriterion("OUTCOME_O_NETMARGIN in", values, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginNotIn(List<String> values) {
            addCriterion("OUTCOME_O_NETMARGIN not in", values, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_NETMARGIN between", value1, value2, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeONetmarginNotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_NETMARGIN not between", value1, value2, "outcomeONetmargin");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczIsNull() {
            addCriterion("OUTCOME_O_ZWCZ is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczIsNotNull() {
            addCriterion("OUTCOME_O_ZWCZ is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczEqualTo(String value) {
            addCriterion("OUTCOME_O_ZWCZ =", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczNotEqualTo(String value) {
            addCriterion("OUTCOME_O_ZWCZ <>", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczGreaterThan(String value) {
            addCriterion("OUTCOME_O_ZWCZ >", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_ZWCZ >=", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczLessThan(String value) {
            addCriterion("OUTCOME_O_ZWCZ <", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_ZWCZ <=", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczLike(String value) {
            addCriterion("OUTCOME_O_ZWCZ like", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczNotLike(String value) {
            addCriterion("OUTCOME_O_ZWCZ not like", value, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczIn(List<String> values) {
            addCriterion("OUTCOME_O_ZWCZ in", values, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczNotIn(List<String> values) {
            addCriterion("OUTCOME_O_ZWCZ not in", values, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_ZWCZ between", value1, value2, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOZwczNotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_ZWCZ not between", value1, value2, "outcomeOZwcz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkIsNull() {
            addCriterion("OUTCOME_O_FK is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkIsNotNull() {
            addCriterion("OUTCOME_O_FK is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkEqualTo(String value) {
            addCriterion("OUTCOME_O_FK =", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkNotEqualTo(String value) {
            addCriterion("OUTCOME_O_FK <>", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkGreaterThan(String value) {
            addCriterion("OUTCOME_O_FK >", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_FK >=", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkLessThan(String value) {
            addCriterion("OUTCOME_O_FK <", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_FK <=", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkLike(String value) {
            addCriterion("OUTCOME_O_FK like", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkNotLike(String value) {
            addCriterion("OUTCOME_O_FK not like", value, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkIn(List<String> values) {
            addCriterion("OUTCOME_O_FK in", values, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkNotIn(List<String> values) {
            addCriterion("OUTCOME_O_FK not in", values, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_FK between", value1, value2, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOFkNotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_FK not between", value1, value2, "outcomeOFk");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzIsNull() {
            addCriterion("OUTCOME_O_JZ is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzIsNotNull() {
            addCriterion("OUTCOME_O_JZ is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzEqualTo(String value) {
            addCriterion("OUTCOME_O_JZ =", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzNotEqualTo(String value) {
            addCriterion("OUTCOME_O_JZ <>", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzGreaterThan(String value) {
            addCriterion("OUTCOME_O_JZ >", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_JZ >=", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzLessThan(String value) {
            addCriterion("OUTCOME_O_JZ <", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_JZ <=", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzLike(String value) {
            addCriterion("OUTCOME_O_JZ like", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzNotLike(String value) {
            addCriterion("OUTCOME_O_JZ not like", value, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzIn(List<String> values) {
            addCriterion("OUTCOME_O_JZ in", values, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzNotIn(List<String> values) {
            addCriterion("OUTCOME_O_JZ not in", values, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_JZ between", value1, value2, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOJzNotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_JZ not between", value1, value2, "outcomeOJz");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherIsNull() {
            addCriterion("OUTCOME_O_OTHER is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherIsNotNull() {
            addCriterion("OUTCOME_O_OTHER is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHER =", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherNotEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHER <>", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherGreaterThan(String value) {
            addCriterion("OUTCOME_O_OTHER >", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHER >=", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherLessThan(String value) {
            addCriterion("OUTCOME_O_OTHER <", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHER <=", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherLike(String value) {
            addCriterion("OUTCOME_O_OTHER like", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherNotLike(String value) {
            addCriterion("OUTCOME_O_OTHER not like", value, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherIn(List<String> values) {
            addCriterion("OUTCOME_O_OTHER in", values, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherNotIn(List<String> values) {
            addCriterion("OUTCOME_O_OTHER not in", values, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_OTHER between", value1, value2, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOtherNotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_OTHER not between", value1, value2, "outcomeOOther");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryIsNull() {
            addCriterion("OUTCOME_O_OTHERSALARY is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryIsNotNull() {
            addCriterion("OUTCOME_O_OTHERSALARY is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY =", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryNotEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY <>", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryGreaterThan(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY >", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryGreaterThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY >=", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryLessThan(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY <", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryLessThanOrEqualTo(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY <=", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryLike(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY like", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryNotLike(String value) {
            addCriterion("OUTCOME_O_OTHERSALARY not like", value, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryIn(List<String> values) {
            addCriterion("OUTCOME_O_OTHERSALARY in", values, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryNotIn(List<String> values) {
            addCriterion("OUTCOME_O_OTHERSALARY not in", values, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_OTHERSALARY between", value1, value2, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andOutcomeOOthersalaryNotBetween(String value1, String value2) {
            addCriterion("OUTCOME_O_OTHERSALARY not between", value1, value2, "outcomeOOthersalary");
            return (Criteria) this;
        }

        public Criteria andAllprofitIsNull() {
            addCriterion("ALLPROFIT is null");
            return (Criteria) this;
        }

        public Criteria andAllprofitIsNotNull() {
            addCriterion("ALLPROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andAllprofitEqualTo(String value) {
            addCriterion("ALLPROFIT =", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitNotEqualTo(String value) {
            addCriterion("ALLPROFIT <>", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitGreaterThan(String value) {
            addCriterion("ALLPROFIT >", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitGreaterThanOrEqualTo(String value) {
            addCriterion("ALLPROFIT >=", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitLessThan(String value) {
            addCriterion("ALLPROFIT <", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitLessThanOrEqualTo(String value) {
            addCriterion("ALLPROFIT <=", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitLike(String value) {
            addCriterion("ALLPROFIT like", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitNotLike(String value) {
            addCriterion("ALLPROFIT not like", value, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitIn(List<String> values) {
            addCriterion("ALLPROFIT in", values, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitNotIn(List<String> values) {
            addCriterion("ALLPROFIT not in", values, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitBetween(String value1, String value2) {
            addCriterion("ALLPROFIT between", value1, value2, "allprofit");
            return (Criteria) this;
        }

        public Criteria andAllprofitNotBetween(String value1, String value2) {
            addCriterion("ALLPROFIT not between", value1, value2, "allprofit");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxIsNull() {
            addCriterion("INCOMDETAX is null");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxIsNotNull() {
            addCriterion("INCOMDETAX is not null");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxEqualTo(String value) {
            addCriterion("INCOMDETAX =", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxNotEqualTo(String value) {
            addCriterion("INCOMDETAX <>", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxGreaterThan(String value) {
            addCriterion("INCOMDETAX >", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxGreaterThanOrEqualTo(String value) {
            addCriterion("INCOMDETAX >=", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxLessThan(String value) {
            addCriterion("INCOMDETAX <", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxLessThanOrEqualTo(String value) {
            addCriterion("INCOMDETAX <=", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxLike(String value) {
            addCriterion("INCOMDETAX like", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxNotLike(String value) {
            addCriterion("INCOMDETAX not like", value, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxIn(List<String> values) {
            addCriterion("INCOMDETAX in", values, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxNotIn(List<String> values) {
            addCriterion("INCOMDETAX not in", values, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxBetween(String value1, String value2) {
            addCriterion("INCOMDETAX between", value1, value2, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andIncomdetaxNotBetween(String value1, String value2) {
            addCriterion("INCOMDETAX not between", value1, value2, "incomdetax");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeIsNull() {
            addCriterion("FEWPARTNERINCOME is null");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeIsNotNull() {
            addCriterion("FEWPARTNERINCOME is not null");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeEqualTo(String value) {
            addCriterion("FEWPARTNERINCOME =", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeNotEqualTo(String value) {
            addCriterion("FEWPARTNERINCOME <>", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeGreaterThan(String value) {
            addCriterion("FEWPARTNERINCOME >", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeGreaterThanOrEqualTo(String value) {
            addCriterion("FEWPARTNERINCOME >=", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeLessThan(String value) {
            addCriterion("FEWPARTNERINCOME <", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeLessThanOrEqualTo(String value) {
            addCriterion("FEWPARTNERINCOME <=", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeLike(String value) {
            addCriterion("FEWPARTNERINCOME like", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeNotLike(String value) {
            addCriterion("FEWPARTNERINCOME not like", value, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeIn(List<String> values) {
            addCriterion("FEWPARTNERINCOME in", values, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeNotIn(List<String> values) {
            addCriterion("FEWPARTNERINCOME not in", values, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeBetween(String value1, String value2) {
            addCriterion("FEWPARTNERINCOME between", value1, value2, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andFewpartnerincomeNotBetween(String value1, String value2) {
            addCriterion("FEWPARTNERINCOME not between", value1, value2, "fewpartnerincome");
            return (Criteria) this;
        }

        public Criteria andUnsurelossIsNull() {
            addCriterion("UNSURELOSS is null");
            return (Criteria) this;
        }

        public Criteria andUnsurelossIsNotNull() {
            addCriterion("UNSURELOSS is not null");
            return (Criteria) this;
        }

        public Criteria andUnsurelossEqualTo(String value) {
            addCriterion("UNSURELOSS =", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossNotEqualTo(String value) {
            addCriterion("UNSURELOSS <>", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossGreaterThan(String value) {
            addCriterion("UNSURELOSS >", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossGreaterThanOrEqualTo(String value) {
            addCriterion("UNSURELOSS >=", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossLessThan(String value) {
            addCriterion("UNSURELOSS <", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossLessThanOrEqualTo(String value) {
            addCriterion("UNSURELOSS <=", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossLike(String value) {
            addCriterion("UNSURELOSS like", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossNotLike(String value) {
            addCriterion("UNSURELOSS not like", value, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossIn(List<String> values) {
            addCriterion("UNSURELOSS in", values, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossNotIn(List<String> values) {
            addCriterion("UNSURELOSS not in", values, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossBetween(String value1, String value2) {
            addCriterion("UNSURELOSS between", value1, value2, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andUnsurelossNotBetween(String value1, String value2) {
            addCriterion("UNSURELOSS not between", value1, value2, "unsureloss");
            return (Criteria) this;
        }

        public Criteria andNetmarginIsNull() {
            addCriterion("NETMARGIN is null");
            return (Criteria) this;
        }

        public Criteria andNetmarginIsNotNull() {
            addCriterion("NETMARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andNetmarginEqualTo(String value) {
            addCriterion("NETMARGIN =", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginNotEqualTo(String value) {
            addCriterion("NETMARGIN <>", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginGreaterThan(String value) {
            addCriterion("NETMARGIN >", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginGreaterThanOrEqualTo(String value) {
            addCriterion("NETMARGIN >=", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginLessThan(String value) {
            addCriterion("NETMARGIN <", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginLessThanOrEqualTo(String value) {
            addCriterion("NETMARGIN <=", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginLike(String value) {
            addCriterion("NETMARGIN like", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginNotLike(String value) {
            addCriterion("NETMARGIN not like", value, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginIn(List<String> values) {
            addCriterion("NETMARGIN in", values, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginNotIn(List<String> values) {
            addCriterion("NETMARGIN not in", values, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginBetween(String value1, String value2) {
            addCriterion("NETMARGIN between", value1, value2, "netmargin");
            return (Criteria) this;
        }

        public Criteria andNetmarginNotBetween(String value1, String value2) {
            addCriterion("NETMARGIN not between", value1, value2, "netmargin");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedIsNull() {
            addCriterion("BEGINOFYEARUNDISTRIBUTED is null");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedIsNotNull() {
            addCriterion("BEGINOFYEARUNDISTRIBUTED is not null");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedEqualTo(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED =", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedNotEqualTo(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED <>", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedGreaterThan(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED >", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedGreaterThanOrEqualTo(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED >=", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedLessThan(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED <", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedLessThanOrEqualTo(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED <=", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedLike(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED like", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedNotLike(String value) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED not like", value, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedIn(List<String> values) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED in", values, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedNotIn(List<String> values) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED not in", values, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedBetween(String value1, String value2) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED between", value1, value2, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andBeginofyearundistributedNotBetween(String value1, String value2) {
            addCriterion("BEGINOFYEARUNDISTRIBUTED not between", value1, value2, "beginofyearundistributed");
            return (Criteria) this;
        }

        public Criteria andYygjbkIsNull() {
            addCriterion("YYGJBK is null");
            return (Criteria) this;
        }

        public Criteria andYygjbkIsNotNull() {
            addCriterion("YYGJBK is not null");
            return (Criteria) this;
        }

        public Criteria andYygjbkEqualTo(String value) {
            addCriterion("YYGJBK =", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkNotEqualTo(String value) {
            addCriterion("YYGJBK <>", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkGreaterThan(String value) {
            addCriterion("YYGJBK >", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkGreaterThanOrEqualTo(String value) {
            addCriterion("YYGJBK >=", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkLessThan(String value) {
            addCriterion("YYGJBK <", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkLessThanOrEqualTo(String value) {
            addCriterion("YYGJBK <=", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkLike(String value) {
            addCriterion("YYGJBK like", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkNotLike(String value) {
            addCriterion("YYGJBK not like", value, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkIn(List<String> values) {
            addCriterion("YYGJBK in", values, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkNotIn(List<String> values) {
            addCriterion("YYGJBK not in", values, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkBetween(String value1, String value2) {
            addCriterion("YYGJBK between", value1, value2, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andYygjbkNotBetween(String value1, String value2) {
            addCriterion("YYGJBK not between", value1, value2, "yygjbk");
            return (Criteria) this;
        }

        public Criteria andQttzysIsNull() {
            addCriterion("QTTZYS is null");
            return (Criteria) this;
        }

        public Criteria andQttzysIsNotNull() {
            addCriterion("QTTZYS is not null");
            return (Criteria) this;
        }

        public Criteria andQttzysEqualTo(String value) {
            addCriterion("QTTZYS =", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysNotEqualTo(String value) {
            addCriterion("QTTZYS <>", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysGreaterThan(String value) {
            addCriterion("QTTZYS >", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysGreaterThanOrEqualTo(String value) {
            addCriterion("QTTZYS >=", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysLessThan(String value) {
            addCriterion("QTTZYS <", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysLessThanOrEqualTo(String value) {
            addCriterion("QTTZYS <=", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysLike(String value) {
            addCriterion("QTTZYS like", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysNotLike(String value) {
            addCriterion("QTTZYS not like", value, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysIn(List<String> values) {
            addCriterion("QTTZYS in", values, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysNotIn(List<String> values) {
            addCriterion("QTTZYS not in", values, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysBetween(String value1, String value2) {
            addCriterion("QTTZYS between", value1, value2, "qttzys");
            return (Criteria) this;
        }

        public Criteria andQttzysNotBetween(String value1, String value2) {
            addCriterion("QTTZYS not between", value1, value2, "qttzys");
            return (Criteria) this;
        }

        public Criteria andKgfpllIsNull() {
            addCriterion("KGFPLL is null");
            return (Criteria) this;
        }

        public Criteria andKgfpllIsNotNull() {
            addCriterion("KGFPLL is not null");
            return (Criteria) this;
        }

        public Criteria andKgfpllEqualTo(String value) {
            addCriterion("KGFPLL =", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllNotEqualTo(String value) {
            addCriterion("KGFPLL <>", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllGreaterThan(String value) {
            addCriterion("KGFPLL >", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllGreaterThanOrEqualTo(String value) {
            addCriterion("KGFPLL >=", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllLessThan(String value) {
            addCriterion("KGFPLL <", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllLessThanOrEqualTo(String value) {
            addCriterion("KGFPLL <=", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllLike(String value) {
            addCriterion("KGFPLL like", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllNotLike(String value) {
            addCriterion("KGFPLL not like", value, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllIn(List<String> values) {
            addCriterion("KGFPLL in", values, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllNotIn(List<String> values) {
            addCriterion("KGFPLL not in", values, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllBetween(String value1, String value2) {
            addCriterion("KGFPLL between", value1, value2, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andKgfpllNotBetween(String value1, String value2) {
            addCriterion("KGFPLL not between", value1, value2, "kgfpll");
            return (Criteria) this;
        }

        public Criteria andDxlyllIsNull() {
            addCriterion("DXLYLL is null");
            return (Criteria) this;
        }

        public Criteria andDxlyllIsNotNull() {
            addCriterion("DXLYLL is not null");
            return (Criteria) this;
        }

        public Criteria andDxlyllEqualTo(String value) {
            addCriterion("DXLYLL =", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllNotEqualTo(String value) {
            addCriterion("DXLYLL <>", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllGreaterThan(String value) {
            addCriterion("DXLYLL >", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllGreaterThanOrEqualTo(String value) {
            addCriterion("DXLYLL >=", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllLessThan(String value) {
            addCriterion("DXLYLL <", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllLessThanOrEqualTo(String value) {
            addCriterion("DXLYLL <=", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllLike(String value) {
            addCriterion("DXLYLL like", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllNotLike(String value) {
            addCriterion("DXLYLL not like", value, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllIn(List<String> values) {
            addCriterion("DXLYLL in", values, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllNotIn(List<String> values) {
            addCriterion("DXLYLL not in", values, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllBetween(String value1, String value2) {
            addCriterion("DXLYLL between", value1, value2, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andDxlyllNotBetween(String value1, String value2) {
            addCriterion("DXLYLL not between", value1, value2, "dxlyll");
            return (Criteria) this;
        }

        public Criteria andBcldzbIsNull() {
            addCriterion("BCLDZB is null");
            return (Criteria) this;
        }

        public Criteria andBcldzbIsNotNull() {
            addCriterion("BCLDZB is not null");
            return (Criteria) this;
        }

        public Criteria andBcldzbEqualTo(String value) {
            addCriterion("BCLDZB =", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbNotEqualTo(String value) {
            addCriterion("BCLDZB <>", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbGreaterThan(String value) {
            addCriterion("BCLDZB >", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbGreaterThanOrEqualTo(String value) {
            addCriterion("BCLDZB >=", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbLessThan(String value) {
            addCriterion("BCLDZB <", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbLessThanOrEqualTo(String value) {
            addCriterion("BCLDZB <=", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbLike(String value) {
            addCriterion("BCLDZB like", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbNotLike(String value) {
            addCriterion("BCLDZB not like", value, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbIn(List<String> values) {
            addCriterion("BCLDZB in", values, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbNotIn(List<String> values) {
            addCriterion("BCLDZB not in", values, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbBetween(String value1, String value2) {
            addCriterion("BCLDZB between", value1, value2, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andBcldzbNotBetween(String value1, String value2) {
            addCriterion("BCLDZB not between", value1, value2, "bcldzb");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjIsNull() {
            addCriterion("TQFDYYGJ is null");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjIsNotNull() {
            addCriterion("TQFDYYGJ is not null");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjEqualTo(String value) {
            addCriterion("TQFDYYGJ =", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjNotEqualTo(String value) {
            addCriterion("TQFDYYGJ <>", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjGreaterThan(String value) {
            addCriterion("TQFDYYGJ >", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjGreaterThanOrEqualTo(String value) {
            addCriterion("TQFDYYGJ >=", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjLessThan(String value) {
            addCriterion("TQFDYYGJ <", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjLessThanOrEqualTo(String value) {
            addCriterion("TQFDYYGJ <=", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjLike(String value) {
            addCriterion("TQFDYYGJ like", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjNotLike(String value) {
            addCriterion("TQFDYYGJ not like", value, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjIn(List<String> values) {
            addCriterion("TQFDYYGJ in", values, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjNotIn(List<String> values) {
            addCriterion("TQFDYYGJ not in", values, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjBetween(String value1, String value2) {
            addCriterion("TQFDYYGJ between", value1, value2, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygjNotBetween(String value1, String value2) {
            addCriterion("TQFDYYGJ not between", value1, value2, "tqfdyygj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjIsNull() {
            addCriterion("TQFDYYGYJ is null");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjIsNotNull() {
            addCriterion("TQFDYYGYJ is not null");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjEqualTo(String value) {
            addCriterion("TQFDYYGYJ =", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjNotEqualTo(String value) {
            addCriterion("TQFDYYGYJ <>", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjGreaterThan(String value) {
            addCriterion("TQFDYYGYJ >", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjGreaterThanOrEqualTo(String value) {
            addCriterion("TQFDYYGYJ >=", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjLessThan(String value) {
            addCriterion("TQFDYYGYJ <", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjLessThanOrEqualTo(String value) {
            addCriterion("TQFDYYGYJ <=", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjLike(String value) {
            addCriterion("TQFDYYGYJ like", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjNotLike(String value) {
            addCriterion("TQFDYYGYJ not like", value, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjIn(List<String> values) {
            addCriterion("TQFDYYGYJ in", values, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjNotIn(List<String> values) {
            addCriterion("TQFDYYGYJ not in", values, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjBetween(String value1, String value2) {
            addCriterion("TQFDYYGYJ between", value1, value2, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqfdyygyjNotBetween(String value1, String value2) {
            addCriterion("TQFDYYGYJ not between", value1, value2, "tqfdyygyj");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyIsNull() {
            addCriterion("TQZGJLJFLDY is null");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyIsNotNull() {
            addCriterion("TQZGJLJFLDY is not null");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyEqualTo(String value) {
            addCriterion("TQZGJLJFLDY =", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyNotEqualTo(String value) {
            addCriterion("TQZGJLJFLDY <>", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyGreaterThan(String value) {
            addCriterion("TQZGJLJFLDY >", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyGreaterThanOrEqualTo(String value) {
            addCriterion("TQZGJLJFLDY >=", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyLessThan(String value) {
            addCriterion("TQZGJLJFLDY <", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyLessThanOrEqualTo(String value) {
            addCriterion("TQZGJLJFLDY <=", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyLike(String value) {
            addCriterion("TQZGJLJFLDY like", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyNotLike(String value) {
            addCriterion("TQZGJLJFLDY not like", value, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyIn(List<String> values) {
            addCriterion("TQZGJLJFLDY in", values, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyNotIn(List<String> values) {
            addCriterion("TQZGJLJFLDY not in", values, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyBetween(String value1, String value2) {
            addCriterion("TQZGJLJFLDY between", value1, value2, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqzgjljfldyNotBetween(String value1, String value2) {
            addCriterion("TQZGJLJFLDY not between", value1, value2, "tqzgjljfldy");
            return (Criteria) this;
        }

        public Criteria andTqcbjIsNull() {
            addCriterion("TQCBJ is null");
            return (Criteria) this;
        }

        public Criteria andTqcbjIsNotNull() {
            addCriterion("TQCBJ is not null");
            return (Criteria) this;
        }

        public Criteria andTqcbjEqualTo(String value) {
            addCriterion("TQCBJ =", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjNotEqualTo(String value) {
            addCriterion("TQCBJ <>", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjGreaterThan(String value) {
            addCriterion("TQCBJ >", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjGreaterThanOrEqualTo(String value) {
            addCriterion("TQCBJ >=", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjLessThan(String value) {
            addCriterion("TQCBJ <", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjLessThanOrEqualTo(String value) {
            addCriterion("TQCBJ <=", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjLike(String value) {
            addCriterion("TQCBJ like", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjNotLike(String value) {
            addCriterion("TQCBJ not like", value, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjIn(List<String> values) {
            addCriterion("TQCBJ in", values, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjNotIn(List<String> values) {
            addCriterion("TQCBJ not in", values, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjBetween(String value1, String value2) {
            addCriterion("TQCBJ between", value1, value2, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqcbjNotBetween(String value1, String value2) {
            addCriterion("TQCBJ not between", value1, value2, "tqcbj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjIsNull() {
            addCriterion("TQQYFZJJ is null");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjIsNotNull() {
            addCriterion("TQQYFZJJ is not null");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjEqualTo(String value) {
            addCriterion("TQQYFZJJ =", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjNotEqualTo(String value) {
            addCriterion("TQQYFZJJ <>", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjGreaterThan(String value) {
            addCriterion("TQQYFZJJ >", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjGreaterThanOrEqualTo(String value) {
            addCriterion("TQQYFZJJ >=", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjLessThan(String value) {
            addCriterion("TQQYFZJJ <", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjLessThanOrEqualTo(String value) {
            addCriterion("TQQYFZJJ <=", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjLike(String value) {
            addCriterion("TQQYFZJJ like", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjNotLike(String value) {
            addCriterion("TQQYFZJJ not like", value, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjIn(List<String> values) {
            addCriterion("TQQYFZJJ in", values, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjNotIn(List<String> values) {
            addCriterion("TQQYFZJJ not in", values, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjBetween(String value1, String value2) {
            addCriterion("TQQYFZJJ between", value1, value2, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andTqqyfzjjNotBetween(String value1, String value2) {
            addCriterion("TQQYFZJJ not between", value1, value2, "tqqyfzjj");
            return (Criteria) this;
        }

        public Criteria andLlghtzIsNull() {
            addCriterion("LLGHTZ is null");
            return (Criteria) this;
        }

        public Criteria andLlghtzIsNotNull() {
            addCriterion("LLGHTZ is not null");
            return (Criteria) this;
        }

        public Criteria andLlghtzEqualTo(String value) {
            addCriterion("LLGHTZ =", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzNotEqualTo(String value) {
            addCriterion("LLGHTZ <>", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzGreaterThan(String value) {
            addCriterion("LLGHTZ >", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzGreaterThanOrEqualTo(String value) {
            addCriterion("LLGHTZ >=", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzLessThan(String value) {
            addCriterion("LLGHTZ <", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzLessThanOrEqualTo(String value) {
            addCriterion("LLGHTZ <=", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzLike(String value) {
            addCriterion("LLGHTZ like", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzNotLike(String value) {
            addCriterion("LLGHTZ not like", value, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzIn(List<String> values) {
            addCriterion("LLGHTZ in", values, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzNotIn(List<String> values) {
            addCriterion("LLGHTZ not in", values, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzBetween(String value1, String value2) {
            addCriterion("LLGHTZ between", value1, value2, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzNotBetween(String value1, String value2) {
            addCriterion("LLGHTZ not between", value1, value2, "llghtz");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherIsNull() {
            addCriterion("LLGHTZOTHER is null");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherIsNotNull() {
            addCriterion("LLGHTZOTHER is not null");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherEqualTo(String value) {
            addCriterion("LLGHTZOTHER =", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherNotEqualTo(String value) {
            addCriterion("LLGHTZOTHER <>", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherGreaterThan(String value) {
            addCriterion("LLGHTZOTHER >", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherGreaterThanOrEqualTo(String value) {
            addCriterion("LLGHTZOTHER >=", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherLessThan(String value) {
            addCriterion("LLGHTZOTHER <", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherLessThanOrEqualTo(String value) {
            addCriterion("LLGHTZOTHER <=", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherLike(String value) {
            addCriterion("LLGHTZOTHER like", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherNotLike(String value) {
            addCriterion("LLGHTZOTHER not like", value, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherIn(List<String> values) {
            addCriterion("LLGHTZOTHER in", values, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherNotIn(List<String> values) {
            addCriterion("LLGHTZOTHER not in", values, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherBetween(String value1, String value2) {
            addCriterion("LLGHTZOTHER between", value1, value2, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andLlghtzotherNotBetween(String value1, String value2) {
            addCriterion("LLGHTZOTHER not between", value1, value2, "llghtzother");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllIsNull() {
            addCriterion("KGTZZFFLL is null");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllIsNotNull() {
            addCriterion("KGTZZFFLL is not null");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllEqualTo(String value) {
            addCriterion("KGTZZFFLL =", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllNotEqualTo(String value) {
            addCriterion("KGTZZFFLL <>", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllGreaterThan(String value) {
            addCriterion("KGTZZFFLL >", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllGreaterThanOrEqualTo(String value) {
            addCriterion("KGTZZFFLL >=", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllLessThan(String value) {
            addCriterion("KGTZZFFLL <", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllLessThanOrEqualTo(String value) {
            addCriterion("KGTZZFFLL <=", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllLike(String value) {
            addCriterion("KGTZZFFLL like", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllNotLike(String value) {
            addCriterion("KGTZZFFLL not like", value, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllIn(List<String> values) {
            addCriterion("KGTZZFFLL in", values, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllNotIn(List<String> values) {
            addCriterion("KGTZZFFLL not in", values, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllBetween(String value1, String value2) {
            addCriterion("KGTZZFFLL between", value1, value2, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andKgtzzffllNotBetween(String value1, String value2) {
            addCriterion("KGTZZFFLL not between", value1, value2, "kgtzzffll");
            return (Criteria) this;
        }

        public Criteria andYfyxgglIsNull() {
            addCriterion("YFYXGGL is null");
            return (Criteria) this;
        }

        public Criteria andYfyxgglIsNotNull() {
            addCriterion("YFYXGGL is not null");
            return (Criteria) this;
        }

        public Criteria andYfyxgglEqualTo(String value) {
            addCriterion("YFYXGGL =", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglNotEqualTo(String value) {
            addCriterion("YFYXGGL <>", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglGreaterThan(String value) {
            addCriterion("YFYXGGL >", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglGreaterThanOrEqualTo(String value) {
            addCriterion("YFYXGGL >=", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglLessThan(String value) {
            addCriterion("YFYXGGL <", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglLessThanOrEqualTo(String value) {
            addCriterion("YFYXGGL <=", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglLike(String value) {
            addCriterion("YFYXGGL like", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglNotLike(String value) {
            addCriterion("YFYXGGL not like", value, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglIn(List<String> values) {
            addCriterion("YFYXGGL in", values, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglNotIn(List<String> values) {
            addCriterion("YFYXGGL not in", values, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglBetween(String value1, String value2) {
            addCriterion("YFYXGGL between", value1, value2, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andYfyxgglNotBetween(String value1, String value2) {
            addCriterion("YFYXGGL not between", value1, value2, "yfyxggl");
            return (Criteria) this;
        }

        public Criteria andTqryyygjIsNull() {
            addCriterion("TQRYYYGJ is null");
            return (Criteria) this;
        }

        public Criteria andTqryyygjIsNotNull() {
            addCriterion("TQRYYYGJ is not null");
            return (Criteria) this;
        }

        public Criteria andTqryyygjEqualTo(String value) {
            addCriterion("TQRYYYGJ =", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjNotEqualTo(String value) {
            addCriterion("TQRYYYGJ <>", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjGreaterThan(String value) {
            addCriterion("TQRYYYGJ >", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjGreaterThanOrEqualTo(String value) {
            addCriterion("TQRYYYGJ >=", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjLessThan(String value) {
            addCriterion("TQRYYYGJ <", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjLessThanOrEqualTo(String value) {
            addCriterion("TQRYYYGJ <=", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjLike(String value) {
            addCriterion("TQRYYYGJ like", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjNotLike(String value) {
            addCriterion("TQRYYYGJ not like", value, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjIn(List<String> values) {
            addCriterion("TQRYYYGJ in", values, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjNotIn(List<String> values) {
            addCriterion("TQRYYYGJ not in", values, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjBetween(String value1, String value2) {
            addCriterion("TQRYYYGJ between", value1, value2, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andTqryyygjNotBetween(String value1, String value2) {
            addCriterion("TQRYYYGJ not between", value1, value2, "tqryyygj");
            return (Criteria) this;
        }

        public Criteria andYfptgglIsNull() {
            addCriterion("YFPTGGL is null");
            return (Criteria) this;
        }

        public Criteria andYfptgglIsNotNull() {
            addCriterion("YFPTGGL is not null");
            return (Criteria) this;
        }

        public Criteria andYfptgglEqualTo(String value) {
            addCriterion("YFPTGGL =", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglNotEqualTo(String value) {
            addCriterion("YFPTGGL <>", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglGreaterThan(String value) {
            addCriterion("YFPTGGL >", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglGreaterThanOrEqualTo(String value) {
            addCriterion("YFPTGGL >=", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglLessThan(String value) {
            addCriterion("YFPTGGL <", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglLessThanOrEqualTo(String value) {
            addCriterion("YFPTGGL <=", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglLike(String value) {
            addCriterion("YFPTGGL like", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglNotLike(String value) {
            addCriterion("YFPTGGL not like", value, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglIn(List<String> values) {
            addCriterion("YFPTGGL in", values, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglNotIn(List<String> values) {
            addCriterion("YFPTGGL not in", values, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglBetween(String value1, String value2) {
            addCriterion("YFPTGGL between", value1, value2, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andYfptgglNotBetween(String value1, String value2) {
            addCriterion("YFPTGGL not between", value1, value2, "yfptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglIsNull() {
            addCriterion("ZZZBPTGGL is null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglIsNotNull() {
            addCriterion("ZZZBPTGGL is not null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglEqualTo(String value) {
            addCriterion("ZZZBPTGGL =", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglNotEqualTo(String value) {
            addCriterion("ZZZBPTGGL <>", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglGreaterThan(String value) {
            addCriterion("ZZZBPTGGL >", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglGreaterThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGL >=", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglLessThan(String value) {
            addCriterion("ZZZBPTGGL <", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglLessThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGL <=", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglLike(String value) {
            addCriterion("ZZZBPTGGL like", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglNotLike(String value) {
            addCriterion("ZZZBPTGGL not like", value, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglIn(List<String> values) {
            addCriterion("ZZZBPTGGL in", values, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglNotIn(List<String> values) {
            addCriterion("ZZZBPTGGL not in", values, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGL between", value1, value2, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglNotBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGL not between", value1, value2, "zzzbptggl");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherIsNull() {
            addCriterion("ZZZBPTGGLOTHER is null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherIsNotNull() {
            addCriterion("ZZZBPTGGLOTHER is not null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherEqualTo(String value) {
            addCriterion("ZZZBPTGGLOTHER =", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherNotEqualTo(String value) {
            addCriterion("ZZZBPTGGLOTHER <>", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherGreaterThan(String value) {
            addCriterion("ZZZBPTGGLOTHER >", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherGreaterThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGLOTHER >=", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherLessThan(String value) {
            addCriterion("ZZZBPTGGLOTHER <", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherLessThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGLOTHER <=", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherLike(String value) {
            addCriterion("ZZZBPTGGLOTHER like", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherNotLike(String value) {
            addCriterion("ZZZBPTGGLOTHER not like", value, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherIn(List<String> values) {
            addCriterion("ZZZBPTGGLOTHER in", values, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherNotIn(List<String> values) {
            addCriterion("ZZZBPTGGLOTHER not in", values, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGLOTHER between", value1, value2, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglotherNotBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGLOTHER not between", value1, value2, "zzzbptgglother");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteIsNull() {
            addCriterion("ZZZBPTGGLUNDISBUTE is null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteIsNotNull() {
            addCriterion("ZZZBPTGGLUNDISBUTE is not null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE =", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteNotEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE <>", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteGreaterThan(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE >", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteGreaterThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE >=", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteLessThan(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE <", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteLessThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE <=", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteLike(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE like", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteNotLike(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE not like", value, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteIn(List<String> values) {
            addCriterion("ZZZBPTGGLUNDISBUTE in", values, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteNotIn(List<String> values) {
            addCriterion("ZZZBPTGGLUNDISBUTE not in", values, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGLUNDISBUTE between", value1, value2, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteNotBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGLUNDISBUTE not between", value1, value2, "zzzbptgglundisbute");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeIsNull() {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE is null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeIsNotNull() {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE is not null");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE =", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeNotEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE <>", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeGreaterThan(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE >", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeGreaterThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE >=", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeLessThan(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE <", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeLessThanOrEqualTo(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE <=", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeLike(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE like", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeNotLike(String value) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE not like", value, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeIn(List<String> values) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE in", values, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeNotIn(List<String> values) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE not in", values, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE between", value1, value2, "zzzbptgglundisbuteBefore");
            return (Criteria) this;
        }

        public Criteria andZzzbptgglundisbuteBeforeNotBetween(String value1, String value2) {
            addCriterion("ZZZBPTGGLUNDISBUTE_BEFORE not between", value1, value2, "zzzbptgglundisbuteBefore");
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

        public Criteria andRecoderIsNull() {
            addCriterion("RECODER is null");
            return (Criteria) this;
        }

        public Criteria andRecoderIsNotNull() {
            addCriterion("RECODER is not null");
            return (Criteria) this;
        }

        public Criteria andRecoderEqualTo(String value) {
            addCriterion("RECODER =", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderNotEqualTo(String value) {
            addCriterion("RECODER <>", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderGreaterThan(String value) {
            addCriterion("RECODER >", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderGreaterThanOrEqualTo(String value) {
            addCriterion("RECODER >=", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderLessThan(String value) {
            addCriterion("RECODER <", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderLessThanOrEqualTo(String value) {
            addCriterion("RECODER <=", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderLike(String value) {
            addCriterion("RECODER like", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderNotLike(String value) {
            addCriterion("RECODER not like", value, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderIn(List<String> values) {
            addCriterion("RECODER in", values, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderNotIn(List<String> values) {
            addCriterion("RECODER not in", values, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderBetween(String value1, String value2) {
            addCriterion("RECODER between", value1, value2, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecoderNotBetween(String value1, String value2) {
            addCriterion("RECODER not between", value1, value2, "recoder");
            return (Criteria) this;
        }

        public Criteria andRecodertimeIsNull() {
            addCriterion("RECODERTIME is null");
            return (Criteria) this;
        }

        public Criteria andRecodertimeIsNotNull() {
            addCriterion("RECODERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecodertimeEqualTo(Date value) {
            addCriterion("RECODERTIME =", value, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeNotEqualTo(Date value) {
            addCriterion("RECODERTIME <>", value, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeGreaterThan(Date value) {
            addCriterion("RECODERTIME >", value, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RECODERTIME >=", value, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeLessThan(Date value) {
            addCriterion("RECODERTIME <", value, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeLessThanOrEqualTo(Date value) {
            addCriterion("RECODERTIME <=", value, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeIn(List<Date> values) {
            addCriterion("RECODERTIME in", values, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeNotIn(List<Date> values) {
            addCriterion("RECODERTIME not in", values, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeBetween(Date value1, Date value2) {
            addCriterion("RECODERTIME between", value1, value2, "recodertime");
            return (Criteria) this;
        }

        public Criteria andRecodertimeNotBetween(Date value1, Date value2) {
            addCriterion("RECODERTIME not between", value1, value2, "recodertime");
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