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