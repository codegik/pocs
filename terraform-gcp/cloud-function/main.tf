
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
  location    = "us-central1"
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

output "function_uri" {
  value = google_cloudfunctions2_function.app.service_config[0].uri
}
