package java100.app.domain;

public class Room {
    protected String location;
    protected String name;
    protected int capacity;
    
    public Room() {}
    
    public Room(String location, String name, int capacity) {
        this.location = location;
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room [location=" + location + ", name=" + name + ", capacity=" + capacity + "]";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
