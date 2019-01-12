FROM mysql:5.7

MAINTAINER Kumar Rohit

EXPOSE 3306

COPY ./script.sql /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD=passwd



