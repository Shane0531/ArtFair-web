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
      centerPadding: '50px',
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

    const items = times(5, function(key) {
      return (<div key={key}><img src='http://placekitten.com/g/400/200' /></div>)
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
