package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Guest;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.SqlParameterSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class GuestRepository implements IRepository<Guest> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // https://simpleflatmapper.org/0104-getting-started-springjdbc.html
    private final RowMapper<Guest> rowMapper =
            JdbcTemplateMapperFactory.newInstance().newRowMapper(Guest.class);


    // Testing different way of inserting objects into database table
    private final SqlParameterSourceFactory<Guest> parameterSourceFactory =
            JdbcTemplateMapperFactory
                    .newInstance()
                    .newSqlParameterSourceFactory(Guest.class);

    @Override
    public List<Guest> findAll() {

        String sql = "SELECT * FROM guests";

        return jdbcTemplate.query(sql, rowMapper);
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
            ps.setString(1, guest.getName());
            ps.setString(2, guest.getPhoneNo());
            ps.setString(3, guest.getEmail());
            ps.setInt(4, guest.getAwardPoints());


            return ps;}, keyholder);

        guest.setGuestId(keyholder.getKey().intValue());

        return guest;
    }

    // Gonna test after finishing controllers and view
    public Guest addGuestTest(Guest guest) {

        String sql = "INSERT INTO guests(name, phone, email, award_points)" +
                " VALUES (:name, :phone, :email, :award_points)";

        KeyHolder keyholder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, parameterSourceFactory.newSqlParameterSource(guest), keyholder);

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
