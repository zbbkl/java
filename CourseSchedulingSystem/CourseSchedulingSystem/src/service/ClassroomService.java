package service;

import java.util.List;
import dao.ClassroomDaoImpl;
import dao.BaseDao;
import model.Classroom;

public class ClassroomService {
    private BaseDao<Classroom> classroomDao = new ClassroomDaoImpl();
    
    public boolean addClassroom(Classroom classroom) {
        return classroomDao.add(classroom);
    }
    
    public boolean deleteClassroom(String roomId) {
        return classroomDao.delete(roomId);
    }
    
    public boolean updateClassroom(Classroom classroom) {
        return classroomDao.update(classroom);
    }
    
    public Classroom getClassroomById(String roomId) {
        return classroomDao.getById(roomId);
    }
    
    public List<Classroom> getAllClassrooms() {
        return classroomDao.getAll();
    }
}
