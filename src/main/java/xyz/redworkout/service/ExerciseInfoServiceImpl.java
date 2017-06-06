package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.redworkout.dao.ExerciseInfoDao;
import xyz.redworkout.model.ExerciseInfo;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */


@Service("exerciseInfoService")
@Transactional
public class ExerciseInfoServiceImpl implements ExerciseInfoService{

    @Autowired
    private ExerciseInfoDao dao;

    @Override
    public ExerciseInfo findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public ExerciseInfo findByName(String name) {
        return dao.findByExerciseName(name);
    }

    @Override
    public List<ExerciseInfo> findAllExercises() {
        return dao.findAllExercises();
    }

    @Override

    public List<ExerciseInfo> findAllPublicExercises() {
        List<ExerciseInfo> publicExercises = new ArrayList<ExerciseInfo>();
        List<ExerciseInfo> allExercises = findAllExercises();
        for (ExerciseInfo exerciseInfo : allExercises) {
            if (exerciseInfo.isPublicAccess())
                publicExercises.add(exerciseInfo);
        }
        return publicExercises;
    }


    @Override
    public void saveExerciseInfo(ExerciseInfo exerciseInfo) {
        dao.save(exerciseInfo);
    }

    @Override
    public void updateExerciseInfo(ExerciseInfo exerciseInfo) {
        ExerciseInfo entity = dao.findById(exerciseInfo.getId());
        if (entity != null) {
            entity.setExerciseName(exerciseInfo.getExerciseName());
            entity.setTags(exerciseInfo.getTags());
            entity.setDescription(exerciseInfo.getDescription());
            entity.setPublicAccess(exerciseInfo.isPublicAccess());
        }
    }

    @Override
    public void deleteExerciseInfoById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public boolean isNameUnique(Integer id, String exerciseName) {
        ExerciseInfo exerciseInfo = findByName(exerciseName);
        return (exerciseInfo == null || ((id != null) && (exerciseInfo.getId() == id)));
    }
}
