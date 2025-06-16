
output "grafana_admin_password" {
  value = "kubectl get secret --namespace monitoring grafana -o jsonpath='{.data.admin-password}' | base64 --decode"
}

output "access_prometheus" {
  value = "kubectl port-forward -n monitoring svc/prometheus-server 9090:80"
}

output "access_grafana" {
  value = "kubectl port-forward -n monitoring svc/grafana 3000:80"
}