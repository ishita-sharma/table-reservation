#!/usr/bin/zsh
helm uninstall table-reservation --wait
./gradlew bJ
docker build -t table-reservation:LOCAL-SNAPSHOT .
helm install --set service.boot=true table-reservation ./src/test/resources/helm/table-reservation --wait