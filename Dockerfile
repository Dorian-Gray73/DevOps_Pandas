FROM ubuntu
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN apt-get install -y maven
COPY ./pandas/ ./pandas/
WORKDIR pandas
RUN mvn clean package
CMD ["java", "-cp", "/pandas/target/pandas-0.1-SNAPSHOT.jar", "com.devops.App"]