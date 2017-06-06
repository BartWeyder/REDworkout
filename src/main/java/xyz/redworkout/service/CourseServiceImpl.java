package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.redworkout.dao.CourseDao;
import xyz.redworkout.model.Course;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao dao;

    @Override
    public Course findById(int id) {
        Course course = dao.findById(id);
        return course;
    }

    @Override
    public void saveCourse(Course course) {
        dao.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        Course entity = dao.findById(course.getId());
        if (entity != null) {
            entity.setActive(course.isActive());
            entity.setCourseInfo(course.getCourseInfo());
            entity.setDone(course.isDone());
            entity.setTrainings(course.getTrainings());
            entity.setTrainingsDone(course.getTrainingsDone());
            entity.setUser(course.getUser());
        }
    }

    @Override
    public void deleteCourseById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Course> findAllCourses() {
        return dao.findAll();
    }

    @Override
    public List<Course> findAllActiveCourses() {
        List<Course> courses = findAllCourses();
        List<Course> activeCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.isActive())
                activeCourses.add(course);
        }
        return activeCourses;
    }

    @Override
    public List<Course> findAllDoneCourses() {
        List<Course> courses = findAllCourses();
        List<Course> activeCourses = new ArrayList<>();
        for (Course course: courses) {
            if (course.isDone())
                activeCourses.add(course);
        }
        return activeCourses;
    }
}
