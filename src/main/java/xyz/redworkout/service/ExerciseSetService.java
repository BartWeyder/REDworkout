package xyz.redworkout.service;

import xyz.redworkout.model.ExerciseSet;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
public interface ExerciseSetService {
    ExerciseSet findExerciseSetById(Integer id);

    void saveExerciseSet(ExerciseSet set);

    void updateExerciseSet(ExerciseSet set);

    void deleteExerciseSetById(Integer id);

    List<ExerciseSet> findAllExerciseSets();
}
