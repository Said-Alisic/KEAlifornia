import React, { useState, useEffect } from 'react';
import { fetchReservations } from '../repository/Repository';

import Container from 'components/Container/Container';
import AddButton from 'components/Buttons/AddButton/AddButton';

const ReservationsPage = props => {

  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    fetchReservations()
      .then(res => setReservations(res.data));

  }, [])

  return (
    <Container>

      {/* Displaing reservations  */}
      <div>
        <h2>Reservations page</h2>
        <ul>
          {reservations.map(res => {
            return <li>
              {res.reservationId} -- {res.checkInDay} : {res.checkOutDay}
            </li>
          })}
        </ul>
      </div>

      <AddButton />

    </Container>
  )
}

export default ReservationsPage;