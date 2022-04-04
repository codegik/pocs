CREATE SCHEMA misdb AUTHORIZATION sa;

CREATE TABLE misdb.tran_warehouse (
   tw_seq_nbr           VARCHAR(20)     NOT NULL,
   tw_ach_rec_data      VARCHAR(200)    NOT NULL,
   tw_batch_seq         VARCHAR(50)     NOT NULL,
   tw_ach_comp_id       VARCHAR(20)     NOT NULL,
   tw_ach_rec_trace     VARCHAR(50)     NOT NULL,
   tw_rej_reason        VARCHAR(50)     NOT NULL,
   tw_post_dt           DATE,
   tw_proc_dt           DATE
);

CREATE ALIAS IF NOT EXISTS DATE AS $$ java.util.Date to_date(String value) throws java.text.ParseException { return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(value); }$$;