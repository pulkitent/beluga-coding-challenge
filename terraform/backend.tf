terraform {
  backend "gcs" {
    bucket = "beluga-terraform-challenge-state"
  }
}
