FROM centos:6
# setup our container disk image
ADD shakespeare.txt shakespeare.txt
ADD requirements.txt requirements.txt
# setup our environment
RUN yum -y install python-setuptools && easy_install virtualenv && virtualenv /tmp/simpleapp && source /tmp/simpleapp/bin/activate && pip install -r requirements.txt
# Finish copying our files
ADD simpleapp.py simpleapp.py
ADD runapp.sh runapp.sh
# Declare our apps volume
VOLUME /usr/local/apps
# Expose our port!
EXPOSE 5000
CMD ["./runapp.sh"]
