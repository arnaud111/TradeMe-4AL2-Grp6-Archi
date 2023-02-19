FROM openjdk:19-jdk-alpine
COPY target/TradeMe-4AL2-Grp6-Archi-1.0-SNAPSHOT.jar TradeMe-4AL2-Grp6-Archi-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TradeMe-4AL2-Grp6-Archi-1.0-SNAPSHOT.jar"]
