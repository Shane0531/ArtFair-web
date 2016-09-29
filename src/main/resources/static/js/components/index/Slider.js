import React, {Component} from 'react'
import Carousel from 'nuka-carousel'
import Decorators from './Decorators'

class Slider extends Component {

  render() {

    return (
      <div style={{margin: 'auto'}}>
        <Carousel decorators={Decorators}>
          <img src="http://placehold.it/1000x400&text=slide1"/>
          <img src="http://placehold.it/1000x400&text=slide2"/>
          <img src="http://placehold.it/1000x400&text=slide3"/>
          <img src="http://placehold.it/1000x400&text=slide4"/>
        </Carousel>
      </div>
    )
  }
}

export default Slider
