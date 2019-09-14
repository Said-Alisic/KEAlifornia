import React, { useState, useEffect } from 'react';
import Container from 'components/Container/Container';
import DatePicker from 'components/Inputs/DatePicker/DatePicker';
import Button from '@material-ui/core/Button';
import ReservationsList from 'components/ReservationsList/ReservationsList';
import { getAvailableRooms } from 'repository/Repository';
import { ThreeDaysLater, formatDate } from 'helpers/helpers';



const AddReservationPage = props => {

  const [checkIn, setCheckIn] = useState(new Date());
  const [checkOut, setCheckOut] = useState(ThreeDaysLater());
  const [rooms, setRooms] = useState([]);

  // When component loaded, fetch available rooms for the default dates:
  // checkIn today and checkOut 3 days later
  useEffect(() => {
    handleRoomsSearch();
  }, [])

  const handleRoomsSearch = () => {
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
      {/* TODO: Make it a component */}
      <Container flexCenter={true} >
        <DatePicker date={checkIn} onDateChange={(date) => setCheckIn(date)} label='Check In Date' />
        <DatePicker date={checkOut} onDateChange={(date) => setCheckOut(date)} label='Check Out Date' />
        <Button
          variant='contained'
          color="primary"
          onClick={handleRoomsSearch}>
          Search Rooms
        </Button>
      </Container>

      <ReservationsList rooms={rooms} />

    </Container>
  )
}

export default AddReservationPage;