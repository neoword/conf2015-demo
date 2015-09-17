FROM centos:6
# Install confluent schema registry
ADD confluent.repo /etc/yum.repos.d/confluent.repo
RUN rpm --import http://packages.confluent.io/rpm/1.0/archive.key && yum -y install java-1.8.0-openjdk && yum -y install confluent-schema-registry
# configure schema registry
ADD schema-registry.properties /etc/schema-registry/schema-registry.properties
# Declare our static data volume
# VOLUME /usr/local/apps
# Expose our port!
EXPOSE 8081
CMD ["schema-registry-start","/etc/schema-registry/schema-registry.properties"]
