# Simple Docker Logging Demo

## Setup docker

* `docker-machine ls`
* `docker-machine create --driver virtualbox --engine-insecure-registry 172.31.2.11:31000 --virtualbox-disk-size "20000" docker-machine`
* `docker-machine start docker-machine`
* `eval "$(docker-machine env docker-machine)"`
* `docker info`

## Setup local docker registry

* `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @registry/deploy.json`

## Export your volume

* (show the program what it does)
* (show the file in Dockerfile)

## Create your docker image

* `docker build -t 172.31.2.11:31000:31000/registry:0.1 simpleapp/`

## SIMPLE-EXAMPLE :: Show this running on marathon

### Build docker (with volumes)

* `curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" "http://172.31.3.11:8080/v2/apps" -d @simpleapp/deploy.json`

### 

