package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RoomRepository implements IRepository<Room> {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Room> readAll(String tableName) {

        String sql = "SELECT * FROM rooms;";
        List<Room> rooms = jdbc.query(sql, new BeanPropertyRowMapper<>(Room.class));

        return rooms;
    }

    @Override
    public Room readOne(String tableName, int id) {

        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        Room room = jdbc.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Room.class));

        return new Room();
    }

    @Override
    public Room read(String tableName, String columnName, String value) {
        return null;
    }

    @Override
    public Room readId(int id) {
        return null;
    }

    @Override
    public void create(String tableName, Room room) {

        String sql = "INSERT INTO rooms VALUES (null, ?, ?, ?)";

        PreparedStatementCreator psc = Connection -> {
            PreparedStatement ps = Connection.prepareStatement(sql, new String[]{"room_id"});
            ps.setString(1, room.getName());
            ps.setDouble(2, room.getPrice());
            ps.setInt(3, room.getNumOfGuests());
            return ps;
        };
    }

    @Override
    public void update(String tableName, int id, Room object) {

    }

    @Override
    public void delete(String tableName, int id) {

        String sql = "DELETE FROM rooms WHERE room_id = " + id;
        jdbc.update(sql);
        
    }


}
