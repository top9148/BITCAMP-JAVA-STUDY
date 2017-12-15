package java100.app.domain;

public class Room {
    protected String location;
    protected String no;
    protected int capacity;
    
    public Room() {}
    
    public Room(String location, String no, int capacity) {
        this.location = location;
        this.no = no;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room [location=" + location + ", no=" + no + ", capacity=" + capacity + "]";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
