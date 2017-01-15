import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import { Router, Route, browserHistory } from 'react-router'

import Landing from './components/landing/Landing';
import Admin from './views/admin/Admin';
import './index.css';

ReactDOM.render(
  <Router history={browserHistory}>
    <Route path="/" component={Landing}></Route>
		<Route path="admin" component={Admin}></Route>
	</Router>,
  document.getElementById('root')
);
