import React, { Component } from 'react'

export default class SubHeader extends Component {
  render() {

    const { title, title_2, title_description } = this.props

    return (
      <div class="jumbotron sub-header">
        <div class="container">
          <h1 class="sub-title">{ title }</h1>
          <h3 class="sub-title-2">{ title_2 }</h3>
          <p class="sub-title-description">{ title_description }</p>
        </div>
      </div>
    )
  }
}
