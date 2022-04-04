package com.codegik.h2.h2hive.controller;

import com.codegik.h2.h2hive.dao.TransactionsDao;
import com.codegik.h2.h2hive.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionsDao transactionsDao;

    @GetMapping("/transactions/{date}")
    public ResponseEntity<List<Transaction>> findByDate(@PathVariable String date) {
        return ResponseEntity.ok(transactionsDao.findByDate(date));
    }
}
