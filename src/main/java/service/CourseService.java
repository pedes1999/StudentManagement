
package service;

import domain.Course;

public interface CourseService extends BaseService<Course>{
    boolean updateCourse(Integer id,Course newCourse);
}
