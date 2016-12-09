var morgan=require('morgan');
var fs = require('fs')
var accessLogStream = fs.createWriteStream(__dirname + '/access.log', {flags: 'a'})

function setUpProxy(port, proxyPort) {
  var http = require('http'),
      httpProxy = require('http-proxy'),
      HttpProxyRules = require('http-proxy-rules');

  // Set up proxy rules instance
  var proxyRules = new HttpProxyRules({
      rules: {
          '.*/proposal': 'http://proposal:8080',
          '.*/conference': 'http://conference:8080'
      },
      default: 'http://localhost:' + port
  });

  var proxy = httpProxy.createProxy();

  http.createServer(function(req, res) {
      var target = proxyRules.match(req);
      if (target) {
          return proxy.web(req, res, {
              target: target
          });
      }
      res.writeHead(500, { 'Content-Type': 'text/plain' });
      res.end('The request url and path did not match any of the listed rules!');
  }).listen(proxyPort);
}

function serve(app, port, proxyPort) {
    var express = require("express")
    app.use(express.static('public'));
    app.use(morgan('combined', {stream: accessLogStream}))
    var p = port || 3000;
    app.listen(p, function () {
      console.log('Express app listening on port ' + p + '!');
    });

    setUpProxy(p, proxyPort || 8088);
}

module.exports = serve;
