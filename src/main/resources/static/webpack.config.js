const autoprefixer = require('autoprefixer');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const path = require('path');
const precss = require('precss');
const webpack = require('webpack');

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
      },
      {
        test: /\.(ttf|woff|woff2|eot|svg)$/,
        loader: 'url?limit=100000'
      },
      {
        test: /\.(png)$/,
        loader: 'url?limit=100000'
      }
    ]
  },
  postcss: function() {
    return [precss, autoprefixer]
  },
  plugins: [
    new ExtractTextPlugin({ filename: 'css/app.css', disable: false, allChunks: true }),
    new webpack.optimize.OccurrenceOrderPlugin(),
  ]
};
