package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import xyz.redworkout.model.ExerciseInfo;
import xyz.redworkout.model.User;

@Repository("exerciseInfoDao")
public class ExerciseInfoDaoImpl extends AbstractDao<Integer, ExerciseInfo> implements ExerciseInfoDao {

    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public ExerciseInfo findById(Integer id) {
        ExerciseInfo exerciseInfo = getByKey(id);
        if (exerciseInfo != null)
            Hibernate.initialize(exerciseInfo.getAuthor());
        return exerciseInfo;
    }

    @Override
    public List<ExerciseInfo> findByAuthor(User author) {
        logger.info("User: {}", author.getEmail());
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.add(Restrictions.eq("author", author));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        //very not sure
        List<ExerciseInfo> exerciseInfoList = (List<ExerciseInfo>) criteria.list();
        return exerciseInfoList;
    }

    @Override
    public ExerciseInfo findByExerciseName(String exerciseName) {
        logger.info("Exercise Name: {}", exerciseName);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("exerciseName", exerciseName));
        ExerciseInfo exerciseInfo = (ExerciseInfo) criteria.uniqueResult();
        if (exerciseInfo != null)
            Hibernate.initialize(exerciseInfo.getAuthor());
        return exerciseInfo;
    }

    @Override
    public void save(ExerciseInfo exerciseInfo) {
        persist(exerciseInfo);
    }

    @Override
    public void deleteById(Integer id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        ExerciseInfo exerciseInfo = (ExerciseInfo)criteria.uniqueResult();
        delete(exerciseInfo);
    }

    @Override
    public List<ExerciseInfo> findAllExercises() {
        Criteria criteria = createEntityCriteria().addOrder((Order.asc("exerciseName")));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<ExerciseInfo> exerciseInfoList = (List<ExerciseInfo>)criteria.list();
        return exerciseInfoList;
    }
}
