import React from 'react';
import { NavLink } from 'react-router-dom';

import './Navigation.css';

const Navigation = props => {
  return (
    <header className="masthead mb-5">
      <div className="inner container">
        <h2 className="masthead-brand">
          <NavLink to="/">KEAlifornia</NavLink>
        </h2>
        <nav className="nav nav-masthead justify-content-center">
          <NavLink className="nav-link" to="/rooms">Rooms</NavLink>
          <NavLink className="nav-link" to="/reservations">Reservations</NavLink>
        </nav>
      </div>
    </header>
  )
}

export default Navigation;