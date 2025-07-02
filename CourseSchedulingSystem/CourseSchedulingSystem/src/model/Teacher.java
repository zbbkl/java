package model;

public class Teacher {
    private String teacherId;
    private String name;
    private String title;
    private String department;
    
    public Teacher(String teacherId, String name, String title, String department) {
        this.teacherId = teacherId;
        this.name = name;
        this.title = title;
        this.department = department;
    }
    
    // Getters and Setters
    public String getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return teacherId + " - " + name + " (" + title + ", " + department + ")";
    }
}
