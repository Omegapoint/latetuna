FROM java:openjdk-8-jdk

WORKDIR /app

COPY gradle gradle
COPY build.gradle ./
COPY gradlew ./

RUN ["./gradlew"]

ADD . ./

ENTRYPOINT ["./gradlew", "bootRun"]
