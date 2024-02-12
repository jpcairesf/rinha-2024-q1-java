#!/bin/bash
mvn clean install -DskipTests \
  && docker buildx build --platform linux/amd64 -t jpcairesf/pixvulture:latest . \
  && docker push jpcairesf/pixvulture:latest