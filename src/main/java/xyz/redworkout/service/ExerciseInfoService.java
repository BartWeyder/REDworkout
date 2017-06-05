package xyz.redworkout.service;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

import xyz.redworkout.model.ExerciseInfo;
import java.util.List;

public interface ExerciseInfoService {
    ExerciseInfo findById(Integer id);
    ExerciseInfo findByName(String name);
    List<ExerciseInfo> findAllExercises();
    List<ExerciseInfo> findAllPublicExercises();
    void saveExerciseInfo(ExerciseInfo exerciseInfo);
    void updateExerciseInfo(ExerciseInfo exerciseInfo);
    void deleteExerciseInfoById(Integer id);
    boolean isNameUnique(Integer id, String exerciseName);
}
