import React from 'react';
import 'date-fns';
import DateFnsUtils from '@date-io/date-fns';
import {
  MuiPickersUtilsProvider,
  KeyboardDatePicker
} from '@material-ui/pickers';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
  inputContainer: {
    marginRight: theme.spacing(5)
  }
}));

const DatePicker = ({ date, label, onDateChange }) => {

  const classes = useStyles();

  return (
    <MuiPickersUtilsProvider utils={DateFnsUtils}>
      <KeyboardDatePicker
        className={classes.inputContainer}
        disableToolbar
        variant='inline'
        format='dd-MM-yyyy'
        margin='normal'
        label={label}
        value={date}
        onChange={onDateChange}
        KeyboardButtonProps={{
          'aria-label': 'change date',
        }}
      />
    </MuiPickersUtilsProvider>
  )
}

export default DatePicker;