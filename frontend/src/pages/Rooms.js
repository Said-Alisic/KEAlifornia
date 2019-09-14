import React, { useState, useEffect } from 'react';
import { getRooms } from 'repository/Repository';
import Container from 'components/Container/Container';

const RoomsPage = props => {

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
          return <li>{room.name}</li>
        })}
      </ul>
    </Container>
  )
}

export default RoomsPage;