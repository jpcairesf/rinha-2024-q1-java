#!/bin/bash
mvn clean install -DskipTests \
  && docker tag pixvulture:0.0.1-SNAPSHOT jpcairesf/pixvulture:latest \
  && docker push jpcairesf/pixvulture:latest