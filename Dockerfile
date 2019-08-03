FROM circleci/openjdk:8-jdk
USER root
RUN apt-get update && apt-get install vim groovy

# RUN curl -s "https://get.sdkman.io" && bash

# RUN sdk install groovy && sdk install groovyserv

USER circleci