FROM  openjdk:8-jdk-slim
COPY "./target/interestMicroService-0.0.1-SNAPSHOT.jar" "appCreditList.jar"
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "appCreditList.jar"]