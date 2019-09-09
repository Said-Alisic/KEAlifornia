package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class GuestRepository implements IRepository<Guest> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Guest> findAll() {

        return null;
    }

    @Override
    public Guest findOne(int id) {
        return null;
    }

    @Override
    public Guest add(Guest guest) {

        String sql = "INSERT INTO guests VALUES (null, ?, ?, ?, ?)";

        KeyHolder keyholder = new GeneratedKeyHolder();

        jdbcTemplate.update(Connection -> {
            PreparedStatement ps = Connection.prepareStatement(sql, new String[]{"guest_id"});
            ps.setString(1, guest.getFirstName());
            ps.setString(2, guest.getLastName());
            ps.setString(3, guest.getPhoneNo());
            ps.setString(4, guest.getEmail());


            return ps;}, keyholder);

        guest.setGuestId(keyholder.getKey().intValue());

        return guest;
    }

    @Override
    public Guest update(int id, Guest object) {
        return null;
    }

    @Override
    public Guest delete(int id) {
        return null;
    }
}
