package repository.repositoryImpl;

import domain.Course;
import domain.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.ProfessorRepository;
import service.serviceImpl.StudentServiceImpl;

public class ProfessorRepositoryImpl extends BaseRepositoryImpl<Professor> implements ProfessorRepository {

    static final Logger logger = LoggerFactory.getLogger(ProfessorRepositoryImpl.class.getName());

    public ProfessorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }

    @Override
    public Professor updateProfFirstName(Integer id, String fname) {
        Optional<Professor> prof = read(id);
        if (!prof.isPresent()) {
            logger.warn("There is no Professor with this id");
        }
        prof.get().setProfFirstName(fname);
        return prof.get();
    }

    @Override
    public String getClassName() {
        return Professor.class.getName();
    }

    @Override
    public Optional<Professor> readProfByFirstName(String fname) {
        String fnameQuery = "Select * from professor where fname = ?";
        Query sqlQuery = entityManager.createNativeQuery(fnameQuery, Professor.class);
        sqlQuery.setParameter(1, fname);
        try {
            Professor p = (Professor) sqlQuery.getSingleResult();
            return Optional.of(p);
        } catch (Exception e) {
            logger.warn("There are no professors with this first name");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Professor> readProfByLastName(String lname) {
        String fnameQuery = "Select * from professor where lname = ?";
        Query sqlQuery = entityManager.createNativeQuery(fnameQuery, Professor.class);
        sqlQuery.setParameter(1, lname);
        try {
            Professor p = (Professor) sqlQuery.getSingleResult();
            return Optional.of(p);
        } catch (Exception e) {
            logger.warn("There are no professors with this last name");
            return Optional.empty();
        }
    }

}
