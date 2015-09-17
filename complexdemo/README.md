# Complex Docker Logging Demo

## Install kafka-mesos on master1
* https://github.com/mesos/kafka
* `kafka-mesos.properties`:

```
# Scheduler options defaults. See `./kafka-mesos.sh help scheduler` for more details
debug=true

user=vagrant

storage=file:kafka-mesos.json

master=zk://172.31.0.11:2181/mesos

zk=172.31.0.11:2181

api=http://172.31.1.11:7000
```

## Show kafka-mesos running
* (show kafka running as mesos module) `http://172.31.1.11:5050/#/frameworks`
* (show brokers running) `http://172.31.1.11:5050/#/frameworks/20150916-171306-184623020-5050-2379-0001`

## Deploy Confluent Schema Registry

* Build confluent schema registry container - `docker build -t 172.31.2.11:31000/confluent/schema-registry:1.0.1 schemaregistry/`
* Push it to local registry - `docker push 172.31.2.11:31000/confluent/schema-registry:1.0.1`
* (show it is working) - `http://172.31.2.11:31000/v2/_catalog`
* (show it is working) - `http://172.31.2.11:31000/v2/confluent/schema-registry/tags/list`
* (deploy deploy.json) - `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @schemaregistry/deploy.json`

## Install / Configure Camus
* added camus user
* configure /etc/camus/camus.properties (see file checked in this project)

