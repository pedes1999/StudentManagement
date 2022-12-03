package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    T add(T t);
    Optional<T> findById(int id);
    List<T> findAll();
    void deleteById(int id);
    
    boolean isIdValid(int id);
    boolean isDateValid(LocalDate date);
    
}
