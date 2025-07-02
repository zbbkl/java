package service;

import java.util.List;
import dao.ScheduleDaoImpl;
import dao.BaseDao;
import model.Schedule;
import model.Course;
import model.Teacher;
import model.Classroom;

public class ScheduleService {
    private BaseDao<Schedule> scheduleDao = new ScheduleDaoImpl();
    private CourseService courseService = new CourseService();
    private TeacherService teacherService = new TeacherService();
    private ClassroomService classroomService = new ClassroomService();
    
    public boolean addSchedule(Schedule schedule) {
        // 验证关联对象是否存在
        if (courseService.getCourseById(schedule.getCourse().getCourseId()) == null ||
            teacherService.getTeacherById(schedule.getTeacher().getTeacherId()) == null ||
            classroomService.getClassroomById(schedule.getClassroom().getRoomId()) == null) {
            return false;
        }
        return scheduleDao.add(schedule);
    }
    
    public boolean deleteSchedule(String scheduleId) {
        return scheduleDao.delete(scheduleId);
    }
    
    public boolean updateSchedule(Schedule schedule) {
        // 验证关联对象是否存在
        if (courseService.getCourseById(schedule.getCourse().getCourseId()) == null ||
            teacherService.getTeacherById(schedule.getTeacher().getTeacherId()) == null ||
            classroomService.getClassroomById(schedule.getClassroom().getRoomId()) == null) {
            return false;
        }
        return scheduleDao.update(schedule);
    }
    
    public Schedule getScheduleById(String scheduleId) {
        return scheduleDao.getById(scheduleId);
    }
    
    public List<Schedule> getAllSchedules() {
        return scheduleDao.getAll();
    }
    
    // 根据条件查询排课
    public List<Schedule> findSchedules(String courseId, String teacherId, String roomId) {
        List<Schedule> all = scheduleDao.getAll();
        List<Schedule> result = new ArrayList<>();
        
        for (Schedule s : all) {
            boolean match = true;
            if (courseId != null && !courseId.isEmpty() && 
                !s.getCourse().getCourseId().equals(courseId)) {
                match = false;
            }
            if (teacherId != null && !teacherId.isEmpty() && 
                !s.getTeacher().getTeacherId().equals(teacherId)) {
                match = false;
            }
            if (roomId != null && !roomId.isEmpty() && 
                !s.getClassroom().getRoomId().equals(roomId)) {
                match = false;
            }
            if (match) {
                result.add(s);
            }
        }
        return result;
    }
}
