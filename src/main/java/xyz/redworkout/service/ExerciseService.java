package xyz.redworkout.service;

import xyz.redworkout.model.Exercise;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
public interface ExerciseService {
    Exercise findExerciseById(Integer id);
    void saveExercise(Exercise exercise);
    void updateExercise(Exercise exercise);
    void deleteExerciseById(Integer id);
    List<Exercise> findAllExercises();
}
