import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.css'
import '../stylesheets/main.scss'

import React from 'react'
import { render } from 'react-dom'
import { Router, browserHistory } from 'react-router'
import App from './components/App'
import routes from '../serverRoutes'

render(
    <Router history={browserHistory} routes={routes} />,
    document.getElementById('app')
)
