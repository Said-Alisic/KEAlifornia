import React from 'react';
import { NavLink } from 'react-router-dom';
import { FaPlus } from 'react-icons/fa';

import './AddButton.css';

const AddButton = props => {
  return (
    <NavLink className='btn btn-purple add-btn' to='/reservations/add'>
      <FaPlus />
    </NavLink>
  )
}

export default AddButton;