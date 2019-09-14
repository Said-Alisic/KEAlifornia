import React from 'react';
import { NavLink, Link as RouterLink } from 'react-router-dom';

import { makeStyles } from '@material-ui/core/styles';
import { AppBar, MenuList, MenuItem, Container, Link } from '@material-ui/core';

const useStyles = makeStyles(theme => ({
  container: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center'
  },
  brand: {
    color: 'white',
    fontSize: '2rem',
    fontWeight: 'bold'
  },
  menu: {
    display: 'flex'
  },
  active: {
    background: theme.palette.action.selected
  }
}));

const Navigation = props => {

  const classes = useStyles();

  return (
    <header>
      <AppBar position='static'>
        <Container className={classes.container}>
          <Link component={RouterLink} exact='true' to='/' className={classes.brand} underline='none'>
            KEAlifornia
          </Link>

          <MenuList className={classes.menu}>
            <MenuItem component={NavLink} exact='true' to='/rooms' activeClassName={classes.active}>
              Hotels
            </MenuItem>
            <MenuItem component={NavLink} exact='true' to='/rooms' activeClassName={classes.active}>
              Rooms
            </MenuItem>
            <MenuItem component={NavLink} exact='true' to='/reservations' activeClassName={classes.active}>
              Reservations
            </MenuItem>
          </MenuList>
        </Container>
      </AppBar>
    </header>
  )
}

export default Navigation;