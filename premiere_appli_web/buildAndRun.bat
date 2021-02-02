@echo off
call mvn clean package
call docker build -t .fr.insset.paulgilliard/premiere_appli_web .
call docker rm -f premiere_appli_web
call docker run -d -p 9080:9080 -p 9443:9443 --name premiere_appli_web .fr.insset.paulgilliard/premiere_appli_web