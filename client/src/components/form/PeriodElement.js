import React, { Component } from 'react';
import { FormGroup, FormControl, ControlLabel, Col} from 'react-bootstrap'

class PeriodElement extends Component {
	constructor(props) {
		super(props);
		this.state = { fromValue: '', toValue: '' };
		this.handleFromUpdate = this.handleFromUpdate.bind(this);
		this.handleToUpdate = this.handleToUpdate.bind(this);
	}

	handleFromUpdate(event) {
		this.setState({fromValue: event.target.value})
	  this.props.handleChange(this.state.fromValue, this.state.toValue);
  }

	handleToUpdate(event) {
		this.setState({toValue: event.target.value})
	  this.props.handleChange(this.state.fromValue, this.state.toValue);
  }

  render() {
    return (
			<FormGroup controlId="{this.props.elementId}">
				<Col componentClass={ControlLabel} sm={2}>{this.props.label}</Col>
				<Col sm={3}>
					<FormControl onChange={this.handleFromUpdate} type="text" placeholder="2017-05-01" />
				</Col>
				<Col sm={3}>
					<FormControl onChange={this.handleToUpdate} type="text" placeholder="2017-05-05" />
				</Col>
			</FormGroup>
    );
  }
}

export default PeriodElement;
