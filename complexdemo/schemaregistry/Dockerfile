FROM centos:6
# Install confluent schema registry
ADD confluent.repo /etc/yum.repos.d/confluent.repo
RUN rpm --import http://packages.confluent.io/rpm/1.0/archive.key && yum -y install java-1.8.0-openjdk && yum -y install confluent-schema-registry
# configure schema registry
ADD schema-registry.properties /etc/schema-registry/schema-registry.properties
COPY run-registry.sh /root/run-registry.sh
# Expose our port!
EXPOSE 8081
CMD ["/root/run-registry.sh"]
