FROM gradle:6.6.1-jdk14 as builder

RUN mkdir /app
WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY dependencies.gradle .
COPY src/ ./src

RUN gradle clean build

##################################################################
FROM openjdk:jdk

COPY --from=builder /app /app
WORKDIR /app

EXPOSE 8283

CMD /app/build/install/temperature-service/bin/temperature-service