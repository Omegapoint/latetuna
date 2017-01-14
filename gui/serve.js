var proxy = require('express-http-proxy');

function serve(app, port) {
    var express = require("express");
    app.use(express.static('public'));
    app.use('/proposal', proxy('http://localhost:8090'));
    app.use('/conference', proxy('http://localhost:8091'));
    var p = port || 3000;
    app.listen(p, function () {
      console.log('Express app listening on port ' + p + '!');
    });
}

module.exports = serve;
