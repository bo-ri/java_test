#!/bin/sh

docker run -it --rm -e CLASSPATH=/home/groovy/java_test/libs:/home/groovy/java_test/src/main/java -v $PWD:/home/groovy/java_test groovy:jdk8 bash