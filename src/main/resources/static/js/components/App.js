import React, { Component } from 'react'

import Header from './header/Header'
import Body from './body/Body'
import Footer from './footer/Footer'

import client from '../client'

import fakeArtists from '../../fakeData/artists.js'

class App extends Component {

  constructor(props) {
    super(props);
    this.state = { artists: fakeArtists };
  }

  componentDidMount() {
    /*client({method: 'GET', path: '/api/employees'}).done(response => {
      this.setState({artists: response.entity});
    });*/
  }

  render() {
    return (
      <div class="app container">
        <Header />
        <Body />
        <Footer />
      </div>
    )
  }
}

export default App
