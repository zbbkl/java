package service;

import java.util.List;
import dao.BaseDao;
import dao.TeacherDaoImpl;
import model.Teacher;

public class TeacherService {
    private BaseDao<Teacher> teacherDao = new TeacherDaoImpl();
    
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.add(teacher);
    }
    public boolean deleteTeacher(String teacherId) {
        return teacherDao.delete(teacherId);
    }
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.update(teacher);
    }
    public Teacher getTeacherById(String teacherId) {
        return teacherDao.getById(teacherId);
    }
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAll();
    }
}