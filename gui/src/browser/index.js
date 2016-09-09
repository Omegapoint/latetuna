/* eslint-disable react/require-extension */
// Bootstrap environment

const onWindowIntl = () => {
  require('babel-polyfill');
  window.Promise = require('../common/configureBluebird');

  // App locales are defined in src/server/config.js
  const { addLocaleData } = require('react-intl');
  const de = require('react-intl/locale-data/de');
  const en = require('react-intl/locale-data/en');
  const es = require('react-intl/locale-data/es');
  const fr = require('react-intl/locale-data/fr');
  const sv = require('react-intl/locale-data/sv');

  [de, en, es, fr, sv].forEach(locale => addLocaleData(locale));

  require('./main');
};

// github.com/andyearnshaw/Intl.js/#intljs-and-browserifywebpack
if (!window.Intl) {
  require.ensure([
    'intl',
    'intl/locale-data/jsonp/de.js',
    'intl/locale-data/jsonp/en.js',
    'intl/locale-data/jsonp/es.js',
    'intl/locale-data/jsonp/fr.js',
    'intl/locale-data/jsonp/sv.js',
  ], (require) => {
    require('intl');
    require('intl/locale-data/jsonp/de.js');
    require('intl/locale-data/jsonp/en.js');
    require('intl/locale-data/jsonp/es.js');
    require('intl/locale-data/jsonp/fr.js');
    require('intl/locale-data/jsonp/sv.js');

    onWindowIntl();
  });
} else {
  onWindowIntl();
}
