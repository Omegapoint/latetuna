const proxy = require('http-proxy-middleware');
const express = require('express');
const app = express();

app.use(express.static('public'));
//Proxy rulez
app.use('/proposal', proxy({
		target:'http://localhost:8090',
		pathRewrite: {'^/proposal': ''},
		changeOrigin:true
}));
app.use('/conference', proxy({
	target:'http://localhost:8091',
	pathRewrite: {'^/conference': ''},
	changeOrigin:true
}));

app.listen(3001, function () {
  console.log('proxy is listening on port 3001!');
});
