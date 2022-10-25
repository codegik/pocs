output "database_name" {
  value       = join("", aws_rds_cluster.postgresql.*.database_name)
  description = "Database name"
}

output "master_username" {
  value       = join("", aws_rds_cluster.postgresql.*.master_username)
  description = "Username for the master DB user"
}

output "cluster_identifier" {
  value       = join("", aws_rds_cluster.postgresql.*.cluster_identifier)
  description = "Cluster Identifier"
}

output "reader_endpoint" {
  value = join("", aws_rds_cluster.postgresql.*.reader_endpoint)
}
