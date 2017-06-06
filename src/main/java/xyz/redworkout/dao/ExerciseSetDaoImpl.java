package xyz.redworkout.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.redworkout.model.ExerciseSet;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */

@Repository("exerciseSetDao")
public class ExerciseSetDaoImpl extends AbstractDao<Integer, ExerciseSet> implements ExerciseSetDao {

    @Override
    public ExerciseSet findById(Integer id) {
        ExerciseSet set = getByKey(id);
        if (set != null) {
            Hibernate.initialize(set.getExercise());
        }
        return set;
    }

    @Override
    public void save(ExerciseSet user) {
        persist(user);
    }

    @Override
    public void deleteById(Integer id) {
        ExerciseSet set = findById(id);
        delete(set);
    }

    @Override
    public List<ExerciseSet> findAllExerciseSet() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        List<ExerciseSet> sets = (List<ExerciseSet>)criteria.list();
        return sets;
    }
}
