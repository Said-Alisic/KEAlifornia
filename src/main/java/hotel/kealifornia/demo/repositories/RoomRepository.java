package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RoomRepository implements IRepository<Room> {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Room> findAll() {

        String sql = "SELECT * FROM rooms;";
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
    public Room add(Room room) throws NullPointerException {

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

            return ps;});

        return room;

    }

    @Override
    public Room delete(int id) {

        String sql = "DELETE FROM rooms WHERE room_id = " + id;
        jdbc.update(sql);

        return null;
    }


}
