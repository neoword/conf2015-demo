#!/bin/bash

echo "172.31.2.11	slave1" >> /etc/hosts
echo "172.31.2.12	slave2" >> /etc/hosts
echo "Dumping /etc/hosts"
cat /etc/hosts
schema-registry-start /etc/schema-registry/schema-registry.properties
