import React, { useState, useEffect } from 'react';
import MaterialTable from 'material-table';
import { getRooms, addRoom, updateRoom } from 'repository/Repository';

const RoomsTable = (props) => {

  //const [rooms, setRooms] = useState([]);
  const [rooms, setRooms] = useState({
      columns: [
        { title: 'Name', field: 'name' },
        { title: 'Price', field: 'price' },
        { title: 'Number of guests', field: 'numOfGuests', type: 'numeric' },
        { title: 'Hotel id', field: 'hotelId', type: 'numeric' },
        {
          lookup: { 34: 'KeaLifornia', 63: 'Happy Holidays Hotel' },
        },
      ],
      data: props.rooms,
    
    });

    
  useEffect(() => {
    getRooms()
      .then(res => setRooms({...rooms, data: res.data}));
  }, [])


    return (
        <MaterialTable  
          title="Editable Example"
          columns={rooms.columns}
          data={rooms.data}
          editable={{
            onRowAdd: newData =>
              new Promise(resolve => {
                setTimeout(() => {
                  resolve();
                  const data = [...rooms.data];
                  data.push(newData);
                  setRooms({ ...rooms, data });
                }, 600);
                addRoom(newData);
              }),
            onRowUpdate: (newData, oldData) =>
              new Promise(resolve => {
                setTimeout(() => {
                  resolve();
                  const data = [...rooms.data];
                  data[data.indexOf(oldData)] = newData;
                  setRooms({ ...rooms, data });
                }, 600);
                console.log(newData);
                updateRoom(newData);
              }),
            onRowDelete: oldData =>
              new Promise(resolve => {
                setTimeout(() => {
                  resolve();
                  const data = [...rooms.data];
                  data.splice(data.indexOf(oldData), 1);
                  setRooms({ ...rooms, data });
                }, 600);
              }),
          }}
        />
      );
}

export default RoomsTable;