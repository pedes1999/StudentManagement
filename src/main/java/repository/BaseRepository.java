
package repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    
    Optional<T> create(T t);
    Optional<T> read(int id);
    List<T> read();
    boolean delete(T t);
}
