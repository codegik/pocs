#/bin/zsh

docker rm -f prometheus
docker run -d --name prometheus -p 9090:9090 -v ./env/prometheus.yml:/etc/prometheus/prometheus.yml -v ./env/prometheus_rules.yml:/etc/prometheus/prometheus_rules.yml prom/prometheus

./gradlew clean build
./app-start.sh
