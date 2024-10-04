#!/bin/sh

echo "\n-----------------------------------------------------\n"

echo "destroy namespace argocd"

kubectl delete -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml