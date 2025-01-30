variable "google_project" {
  description = "Google Project ID"
  type        = string
  default     = "test-id"
}

variable "database_password" {
  description = "MySQL Password"
  type        = string
  default     = "defaultpasswd"
}

variable "region" {
  description = "Cloud Region"
  type        = string
  default     = "us-central1"
}


