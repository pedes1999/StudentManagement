package service.serviceImpl;

import domain.Course;
import domain.Course;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.CourseRepository;
import service.CourseService;
import static service.serviceImpl.CourseServiceImpl.logger;
import static service.serviceImpl.StudentServiceImpl.logger;

public class CourseServiceImpl implements CourseService {

    static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class.getName());

    protected CourseRepository courseRepo;

    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public boolean updateCourse(Integer id, Course newCourse) {
        try {
            courseRepo.updateCourse(id, newCourse);
            return true;
        } catch (Exception e) {
            logger.warn("Something went wrong with updating course : " + id);
            return false;
        }
    }

    @Override
    public Course add(Course t) {
        try {
            courseRepo.create(t);
            logger.info("Successfully inserted a course with id " + t.getCourseId());
        } catch (Exception e) {
            logger.error("Something went wrong!!");
        }
        return t;
    }

    @Override
    public Optional<Course> findById(int id) {
        if (!isIdValid(id)) {
            logger.warn("This is not a valid Id");
            return Optional.empty();
        }
        Optional<Course> prof = null;
        try {
            prof = courseRepo.read(id);
        } catch (Exception e) {
            logger.error("Something went wrong with finding a student!", e);
        }
        if (!prof.isPresent()) {
            logger.warn("There is no Course with this id!");
        }
        return prof;
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.read();
    }

    @Override
    public void deleteById(int id) {
        if (!isIdValid(id)) {
            logger.warn("This is not a valid Id");
        }
        Optional<Course> pOpt = courseRepo.read(id);
        try {
            courseRepo.delete(pOpt.get());
        } catch (Exception e) {
            logger.warn("Something went wrong with deleting course with id : " + id, e);
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

}
