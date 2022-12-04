package service.serviceImpl;

import domain.Student;
import exceptions.ResourceNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.StudentRepository;
import service.StudentService;

public class StudentServiceImpl implements StudentService {

    static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class.getName());

    protected StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student add(Student t) {
        try {
            studentRepo.create(t);
            logger.info("Successfully inserted a student with id " + t.getStudentId());
        } catch (Exception e) {
            logger.error("Something went wrong!!");
        }
        return t;
    }

    @Override
    public Optional<Student> findById(int id) {
        if (!isIdValid(id)) {
            logger.warn("This is not a valid Id");
            return Optional.empty();
        }
        Optional<Student> student = null;
        try {
            student = studentRepo.read(id);
        } catch (Exception e) {
            logger.error("Something went wrong with finding a student!", e);
        }
        if (!student.isPresent()) {
            logger.warn("There is no student with this id!");
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.read();
    }

    @Override
    public void deleteById(int id) {
        if (!isIdValid(id)) {
            logger.warn("This is not a valid Id");
        }
        Optional<Student> sOpt = studentRepo.read(id);
        try {
            studentRepo.delete(sOpt.get());
        } catch (Exception e) {
            logger.warn("Something went wrong with deleting a student", e);
        }
    }

    @Override
    public Student searchStudentByFirstName(String fname) {
        Optional<Student> sOpt = null;
        try {
            sOpt = studentRepo.readStudentByFirstName(fname);
            return sOpt.get();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Something went wrong with finding a student!");
        }
        return null;
    }

    @Override
    public Student searchStudentByLastName(String lname) {
        Optional<Student> sOpt = null;
        try {
            sOpt = studentRepo.readStudentByLastName(lname);
            return sOpt.get();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Something went wrong with finding a student!", e);
        }
        return null;
    }

    @Override
    public boolean isDateValid(LocalDate date) {
        return date.getYear() > 1995;
    }

    @Override
    public boolean isIdValid(int id) {
        return id > 0;
    }

    @Override
    public boolean updateStudentFirstName(int id, String fname) {
        try {
            studentRepo.updateStudentFirstName(id, fname);
            return true;
        } catch (Exception e) {
            logger.warn("Something went wrong with updating student : " + id);
            return false;
        }
    }

    @Override
    public boolean updateStudentLastName(int id, String lname) {
        try {
            studentRepo.updateStudentLastName(id, lname);
            return true;
        } catch (Exception e) {
            logger.warn("Something went wrong with updating student : " + id);
            return false;
        }
    }

    @Override
    public boolean updateStudent(int id, Student newStudent) {
        try {
            studentRepo.updateStudent(id, newStudent);
            return true;
        }  catch (Exception e) {
            logger.warn("Something went wrong with updating student : " + id);
            return false;
        }
    }
}
