import React from 'react';
import Typography from '@material-ui/core/Typography';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Container from 'components/Container/Container';
import ReservationItem from './RoomItem/RoomItem';

const RoomList = ({ rooms }) => {
  return (
    <Container>
      <Typography variant='h6' gutterBottom>
        Available Rooms:
      </Typography>

      <List aria-label="list of available rooms to book">
        {rooms.length > 0 ?
          (rooms.map(room => {
            return (
              <ReservationItem room={room} />
            )
          })
          )
          :
          (
            <ListItem>
              <ListItemText primary="No Rooms available in provided period" />
            </ListItem>
          )
        }
      </List>

    </Container>
  )
}

export default RoomList;