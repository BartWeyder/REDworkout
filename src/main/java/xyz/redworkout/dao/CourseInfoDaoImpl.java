package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import xyz.redworkout.model.CourseInfo;

import java.util.List;

@Repository("courseInfoDao")
public class CourseInfoDaoImpl extends AbstractDao<Integer, CourseInfo> implements CourseInfoDao{

    @Override
    public CourseInfo findById(Integer id) {
        CourseInfo courseInfo = getByKey(id);
        if (courseInfo != null) {
            Hibernate.initialize(courseInfo.getAuthor());
            Hibernate.initialize(courseInfo.getTrainingInfoList());
        }
        return courseInfo;
    }

    @Override
    public void save(CourseInfo courseInfo) {
        persist(courseInfo);
    }

    @Override
    public void deleteById(Integer id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        CourseInfo courseInfo = (CourseInfo)criteria.uniqueResult();
        delete(courseInfo);
    }

    @Override
    public List<CourseInfo> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("courseName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<CourseInfo> courseInfoDaos = (List<CourseInfo>)criteria.list();
        return courseInfoDaos;
    }
}
