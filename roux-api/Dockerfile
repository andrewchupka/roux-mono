# Probably an issue with the gradle image being used here
FROM gradle:jdk17

RUN mkdir -p /roux-api
WORKDIR /roux-api

EXPOSE 8080
CMD gradle bootRun
