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
      dots: true,
      draggable: false,
      infinite: false,
      slidesToShow: 1,
      slidesToScroll: 1,
      swipe: true,
      touchMove: false
    }

    const items = times(5, function(key) {
      return (<div key={key}><img src='http://placekitten.com/g/400/200' /></div>)
    })

    return (
      <div>
        <h2>Fade</h2>
        <Slider ref='slider' {...settings}>
          { items }
        </Slider>
      </div>
    )
  }
}

export default Index
