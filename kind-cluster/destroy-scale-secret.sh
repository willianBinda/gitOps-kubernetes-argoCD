#!/bin/sh

echo "\n-----------------------------------------------------\n"

echo "destroy Sealed Secrets Controller"

kubectl delete -f https://github.com/bitnami-labs/sealed-secrets/releases/download/v0.22.0/controller.yaml