package repository.repositoryImpl;

import domain.Course;
import domain.Professor;
import jakarta.persistence.EntityManager;
import repository.ProfessorRepository;

public class ProfessorRepositoryImpl extends BaseRepositoryImpl<Professor> implements ProfessorRepository {

    public ProfessorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }

    @Override
    public boolean updateProfFirstName(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getClassName() {
        return Professor.class.getName();
    }

}
