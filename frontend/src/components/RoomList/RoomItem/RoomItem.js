import React from 'react';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

const ReservationItem = ({ room }) => {
  return (
    <TableRow key={room.roomId}>
      <TableCell component="th" scope="row">
        {room.name}
      </TableCell>
      <TableCell align="right">{room.numOfGuests}</TableCell>
      <TableCell align="right">{room.price}</TableCell>
      <TableCell align="right">{room.price}</TableCell>
    </TableRow>
  )
}

export default ReservationItem;