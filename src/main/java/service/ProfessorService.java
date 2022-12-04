
package service;

import domain.Professor;
import domain.Student;

public interface ProfessorService extends BaseService<Professor>{
    Professor searchProfWithFirstName(String fname);
    Professor searchProfWithLastName(String lname);
    
    boolean updateProfessor(int id,Professor newProfessor);
}
