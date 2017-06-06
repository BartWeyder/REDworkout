package xyz.redworkout.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import xyz.redworkout.model.Exercise;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
@Repository("exerciseDao")
public class ExerciseDaoImpl extends AbstractDao<Integer, Exercise> implements ExerciseDao {

    @Override
    public Exercise findById(Integer id) {
        Exercise exercise = getByKey(id);
        if (exercise != null) {
            Hibernate.initialize(exercise.getExerciseInfo());
            Hibernate.initialize(exercise.getTraining());
            Hibernate.initialize(exercise.getSets());
        }
        return exercise;
    }

    @Override
    public void save(Exercise exercise) {
        persist(exercise);
    }

    @Override
    public void deleteById(Integer id) {
        Exercise exercise = findById(id);
        delete(exercise);
    }

    @Override
    public List<Exercise> findAllExercises() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        List<Exercise> exercises = (List<Exercise>)criteria.list();
        return exercises;
    }
}
