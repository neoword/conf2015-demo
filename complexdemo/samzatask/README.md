# samzatask

This is a basic task that listens to a kafka stream and looks for
specific messages to log to a log file that is monitored by splunk.

```
build:
mvn3 clean install

deploy: (from project dir)
ansible-playbook -u samza -i src/deploy/ansible/env/dev-inventory.ini src/deploy/ansible/submit-samza-job.yml --extra-vars '{ "artifactId":"conf2015-samzatask","env":"dev","artifactVersion":"0.1-SNAPSHOT" }' -v
```

#### Prerequisities: 
* Ansible must be installed on your machine - (easiest way is `$ easy_install ansble`)

## What does this samza task do?
This samza task parses the incoming kafka stream and looks for INT=17
or INT=18 and logs them appropriately to a logfile that is monitored
by splunk
