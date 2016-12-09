FROM mhart/alpine-node

WORKDIR /app

ENV FILEBEAT_SRC_SHA1=b8139a51834f6c0ff90a7de1159c0b2162b86e7e
ENV FILEBEAT_VERSION=5.0.1
RUN apk --no-cache add --virtual .build-dependencies curl && \
	curl -fsSL https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz -o /tmp/filebeat.tar.gz && \
\
	cd /tmp && \
	echo "${FILEBEAT_SRC_SHA1} *filebeat.tar.gz" | sha1sum -c - && \
	tar -xzf filebeat.tar.gz && \
	\
	cd filebeat-* && \
	cp filebeat /bin && \
	\
	rm -rf /tmp/filebeat* && \
	apk del .build-dependencies

RUN mkdir -p /etc/filebeat
ADD filebeat.yml /etc/filebeat/filebeat.yml
RUN cp /etc/filebeat/filebeat.yml /bin/filebeat.yml
ADD start.sh /app/start.sh
# CA cert
RUN mkdir -p /etc/pki/tls/certs
ADD logstash-beats.crt /etc/pki/tls/certs/logstash-beats.crt

ADD package.json ./

RUN npm install

ADD . ./

RUN npm run build

CMD [ "/app/start.sh" ]
