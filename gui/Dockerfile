FROM mhart/alpine-node

WORKDIR /app

ADD package.json ./

RUN apk add --no-cache make gcc g++ python

RUN npm install

ADD . ./

EXPOSE 3000

RUN npm start
