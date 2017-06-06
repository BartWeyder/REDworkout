package xyz.redworkout.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;

import org.springframework.stereotype.Repository;
import xyz.redworkout.model.Training;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
@Repository("trainingDao")
public class TrainingDaoImpl extends AbstractDao<Integer, Training> implements TrainingDao {

    @Override
    public Training findById(Integer id) {
        Training training = getByKey(id);
        if (training != null) {
            Hibernate.initialize(training.getCourse());
            Hibernate.initialize(training.getExerciseList());
            Hibernate.initialize(training.hashCode());
        }
        return training;
    }

    @Override
    public List<Training> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("date"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Training> trainings = (List<Training>)criteria.list();
        return trainings;
    }

    @Override
    public void save(Training training) {
        persist(training);
    }

    @Override
    public void deleteById(Integer id) {
        Training training = findById(id);
        delete(training);
    }
}
