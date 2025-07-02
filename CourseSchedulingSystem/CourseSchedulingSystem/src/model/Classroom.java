package model;

public class Classroom {
    private String roomId;
    private String building;
    private int capacity;
    private String type; // 普通教室、实验室等
    
    public Classroom(String roomId, String building, int capacity, String type) {
        this.roomId = roomId;
        this.building = building;
        this.capacity = capacity;
        this.type = type;
    }
    
    // Getters and Setters
    public String getRoomId() {
        return roomId;
    }
    
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    
    public String getBuilding() {
        return building;
    }
    
    public void setBuilding(String building) {
        this.building = building;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return building + "-" + roomId + " (" + type + ", 容量:" + capacity + ")";
    }
}
