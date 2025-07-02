package dao;

import java.util.ArrayList;
import java.util.List;
import model.Course;

public class CourseDaoImpl implements BaseDao<Course> {
    private List<Course> courses = new ArrayList<>();
    
    @Override
    public boolean add(Course course) {
        return courses.add(course);
    }
    
    @Override
    public boolean delete(String courseId) {
        return courses.removeIf(c -> c.getCourseId().equals(courseId));
    }
    
    @Override
    public boolean update(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(course.getCourseId())) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Course getById(String courseId) {
        return courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Course> getAll() {
        return new ArrayList<>(courses);
    }
}
