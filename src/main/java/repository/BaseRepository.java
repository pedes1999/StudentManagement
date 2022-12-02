
package repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    
    boolean create(T t);
    Optional<T> read (T id);
    List<T> read();
    boolean delete(T t);
}
