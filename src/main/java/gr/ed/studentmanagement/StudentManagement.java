package gr.ed.studentmanagement;

import gr.ed.studentmanagement.util.JpaUtil;
import jakarta.persistence.EntityManager;
import repository.CourseRepository;
import repository.ProfessorRepository;
import repository.StudentRepository;
import repository.repositoryImpl.CourseRepositoryImpl;
import repository.repositoryImpl.ProfessorRepositoryImpl;
import repository.repositoryImpl.StudentRepositoryImpl;

public class StudentManagement {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        StudentRepository studentRepo = new StudentRepositoryImpl(entityManager);
        ProfessorRepository profRepo = new ProfessorRepositoryImpl(entityManager);
        CourseRepository courseRepo = new CourseRepositoryImpl(entityManager);
    }
}
