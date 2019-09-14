import React from 'react';
import Typography from '@material-ui/core/Typography';
import Container from 'components/Container/Container';
import RoomItem from './RoomItem/RoomItem';

import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const useStyles = makeStyles(theme => ({
  root: {
    width: '100%',
    marginTop: theme.spacing(3),
    overflowX: 'auto',
  },
  table: {
    minWidth: 650,
  },
}));

const RoomList = ({ rooms }) => {

  const classes = useStyles();

  return (
    <Container>
      <Typography variant='h6' gutterBottom>
        Available Rooms:
      </Typography>
      {rooms.length > 0 ?
        (
          <Paper className={classes.root}>
            <Table className={classes.table}>
              <TableHead>
                <TableRow>
                  <TableCell>Room</TableCell>
                  <TableCell align="right">Number of Guests</TableCell>
                  <TableCell align="right">Price/night</TableCell>
                  <TableCell align="right">Total price</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {rooms.map(room => (
                  <RoomItem room={room} />
                ))
                }
              </TableBody>
            </Table>
          </Paper>
        )
        :
        (
          <Typography variant='h6' gutterBottom>
            No Rooms available in provided period
          </Typography>
        )
      }

    </Container>
  )
}

export default RoomList;