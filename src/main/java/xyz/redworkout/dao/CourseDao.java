package xyz.redworkout.dao;

import xyz.redworkout.model.Course;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
public interface CourseDao {
    Course findById(Integer id);
    List<Course> findAll();
    void save(Course course);
    void deleteById(Integer id);
}
