FROM maven:3.6.3-jdk-14

ADD . /usr/src/axreng
WORKDIR /usr/src/axreng
ENTRYPOINT ["mvn", "clean", "verify", "exec:java"]
