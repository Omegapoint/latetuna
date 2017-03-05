import React, { Component } from 'react';
import {Button, Grid, Row, Col, PageHeader} from 'react-bootstrap'
import MyNavbar from '../../components/layout/Navbar'
import CreateConferenceModal from '../../components/modals/ConferenceModal'


class Admin extends Component {
	constructor(props) {
		super(props);
		this.state = { showModal: false };
	}

  render() {
		let closeModal = () => { this.setState( {showModal: false}); }
    return (
      <div>
        <div>
					<MyNavbar />
      	</div>
				<Grid>
					<Row>
						<Col><PageHeader>Administration</PageHeader></Col>
					</Row>
					<Row>
						<Col>
							<Button bsStyle="primary" onClick={()=>this.setState({ showModal: true })} >Create conference</Button>
							<CreateConferenceModal show={this.state.showModal} onHide={closeModal}/>
						</Col>
					</Row>
				</Grid>
			</div>
    );
  }
}

export default Admin;
