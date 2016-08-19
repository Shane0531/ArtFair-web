const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const precss = require('precss');
const autoprefixer = require('autoprefixer');

module.exports = {
  entry: './js/index.js',
  devtool: 'cheap-eval-source-map',
  debug: true,
  output: {
    path: path.join(__dirname, 'built'),
    publicPath: '/built/',
    filename: 'js/app.js'
  },
  module: {
    loaders: [
      {
        test: /\.js?$/,
        exclude: '/node_modules/',
        loader: 'babel',
        query: {
          presets: ['react', 'es2015', 'es2016'],
          plugins: ['react-html-attrs']
        }
      },
      {
        test: /\.css?$/,
        loader: ExtractTextPlugin.extract({ fallbackLoader: 'style-loader', loader: 'css-loader!postcss-loader'})
      },
      {
        test: /\.scss?$/,
        loader: ExtractTextPlugin.extract({ fallbackLoader: 'style-loader', loader: 'css-loader!scss-loader'})
      }
    ]
  },
  postcss: function() {
    return [precss, autoprefixer]
  },
  plugins: [
    new ExtractTextPlugin({ filename: 'css/app.css', disable: false, allChunks: true })
  ]
};
