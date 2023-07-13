#!/bin/zsh
kubectl -n ingress-nginx delete all --all
kubectl apply -f deploy.yaml
kubectl -n ingress-nginx delete service ingress-nginx-controller
kubectl -n ingress-nginx delete configmap ingress-nginx-controller