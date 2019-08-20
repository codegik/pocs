package com.codegik.simlesnacional.service;

import com.codegik.simlesnacional.domain.Customer;
import com.codegik.simlesnacional.domain.Tax;
import com.codegik.simlesnacional.repository.Repository;
import io.reactivex.Observable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SimplesNacionalService {
    private Repository customerService = new Repository();


    public void calc() {
        Observable.fromIterable(customerService.getAllCustomers())
            .map(customer -> calculateFatorR(customer))
            .map(customer -> calculateEffectiveAliquot(customer))
            .subscribe(customer -> System.out.println(customer));
    }


    private Customer calculateFatorR(Customer customer) {

        customer.fatorR(customer.getSalary12months().divide(customer.getGrossRevenue(), 2, RoundingMode.HALF_UP));

        return customer;
    }


    private Customer calculateEffectiveAliquot(Customer customer) {
        final List<Tax> anexoTable = customer.getFatorR().compareTo(BigDecimal.valueOf(0.28)) >= 0 ? customerService.getAnexoIII() : customerService.getAnexoV();
        Observable.fromIterable(anexoTable)
            .filter(anexo -> anexo.getFrom().compareTo(customer.getGrossRevenue()) <= 0 && anexo.getTo().compareTo(customer.getGrossRevenue()) >= 0)
            .map(anexo -> {
                final BigDecimal effectiveAliquot =
                    (customer.getGrossRevenue().multiply(anexo.getAliquot()).divide(BigDecimal.valueOf(100))
                        .subtract(anexo.getAmountDeducted())).divide(customer.getGrossRevenue());
                customer.effectiveAliquot(effectiveAliquot.multiply(BigDecimal.valueOf(100)));
                return anexo;
            }).subscribe();

        return customer;
    }

}
