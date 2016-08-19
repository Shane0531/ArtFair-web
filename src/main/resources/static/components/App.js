import React, { Component } from 'react'

import Header from './header/Header'
import EmployeeList from './employee/EmployeeList'
import client from '../client'

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {employees: []};
  }

  componentDidMount() {
    client({method: 'GET', path: '/api/employees'}).done(response => {
      this.setState({employees: response.entity});
    });
  }

  render() {
    return (
      <div className="app">
        <Header />
        <EmployeeList employees={this.state.employees}/>
      </div>
    )
  }
}

export default App
