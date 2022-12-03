package service.serviceImpl;

import domain.Professor;
import exceptions.ResourceNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.ProfessorRepository;
import service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

    static final Logger logger = LoggerFactory.getLogger(ProfessorServiceImpl.class.getName());

    protected ProfessorRepository profRepo;

    public ProfessorServiceImpl(ProfessorRepository profRepo) {
        this.profRepo = profRepo;
    }

    @Override
    public Professor add(Professor t) {
        try {
            profRepo.create(t);
            logger.info("Successfully inserted a professor with id " + t.getProfessorId());
        } catch (Exception e) {
            logger.error("Something went wrong!!");
        }
        return t;
    }

    @Override
    public Optional<Professor> findById(int id) {
        if (!isIdValid(id)) {
            logger.warn("This is not a valid Id");
            return Optional.empty();
        }
        Optional<Professor> prof = null;
        try {
            prof = profRepo.read(id);
        } catch (Exception e) {
            logger.error("Something went wrong with finding a student!", e);
        }
        if (!prof.isPresent()) {
            logger.warn("There is no Professor with this id!");
        }
        return prof;
    }

    @Override
    public List<Professor> findAll() {
        return profRepo.read();
    }

    @Override
    public void deleteById(int id) {
        if (!isIdValid(id)) {
            logger.warn("This is not a valid Id");
        }
        Optional<Professor> pOpt = profRepo.read(id);
        try {
            profRepo.delete(pOpt.get());
        } catch (Exception e) {
            logger.warn("Something went wrong with deleting professor with id : " + id, e);
        }
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
    public Professor searchProfWithFirstName(String fname) {
        Optional<Professor> pOpt = null;
        try {
            pOpt = profRepo.readProfByFirstName(fname);
            return pOpt.get();
        } catch (Exception e) {
            logger.warn("Something went wrong with finding a professor", e);
        }
        return null;
    }

    @Override
    public Professor searchProfWithLastName(String lname) {
        Optional<Professor> pOpt = null;
        try {
            pOpt = profRepo.readProfByLastName(lname);
            return pOpt.get();
        } catch (Exception e) {
            logger.warn("Something went wrong with finding a professor", e);
        }
        return null;
    }

}
