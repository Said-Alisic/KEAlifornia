import React from 'react';
import axios from 'axios';

export default class AddGuest extends React.Component {
  state = {
    name: '',
    phoneNo: '',
    email: '',
    awardPoints: 0,
  }

  // 'e' is a synthetic event
  // Event handlers for each state
  handleChangeName = (e) => {
    this.setState({ name: e.target.value });
    
  }

  handleChangePhoneNo = (e) => {
    this.setState({ phoneNo: e.target.value });
  }

  handleChangeEmail = (e) => {
    this.setState({ email: e.target.value });
  }

  handleSubmit = (e) => {
    e.preventDefault();

    const guest = {
      guestId: 0,
      name: this.state.name,
      phoneNo: this.state.phoneNo,
      email: this.state.email,
      awardPoints: this.state.awardPoints

    };

       

    axios.post(`http://localhost:8080/guests/add`, guest)
      .then(res => {
        // Print guest object
        console.log(guest);
      })
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <label>
            Name
            <input type="text" name="name" onChange={this.handleChangeName} />
          </label>
          <label>
            Phonenumber
            <input type="text" name="phoneNo" onChange={this.handleChangePhoneNo} />
          </label>
          <label>
            Email
            <input type="text" name="email" onChange={this.handleChangeEmail} />
          </label>
          <button type="submit">Add</button>
        </form>
      </div>
    )
  }
}