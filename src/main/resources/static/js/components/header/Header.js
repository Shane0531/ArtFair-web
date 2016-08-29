import React, { Component } from 'react'

class Header extends Component {
  render() {
    return (
      <header>
        <div class="masthead clearfix">
          <div class="inner">
            <h3 class="masthead-brand">SYLC</h3>
            <nav>
              <ul class="nav masthead-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Features</a></li>
                <li><a href="#">Contact</a></li>
              </ul>
            </nav>
          </div>
        </div>
      </header>
    )
  }
}

export default Header
