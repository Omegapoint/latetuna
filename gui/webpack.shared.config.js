var path = require("path");

var srcDirectory = path.join(__dirname, "src");

module.exports = {
  "entry": [ "./src/app.js" ],
  "output": {
    "filename": "app.bundle.js"
  },
  "module": {
    "loaders": [{
      "test": /\.js?$/,
      "include": srcDirectory,
      "loader": 'babel'
    }]
  }
};
