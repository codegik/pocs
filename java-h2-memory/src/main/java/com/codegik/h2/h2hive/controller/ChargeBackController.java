package com.codegik.h2.h2hive.controller;

import com.codegik.h2.h2hive.dao.AccountsWithFedReturnsDao;
import com.codegik.h2.h2hive.dao.ChargeBackDao;
import com.codegik.h2.h2hive.dao.FedReturnsDao;
import com.codegik.h2.h2hive.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChargeBackController {

    @Autowired
    private ChargeBackDao chargeBackDao;

    @Autowired
    private FedReturnsDao fedReturnsDao;

    @Autowired
    private AccountsWithFedReturnsDao accountsWithFedReturnsDao;



    @GetMapping("/chargeback/{date}")
    public ResponseEntity<List<Transaction>> chargeBack(@PathVariable String date) {
        return ResponseEntity.ok(chargeBackDao.findByDate(date));
    }

    @GetMapping("/fedreturns/{date}")
    public ResponseEntity<List<Transaction>> fedReturns(@PathVariable String date) {
        return ResponseEntity.ok(fedReturnsDao.findByDate(date));
    }

    @GetMapping("/accountswithfedreturns/{date}")
    public ResponseEntity<List<Transaction>> accountsWithFedReturns(@PathVariable String date) {
        return ResponseEntity.ok(accountsWithFedReturnsDao.findByDate(date));
    }
}
