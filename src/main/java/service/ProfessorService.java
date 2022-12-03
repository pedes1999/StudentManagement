
package service;

import domain.Professor;

public interface ProfessorService extends BaseService<Professor>{
    Professor searchProfWithFirstName(String fname);
    Professor searchProfWithLastName(String lname);
}
