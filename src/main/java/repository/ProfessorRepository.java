package repository;

import domain.Professor;
import java.util.Optional;

public interface ProfessorRepository extends BaseRepository<Professor> {
    Optional<Professor> readProfByFirstName(String fname);
    Optional<Professor> readProfByLastName(String lname);
    
    Professor updateProfFirstName(Integer id,String fname);
    
    Professor updateProfessor(Integer id , Professor newProfessor);
}
