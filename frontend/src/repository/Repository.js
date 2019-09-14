import axios from 'axios';

const URL = 'http://localhost:8080';

export const getRooms = () => {
  return axios(`${URL}/rooms`);
}

export const getReservations = () => {
  return axios(`${URL}/reservations`);
}


// Get available rooms in between provided period
export const getAvailableRooms = (checkIn, checkOut) => {
  return axios(`${URL}/reservations/search/${checkIn}/${checkOut}`)
}

// A faster way of writing Get Request for getting guest data from backend
export const fetchGuests = () => {
  return axios(`${URL}/guests`);

}