package repository.repositoryImpl;

import domain.Course;
import jakarta.persistence.EntityManager;
import repository.CourseRepository;

public class CourseRepositoryImpl extends BaseRepositoryImpl<Course> implements CourseRepository {

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public boolean updateCourseName(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getClassName() {
        return Course.class.getName();
    }

}
