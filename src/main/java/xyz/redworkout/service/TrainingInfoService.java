package xyz.redworkout.service;

import xyz.redworkout.model.TrainingInfo;

import java.util.List;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */
public interface TrainingInfoService {
    public TrainingInfo findById(Integer id);
    public List<TrainingInfo> findAllTrainings();
    public void saveTrainingInfo(TrainingInfo trainingInfo);
    public void updateTrainingInfo(TrainingInfo trainingInfo);
    public void deleteTrainingInfoById(Integer id);
}
