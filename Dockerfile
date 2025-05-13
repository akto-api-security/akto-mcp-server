FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

COPY target/mcp-1.0.jar app.jar

ENV AKTO_API_KEY=""

ENTRYPOINT ["/bin/sh", "-c", "if [ -z \"$AKTO_API_KEY\" ]; then echo 'AKTO_API_KEY variable is required!'; exit 1; fi && java -jar app.jar"]
