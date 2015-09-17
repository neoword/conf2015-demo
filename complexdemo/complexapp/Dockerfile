FROM centos:6
# Add java
RUN yum -y install java-1.8.0-openjdk
# configure schema registry
ADD target/conf2015-complexapp-1.0-SNAPSHOT.jar /root/conf2015-complexapp.jar
ADD config.yaml /root/config.yaml
# Expose our port
EXPOSE 8180
CMD ["java","-jar","/root/conf2015-complexapp.jar","server","/root/config.yaml"]
