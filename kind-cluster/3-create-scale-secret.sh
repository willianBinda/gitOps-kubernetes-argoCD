#!/bin/sh

echo "\n-----------------------------------------------------\n"

echo "Create Sealed Secrets Controller"

kubectl apply -f https://github.com/bitnami-labs/sealed-secrets/releases/download/v0.22.0/controller.yaml