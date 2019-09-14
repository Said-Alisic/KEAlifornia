import React from 'react';
import { Container as MContainer } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
  container: {
    marginTop: theme.spacing(10),
  },
  flexCenter: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center'
  }
}));

const Container = props => {

  const { container, flexCenter } = useStyles();

  return (
    <MContainer
      className={`${container} ${props.flexCenter && flexCenter}`}>
      {props.children}
    </MContainer>
  )
}

export default Container;