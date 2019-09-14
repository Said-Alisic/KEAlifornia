import React, { useState } from 'react';
import MaterialTable from 'material-table';

const RoomsTable = (props, { name, price, numOfGuests, hotelId }) => {

    const [room, setRoom] = useState({
        columns: [
          { title: 'Name', field: 'name' },
          { title: 'Price', field: 'price' },
          { title: 'Number of guests', field: 'numOfGuests', type: 'numeric' },
          {
            lookup: { 34: 'KeaLifornia', 63: 'Happy Holidays Hotel' },
          },
        ],
        
        data: [
          { name: props.name, price: props.price, numOfGuests: props.numOfGuests, hotelId: props.hotelId },
        ],
      });


    return (
        <MaterialTable
          title="Editable Example"
          columns={room.columns}
          data={room.data}
          editable={{
            onRowAdd: newData =>
              new Promise(resolve => {
                setTimeout(() => {
                  resolve();
                  const data = [...room.data];
                  data.push(newData);
                  setRoom({ ...room, data });
                }, 600);
              }),
            onRowUpdate: (newData, oldData) =>
              new Promise(resolve => {
                setTimeout(() => {
                  resolve();
                  const data = [...room.data];
                  data[data.indexOf(oldData)] = newData;
                  setRoom({ ...room, data });
                }, 600);
              }),
            onRowDelete: oldData =>
              new Promise(resolve => {
                setTimeout(() => {
                  resolve();
                  const data = [...room.data];
                  data.splice(data.indexOf(oldData), 1);
                  setRoom({ ...room, data });
                }, 600);
              }),
          }}
        />
      );
}

export default RoomsTable;