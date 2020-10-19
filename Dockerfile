FROM openjdk:8
EXPOSE 5000
ADD  target/pharmacy-application-springs.jar pharmacy-application-springs.jar
ENTRYPOINT ["java","-jar","/pharmacy-application-springs.jar"]


