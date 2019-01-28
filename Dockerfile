FROM openjdk:11
ADD ./target/MuzixApplication-0.0.1-SNAPSHOT.jar /home/user/src/MuzixApplication-0.0.1-SNAPSHOT.jar
EXPOSE 8084
WORKDIR /home/user/src
ENTRYPOINT ["java","-jar","MuzixApplication-0.0.1-SNAPSHOT.jar"]
