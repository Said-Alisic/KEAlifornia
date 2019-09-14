import React, { useState, useEffect } from 'react';
import { getReservations } from '../repository/Repository';
import Container from 'components/Container/Container';
import AddButtonLink from 'components/Buttons/AddButton/AddButtonLink';

const ReservationsPage = props => {

  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    getReservations()
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

      <AddButtonLink to='/reservations/add' />

    </Container>
  )
}

export default ReservationsPage;