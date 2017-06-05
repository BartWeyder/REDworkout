package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

import xyz.redworkout.model.TrainingInfo;

import java.util.List;

public interface TrainingInfoDao {
    TrainingInfo findById(Integer id);
    void save (TrainingInfo trainingInfo);
    void deleteById(Integer id);
    List<TrainingInfo> findAllTrainings();
}
