import React, { Component } from 'react'
import Employee from './Employee'

export default class EmployeeList extends Component {
  render() {
    const employees = this.props.employees.map(employee =>
      <Employee key={employee} employee={employee}/>
    )

    return (
      <table>
        <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Description</th>
        </tr>
        </thead>
        <tbody>{employees}</tbody>
      </table>
    )
  }
}
