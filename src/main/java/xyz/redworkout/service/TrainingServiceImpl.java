package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.redworkout.dao.TrainingDao;
import xyz.redworkout.model.Training;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */
@Service("trainingService")
@Transactional
public class TrainingServiceImpl implements TrainingService{

    @Autowired
    TrainingDao dao;

    @Override
    public Training findTrainingById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveTraining(Training training) {
        dao.save(training);
    }

    @Override
    public void updateTraining(Training training) {
        Training entity = dao.findById(training.getId());
        if (entity != null){
            entity.setCourse(training.getCourse());
            entity.setDate(training.getDate());
            entity.setExerciseList(training.getExerciseList());
            entity.setName(training.getName());
            entity.setTrainingInfo(training.getTrainingInfo());
        }
    }

    @Override
    public void deleteTrainingById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Training> findAllTrainings() {
        return dao.findAll();
    }

    @Override
    public List<Training> findTrainingsByDate(Date date) {
        List<Training> trainings = findAllTrainings();
        List<Training> trainingsByDate = new ArrayList<>();
        for (Training training: trainings) {
            if (training.getDate().equals(date))
                trainingsByDate.add(training);
        }
        return trainingsByDate;
    }
}
