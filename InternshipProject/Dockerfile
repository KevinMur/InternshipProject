FROM java:8
VOLUME /tmp
ADD target/InternshipProject-0.0.1-SNAPSHOT.jar myapp.jar
EXPOSE 8080
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]