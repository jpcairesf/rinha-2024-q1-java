FROM openjdk:17.0.2 AS JAR_EXTRACT
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17.0.2
COPY --from=JAR_EXTRACT dependencies ./
COPY --from=JAR_EXTRACT spring-boot-loader ./
COPY --from=JAR_EXTRACT snapshot-dependencies ./
COPY --from=JAR_EXTRACT application ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]