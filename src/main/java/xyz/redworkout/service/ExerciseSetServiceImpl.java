package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.redworkout.dao.ExerciseSetDao;
import xyz.redworkout.model.ExerciseSet;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */

@Service("exerciseSetService")
@Transactional
public class ExerciseSetServiceImpl implements ExerciseSetService{
    @Autowired
    ExerciseSetDao dao;

    @Override
    public ExerciseSet findExerciseSetById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void saveExerciseSet(ExerciseSet exercise) {
        dao.save(exercise);
    }

    @Override
    public void updateExerciseSet(ExerciseSet exercise) {
        ExerciseSet entity = findExerciseSetById(exercise.getId());
        entity.setExercise(exercise.getExercise());
        entity.setReps(exercise.getReps());
        entity.setWeight(exercise.getWeight());
    }

    @Override
    public void deleteExerciseSetById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<ExerciseSet> findAllExerciseSets() {
        return dao.findAllExerciseSet();
    }
}
