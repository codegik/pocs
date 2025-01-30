
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
  name                = "app-db-instance"
  database_version    = "MYSQL_8_0"
  region              = var.region
  deletion_protection = false
  project             = var.google_project
  settings {
    tier = "db-f1-micro"
  }
}

resource "google_sql_user" "database_user" {
  instance = google_sql_database_instance.database.name
  name     = var.database_user
  password = google_secret_manager_secret_version.password.secret
}

resource "random_password" "password" {
  length           = 16
  special          = true
  override_special = "_%@"
}

resource "google_secret_manager_secret" "password" {
  project = var.google_project
  secret_id = "DATABASE_PASSWORD"
  replication {
    user_managed {
      replicas {
        location = var.region
      }
    }
  }
}

resource "google_secret_manager_secret_version" "password" {
  secret      = google_secret_manager_secret.password.id
  secret_data = random_password.password.result
}

resource "google_vpc_access_connector" "connector" {
  subnet {
    name = google_compute_subnetwork.subnetwork.name
  }
  name          = "vpc-connector"
  min_instances = 2
  max_instances = 3
}

resource "google_compute_subnetwork" "subnetwork" {
  name          = "vpc-subnetwork"
  ip_cidr_range = "10.2.0.0/28"
  region        = var.region
  network       = "default"
}
