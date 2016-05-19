var webpack = require("webpack");
var path = require("path");
var config = require("./webpack.shared.config.js");

var buildDirectory = path.join(__dirname, "public", "bundles");

config.devtool = 'source-map';
config.output.path = buildDirectory;
config.output.publicPath = '/public/bundles/'
config.plugins = [
  new webpack.optimize.OccurrenceOrderPlugin(),
  new webpack.DefinePlugin({
    'process.env': {
      'NODE_ENV': JSON.stringify('production')
    }
  }),
  new webpack.optimize.UglifyJsPlugin({
    compressor: {
      warnings: false
    }
  })
];

module.exports = config;
