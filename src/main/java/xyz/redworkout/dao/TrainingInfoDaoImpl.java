package xyz.redworkout.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import xyz.redworkout.model.TrainingInfo;

import java.util.List;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

@Repository("trainingInfoDao")
public class TrainingInfoDaoImpl extends AbstractDao<Integer, TrainingInfo> implements TrainingInfoDao{

    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public TrainingInfo findById(Integer id) {
        TrainingInfo trainingInfo = getByKey(id);
        if(trainingInfo != null) {
            Hibernate.initialize(trainingInfo.getCourse());
            Hibernate.initialize(trainingInfo.getExercises());
        }
        return trainingInfo;
    }

    @Override
    public void save(TrainingInfo trainingInfo) {
        persist(trainingInfo);
    }

    @Override
    public void deleteById(Integer id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        TrainingInfo trainingInfo = (TrainingInfo)criteria.uniqueResult();
        delete(trainingInfo);
    }

    @Override
    public List<TrainingInfo> findAllTrainings() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<TrainingInfo> trainingInfos = (List<TrainingInfo>)criteria.list();
        return trainingInfos;
    }
}
