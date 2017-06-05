package xyz.redworkout.service;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

import xyz.redworkout.model.CourseInfo;

import java.util.List;

public interface CourseInfoService  {
    CourseInfo findCourseInfoById(Integer id);
    void saveCourseInfo(CourseInfo courseInfo);
    void deleteCourseInfoById(Integer id);
    void updateCourseInfo(CourseInfo courseInfo);
    List<CourseInfo> findAllCourseInfos();
}
