import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

const ReservationItem = ({ room }) => {
  return (
    <ListItem key={room.roomId} button="true">
      <ListItemText primary={room.name} />
    </ListItem>
  )
}

export default ReservationItem;