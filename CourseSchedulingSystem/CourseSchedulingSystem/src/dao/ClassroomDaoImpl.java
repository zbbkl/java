package dao;

import java.util.ArrayList;
import java.util.List;
import model.Classroom;

public class ClassroomDaoImpl implements BaseDao<Classroom> {
    private List<Classroom> classrooms = new ArrayList<>();
    
    @Override
    public boolean add(Classroom classroom) {
        return classrooms.add(classroom);
    }
    
    @Override
    public boolean delete(String roomId) {
        return classrooms.removeIf(r -> r.getRoomId().equals(roomId));
    }
    
    @Override
    public boolean update(Classroom classroom) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getRoomId().equals(classroom.getRoomId())) {
                classrooms.set(i, classroom);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Classroom getById(String roomId) {
        return classrooms.stream()
                .filter(r -> r.getRoomId().equals(roomId))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Classroom> getAll() {
        return new ArrayList<>(classrooms);
    }
}
