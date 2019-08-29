resource "aws_security_group" "postgresql" {
  vpc_id = "${var.AWS_DEFAULT_VPC}"

  egress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    ipv6_cidr_blocks = ["::/0"]
  }

  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    ipv6_cidr_blocks = ["::/0"]
  }
}

resource "aws_rds_cluster_instance" "cluster_instances" {
  count              = 2
  identifier         = "cluster-instance-${count.index}"
  cluster_identifier = "${aws_rds_cluster.postgresql.cluster_identifier}"
  instance_class     = "${var.AWS_DEFAULT_INSTANCE_TYPE}"
}

resource "aws_rds_cluster" "postgresql" {
  cluster_identifier      = "rds-postgres-cluster-poc"
  availability_zones      = "${var.AVAILABILITY_ZONES}"
  database_name           = "${var.DB_NAME}"
  master_username         = "${var.DB_MASTER_USER}"
  master_password         = "${var.DB_MASTER_PASSWORD}"
#  vpc_security_group_ids  = ["${aws_security_group.postgresql.id}"]
  skip_final_snapshot     = true
}

