import React, {Component} from 'react';
import {Button, Grid, Row, Col, PageHeader} from 'react-bootstrap'
import MyNavbar from '../../components/layout/Navbar'
import CreateConferenceModal from '../../components/modals/ConferenceModal'

class Admin extends Component {
	constructor(props) {
		super(props);
		this.state = {
			showModal: false,
			conferences: []
		};
		this.getConferences();
	}

	getConferences() {
		let handleUpdate = (newList) => {this.setState({conferences: newList})};
		fetch('/conference', {
			method: 'GET',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		}).then(function (response){
			return response.json();
		}).then(function (json){
			handleUpdate(json);
		});
	}

	render() {
		let closeModal = () => {
			this.setState({showModal: false});
		}
		return (
			<div>
				<div>
					<MyNavbar/>
				</div>
				<Grid>
					<Row>
						<Col md={12}>
							<PageHeader>Administration</PageHeader>
						</Col>
					</Row>
					<Row>
						<Col md={10}>
							<h2>Your conferences</h2>
							<!-- todo print the list of conferences -->
						</Col>
						<Col md={2}>
							<Button bsStyle="primary" onClick={() => this.setState({showModal: true})}>Create conference</Button>
							<CreateConferenceModal show={this.state.showModal} onHide={closeModal}/>
						</Col>
					</Row>
					<Row>
						<Col></Col>
					</Row>
				</Grid>
			</div>
		);
	}
}

export default Admin;
