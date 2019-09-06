package hotel.kealifornia.demo.repositories;

import java.util.List;

public interface IRepository<T> {

    List<T> findAll();

    T findOne(int id);

    T add(T object);

    T update(int id, T object);

    T delete(int id);
}