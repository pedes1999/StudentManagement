package gr.ed.studentmanagement;

import forms.LoginForm;
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
import service.ProfessorService;
import service.StudentService;
import service.serviceImpl.ProfessorServiceImpl;
import service.serviceImpl.StudentServiceImpl;
import util.DataImport;

public class StudentManagement {

    private static final Logger logger = LoggerFactory.getLogger(StudentManagement.class);

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        StudentRepository studentRepo = new StudentRepositoryImpl(entityManager);
        ProfessorRepository profRepo = new ProfessorRepositoryImpl(entityManager);
        CourseRepository courseRepo = new CourseRepositoryImpl(entityManager);
        StudentService studentService = new StudentServiceImpl(studentRepo);
        ProfessorService profService = new ProfessorServiceImpl(profRepo);
        DataImport di = new DataImport(studentService,profService);
        
        //di.insertStudents();
       // di.insertProfessors();
//       LoginForm lf = new LoginForm(entityManager);
//       lf.setVisible(true);
       
    }
}
