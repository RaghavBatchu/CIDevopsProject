#!/usr/bin/env bash
set -euo pipefail

# Build the project and Docker image
mvn -B clean package
docker build -t calculator:latest -f docker/Dockerfile .

echo "Build complete: calculator:latest"
