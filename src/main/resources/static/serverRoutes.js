import React from 'react'
import { Router, Route, IndexRoute } from 'react-router'
import Contents from './js/components/content/Content'
import Artists from './js/components/artist/Artist'
import Events from './js/components/event/Event'
import About from './js/components/about/About'
import Index from './js/components/index/Slider'
import Location from './js/components/location/Location'
import App from './js/components/App'

const routes  = (
      <Route path="/" component={App}>
        <IndexRoute component={Index} />
        <Route path="/artists" component={Artists}/>
        <Route path="/location" component={Location}/>
        <Route path="/events" component={Events}/>
        <Route path="/about" component={About}/>
      </Route>
)

export default routes
