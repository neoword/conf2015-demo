# Complex Docker Logging Demo

## Install kafka-mesos on master1
* https://github.com/mesos/kafka
* See `kafka-mesos.properties`
* Start scheduler (as root) - `/opt/kafka-mesos/kafka-mesos.sh scheduler &> /opt/kafka-mesos/kafka-mesos.log &`  `disown %1`
* Add two brokers - `/opt/kafka-mesos/kafka-mesos.sh broker add 0,1 --heap 256 --mem 512`
* Start them - `/opt/kafka-mesos/kafka-mesos.sh broker start 0,1`
* Show their status - `/opt/kafka-mesos/kafka-mesos.sh broker list`
* Show any topics - `/opt/kafka-mesos/kafka-mesos.sh topic list`

## Show kafka-mesos running
* (show kafka running as mesos module) `http://172.31.1.11:5050/#/frameworks`
* (show brokers running) `http://172.31.1.11:5050/#/frameworks/20150916-171306-184623020-5050-2379-0001`

## Deploy Confluent Schema Registry

* Build confluent schema registry container - `docker build -t 172.31.2.11:31000/confluent/schema-registry:1.0.1 schemaregistry/`
* Push it to local registry - `docker push 172.31.2.11:31000/confluent/schema-registry:1.0.1`
* (show it is working) - `http://172.31.2.11:31000/v2/_catalog`
* (show it is working) - `http://172.31.2.11:31000/v2/confluent/schema-registry/tags/list`
* (deploy deploy.json) - `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @schemaregistry/deploy.json"`
* (show it is running) - `http://172.31.2.12:31002/subjects`

## Deploy ComplexApp demo
* Build complexapp - `(cd complexapp && mvn3 clean install)`
* Build complexapp container - `docker build -t 172.31.2.11:31000/conf2015-demo/complexapp:0.1 complexapp/`
* Push it to local registry - `docker push 172.31.2.11:31000/conf2015-demo/complexapp:0.1`
* (deploy deploy.json) - `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @complexapp/deploy.json`

## Install / Configure Camus
* added camus user
* configure /etc/camus/camus.properties (see file checked in this project)
* as camus user... run it - `camus-run -P /etc/camus/camus.properties -Dlog4j.configuration=/etc/camus/log4j.xml`
* verify it ran - `hdfs dfs -text topics/bigstream/hourly/2015/09/17/03/bigstream.0.0.100.100.1442476800000.avro`

## Install / Configure Hunk
* TBD

## Deploy Samza Task
* Install Task and Deploy to YARN - `(cd samzatask && mvn3 clean install && ansible-playbook -u samza -i src/deploy/ansible/env/dev-inventory.ini src/deploy/ansible/submit-samza-job.yml --extra-vars '{ "artifactId":"conf2015-samzatask","env":"dev","artifactVersion":"0.1-SNAPSHOT" }' -v)`
* show it running - TBD

## Install / Configure SplunkForwarder
* Copy "splunkforwarder/props.conf" to HDP /opt/splunkforwarder/etc/system/local/props.conf

