//npm install --save-dev webpack webpack-dev-server webpack-cli babel-core babel-loader@7.1.5 babel-preset-env babel-preset-stage-2 babel-preset-react react-hot-loader
//npm install --save react react-dom
// "start": "webpack-dev-server --config ./webpack.config.js --mode development",
// "babel": {
//   "presets": [
//     "env",
//     "react",
//     "stage-2"
//   ]
// },

const webpack = require('webpack');

module.exports = {
	entry : './src/main/resources/src/index.js',
	module : {
		rules : [ {
			test : /\.(js|jsx)$/,
			exclude : /node_modules/,
			use : [ 'babel-loader' ]
		} ]
	},
	resolve : {
		extensions : [ '*', '.js', '.jsx' ]
	},
	output : {
		path : __dirname + '/src/main/resources/static',
		publicPath : '/',
		filename : 'bundle.js'
	},
	plugins : [ new webpack.HotModuleReplacementPlugin() ],
	devServer : {
		contentBase : './src/main/resources/static',
		hot : true
	}
};
