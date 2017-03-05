import React, { Component } from 'react';
import { FormGroup, FormControl, ControlLabel, Col} from 'react-bootstrap'

class TextElement extends Component {
	constructor(props) {
		super(props);
		this.state = { value: '' };
		this.handleUpdate = this.handleUpdate.bind(this);
	}

	handleUpdate(event) {
	  this.props.handleChange(event.target.value);
  }

  render() {
    return (
			<FormGroup controlId="{this.props.elementId}">
				<Col componentClass={ControlLabel} sm={2}>{this.props.label}</Col>
				<Col sm={10}>
					<FormControl						
						onChange={this.handleUpdate}
						type="text" placeholder={this.props.placeholder} />
				</Col>
			</FormGroup>
    );
  }
}

export default TextElement;
