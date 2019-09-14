import React from 'react';


const RoomInput = ({ name, price, numOfGuests }) => {

    return(
        <div>
            <label> Name
                <input type="text" placeholder="Name" onChange={name = (e) => e.target.value} />
            </label>
            <label> Name
                <input type="text" placeholder="price" onChange={price = (e) => e.target.value} />
            </label>
            <label> Name
                <input type="text" placeholder="numOfGuests" onChange={numOfGuests = (e) => e.target.value} />
            </label>
        </div>

    )

}