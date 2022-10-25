variable "DB_NAME" {}
variable "DB_MASTER_USER" {}
variable "DB_MASTER_PASSWORD" {}
variable "AWS_ACCESS_KEY" {} 
variable "AWS_SECRET_KEY" {} 

variable "AWS_DEFAULT_VPC" {
  default = "vpc-f8963080"
} 
variable "AWS_DEFAULT_INSTANCE_TYPE" {
  default = "db.t2.medium"
}
variable "AWS_DEFAULT_REGION" {
  default = "us-west-2"
}
variable "AVAILABILITY_ZONES" {
  type = "list"
  default = ["us-west-2a", "us-west-2b", "us-west-2c"]
}
variable "AWS_KEY_PAIR_NAME" {
  default = "inacio-key"
}
variable "AWS_PUBLIC_KEY" {
  default = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDV0xkMz37MVRsaF4x4fzaIiIzYlWhGpiQorVJfsXiV9reauqof1I4ZLch7+V66l+89Wdu38aBBldEpJvBk76kk/ZiRoMxirRGBHt/cfTnYIdNmV2it2XOH4dyz2yybVkd7/VRw9CDORxSl/Yd5m8L0n1q9yyaIyhNchj2jrCZ05Tb2JkiRRaL/Nbo28nKSVEJ9oghDDkr0/dyctR326LuXXCXwZUA9QEJDXQ9YaRm4koSempdZNao+SpOUR4Wqt9FPfJBeoH1QD/L+J5QF5hyUO7Evo7pLDQv4VJ/OwtxLqfRe9swOI1aWZdrOeCYC0eZxTY9E02kKEw9H86y1fcPYvQj3Akml9me7WEaSJugPLxGul2jf2iK9w/n1ppEaLsDMrhan5OpscPcW+BLzxVcmdihKnTQQCdbS5xl+w4qxY044S7F9zmV8sbUwJV5TJAXAbf4QZs0Z4Cta/G7RDOSeucmS7bqKrYYZwlO52bd601c5VexbRiE3rJbsNbbqoJFx3bzMLgtcO5DhsL+0EG2/UQbZ2k+zT18mwS7j74y/XYgbGUZVwtK5/j1wyDdO2vyNeewknfaaDfu+ILuJEJY/7knmsnEta4xIZMp53oeWPn4st6nmoya7m0gs/UdL5X2Y2JQTRNnt70GPd8g5hSPFeDSxHBi5A12wr7LXbFgrOw== inacioklassmann@gmail.com"
}



provider "aws" {
  region = "${var.AWS_DEFAULT_REGION}"
  access_key = "${var.AWS_ACCESS_KEY}"
  secret_key = "${var.AWS_SECRET_KEY}"
}

resource "aws_key_pair" "key-pair" {
  key_name = "${var.AWS_KEY_PAIR_NAME}"
  public_key = "${var.AWS_PUBLIC_KEY}"
}
