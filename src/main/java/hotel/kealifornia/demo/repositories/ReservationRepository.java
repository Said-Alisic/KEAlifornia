package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Reservation;
import hotel.kealifornia.demo.utilities.ReservationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
    public Reservation add(Reservation reservation) {

        String sql = "INSERT INTO reservations VALUES (null, ?, ?, ?, ?, ?)";

        KeyHolder keyholder = new GeneratedKeyHolder();

        jdbcTemplate.update(Connection -> {
            PreparedStatement ps = Connection.prepareStatement(sql, new String[]{"guest_id"});
            ps.setDate(1, java.sql.Date.valueOf(reservation.getCheckInDay()));
            ps.setDate(2, java.sql.Date.valueOf(reservation.getCheckOutDay()));
            ps.setInt(3, reservation.getGuest().getGuestId());
            ps.setInt(4, reservation.getRoom().getRoomId());
            ps.setDouble(5, reservation.getTotal());


            return ps;}, keyholder);

        reservation.setReservationId(keyholder.getKey().intValue());

        return reservation;
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
