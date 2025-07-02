package model;

public class Course {
    private String courseId;
    private String courseName;
    private int credit;
    private int hours;
    
    public Course(String courseId, String courseName, int credit, int hours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.hours = hours;
    }
    
    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }
    
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public int getHours() {
        return hours;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    @Override
    public String toString() {
        return courseId + " - " + courseName + " (" + credit + "学分, " + hours + "课时)";
    }
}
