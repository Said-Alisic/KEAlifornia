import React, { useState, useEffect } from 'react';

const RoomsPage = props => {

  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    fetchRooms();
  }, [])

  const fetchRooms = () => {
    fetch('http://localhost:8080/rooms')
      .then(res => {
        return res.json();
      })
      .then(rooms => {
        setRooms(rooms);
      })
  }

  return (
    <div className='container mt-4'>
      <h1>Rooms Page</h1>
      <ul>
        {rooms.map(room => {
          return <li>{room.name}</li>
        })}
      </ul>
    </div>
  )
}

export default RoomsPage;