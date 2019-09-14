import React, { useState, useEffect } from 'react';
import Container from 'components/Container/Container';
import RoomList from 'components/RoomList/RoomList';
import RoomSearch from 'components/RoomSearch/RoomSearch';
import { getAvailableRooms } from 'repository/Repository';
import { formatDate } from 'helpers/helpers';


const AddReservationPage = props => {

  const [rooms, setRooms] = useState([]);

  const handleRoomSearch = (checkIn, checkOut) => {
    // Convert to dd-MM-yyyy format
    const checkInFormat = formatDate(checkIn);
    const checkOutFormat = formatDate(checkOut);

    getAvailableRooms(checkInFormat, checkOutFormat)
      .then(res => {
        setRooms(res.data);
      });
  }

  return (
    <Container >

      <RoomSearch onRoomSearch={handleRoomSearch} />
      <RoomList rooms={rooms} />

    </Container>
  )
}

export default AddReservationPage;