package com.codegik.simlesnacional.domain;

import java.math.BigDecimal;

public class Customer {
    private BigDecimal salary12months = BigDecimal.ZERO;
    private BigDecimal grossRevenue = BigDecimal.ZERO;
    private BigDecimal fatorR = BigDecimal.ZERO;
    private BigDecimal effectiveAliquot = BigDecimal.ZERO;

    public BigDecimal getSalary12months() {
        return salary12months;
    }

    public Customer salary12months(BigDecimal salary12months) {
        this.salary12months = salary12months;
        return this;
    }

    public BigDecimal getGrossRevenue() {
        return grossRevenue;
    }

    public Customer grossRevenue(BigDecimal grossRevenue) {
        this.grossRevenue = grossRevenue;
        return this;
    }

    public BigDecimal getFatorR() {
        return fatorR;
    }

    public Customer fatorR(BigDecimal fatorR) {
        this.fatorR = fatorR;
        return this;
    }

    public BigDecimal getEffectiveAliquot() {
        return effectiveAliquot;
    }

    public Customer effectiveAliquot(BigDecimal effectiveAliquot) {
        this.effectiveAliquot = effectiveAliquot;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Customer {salary12months: %s, grossRevenue: %s, fatorR: %s, effectiveAliquot: %s}", salary12months, grossRevenue, fatorR, effectiveAliquot);
    }
}
