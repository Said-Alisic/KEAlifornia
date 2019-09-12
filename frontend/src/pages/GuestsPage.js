import React, {useState, useEffect} from 'react';

fetch('http://localhost:8080/guests')
  .then(res => res.json())
  .then((jsonData) => {
    
    
    console.log(jsonData)
  })
  .catch((error) => {
    // handle your errors here
    console.error(error)
  })

return (
    <div>
        <h1>Welcome to the Guests page</h1>
        <ul>
            <li></li>
        </ul>
    </div>
)
