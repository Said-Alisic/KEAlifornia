import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';

import HomePage from 'pages/HomePage';
import ReservationsPage from 'pages/ReservationsPage';
import RoomsPage from 'pages/RoomsPage';

import Navigation from 'components/Navigation/Navigation';

import './App.css';

function App () {
  return (
    <BrowserRouter>

      <Navigation />

      <main className="main-content">
        <Route path='/' exact component={HomePage} />
        <Route path='/reservations' exact component={ReservationsPage} />
        <Route path='/rooms' exact component={RoomsPage} />
      </main>

    </BrowserRouter>
  );
}

export default App;
