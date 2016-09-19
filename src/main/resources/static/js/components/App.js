import React, { Component } from 'react'

import Header from './header/Header'
import Content from './content/Content'
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
    const { children } = this.props
    return (
      <div class="site-wrapper">
        <Header />
        { children }
        <Footer />
      </div>
    )
  }
}

export default App
