FROM jenkins:2.0-beta-1

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
USER root
RUN groupadd --gid 999 docker
RUN gpasswd -a jenkins docker
RUN apt-get update
RUN apt-get -y install apt-transport-https ca-certificates
RUN apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
RUN echo "deb https://apt.dockerproject.org/repo debian-jessie main" > /etc/apt/sources.list.d/docker.list
RUN apt-get update
RUN apt-get -y install docker-engine
USER jenkins
