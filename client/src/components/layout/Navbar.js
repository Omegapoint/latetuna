import React from 'react';
import {Navbar, Nav, NavItem} from 'react-bootstrap';

const MyNavbar = (props) => (
	<div>
		<Navbar>
			<Nav pullRight>
				<NavItem eventKey={1} href="#">Profile</NavItem>
				<NavItem eventKey={2} href="/signout">Sign out</NavItem>
			</Nav>
		</Navbar>
	</div>
);

export default MyNavbar;
