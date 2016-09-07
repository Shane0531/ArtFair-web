import React, { Component } from 'react'
import { Nav, Navbar, NavItem } from 'react-bootstrap'

class Header extends Component {

  render() {
    return (
      <header>
        <Navbar inverse>
          <Navbar.Header>
            <Navbar.Brand>
              <a href="/">SYLC</a>
            </Navbar.Brand>
            <Navbar.Toggle />
          </Navbar.Header>
          <Navbar.Collapse>
            <Nav>
              <NavItem eventKey={1} href="/about">About</NavItem>
              <NavItem eventKey={2} href="/artists">Artists</NavItem>
              <NavItem eventKey={3} href="/events">Events</NavItem>
              <NavItem eventKey={4} href="#">Location</NavItem>
            </Nav>
            <Nav pullRight>
              <NavItem eventKey={1} href="#">Contact Us</NavItem>
              <NavItem eventKey={2} href="#">FAQ</NavItem>
              <NavItem eventKey={3} href="#">ENG</NavItem>
              <NavItem eventKey={4} href="#">KOR</NavItem>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </header>
    )
  }
}

export default Header
