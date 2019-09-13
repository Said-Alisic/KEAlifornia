import React, { useState } from 'react';
import axios from 'axios';


// Functional component
const AddGuest = () => {

  // Setting state of functional component using 'useState' hook
  const [name, setName] = useState('');
  const [phoneNo, setPhoneNo] = useState('');
  const [email, setEmail] = useState('');
  

  // Can be used inside the "onChange" event without actually having to declare the function
  // 'e' is a synthetic event
  // Event handler for email state
  const handleChangeEmail = (e) => setEmail(e.target.value);

  const handleSubmit = (e) => {
    e.preventDefault();

    const guest = {
      guestId: 0,
      name: name,
      phoneNo: phoneNo,
      email: email,
      awardPoints: 0

    };

       
    axios.post(`http://localhost:8080/guests/add`, guest)
      .then(res => {
        // Print guest object
        console.log(guest);
      })
  }

  //render() {
    return (
      <div>
        <form onSubmit={handleSubmit}>
          <label>
            Name
            <input type="text" name="name" onChange={(e) => setName(e.target.value)} />
          </label>
          <label>
            Phonenumber
            <input type="text" name="phoneNo" onChange={(e) => setPhoneNo(e.target.value)} />
          </label>
          <label>
            Email
            <input type="text" name="email" onChange={handleChangeEmail} />
          </label>
          <button type="submit">Add</button>
        </form>
      </div>
    )
  }
//}

export default AddGuest;