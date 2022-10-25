package com.codegik.simlesnacional.domain;

import java.math.BigDecimal;

public class Tax {
    private BigDecimal from;
    private BigDecimal to;
    private BigDecimal aliquot;
    private BigDecimal amountDeducted;

    public BigDecimal getFrom() {
        return from;
    }

    public BigDecimal getTo() {
        return to;
    }

    public BigDecimal getAliquot() {
        return aliquot;
    }

    public BigDecimal getAmountDeducted() {
        return amountDeducted;
    }

    public Tax from(BigDecimal value) {
        this.from = value;
        return this;
    }

    public Tax to(BigDecimal value) {
        this.to = value;
        return this;
    }

    public Tax aliquot(BigDecimal value) {
        this.aliquot = value;
        return this;
    }

    public Tax amountDeducted(BigDecimal value) {
        this.amountDeducted = value;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Tax {from: %s, to: %s, aliquot: %s, amountDeducted: %s}", from, to, aliquot, amountDeducted);
    }
}
