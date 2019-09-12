import axios from 'axios';

const URL = 'http://localhost:8080';

export const fetchRooms = () => {
  return axios(`${URL}/rooms`);
}

export const fetchReservations = () => {
  return axios(`${URL}/reservations`);
}