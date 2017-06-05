package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

import java.util.List;
import xyz.redworkout.model.ExerciseInfo;
import xyz.redworkout.model.User;

public interface ExerciseInfoDao {
    ExerciseInfo findById(Integer id);

    //Not sure
    //ExerciseInfo findByAuthor (Integer authorId);
    List<ExerciseInfo> findByAuthor (User author);

    ExerciseInfo findByExerciseName(String exerciseName);

    void save (ExerciseInfo exerciseInfo);

    void deleteById(Integer id);

    List<ExerciseInfo> findAllExercises();


}
