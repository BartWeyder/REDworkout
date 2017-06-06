package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import xyz.redworkout.dao.ExerciseDao;
import xyz.redworkout.model.Exercise;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */

@Service("exerciseService")
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseDao dao;

    @Override
    public Exercise findExerciseById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void saveExercise(Exercise exercise) {
        dao.save(exercise);
    }

    @Override
    public void updateExercise(Exercise exercise) {
        Exercise entity = dao.findById(exercise.getId());
        if (entity != null) {
            entity.setExerciseInfo(exercise.getExerciseInfo());
            entity.setSets(exercise.getSets());
            entity.setTraining(exercise.getTraining());
        }
    }

    @Override
    public void deleteExerciseById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Exercise> findAllExercises() {
        return dao.findAllExercises();
    }
}
