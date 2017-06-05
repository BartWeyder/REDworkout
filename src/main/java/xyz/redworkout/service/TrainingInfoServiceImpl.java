package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.redworkout.model.TrainingInfo;
import xyz.redworkout.dao.TrainingInfoDao;

import java.util.List;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

@Service("trainingInfoService")
@Transactional
public class TrainingInfoServiceImpl implements TrainingInfoService {

    @Autowired
    TrainingInfoDao dao;

    @Override
    public TrainingInfo findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<TrainingInfo> findAllTrainings() {
        return dao.findAllTrainings();
    }

    @Override
    public void saveTrainingInfo(TrainingInfo trainingInfo) {
        dao.save(trainingInfo);
    }

    @Override
    public void updateTrainingInfo(TrainingInfo trainingInfo) {
        TrainingInfo entity = dao.findById(trainingInfo.getId());
        if(entity!=null){
            entity.setTrainingName(trainingInfo.getTrainingName());
            entity.setTrainingDescription(trainingInfo.getTrainingDescription());
            entity.setCourse(trainingInfo.getCourse());
            entity.setExercises(trainingInfo.getExercises());
        }
    }

    @Override
    public void deleteTrainingInfoById(Integer id) {
        dao.deleteById(id);
    }
}
