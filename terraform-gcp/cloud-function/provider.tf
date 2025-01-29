terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = ">= 4.34.0"
    }
  }
}

provider "google" {
  project     = "pristine-bay-448712-v3"
  region      = "us-central1"
}
