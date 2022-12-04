package repository.repositoryImpl;

import domain.Course;
import jakarta.persistence.EntityManager;
import java.util.Optional;
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

    @Override
    public Course updateCourse(Integer id, Course newCourse) {
        Optional<Course> course  = read(id);
       
        if (course.isPresent()) {
            try {
            Course course2 = course.get();
            course2.setCourseName(newCourse.getCourseName());
            course2.setStartDate(newCourse.getStartDate());
            course2.setEndDate(newCourse.getEndDate());
            course2.setCourseProfessor(newCourse.getCourseProfessor());
            entityManager.getTransaction().begin();
            entityManager.merge(course2);
            entityManager.getTransaction().commit();
            } catch (Exception e) {
                logger.warn("Something went wrong with updates",e);
            }

        }
        return course.get();
    }

}
