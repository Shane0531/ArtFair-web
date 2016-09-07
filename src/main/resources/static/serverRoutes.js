import React from 'react'
import { Router, Route, IndexRoute } from 'react-router'
import Contents from './js/components/content/Content'
import Artists from './js/components/artist/Artist'
// import PollsContainer from './containers/poll/index/PollsContainer'
// import PollContainer from './containers/poll/show/PollContainer'
import App from './js/components/App'

const routes  = (
      <Route path="/" component={App}>
        <IndexRoute component={Contents} />
        <Route path="/artists" component={Artists}/>
      </Route>
)

export default routes
