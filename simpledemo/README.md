# Simple Docker Logging Demo

## Setup docker

* `docker-machine ls`
* `docker-machine create --driver virtualbox --engine-insecure-registry 172.31.2.11:31000 --virtualbox-disk-size "20000" docker-machine`
* `docker-machine start docker-machine`
* `eval "$(docker-machine env docker-machine)"`
* `docker info`

## Setup local docker registry

* `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @registry/deploy.json`
* (show it is working) - `http://172.31.2.11:31000/v2/_catalog`

NOTE: Need to setup marathon/mesos/docker slaves with insecure registry
E.G.: On each Slave,
* Edit `/etc/default/docker`
* Add `--insecure-registry 172.31.2.11:31000` to the options
* `service docker restart`
* ALSO -- VERY IMPORTANT!! -- make sure that /etc/hosts has slave1 and slave2 only ONCE and is bound to 172.31.2.11 and 172.31.2.12 respectively.
* vagrant halt your machine and vagrant it up
* make sure marathon is up by doing `vagrant provision marathon`

## Now Deploy Splunk Search Head (in a container!!)
* (show the dockerfile)
* (show how it exports the "static portion")
* (show how it looks for a place that is static)
* Build splunk container - `docker build -t 172.31.2.11:31000/splunk:6.2.3 splunk/`
* Push it to local registry - `docker push 172.31.2.11:31000/splunk:6.2.3`
* (show it is working) - `http://172.31.2.11:31000/v2/_catalog`
* (show it is working) - `http://172.31.2.11:31000/v2/splunk/tags/list`
* (show deploy.json)
* Deploy it to Marathon - `curl -X POST -H "Content-Type: application/json" "http://172.31.3.11:8080/v2/apps" -d @splunk/deploy.json`
* (show it is working) - `http://172.31.2.11:31001`

## SIMPLE-EXAMPLE :: Show this running on marathon

* (show the program - what it does)
* (show the dockerfile - show how it uses volumes)
* Build splunk container - `docker build -t 172.31.2.11:31000/conf2015-demo/simpleapp:0.1 simpleapp/`
* Push it to local registry - `docker push 172.31.2.11:31000/conf2015-demo/simpleapp:0.1`
* (show it is working) - `http://172.31.2.11:31000/v2/_catalog`
* (show it is working) - `http://172.31.2.11:31000/v2/conf2015-demo/simpleapp/tags/list`
* (show deploy.json)
* `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @simpleapp/deploy.json`
* (verify its up) - `http://172.31.2.11:31003/health`
* Run some logs `http://172.31.2.11:31003/logShakespeare`

