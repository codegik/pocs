package com.codegik.h2.h2hive.model;

import java.util.Date;

public class Transaction {
    private String tw_seq_nbr;
    private String tw_ach_rec_data;
    private String acct_name;
    private String tw_batch_seq;
    private String tw_ach_comp_id;
    private String tw_ach_rec_trace;
    private String tw_rej_reason;
    private Date tw_post_dt;
    private Date tw_proc_dt;
    private String ach_amt;

    public String getAch_amt() {
        return ach_amt;
    }

    public void setAch_amt(String ach_amt) {
        this.ach_amt = ach_amt;
    }

    public String getAcct_name() {
        return acct_name;
    }

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    public String getTw_seq_nbr() {
        return tw_seq_nbr;
    }

    public void setTw_seq_nbr(String tw_seq_nbr) {
        this.tw_seq_nbr = tw_seq_nbr;
    }

    public String getTw_ach_rec_data() {
        return tw_ach_rec_data;
    }

    public void setTw_ach_rec_data(String tw_ach_rec_data) {
        this.tw_ach_rec_data = tw_ach_rec_data;
    }

    public String getTw_batch_seq() {
        return tw_batch_seq;
    }

    public void setTw_batch_seq(String tw_batch_seq) {
        this.tw_batch_seq = tw_batch_seq;
    }

    public String getTw_ach_comp_id() {
        return tw_ach_comp_id;
    }

    public void setTw_ach_comp_id(String tw_ach_comp_id) {
        this.tw_ach_comp_id = tw_ach_comp_id;
    }

    public String getTw_ach_rec_trace() {
        return tw_ach_rec_trace;
    }

    public void setTw_ach_rec_trace(String tw_ach_rec_trace) {
        this.tw_ach_rec_trace = tw_ach_rec_trace;
    }

    public String getTw_rej_reason() {
        return tw_rej_reason;
    }

    public void setTw_rej_reason(String tw_rej_reason) {
        this.tw_rej_reason = tw_rej_reason;
    }

    public Date getTw_post_dt() {
        return tw_post_dt;
    }

    public void setTw_post_dt(Date tw_post_dt) {
        this.tw_post_dt = tw_post_dt;
    }

    public Date getTw_proc_dt() {
        return tw_proc_dt;
    }

    public void setTw_proc_dt(Date tw_proc_dt) {
        this.tw_proc_dt = tw_proc_dt;
    }
}
