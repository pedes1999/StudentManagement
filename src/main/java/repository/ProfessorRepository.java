package repository;

import domain.Professor;

public interface ProfessorRepository extends BaseRepository<Professor> {
    boolean updateProfFirstName(Integer id);
    
}
