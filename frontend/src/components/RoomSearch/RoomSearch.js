import React, { useState, useEffect } from 'react';
import Button from '@material-ui/core/Button';
import Container from 'components/Container/Container';
import DatePicker from 'components/Inputs/DatePicker/DatePicker';
import { ThreeDaysLater } from 'helpers/helpers';

const RoomSearch = props => {

  const [checkIn, setCheckIn] = useState(new Date());
  const [checkOut, setCheckOut] = useState(ThreeDaysLater());

  // When component loaded, fetch available rooms for the default dates:
  // checkIn today and checkOut 3 days later
  useEffect(() => {
    props.onRoomSearch(checkIn, checkOut);
  }, [])

  return (
    <Container flexCenter={true} >
      <DatePicker date={checkIn} onDateChange={(date) => setCheckIn(date)} label='Check In Date' />
      <DatePicker date={checkOut} onDateChange={(date) => setCheckOut(date)} label='Check Out Date' />
      <Button
        variant='contained'
        color="primary"
        onClick={() => props.onRoomSearch(checkIn, checkOut)}>
        Search Rooms
      </Button>
    </Container>
  )
}

export default RoomSearch;