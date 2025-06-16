
resource "kubernetes_namespace" "iac" {
  metadata {
    name = "iac"
  }
}

resource "kubernetes_namespace" "app" {
  metadata {
    name = "app"
  }
}


# Deploy Prometheus
resource "helm_release" "prometheus" {
  name       = "prometheus"
  repository = "https://prometheus-community.github.io/helm-charts"
  chart      = "prometheus"
  namespace  = kubernetes_namespace.iac.metadata.name

  set {
    name  = "server.persistentVolume.enabled"
    value = "true"
  }

  set {
    name  = "server.persistentVolume.size"
    value = "10Gi"
  }
}

# Deploy Grafana
resource "helm_release" "grafana" {
  name       = "grafana"
  repository = "https://grafana.github.io/helm-charts"
  chart      = "grafana"
  namespace  = kubernetes_namespace.iac.metadata.name

  set {
    name  = "persistence.enabled"
    value = "true"
  }

  set {
    name  = "persistence.size"
    value = "5Gi"
  }

  # Configure Grafana with Prometheus datasource
  values = [file("../resources/grafana.yml")]

  depends_on = [helm_release.prometheus]
}
