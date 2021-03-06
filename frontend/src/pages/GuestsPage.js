import React, {useState, useEffect} from 'react';


const GuestsPage = () => {

    // First state (guest) - function to update state (setGuests)
    const [guests, setGuests] = useState([]);

    useEffect(() => {
        fetchGuests();
      }, []);

    const fetchGuests = () => {
        fetch('http://localhost:8080/guests')
            .then(response => {
                return response.json();
            })
            .then(guests => {
                setGuests(guests);
            })

        };


    return (
        <div className='container mt-4'>
            <h1>Welcome to the Guests page</h1>
            <ul>
            <li><b>Id - Name - Phone Number - Email - Award Points</b></li>
            {guests.map(guest => {
                return <li>{guest.guestId} - {guest.name} - {guest.phoneNo} - {guest.email} - {guest.awardPoints}</li>
            })}
            </ul>
        </div>
    )

}

export default GuestsPage;
