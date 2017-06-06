package xyz.redworkout.dao;

import xyz.redworkout.model.ExerciseSet;

import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
public interface ExerciseSetDao {
    ExerciseSet findById(Integer id);

    void save(ExerciseSet user);

    void deleteById(Integer id);

    List<ExerciseSet> findAllExerciseSet();
}
