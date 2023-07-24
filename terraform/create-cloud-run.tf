resource "google_cloud_run_service" "cloud-run-infra" {
  name     = "beluga-cloud-run"
  location = "europe-west1"

  template {
    spec {
      containers {
        image = "us-docker.pkg.dev/cloudrun/container/hello"
      }
    }
  }

  traffic {
    percent         = 100
    latest_revision = true
  }
}
