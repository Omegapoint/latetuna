FROM mhart/alpine-node

WORKDIR /app

ADD package.json ./

RUN npm install

ADD . ./

CMD node .
