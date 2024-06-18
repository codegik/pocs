provider "aws" {
  region  = "us-east-1"
  profile = "personal-lab"
}


resource "aws_s3_bucket" "test-s3-bucket" {
  bucket        = "codegik-s3-test"
  force_destroy = true

  tags = {
    Name        = "codegik-s3"
    Environment = "test"
  }
}


output "bucket-name" {
  value = aws_s3_bucket.test-s3-bucket.bucket
}