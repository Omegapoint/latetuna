var express = require('express');
var app = express();

app.use(express.static('public'));

app.listen(9000, function () {
  console.log('Express app listening on port 9000!');
});

var http = require('http'),
    httpProxy = require('http-proxy'),
    HttpProxyRules = require('http-proxy-rules');

// Set up proxy rules instance
var proxyRules = new HttpProxyRules({
    rules: {
        '.*/proposal': 'http://proposal:8080',
        '.*/conference/': 'http://conference:8080'
    },
    default: 'http://localhost:9000'
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
}).listen(8080);