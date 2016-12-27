var webpack = require("webpack");
var path = require("path");
var config = require("./webpack.shared.config.js");

var buildDirectory = path.join(__dirname, "dist");

config.devtool = 'cheap-module-eval-source-map';
config.entry.push("webpack-hot-middleware/client");
config.output.path = buildDirectory;
config.output.publicPath = '/bundles/';
config.plugins = [
  new webpack.optimize.OccurenceOrderPlugin(),
  new webpack.HotModuleReplacementPlugin(),
  new webpack.NoErrorsPlugin()
];

module.exports = config;
