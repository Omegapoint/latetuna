var express = require("express");
var morgan = require('morgan')
var fs = require('fs')
var accessLogStream = fs.createWriteStream('/app/access.log', {flags: 'a'})

app=express()
app.use(morgan('combined', {stream: accessLogStream}))
require("./serve.js")(app);
