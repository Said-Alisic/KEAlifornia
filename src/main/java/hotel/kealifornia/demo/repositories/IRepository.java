package hotel.kealifornia.demo.repositories;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T> {

    List<T> readAll(String tableName);
    T read(String tableName, String columnName, String value);
    T readOne(String tableName, int value);
    T readId(int id);
    void create(String tableName, T object);
    void update(String tableName, int value, T object);
    void delete(String tableName, int value);
}