package xyz.redworkout.dao;

import xyz.redworkout.model.Exercise;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
public interface ExerciseDao {
    Exercise findById(Integer id);
    void save(Exercise exercise);
    void deleteById(Integer id);
    List<Exercise> findAllExercises();
}
