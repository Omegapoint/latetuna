/* @flow */
import React from 'react';
import { IndexRoute, Route } from 'react-router';

import App from './app/App';
import Fields from './fields/FieldsPage';
import Firebase from './firebase/FirebasePage';
import Home from './home/HomePage';
import Admin from './admin/AdminPage';
import SignIn from './auth/SignInPage';

const createRoutes = (getState: Function) => {
  const requireViewer = (nextState, replace) => {
    if (getState().users.viewer) return;
    replace({
      pathname: '/signin',
      state: { nextPathname: nextState.location.pathname },
    });
  };

  return (
    <Route component={App} path="/">
      <IndexRoute component={Home} />
      <Route component={Admin} path="/admin" />
      <Route component={SignIn} path="/signin" />
    </Route>
  );
};

export default createRoutes;
