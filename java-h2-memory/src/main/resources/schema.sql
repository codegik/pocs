CREATE SCHEMA IF NOT EXISTS misdb AUTHORIZATION sa;
CREATE SCHEMA IF NOT EXISTS udf AUTHORIZATION sa;

DROP TABLE IF EXISTS misdb.tran_warehouse;
DROP TABLE IF EXISTS misdb.fed_returns;
DROP TABLE IF EXISTS misdb.third_party_mast;
DROP TABLE IF EXISTS misdb.nda;
DROP TABLE IF EXISTS misdb.savings;
DROP TABLE IF EXISTS misdb.loan;
DROP TABLE IF EXISTS misdb.nd_history;
DROP TABLE IF EXISTS misdb.sv_history;

CREATE TABLE misdb.tran_warehouse (
   tw_seq_nbr           VARCHAR(20)     NOT NULL,
   tw_ach_rec_data      VARCHAR(200)    NOT NULL,
   tw_batch_seq         VARCHAR(50)     NOT NULL,
   tw_ach_comp_id       VARCHAR(20)     NOT NULL,
   tw_ach_rec_trace     VARCHAR(50)     NOT NULL,
   tw_rej_reason        VARCHAR(50)     NOT NULL,
   tw_tpr_last_trace    BIGINT          NOT NULL,
   tw_ach_rec_type      VARCHAR(20)     NOT NULL,
   tw_origin            INT(10)         NOT NULL,
   acct_nbr             VARCHAR(20)     NOT NULL,
   tw_orig_rej_rsn      INT(10)         NOT NULL,
   tw_tpr_last_date     DATE,
   tw_post_dt           DATE,
   tw_proc_dt           DATE
);

CREATE TABLE misdb.fed_returns (
   tw_seq_nbr        VARCHAR(20)     NOT NULL,
   acct_name         VARCHAR(20)     NOT NULL,
   ach_amt           VARCHAR(20)     NOT NULL,
   return_code       VARCHAR(20)     NOT NULL,
   last_trace_nbr    VARCHAR(20)     NOT NULL,
   tw_ach_comp_id    VARCHAR(20)     NOT NULL,
   tw_batch_seq      VARCHAR(50)     NOT NULL
);

CREATE TABLE misdb.third_party_mast (
   tpm_adj_acct_nbr        VARCHAR(20)     NOT NULL,
   tpm_co_id               VARCHAR(20)     NOT NULL
);

CREATE TABLE misdb.nda (
   nd_acct_nbr        VARCHAR(20)     NOT NULL,
   nd_appl_code       VARCHAR(20)     NOT NULL,
   nd_opening_dt      DATE,
   nd_close_date      DATE
);

CREATE TABLE misdb.savings (
   s_acct_nbr        VARCHAR(20)     NOT NULL,
   s_appl_code       VARCHAR(20)     NOT NULL,
   s_opening_dt      DATE,
   s_close_date      DATE
);

CREATE TABLE misdb.loan (
   l_acct_nbr        VARCHAR(20)     NOT NULL,
   l_appl_code       VARCHAR(20)     NOT NULL,
   l_dt_first_occur  DATE
);

CREATE TABLE misdb.nd_history (
   ndhist_ach_seq_nbr        VARCHAR(20)     NOT NULL,
   ndhist_trcd               VARCHAR(5)      NOT NULL
);

CREATE TABLE misdb.sv_history (
   svhist_ach_seq_nbr        VARCHAR(20)     NOT NULL,
   svhist_trcd               VARCHAR(5)      NOT NULL
);

CREATE ALIAS IF NOT EXISTS DATE AS $$ java.util.Date toDate(String value) throws java.text.ParseException { return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(value); } $$;

CREATE ALIAS IF NOT EXISTS udf.LCDECRYPT AS $$ java.lang.String lcDecrypt(String field, String key) { return field; } $$;