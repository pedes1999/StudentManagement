package repository.repositoryImpl;

import domain.Course;
import domain.Student;
import jakarta.persistence.EntityManager;
import repository.StudentRepository;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {

    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean updateStudentFistName(Integer studentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateStudentLastName(Integer studentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public String getClassName() {
        return Student.class.getName();
    }

}
