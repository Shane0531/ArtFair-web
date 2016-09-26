import React, { Component } from 'react'
import SubHeader from '../header/SubHeader'

export default class Event extends Component {
  render() {

    return (
      <div class="event">
        <SubHeader
          title="Event"
          title_2="SYLC Art Fair 2016"
          title_description="This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique."
        />
        <div class="event-list">
          <div class="container">
            <div class="row">
              <div class="event-list-item col-lg-12">
                <img class="col-lg-6" src="http://placehold.it/500x200"/>
                <div class="event-item col-lg-6">
                  <h2>바이올린 연주</h2>
                  <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                    mollis euismod. Donec sed odio dui.</p>
                </div>
              </div>
              <div class="event-list-item col-lg-12">
                <img class="col-lg-6" src="http://placehold.it/500x200"/>
                <div class="event-item col-lg-6">
                  <h2>바이올린 연주</h2>
                  <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                    mollis euismod. Donec sed odio dui.</p>
                </div>
              </div>
              <div class="event-list-item col-lg-12">
                <img class="col-lg-6" src="http://placehold.it/500x200"/>
                <div class="event-item col-lg-6">
                  <h2>바이올린 연주</h2>
                  <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                    mollis euismod. Donec sed odio dui.</p>
                </div>
              </div>
              <div class="event-list-item col-lg-12">
                <img class="col-lg-6" src="http://placehold.it/500x200"/>
                <div class="event-item col-lg-6">
                  <h2>바이올린 연주</h2>
                  <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                    mollis euismod. Donec sed odio dui.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
