package xyz.redworkout.service;

import xyz.redworkout.model.Training;

import java.util.Date;
import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
public interface TrainingService {
    Training findTrainingById(int id);
    void saveTraining(Training training);
    void updateTraining(Training training);
    void deleteTrainingById(Integer id);
    List<Training> findAllTrainings();
    List<Training> findTrainingsByDate(Date date);
}
