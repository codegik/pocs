
output "function_uri" {
  value = google_cloudfunctions2_function.app.service_config[0].uri
}

# output "database_uri" {
#   value = google_sql_database_instance.database.service_config[0].uri
# }