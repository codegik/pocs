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

variable "database_user" {
  description = "MySQL Username"
  type        = string
  default     = "app_user"
}

variable "region" {
  description = "Cloud Region"
  type        = string
  default     = "us-central1"
}



