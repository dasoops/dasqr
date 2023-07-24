FROM openjdk:17
WORKDIR /dasqr
COPY ./ /dasqr

ENTRYPOINT ["java","-jar","dasqr.jar"]
