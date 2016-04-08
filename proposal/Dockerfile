FROM java:openjdk-8-jdk

WORKDIR /app

COPY gradle gradle
COPY build.gradle ./
COPY gradlew ./
RUN ["chmod", "a+x", "gradlew"]

RUN ["./gradlew"]

ADD . ./
RUN ["chmod", "a+x", "gradlew"]

ENTRYPOINT ["./gradlew", "bootRun"]
