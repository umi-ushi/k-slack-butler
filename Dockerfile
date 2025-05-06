FROM amazoncorretto:21 AS build
COPY ./ /home/app
RUN cd /home/app && ./gradlew build

FROM amazoncorretto:21-alpine
COPY --from=build /home/app/build/libs/k-slack-butler-1.0-SNAPSHOT.jar /usr/local/lib/k-slack-butler.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","-Dfile.encoding=UTF-8","/usr/local/lib/k-slack-butler.jar"]