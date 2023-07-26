#!/bin/zsh
echo "Installing Ingress on a fresh kubernetes instance, enable tcp-connection to access db"
kubectl -n ingress-nginx delete all --all
kubectl apply -f deploy.yaml
kubectl -n ingress-nginx delete service ingress-nginx-controller
kubectl -n ingress-nginx delete configmap ingress-nginx-controller