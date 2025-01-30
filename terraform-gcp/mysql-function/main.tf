
resource "google_storage_bucket" "bucket" {
  name                        = "codegik-bucket"
  location                    = "US"
  uniform_bucket_level_access = true
}

data "archive_file" "app" {
  type        = "zip"
  output_path = "/tmp/app.zip"
  source_dir  = "./app"
  excludes = ["node_modules", ".gcloudignore"]
}
resource "google_storage_bucket_object" "object" {
  name   = "app.zip"
  bucket = google_storage_bucket.bucket.name
  source = data.archive_file.app.output_path
}

resource "google_cloudfunctions2_function" "app" {
  name        = "app-first-function"
  location    = var.region
  description = "a new function"

  build_config {
    runtime     = "nodejs16"
    entry_point = "hello"
    source {
      storage_source {
        bucket = google_storage_bucket.bucket.name
        object = google_storage_bucket_object.object.name
      }
    }
  }

  service_config {
    max_instance_count = 1
    available_memory   = "256M"
    timeout_seconds    = 60
  }
}

resource "google_cloud_run_service_iam_member" "member" {
  location = google_cloudfunctions2_function.app.location
  service  = google_cloudfunctions2_function.app.name
  role     = "roles/run.invoker"
  member   = "allUsers"
}

resource "google_sql_database_instance" "database" {
  name             = "my-db-instance"
  database_version = "MYSQL_8_0"
  region           = var.region

  settings {
    tier = "db-f1-micro"
  }
}

resource "google_sql_user" "database_user" {
  instance = google_sql_database_instance.database.name
  name     = "app_user"
  password = var.database_password
}

resource "google_vpc_access_connector" "connector" {
  name    = "serverless-vpc-connector"
  region  = var.region
  network = "default"
}

resource "google_secret_manager_secret" "ap_secret" {
  secret_id = "app-secret"
  replication {
    auto {
      customer_managed_encryption {
        kms_key_name = "app-secret"
      }
    }
  }
}

resource "google_secret_manager_secret_version" "app_secret_version" {
  secret = google_secret_manager_secret.ap_secret.id
  secret_data = "super-secret-value"
}