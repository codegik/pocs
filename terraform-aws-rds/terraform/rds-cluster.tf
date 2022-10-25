resource "aws_rds_cluster_instance" "cluster_instances" {
  count              = 2
  identifier         = "cluster-instance-${count.index}"
  cluster_identifier = "${aws_rds_cluster.postgresql.cluster_identifier}"
  instance_class     = "${var.AWS_DEFAULT_INSTANCE_TYPE}"
  publicly_accessible = true
}

resource "aws_rds_cluster" "postgresql" {
  cluster_identifier      = "rds-postgres-cluster-poc"
  availability_zones      = "${var.AVAILABILITY_ZONES}"
  database_name           = "${var.DB_NAME}"
  master_username         = "${var.DB_MASTER_USER}"
  master_password         = "${var.DB_MASTER_PASSWORD}"
  skip_final_snapshot     = true
}

