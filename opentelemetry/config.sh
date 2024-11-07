#!/bin/sh

brew install kind helm kubectl
helm repo add signoz https://charts.signoz.io
kind create cluster --config kind.yml
kubectl create ns platform
helm --namespace platform install my-release signoz/signoz
kubectl -n platform get pods
