
package repository;

import domain.Course;

public interface CourseRepository extends BaseRepository<Course>{
    boolean updateCourseName(Integer id);
    
    Course updateCourse(Integer id , Course newCourse);
}
