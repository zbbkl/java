package dao;

import java.util.ArrayList;
import java.util.List;
import model.Teacher;

public class TeacherDaoImpl implements BaseDao<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();
    
    @Override
    public boolean add(Teacher teacher) {
        return teachers.add(teacher);
    }
    
    @Override
    public boolean delete(String teacherId) {
        return teachers.removeIf(t -> t.getTeacherId().equals(teacherId));
    }
    
    @Override
    public boolean update(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId().equals(teacher.getTeacherId())) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Teacher getById(String teacherId) {
        return teachers.stream()
                .filter(t -> t.getTeacherId().equals(teacherId))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Teacher> getAll() {
        return new ArrayList<>(teachers);
    }
}

