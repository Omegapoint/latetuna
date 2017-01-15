import React, { Component } from 'react';
import {Navbar, Nav, NavItem, Button, Grid, Form, FormGroup, FormControl, ControlLabel, Row, Col, Modal, PageHeader} from 'react-bootstrap'

class Admin extends Component {
	constructor(props) {
		super(props);
		this.state = {
			showModal: false,
			name:'',
			from:'',
			to:'',
			tags:'',
			domain:''
		};
		this.close = this.close.bind(this);
		this.open = this.open.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleNameChange = this.handleChange.bind(this);
		this.handleFromChange = this.handleFromChange.bind(this);
		this.handleToChange = this.handleToChange.bind(this);
		this.handleTagsChange = this.handleTagsChange.bind(this);
		this.handleDomainChange = this.handleDomainChange.bind(this);
	}

	handleNameChange(event) {
	  this.setState({name: event.target.value});
  }
	handleFromChange(event) {
	  this.setState({from: event.target.value});
  }
	handleToChange(event) {
	  this.setState({to: event.target.value});
  }
	handleTagsChange(event) {
	  this.setState({tags: event.target.value});
  }
	handleDomainChange(event) {
	  this.setState({domain: event.target.value});
  }

	handleSubmit() {
		const conference = {
				name: this.state.name,
				fromDate: this.state.from,
				toDate: this.state.to,
				tags: this.state.tags,
				domain: this.state.domain
		};
	 	console.log('A conference ' + this.state.name + ' was submitted');
		console.log(JSON.stringify(conference));
		fetch('/conference', {
				method: 'POST',
				headers: {
						'Accept': 'application/json',
						'Content-Type': 'application/json',
				},
				body: JSON.stringify(conference)
			});

		this.setState({showModal: false});
	 	event.preventDefault();
 	}

	close() {
		this.setState({showModal: false});
	}

	open() {
		this.setState({showModal: true});
	}

  render() {
		var showModal = this.state.showModal;
    return (
      <div>
        <div>
					<Navbar>
						<Nav pullRight>
							<NavItem eventKey={1} href="#">Profile</NavItem>
							<NavItem eventKey={2} href="/signout">Sign out</NavItem>
						</Nav>
					</Navbar>
      	</div>
				<Grid>
					<Row>
						<Col><PageHeader>Administration</PageHeader></Col>
					</Row>
					<Row>
						<Col>
							<Button bsStyle="primary" onClick={this.open}>Create conference</Button>
							<Modal show={showModal} onHide={this.close}>
			          <Modal.Header closeButton>
			            <Modal.Title>Create a conference</Modal.Title>
			          </Modal.Header>
			          <Modal.Body>
									<Form horizontal>
										<FormGroup controlId="formHorizontalName">
											<Col componentClass={ControlLabel} sm={2}>
												Name
											</Col>
											<Col sm={10}>
												<FormControl
													value={this.state.name}
													onChange={this.handleChange}
													type="text" placeholder="Name" />
											</Col>
										</FormGroup>

										<FormGroup controlId="formHorizontalDates">
											<Col componentClass={ControlLabel} sm={2}>
												Dates
											</Col>
											<Col sm={3}>
												<FormControl value={this.state.from} onChange={this.handleChange} type="text" placeholder="2017-05-01" />
											</Col>
											<Col sm={3}>
												<FormControl value={this.state.to} onChange={this.handleChange} type="text" placeholder="2017-05-05" />
											</Col>
										</FormGroup>

										<FormGroup controlId="formHorizontalTags">
											<Col componentClass={ControlLabel} sm={2}>
												Tags
											</Col>
											<Col sm={10}>
												<FormControl value={this.state.tags} onChange={this.handleChange} type="text" placeholder="Keywords" />
											</Col>
										</FormGroup>


										<FormGroup controlId="formHorizontalDomain">
											<Col componentClass={ControlLabel} sm={2}>
												Domain
											</Col>
											<Col sm={10}>
												<FormControl value={this.state.domain} onChange={this.handleChange} type="text" placeholder="www.yourdomain.com" />
											</Col>
										</FormGroup>
									</Form>

			          </Modal.Body>
			          <Modal.Footer>
			            <Button onClick={this.close}>Close</Button>
			            <Button onClick={this.handleSubmit} bsStyle="primary">Save</Button>
			          </Modal.Footer>
			        </Modal>
						</Col>
					</Row>
				</Grid>
			</div>
    );
  }
}

export default Admin;
