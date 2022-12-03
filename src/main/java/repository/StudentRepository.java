
package repository;

import domain.Student;
import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student> {
    Student updateStudentFirstName(Integer studentId,String fname);
    Student updateStudentLastName(Integer studentId,String lname);
    
    Optional<Student> readStudentByFirstName(String fname);
    Optional<Student> readStudentByLastName(String lname);
}
