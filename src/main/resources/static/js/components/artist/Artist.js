import React, { Component } from 'react'

export default class Artist extends Component {
  render() {
    const {firstName, lastName, description} = this.props.artist
    return (
      <tr>
        <td>{firstName}</td>
        <td>{lastName}</td>
        <td>{description}</td>
      </tr>
    )
  }
}
