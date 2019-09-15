import axios from 'axios';

// Server side url port
const URL = 'http://localhost:8080';

export const getRooms = () => {
  return axios(`${URL}/rooms`);
}

export const addRoom = (room) => {
  return axios.post(`${URL}/rooms/add`, room)
}

export const updateRoom = (room) => {
  return axios.put(`${URL}/rooms/update`, room)
}

export const getReservations = () => {
  return axios(`${URL}/reservations`);
}


// Get available rooms in between provided period
export const getAvailableRooms = (checkIn, checkOut) => {
  return axios(`${URL}/reservations/search/${checkIn}/${checkOut}`)
}

// A faster way of writing Get Request for getting guest data from backend
export const getGuests = () => {
  return axios(`${URL}/guests`);

}

export const getGuest = (id) => {
  return axios(`${URL}/guests/edit/${id}`);

}
