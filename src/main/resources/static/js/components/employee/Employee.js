import React, { Component } from 'react'

export default class Artist extends Component {
  render() {
    return (
      <tr>
        <td>{this.props.employee.firstName}</td>
        <td>{this.props.employee.lastName}</td>
        <td>{this.props.employee.description}</td>
      </tr>
    )
  }
}
