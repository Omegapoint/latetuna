import webpack from 'webpack';
import webpackDev from 'webpack-dev-middleware';
import webpackHot from 'webpack-hot-middleware';
import makeWebpackConfig from '../makeConfig';
import express from 'express';

const app = express();

const webpackConfig = makeWebpackConfig({ isDevelopment: true });
const compiler = webpack(webpackConfig);

app.use(webpackDev(compiler, {
  headers: {'Access-Control-Allow-Origin': '*'},
  noInfo: true,
  publicPath: webpackConfig.output.publicPath
}));

app.use(webpackHot(compiler));

const httpProxy = require("http-proxy");
const apiProxy = httpProxy.createProxyServer();

app.all("/api/:service/*", function (req, res) {
  apiProxy.web(req, res, { "target": "http://" + req.param.service + ":8080" });
  console.log(req.path);
});

app.listen(webpackConfig.hotPort);
