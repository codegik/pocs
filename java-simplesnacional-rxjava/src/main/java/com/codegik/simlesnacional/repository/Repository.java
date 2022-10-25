package com.codegik.simlesnacional.repository;

import com.codegik.simlesnacional.domain.Customer;
import com.codegik.simlesnacional.domain.Tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public List<Customer> getAllCustomers() {
        final List<Customer> customers = new ArrayList();
        customers.add(new Customer()
            .salary12months(BigDecimal.valueOf(145000))
            .grossRevenue(BigDecimal.valueOf(500000)));

        customers.add(new Customer()
            .salary12months(BigDecimal.valueOf(400000))
            .grossRevenue(BigDecimal.valueOf(600000)));

        customers.add(new Customer()
            .salary12months(BigDecimal.valueOf(100000))
            .grossRevenue(BigDecimal.valueOf(400000)));

        return customers;
    }


    public List<Tax> getAnexoIII() {
        final List<Tax> anexoIII = new ArrayList();
        anexoIII.add(new Tax()
            .from(BigDecimal.ZERO).to(BigDecimal.valueOf(180000))
            .aliquot(BigDecimal.valueOf(6)).amountDeducted(BigDecimal.ZERO));
        anexoIII.add(new Tax()
            .from(BigDecimal.valueOf(180000.01)).to(BigDecimal.valueOf(360000))
            .aliquot(BigDecimal.valueOf(11.20)).amountDeducted(BigDecimal.valueOf(9360)));
        anexoIII.add(new Tax()
            .from(BigDecimal.valueOf(360000.01)).to(BigDecimal.valueOf(720000))
            .aliquot(BigDecimal.valueOf(13.50)).amountDeducted(BigDecimal.valueOf(17640)));
        anexoIII.add(new Tax()
            .from(BigDecimal.valueOf(720000.01)).to(BigDecimal.valueOf(1800000))
            .aliquot(BigDecimal.valueOf(16)).amountDeducted(BigDecimal.valueOf(35640)));
        anexoIII.add(new Tax()
            .from(BigDecimal.valueOf(1800000.01)).to(BigDecimal.valueOf(3600000))
            .aliquot(BigDecimal.valueOf(21)).amountDeducted(BigDecimal.valueOf(125640)));
        anexoIII.add(new Tax()
            .from(BigDecimal.valueOf(3600000.01)).to(BigDecimal.valueOf(4800000))
            .aliquot(BigDecimal.valueOf(33)).amountDeducted(BigDecimal.valueOf(648000)));
        return anexoIII;
    }


    public List<Tax> getAnexoV() {
        final List<Tax> anexoV = new ArrayList();
        anexoV.add(new Tax()
            .from(BigDecimal.ZERO).to(BigDecimal.valueOf(180000))
            .aliquot(BigDecimal.valueOf(15.50)).amountDeducted(BigDecimal.ZERO));
        anexoV.add(new Tax()
            .from(BigDecimal.valueOf(180000.01)).to(BigDecimal.valueOf(360000))
            .aliquot(BigDecimal.valueOf(18)).amountDeducted(BigDecimal.valueOf(4500)));
        anexoV.add(new Tax()
            .from(BigDecimal.valueOf(360000.01)).to(BigDecimal.valueOf(720000))
            .aliquot(BigDecimal.valueOf(19.50)).amountDeducted(BigDecimal.valueOf(9900)));
        anexoV.add(new Tax()
            .from(BigDecimal.valueOf(720000.01)).to(BigDecimal.valueOf(1800000))
            .aliquot(BigDecimal.valueOf(20.50)).amountDeducted(BigDecimal.valueOf(17100)));
        anexoV.add(new Tax()
            .from(BigDecimal.valueOf(1800000.01)).to(BigDecimal.valueOf(3600000))
            .aliquot(BigDecimal.valueOf(23)).amountDeducted(BigDecimal.valueOf(62100)));
        anexoV.add(new Tax()
            .from(BigDecimal.valueOf(3600000.01)).to(BigDecimal.valueOf(4800000))
            .aliquot(BigDecimal.valueOf(30.50)).amountDeducted(BigDecimal.valueOf(540000)));
        return anexoV;
    }

}
