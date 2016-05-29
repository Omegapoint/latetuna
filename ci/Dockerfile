FROM jenkins:2.0-beta-1

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
# install gradle
# http://linuxg.net/how-to-install-gradle-2-1-on-ubuntu-14-10-ubuntu-14-04-ubuntu-12-04-and-derivatives/
RUN add-apt-repository ppa:cwchien/gradle && \
  apt-key update && apt-get update && \
  apt-get install -y gradle && \
  apt-get clean
