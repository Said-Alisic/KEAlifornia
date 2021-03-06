package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Room;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomRepository implements IRepository<Room> {

    @Autowired
    JdbcTemplate jdbc;

    // https://arnaudroger.github.io/blog/2017/06/13/jdbc-template-one-to-many.html
    private final ResultSetExtractor<List<Room>> resultSetExtractor =
            JdbcTemplateMapperFactory
                .newInstance()
                .addKeys("roomId")
                .newResultSetExtractor(Room.class);


    // Method calls prepared statement from mysql and gets back available rooms in the provided period
    public List<Room> findRoomsBetweenDates(LocalDate checkInDate, LocalDate checkOutDate) {

        String sql = "CALL get_free_rooms_between_dates(?, ?)";

        List<Room> rooms = jdbc.query(sql, new Object[] {checkInDate, checkOutDate}, new BeanPropertyRowMapper<>(Room.class));

        return rooms;
    }



    @Override
    public List<Room> findAll() {
//        String sql =
//                "SELECT r.room_id as roomId, r.name, r.price, r.num_of_guests," +
//                   " res.reservation_id as reservations_reservation_id, res.check_in_day as reservations_check_in_day," +
//                   " res.check_out_day as reservations_check_out__day" +
//                 " FROM rooms r" +
//                    " JOIN reservations res ON res.room_id = r.room_id;";

        String sql = "SELECT * FROM rooms";


        List<Room> rooms = jdbc.query(sql, new BeanPropertyRowMapper<>(Room.class));
        return rooms;
    }

    @Override
    public Room findOne(int id) {
        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        Room room = jdbc.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Room.class));

        return room;
    }


    @Override
    public Room add(Room room) {
        String sql = "INSERT INTO rooms VALUES (null, ?, ?, ?)";

        KeyHolder keyholder = new GeneratedKeyHolder();

        jdbc.update(Connection -> {
            PreparedStatement ps = Connection.prepareStatement(sql, new String[]{"room_id"});
            ps.setString(1, room.getName());
            ps.setDouble(2, room.getPrice());
            ps.setInt(3, room.getNumOfGuests());

            return ps;}, keyholder);

        room.setRoomId(keyholder.getKey().intValue());

        return room;
    }

    @Override
    public Room update(int id, Room room) {

        String sql = "UPDATE rooms SET name = ?, price = ?, num_of_guests = ? WHERE room_id = " + id;

        jdbc.update(Connection -> {
            PreparedStatement ps = Connection.prepareStatement(sql, new String[]{"room_id"});
            ps.setString(1, room.getName());
            ps.setDouble(2, room.getPrice());
            ps.setInt(3, room.getNumOfGuests());

            return ps;
        });

        return room;
    }


    @Override
    public Room delete(int id) {
        String sql = "DELETE FROM rooms WHERE room_id = " + id;
        jdbc.update(sql);

        return new Room();
    }
}
