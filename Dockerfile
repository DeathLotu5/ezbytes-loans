#Cài đặt phiên bản java mà mình muốn chạy cho application của mình
FROM openjdk:11-slim as build

#Tên của cái wrapper chứa Image
MAINTAINER eazybytes.com

#Add file application jar vào container
COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

#Thực hiện chạy application
ENTRYPOINT ["java", "-jar", "/loans-0.0.1-SNAPSHOT.jar"]