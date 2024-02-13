#!/bin/bash
mvn clean install -DskipTests \
  && docker buildx build --platform linux/amd64 -t jpcairesf/rinha-2024-q1-java:latest . \
  && docker push jpcairesf/rinha-2024-q1-java:latest \
  && docker-compose down --volumes \
  && docker-compose up