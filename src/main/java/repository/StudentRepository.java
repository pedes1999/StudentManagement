
package repository;

import domain.Student;

public interface StudentRepository extends BaseRepository<Student> {
    boolean updateStudentFistName(Integer studentId);
    boolean updateStudentLastName(Integer studentId);
}
