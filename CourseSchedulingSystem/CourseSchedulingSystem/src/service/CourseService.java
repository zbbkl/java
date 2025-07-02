package service;

import java.util.List;
import dao.CourseDaoImpl;
import dao.BaseDao;
import model.Course;

public class CourseService {
    private BaseDao<Course> courseDao = new CourseDaoImpl();
    
    public boolean addCourse(Course course) {
        return courseDao.add(course);
    }
    
    public boolean deleteCourse(String courseId) {
        return courseDao.delete(courseId);
    }
    
    public boolean updateCourse(Course course) {
        return courseDao.update(course);
    }
    
    public Course getCourseById(String courseId) {
        return courseDao.getById(courseId);
    }
    
    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }
}
