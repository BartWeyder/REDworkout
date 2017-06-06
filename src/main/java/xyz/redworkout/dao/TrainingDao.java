package xyz.redworkout.dao;

import xyz.redworkout.model.Training;

import java.util.Date;
import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */

public interface TrainingDao {
    Training findById(Integer id);
    List<Training> findAll();
    void save(Training training);
    void deleteById(Integer id);
}
