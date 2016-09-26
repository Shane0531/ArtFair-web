import React, { Component } from 'react'
import SubHeader from '../header/SubHeader'

export default class Location extends Component {
  render() {

    return (
      <div class="location">
        <SubHeader
          title="Location"
          title_2="SYLC Art Fair 2016"
          title_description="123-123 Cafe Mellow, Samsung Hwarang, Seoul, South Korea"
        />

        <div class="location-content">
          <div class="container">
            <div class="row">
              <div>
                <iframe frameborder="0" class="location-map"
                        src="https://www.google.com/maps/embed/v1/place?q=가로수길&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU">
                </iframe>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
