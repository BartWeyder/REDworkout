package xyz.redworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.redworkout.dao.CourseInfoDao;
import xyz.redworkout.model.CourseInfo;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Eugenij Kizim on 05-Jun-17.
 */

@Service("courseInfoService")
@Transactional
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    CourseInfoDao dao;

    @Override
    public CourseInfo findCourseInfoById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void saveCourseInfo(CourseInfo courseInfo) {
        dao.save(courseInfo);
    }

    @Override
    public void deleteCourseInfoById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public void updateCourseInfo(CourseInfo courseInfo) {
        CourseInfo entity = dao.findById(courseInfo.getId());
        if (entity != null) {
            entity.setAuthor(courseInfo.getAuthor());
            entity.setCourseDescription(courseInfo.getCourseDescription());
            entity.setCourseName(courseInfo.getCourseName());
            entity.setDuration(courseInfo.getDuration());
            entity.setTrainingInfoList(courseInfo.getTrainingInfoList());
            entity.setPrice(courseInfo.getPrice());
            entity.setPublicAccess(courseInfo.isPublicAccess());
            entity.setTrainingsPerWeek(courseInfo.getTrainingsPerWeek());
        }
    }

    @Override
    public List<CourseInfo> findAllCourseInfos() {
        return dao.findAll();
    }
}
