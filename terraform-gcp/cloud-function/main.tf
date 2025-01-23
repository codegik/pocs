#resource "google_compute_network" "vpc_network" {
#  name                    = "my-custom-mode-network"
#  auto_create_subnetworks = false
#  mtu                     = 1460
#}
#
#resource "google_compute_subnetwork" "default" {
#  name          = "my-custom-subnet"
#  ip_cidr_range = "10.0.1.0/24"
#  region        = "us-west1"
#  network       = google_compute_network.vpc_network.id
#}
#


resource "google_storage_bucket" "bucket" {
  name     = "test-bucket"
  location = "US"
}

resource "google_storage_bucket_object" "archive" {
  name   = "index.zip"
  bucket = google_storage_bucket.bucket.name
  source = "./path/to/zip/file/which/contains/code"
}

resource "google_cloudfunctions_function" "function" {
  name        = "function-test"
  description = "My function"
  runtime     = "nodejs16"

  available_memory_mb   = 128
  source_archive_bucket = google_storage_bucket.bucket.name
  source_archive_object = google_storage_bucket_object.archive.name
  trigger_http          = true
  entry_point           = "helloGET"
}

# IAM entry for all users to invoke the function
resource "google_cloudfunctions_function_iam_member" "invoker" {
  project        = google_cloudfunctions_function.function.project
  region         = google_cloudfunctions_function.function.region
  cloud_function = google_cloudfunctions_function.function.name

  role   = "roles/cloudfunctions.invoker"
  member = "allUsers"
}

