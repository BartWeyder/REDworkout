package xyz.redworkout.service;

import xyz.redworkout.model.Course;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */

public interface CourseService {
    Course findById(int id);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(Integer id);
    List<Course> findAllCourses();
    List<Course> findAllActiveCourses();
    List<Course> findAllDoneCourses();
}
