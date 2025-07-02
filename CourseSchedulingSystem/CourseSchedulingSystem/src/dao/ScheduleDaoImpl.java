package dao;

import java.util.ArrayList;
import java.util.List;
import model.Schedule;

public class ScheduleDaoImpl implements BaseDao<Schedule> {
    private List<Schedule> schedules = new ArrayList<>();
    
    @Override
    public boolean add(Schedule schedule) {
        // 检查冲突
        if (hasConflict(schedule)) {
            return false;
        }
        return schedules.add(schedule);
    }
    
    @Override
    public boolean delete(String scheduleId) {
        return schedules.removeIf(s -> s.getScheduleId().equals(scheduleId));
    }
    
    @Override
    public boolean update(Schedule schedule) {
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getScheduleId().equals(schedule.getScheduleId())) {
                // 检查冲突，排除自身
                if (hasConflict(schedule, schedule.getScheduleId())) {
                    return false;
                }
                schedules.set(i, schedule);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Schedule getById(String scheduleId) {
        return schedules.stream()
                .filter(s -> s.getScheduleId().equals(scheduleId))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Schedule> getAll() {
        return new ArrayList<>(schedules);
    }
    
    // 检查排课冲突
    private boolean hasConflict(Schedule newSchedule) {
        return schedules.stream().anyMatch(existing -> 
            (existing.getClassroom().getRoomId().equals(newSchedule.getClassroom().getRoomId()) && 
             existing.getTime().equals(newSchedule.getTime()) && 
             isWeekOverlap(existing, newSchedule)) ||
            (existing.getTeacher().getTeacherId().equals(newSchedule.getTeacher().getTeacherId()) && 
             existing.getTime().equals(newSchedule.getTime()) && 
             isWeekOverlap(existing, newSchedule))
        );
    }
    
    // 检查排课冲突，排除指定ID的记录
    private boolean hasConflict(Schedule newSchedule, String excludeId) {
        return schedules.stream().anyMatch(existing -> 
            !existing.getScheduleId().equals(excludeId) &&
            ((existing.getClassroom().getRoomId().equals(newSchedule.getClassroom().getRoomId()) && 
              existing.getTime().equals(newSchedule.getTime()) && 
              isWeekOverlap(existing, newSchedule)) ||
             (existing.getTeacher().getTeacherId().equals(newSchedule.getTeacher().getTeacherId()) && 
              existing.getTime().equals(newSchedule.getTime()) && 
              isWeekOverlap(existing, newSchedule)))
        );
    }
    
    // 检查周次是否重叠
    private boolean isWeekOverlap(Schedule s1, Schedule s2) {
        return !(s1.getWeekEnd() < s2.getWeekStart() || s2.getWeekEnd() < s1.getWeekStart());
    }
}
