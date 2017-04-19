import React, { Component } from 'react';
import {Navbar, Nav, NavItem, Grid, Row, Col, Jumbotron, PageHeader} from 'react-bootstrap'
import './Landing.css';

class Landing extends Component {
  render() {
    return (
      <div className="Landing">
				<Navbar>
					<Nav pullRight>
						<NavItem eventKey={1} href="#">Sign Up</NavItem>
						<NavItem eventKey={2} href="/admin">Sign In</NavItem>
					</Nav>
				</Navbar>
        <div className="Landing-header">
					<div className="Landing-jumbo">
						<Grid>
							<Row>
								<Col sm={6} smOffset={3} md={8} mdOffset={2} lg={8} lgOffset={2}>
									<Jumbotron>
										<h1>Confy</h1>
										<p>Running conferences made easy!</p>
										<p>Sign up</p>
									</Jumbotron>
								</Col>
							</Row>
						</Grid>
					</div>
        </div>
				<Grid>
					<Row>
						<Col sm={12}>
							<PageHeader>Awesome features</PageHeader>
						</Col>
					</Row>
					<Row>
						<Col sm={4} md={2} mdOffset={3} lg={3} lgOffset={2}>
							<h4>Create you conference with ease</h4>
							<p>With a few clicks and some details you're up and running.</p>
						</Col>
						<Col sm={4} md={3} lg={3}>
							<h4>Manage the proposals</h4>
							<p>The management of proposals will be a breeze</p>
						</Col>
						<Col sm={4} md={3} lg={3}>
							<h4>Room mangagement</h4>
							<p>Capacity, equipment and other features</p>
						</Col>
					</Row>
					<Row>
						<Col sm={4} md={3} mdOffset={2} lg={3} lgOffset={2}>
							<h4>Lay out your schedule</h4>
							<p>Creating the schedule for your conference.</p>
						</Col>
						<Col sm={4} md={3} lg={3}>
							<h4>Management dashboard</h4>
							<p>Get an overview of propsals, sign ups, payments etc</p>
						</Col>
						<Col sm={4} md={3} lg={3}>
							<h4>Sponsor management</h4>
							<p>Manage your exhibition</p>
						</Col>
					</Row>
				</Grid>

				<Grid>
					<Row>
						<Col sm={12}>
							<PageHeader>Testimonials</PageHeader>
						</Col>
					</Row>
					<Row>
						<Col sm={4} md={4} mdOffset={2} lg={4} lgOffset={2}>
							<h4>What a breeze!</h4>
							<p>The KnowIT tech summit was a great success.</p>
						</Col>
						<Col sm={4} md={3} lg={3}>
							<h4>A joy to use!</h4>
							<p></p>
						</Col>
						<Col sm={4} md={3} lg={3}>
							<h4>A great success</h4>
							<p></p>
						</Col>
					</Row>
				</Grid>
      </div>
    );
  }
}

export default Landing;
