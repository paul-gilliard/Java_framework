#!/bin/sh
mvn clean package && docker build -t paulgilliardpremiereappliweb .
docker rm -f premiere_appli_web || true && docker run -d -p 9080:9080 -p 9443:9443 --name premiere_appli_web paulgilliardpremiereappliweb