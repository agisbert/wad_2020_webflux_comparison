#!/bin/bash
set -e

./mvnw clean package
docker build -t wad-2020/mvc .