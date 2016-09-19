import React, { Component } from 'react'

export default class Artist extends Component {
  render() {

    return (
      <div class="artist">
        <div class="jumbotron sub-header">
          <div class="container">
            <h1 class="artist-title">Artists</h1>
            <h3 class="artist-sub-title">SYLC Art Fair 2016</h3>
            <p class="artist-title-description">This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
          </div>
        </div>

        <div class="artist-list">
          <div class="container">
            <div class="row">
              <div class="col-md-4">
                <h2>GUSTAVO LEE</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
                <a class="btn btn-default" href="#" role="button">View details >></a>
              </div>
              <div class="col-md-4">
                <h2>SUNG HWAN KIM</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
                <a class="btn btn-default" href="#" role="button">View details >></a>
              </div>
              <div class="col-md-4">
                <h2>JIYOG KIM</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
                <a class="btn btn-default" href="#" role="button">View details >></a>
              </div>
            </div>
          </div>
        </div>

      </div>
    )
  }
}
