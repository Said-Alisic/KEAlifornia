package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Reservation;
import hotel.kealifornia.demo.utilities.ReservationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository implements IRepository<Reservation>{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Reservation> findAll() {

        String sql = "SELECT * FROM reservations " +
                "JOIN guests ON reservations.guest_id = guests.guest_id " +
                "JOIN rooms ON reservations.room_id = rooms.room_id";

        List<Reservation> reservations = jdbcTemplate.query(sql, new ReservationRowMapper());
        return reservations;
    }

    @Override
    public Reservation findOne(int id) {
        return null;
    }

    @Override
    public Reservation add(Reservation object) {
        return null;
    }

    @Override
    public Reservation update(int id, Reservation object) {
        return null;
    }

    @Override
    public Reservation delete(int id) {
        return null;
    }
}
