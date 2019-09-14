import React, { useState, useEffect } from 'react';
import { fetchRooms, getRooms } from 'repository/Repository';
import RoomsTable from 'components/MaterialTable/RoomsTable/RoomsTable';

import Container from 'components/Container/Container';

const RoomsPage = () => {

  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    getRooms()
      .then(res => setRooms(res.data));
  }, [])

  return (
    <Container>
      <h2>Rooms Page</h2>
      <ul>
        {rooms.map(room => {
          return <RoomsTable name={room.name} price={room.price} numOfGuests={room.numOfGuests} hotelId={room.hotelId}>

          </RoomsTable>
        })}
      </ul>
    </Container>
  )
}

export default RoomsPage;