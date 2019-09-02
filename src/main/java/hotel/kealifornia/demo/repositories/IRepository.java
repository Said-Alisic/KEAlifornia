package hotel.kealifornia.demo.repositories;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T> {

    List<T> readAll(String tableName);
    T read(String tableName, String columnName, String value);
    boolean readOne(String tableName, String value1, String value2);
    T readId(int id);
    void create(String tableName, T object);
    void update(String tableName, T object);
    void delete(String tableName, String columnName, String value);
}