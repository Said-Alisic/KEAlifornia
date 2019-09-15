import React from 'react';
import RoomsTable from 'components/MaterialTable/RoomsTable/RoomsTable';

import Container from 'components/Container/Container';

const RoomsPage = () => {

  return (
    <Container>
      <h2>Rooms Page</h2>
        <RoomsTable  />
    </Container>
  )
}

export default RoomsPage;