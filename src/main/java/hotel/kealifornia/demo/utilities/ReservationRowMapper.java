package hotel.kealifornia.demo.utilities;

import hotel.kealifornia.demo.models.Guest;
import hotel.kealifornia.demo.models.Reservation;
import hotel.kealifornia.demo.models.Room;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// idea to use BeanPropertyRowMapper - https://stackoverflow.com/a/42990110/8421735
public class ReservationRowMapper implements RowMapper<Reservation> {


    @Override
    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
        Reservation reservation = (new BeanPropertyRowMapper<>(Reservation.class)).mapRow(resultSet, i);
        Guest guest = (new BeanPropertyRowMapper<>(Guest.class)).mapRow(resultSet, i);
        Room room = (new BeanPropertyRowMapper<>(Room.class)).mapRow(resultSet, i);
        reservation.setGuest(guest);
        reservation.setRoom(room);
        return reservation;
    }
}
