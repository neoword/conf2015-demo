FROM centos:6
# Add java
RUN yum -y install java-1.8.0-openjdk
ADD kafka.tar.gz /opt
COPY config/server-0.properties /opt/kafka/config/server-0.properties
COPY config/server-1.properties /opt/kafka/config/server-1.properties
WORKDIR /opt/kafka
# Expose our port
EXPOSE 9092
# need to specify cmd from marathon!!
# CMD ["java","-jar","/root/conf2015-complexapp.jar","server","/root/config.yaml"]
# CMD ["bin/kafka-server-start.sh","config/server-0.properties"]
