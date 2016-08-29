import React, { Component } from 'react'
import Slider from 'react-slick'
import { times } from 'lodash'
import 'slick-carousel/slick/slick.css'
import 'slick-carousel/slick/slick-theme.css'

class Index extends Component {
  next() {
    this.refs.slider.slickNext()
  }
  previous() {
    this.refs.slider.slickPrev()
  }

  render() {
    const settings = {
      arrows: true,
      autoplay: false,
      centerMode: true,
      cssEase: 'ease',
      dots: true,
      draggable: false,
      infinite: false,
      slidesToShow: 1,
      slidesToScroll: 1,
      speed: 2000,
      swipe: true,
      touchMove: false
    }

    const items = times(2, function(key) {
      return (
        <div class="text-center slide" key={key} style={{"background": "url('http://placehold.it/1600x650')"}}>
          <h1>Slide {key} heading</h1>
          <p>Slide {key} text</p>
        </div>
      )
    })

    return (
      <div>
        <Slider ref='slider' {...settings}>
          { items }
        </Slider>
      </div>
    )
  }
}

export default Index
