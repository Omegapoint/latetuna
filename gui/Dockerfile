FROM mhart/alpine-node

WORKDIR /app

ADD package.json ./

RUN apk add --no-cache make gcc g++ python

RUN npm install

ADD . ./

CMD ["npm", "start"]
