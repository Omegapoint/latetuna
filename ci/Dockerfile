FROM jenkins:2.0-beta-1

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
USER root
RUN "groupadd --gid 999 docker"
RUN "gpasswd -a jenkins docker"
USER jenkins
