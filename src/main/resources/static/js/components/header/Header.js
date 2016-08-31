import React, { Component } from 'react'

class Header extends Component {
  render() {
    return (
      <header>
        <div class="masthead clearfix">
          <div class="inner">
            <nav class="navbar navbar-inverse navbar-static-top">
              <div class="container">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#">SYLC</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="#">About</a></li>
                    <li><a href="#">Artists</a></li>
                    <li><a href="#">Events</a></li>
                    <li><a href="#">Location</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Contact Us</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li class="nav-locale button-toolbar btn-toolbar" role="toolbar">
                      <div class="button-group btn-group">
                        <a class="link-locale" type="button" href="#">ENG</a>
                        <a class="link-locale" type="button" href="#">KOR</a>
                      </div>
                    </li>
                    <div class="hidden-sm hidden-md hidden-lg">
                      <li role="separator" class="divider"></li>
                      <li><a href="#">Contact Us</a></li>
                      <li><a href="#">FAQ</a></li>
                      <li class="nav-locale button-toolbar btn-toolbar" role="toolbar">
                        <div class="button-group btn-group">
                          <a class="link-locale" type="button" href="#">ENG</a>
                          <a class="link-locale" type="button" href="#">KOR</a>
                        </div>
                      </li>
                    </div>
                  </ul>
                </div>
              </div>
            </nav>
          </div>
        </div>
      </header>
    )
  }
}

export default Header
