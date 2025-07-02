package model;

public class Schedule {
    private String scheduleId;
    private Course course;
    private Teacher teacher;
    private Classroom classroom;
    private String time; // 如"周一1-2节"
    private int weekStart;
    private int weekEnd;
    
    public Schedule(String scheduleId, Course course, Teacher teacher, 
                   Classroom classroom, String time, int weekStart, int weekEnd) {
        this.scheduleId = scheduleId;
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.time = time;
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
    }
    
    // Getters and Setters
    public String getScheduleId() {
        return scheduleId;
    }
    
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public Classroom getClassroom() {
        return classroom;
    }
    
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public int getWeekStart() {
        return weekStart;
    }
    
    public void setWeekStart(int weekStart) {
        this.weekStart = weekStart;
    }
    
    public int getWeekEnd() {
        return weekEnd;
    }
    
    public void setWeekEnd(int weekEnd) {
        this.weekEnd = weekEnd;
    }
    
    @Override
    public String toString() {
        return course.getCourseName() + " - " + teacher.getName() + " - " + 
               classroom.toString() + " - " + time + " - 第" + weekStart + "-" + weekEnd + "周";
    }
}
