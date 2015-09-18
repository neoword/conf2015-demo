# use base-centos
FROM centos:7
RUN umask 002
ADD splunk-6.2.3-264376-Linux-x86_64.tgz /opt
VOLUME /opt/splunk/var
VOLUME /usr/local/apps
RUN /opt/splunk/bin/splunk enable boot-start --accept-license && /opt/splunk/bin/splunk start --accept-license
RUN chmod -R 755 /etc/init.d/splunk
# Monitor simpledemo (locally)
COPY search-inputs.conf /opt/splunk/etc/apps/search/local/inputs.conf
COPY search-props.conf /opt/splunk/etc/apps/search/local/props.conf
# Receive on 9997, rename host to search-head
COPY system-inputs.conf /opt/splunk/etc/system/local/inputs.conf
# Add forwarder server class
COPY serverclass.conf /opt/splunk/etc/system/local/serverclass.conf
# Add samza-forwarder app for input monitor (forwarder already has sourcetype)
ADD samza-forwarder.tgz /opt/splunk/etc/deployment-apps
EXPOSE 8000
EXPOSE 8089
EXPOSE 9997
#USER splunk
CMD /opt/splunk/bin/splunk start --accept-license && tail -f /opt/splunk/var/log/splunk/splunkd.log
