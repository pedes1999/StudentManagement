package repository.repositoryImpl;

import domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Optional;
import repository.StudentRepository;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {

    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Student updateStudentFirstName(Integer studentId, String fname) {
        Optional<Student> student = read(studentId);
        if (student.isPresent()) {
            try {
                Student student2 = student.get();
                student2.setStudentFirstName(fname);
                entityManager.getTransaction().begin();
                entityManager.merge(student2);
                entityManager.getTransaction().commit();
                return student2;
            } catch (Exception e) {
                logger.warn("Something went wrong with updating!!");
            }
        } else {
            logger.warn("There is no student with this id! " + studentId);
        }
        return null;
    }

    @Override
    public Student updateStudentLastName(Integer studentId, String lname) {
        Optional<Student> student = read(studentId);
        if (student.isPresent()) {
            try {
                Student student2 = student.get();
                student2.setStudentLastName(lname);
                entityManager.getTransaction().begin();
                entityManager.merge(student2);
                entityManager.getTransaction().commit();
                return student2;
            } catch (Exception e) {
                logger.warn("Something went wrong with updating!!");
            }

        } else {
            logger.warn("There is no student with this id! " + studentId);

        }
        return null;
    }

    @Override
    public Optional<Student> readStudentByFirstName(String fname) {
        String nameQuery = "Select * from student where fname = ?";
        Query sqlQuery = entityManager.createNativeQuery(nameQuery, Student.class);
        sqlQuery.setParameter(1, fname);
        try {
            Student s = (Student) sqlQuery.getSingleResult();
            return Optional.of(s);
        } catch (Exception NoResultException) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Student> readStudentByLastName(String lname) {
        String nameQuery = "Select * from student where lname = ?";
        Query sqlQuery = entityManager.createNativeQuery(nameQuery, Student.class);
        sqlQuery.setParameter(1, lname);
        try {
            Student s = (Student) sqlQuery.getSingleResult();
            return Optional.of(s);
        } catch (Exception NoResultException) {
            return Optional.empty();
        }
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public String getClassName() {
        return Student.class.getName();
    }

    @Override
    public Student updateStudent(Integer id, Student newStudent) {
        Optional<Student> student = read(id);
       
        if (student.isPresent()) {
            try {
            Student student2 = student.get();
            student2.setStudentFirstName(newStudent.getStudentFirstName());
            student2.setStudentLastName(newStudent.getStudentLastName());
            student2.setStudentDateOfBirth(newStudent.getStudentDateOfBirth());
            student2.setStudentSex(newStudent.getStudentSex());
            student2.setStudentAddress(newStudent.getStudentAddress());
            entityManager.getTransaction().begin();
            entityManager.merge(student2);
            entityManager.getTransaction().commit();
            } catch (Exception e) {
                logger.warn("Something went wrong with updates",e);
            }

        }
        return student.get();
    }

}
