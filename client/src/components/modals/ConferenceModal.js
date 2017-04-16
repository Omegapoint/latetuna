import React, { Component } from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import TextElement from '../form/TextElement';
import PeriodElement from '../form/PeriodElement';

class ConferenceModal extends Component {
	constructor(props) {
		super(props);
		this.state = {
			name:'',
			from:'',
			to:'',
			tags:'',
			domain:''
		};
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleNameChange = this.handleNameChange.bind(this);
		this.handlePeriodChange = this.handlePeriodChange.bind(this);
		this.handleTagsChange = this.handleTagsChange.bind(this);
		this.handleDomainChange = this.handleDomainChange.bind(this);
	}

	handleNameChange(newName) {
	  this.setState({name: newName});
  }
	handlePeriodChange(newFrom, newTo) {
	  this.setState({from: newFrom, to: newTo});
  }
	handleTagsChange(newTags) {
	  this.setState({tags: newTags});
  }
	handleDomainChange(newDomain) {
	  this.setState({domain: newDomain});
  }

	handleSubmit() {
		const conference = {
				name: this.state.name,
				fromDate: this.state.from,
				toDate: this.state.to,
				tags: this.state.tags,
				domain: this.state.domain
		};
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
		this.props.onHide();
 	}

  render() {
    return (
			<Modal {...this.props}>
        <Modal.Header closeButton>
          <Modal.Title>Create a conference</Modal.Title>
        </Modal.Header>
        <Modal.Body>
					<Form horizontal>
						<TextElement elementId="formHorizontalName" label="Name" placeholder="Name the conference" handleChange={this.handleNameChange}></TextElement>
						<PeriodElement elementId="formHorizontalDates" label="Dates" handleChange={this.handlePeriodChange}></PeriodElement>
						<TextElement elementId="formHorizontalTags" label="Tags" placeholder="Keywords" handleChange={this.handleTagsChange}></TextElement>
						<TextElement elementId="formHorizontalDomain" label="Domain" placeholder="www.yourdomain.com" handleChange={this.handleDomainChange}></TextElement>
					</Form>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={this.props.onHide}>Close</Button>
          <Button onClick={this.handleSubmit} bsStyle="primary">Save</Button>
        </Modal.Footer>
      </Modal>
    );
  }
}

export default ConferenceModal;
