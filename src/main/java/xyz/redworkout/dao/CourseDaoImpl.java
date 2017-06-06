package xyz.redworkout.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.redworkout.model.Course;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
@Repository("courseDao")
@Transactional
public class CourseDaoImpl extends AbstractDao<Integer, Course> implements CourseDao{
    @Override
    public Course findById(Integer id) {
        Course course = getByKey(id);
        if (course != null) {
            Hibernate.initialize(course.getUser());
            Hibernate.initialize(course.getCourseInfo());
            Hibernate.initialize(course.getTrainings());
            //TODO: add more initialize if needed
        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Course> courses = (List<Course>) criteria.list();
        return courses;
    }

    @Override
    public void save(Course course) {
        persist(course);
    }

    @Override
    public void deleteById(Integer id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Course course = (Course) criteria.uniqueResult();
        delete(course);
    }
}
