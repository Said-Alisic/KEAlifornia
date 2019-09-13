import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';


import HomePage from 'pages/Home';
import GuestsPage from 'pages/GuestsPage';
import ReservationsPage from 'pages/Reservations';
import RoomsPage from 'pages/Rooms';
import AddReservationPage from 'pages/AddReservation';

import Navigation from 'components/Navigation/Navigation';

import './App.css';
import AddGuest from 'pages/AddGuest';

function App () {
  return (
    <BrowserRouter>

      <Navigation />

      <main className="main-content">
        <Route path='/' exact component={HomePage} />
        <Route path='/reservations' exact component={ReservationsPage} />
        <Route path='/reservations/add' exact component={AddReservationPage} />
        <Route path='/rooms' exact component={RoomsPage} />
        <Route path='/guests' exact component={GuestsPage} />
        <Route path='/guests/add' exact component={AddGuest} />
      </main>

    </BrowserRouter>
  );
}

export default App;
