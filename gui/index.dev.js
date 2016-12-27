var express = require("express");
var app = express();

var webpack = require("webpack");
var webpackConfig = require("./webpack.dev.config.js");
var compiler = webpack(webpackConfig);

app.use(require("webpack-dev-middleware")(compiler, {
    noInfo: true, publicPath: webpackConfig.output.publicPath
}));

app.use(require("webpack-hot-middleware")(compiler));

require("./serve.js")(app, 3000, 8088);
