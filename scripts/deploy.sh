#!/usr/bin/env bash
set -euo pipefail

# Run the calculator container
docker rm -f calculator || true
docker run -d --name calculator -p 8080:8080 calculator:latest

echo "Deployed calculator container on port 8080"
