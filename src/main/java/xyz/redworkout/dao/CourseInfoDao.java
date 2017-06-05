package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

import xyz.redworkout.model.CourseInfo;

import java.util.List;


public interface CourseInfoDao  {
    CourseInfo findById(Integer id);
    void save (CourseInfo courseInfo);
    void deleteById(Integer id);
    List<CourseInfo> findAll();

}
