package service.serviceImpl;

import domain.Student;
import exceptions.ResourceNotFoundException;
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
            logger.info("Successfully inserted a student");
        } catch (Exception e) {
            logger.warn("Something went wrong!!");
        }        
        return t;
    }

    @Override
    public Optional<Student> findById(int id) {
        Optional<Student> student = null;
        try {
            student =  studentRepo.read(id);
        } catch (Exception e) {
            logger.warn("Something went wrong with finding a student!");
        }
        if(!student.isPresent()){
            logger.warn("There are no students with this id!!");
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.read();
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
