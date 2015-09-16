# use base-centos
FROM centos:7
RUN umask 002
ADD splunk-6.2.3-264376-Linux-x86_64.tgz /opt
# Use -l for BIG UIDs, see: https://github.com/docker/docker/issues/5419
#RUN groupadd -g 1239304281 splunk
#RUN useradd -l -u 1239304281 -g 1239304281 splunk
VOLUME /opt/splunk/var
RUN /opt/splunk/bin/splunk enable boot-start --accept-license && /opt/splunk/bin/splunk start --accept-license
RUN chmod -R 755 /etc/init.d/splunk
#RUN chown -R splunk:splunk /opt/hunk
EXPOSE 8000
EXPOSE 8089
#EXPOSE 9997
#USER splunk
CMD /opt/splunk/bin/splunk start --accept-license && tail -f /opt/splunk/var/log/splunk/splunkd.log
