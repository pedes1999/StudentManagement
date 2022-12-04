package service;

import domain.Student;

public interface StudentService extends BaseService<Student>{
    Student searchStudentByFirstName(String fname);
    Student searchStudentByLastName(String lname);
    
    boolean updateStudentFirstName(int id ,String fname);
    boolean updateStudentLastName(int id ,String fname);
    
    boolean updateStudent(int id,Student newStudent);
}
