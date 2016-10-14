/* @flow */
import React from 'react';
import linksMessages from '../../common/app/linksMessages';
import {
  CommentBox,
  PageHeader,
  Title,
  View,
} from '../app/components';
import { injectIntl, intlShape } from 'react-intl';

const AdminPage = ( { intl }) => (
  <View>
    <Title message={linksMessages.admin} />
    <PageHeader heading={intl.formatMessage(linksMessages.admin)} />
    <CommentBox />
  </View>
);

export default injectIntl(AdminPage);
