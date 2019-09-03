package hotel.kealifornia.demo.repositories;

import hotel.kealifornia.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
    public boolean readOne(String tableName, String value1, String value2) {
        return false;
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
    public void create(String tableName, Room object) {

    }

    @Override
    public void update(String tableName, Room object) {

    }

    @Override
    public void delete(String tableName, String columnName, String value) {

    }


}
