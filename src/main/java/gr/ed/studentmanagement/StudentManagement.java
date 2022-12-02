package gr.ed.studentmanagement;

import domain.Student;
import gr.ed.studentmanagement.util.JpaUtil;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.CourseRepository;
import repository.ProfessorRepository;
import repository.StudentRepository;
import repository.repositoryImpl.CourseRepositoryImpl;
import repository.repositoryImpl.ProfessorRepositoryImpl;
import repository.repositoryImpl.StudentRepositoryImpl;
import service.StudentService;
import service.serviceImpl.StudentServiceImpl;

public class StudentManagement {
    private static final Logger logger = LoggerFactory.getLogger(StudentManagement.class);

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        StudentRepository studentRepo = new StudentRepositoryImpl(entityManager);
        ProfessorRepository profRepo = new ProfessorRepositoryImpl(entityManager);
        CourseRepository courseRepo = new CourseRepositoryImpl(entityManager);
        StudentService studentService = new StudentServiceImpl(studentRepo);
        
        Student s = new Student();
        s.setStudentFirstName("asd");
        s.setStudentLastName("sds");
        studentService.add(s);
        
        System.out.println(studentService.findAll());
    }
}
