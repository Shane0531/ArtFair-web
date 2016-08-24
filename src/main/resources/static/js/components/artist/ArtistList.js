import React, { Component } from 'react'
import Artist from './Artist'

export default class ArtistList extends Component {
  render() {
    const artists = this.props.artists.map(artist =>
      <Artist key={artist} artist={artist}/>
    )

    return (
      <table class="employee container">
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>{artists}</tbody>
      </table>
    )
  }
}
