package com.codegik.h2.h2hive.model;

import java.util.Date;

public class Transaction {
    private String acct_nbr;
    private String fed_return_ach_amt;
    private String return_code;
    private String last_trace_nbr;
    private String ach_seq_id;
    private String acct_name;
    private Date tw_post_dt;
    private String acct_transaction_code;
    private String tw_ach_comp_id;
    private String tpm_adj_acct_nbr;
    private String application_code;
    private Date account_opening_date;
    private Date account_close_date;
    private String acct_posted_trcd_code;
    private String tx_type;
    private String source_of_return;


    public String getAcct_nbr() {
        return acct_nbr;
    }

    public void setAcct_nbr(String acct_nbr) {
        this.acct_nbr = acct_nbr;
    }

    public String getFed_return_ach_amt() {
        return fed_return_ach_amt;
    }

    public void setFed_return_ach_amt(String fed_return_ach_amt) {
        this.fed_return_ach_amt = fed_return_ach_amt;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getLast_trace_nbr() {
        return last_trace_nbr;
    }

    public void setLast_trace_nbr(String last_trace_nbr) {
        this.last_trace_nbr = last_trace_nbr;
    }

    public String getAch_seq_id() {
        return ach_seq_id;
    }

    public void setAch_seq_id(String ach_seq_id) {
        this.ach_seq_id = ach_seq_id;
    }

    public String getAcct_name() {
        return acct_name;
    }

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    public Date getTw_post_dt() {
        return tw_post_dt;
    }

    public void setTw_post_dt(Date tw_post_dt) {
        this.tw_post_dt = tw_post_dt;
    }

    public String getAcct_transaction_code() {
        return acct_transaction_code;
    }

    public void setAcct_transaction_code(String acct_transaction_code) {
        this.acct_transaction_code = acct_transaction_code;
    }

    public String getTw_ach_comp_id() {
        return tw_ach_comp_id;
    }

    public void setTw_ach_comp_id(String tw_ach_comp_id) {
        this.tw_ach_comp_id = tw_ach_comp_id;
    }

    public String getTpm_adj_acct_nbr() {
        return tpm_adj_acct_nbr;
    }

    public void setTpm_adj_acct_nbr(String tpm_adj_acct_nbr) {
        this.tpm_adj_acct_nbr = tpm_adj_acct_nbr;
    }

    public String getApplication_code() {
        return application_code;
    }

    public void setApplication_code(String application_code) {
        this.application_code = application_code;
    }

    public Date getAccount_opening_date() {
        return account_opening_date;
    }

    public void setAccount_opening_date(Date account_opening_date) {
        this.account_opening_date = account_opening_date;
    }

    public Date getAccount_close_date() {
        return account_close_date;
    }

    public void setAccount_close_date(Date account_close_date) {
        this.account_close_date = account_close_date;
    }

    public String getAcct_posted_trcd_code() {
        return acct_posted_trcd_code;
    }

    public void setAcct_posted_trcd_code(String acct_posted_trcd_code) {
        this.acct_posted_trcd_code = acct_posted_trcd_code;
    }

    public String getTx_type() {
        return tx_type;
    }

    public void setTx_type(String tx_type) {
        this.tx_type = tx_type;
    }

    public String getSource_of_return() {
        return source_of_return;
    }

    public void setSource_of_return(String source_of_return) {
        this.source_of_return = source_of_return;
    }
}
