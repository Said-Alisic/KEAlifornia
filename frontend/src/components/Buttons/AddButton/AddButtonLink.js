import React from 'react';
import { NavLink } from 'react-router-dom';

import { makeStyles } from '@material-ui/core/styles';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';

const useStyles = makeStyles(theme => ({
  fab: {
    position: 'absolute',
    bottom: theme.spacing(15),
    right: theme.spacing(25),
  }
}))


const AddButton = ({ to }) => {

  const classes = useStyles();

  return (
    <Fab
      component={NavLink}
      to={to}
      color='primary'
      aria-label='add'
      className={classes.fab}>
      <AddIcon />
    </Fab>
  )
}

export default AddButton;