package java100.app.domain;

import java100.app.control.CSVFormatException;

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
    
    public Room(String csv) throws CSVFormatException {
        String[] rec = csv.split(",");
        if (rec.length != 3) // 데이터의 개수가 올바르지 않다면,
            throw new CSVFormatException(
                    "CSV 데이터 항목의 개수가 올바르지 않습니다.");
        
        try {
            this.location = rec[0];
            this.name = rec[1]; 
            this.capacity = Integer.parseInt(rec[2]);
            
        } catch (Exception e) {
            throw new CSVFormatException(
                    "CSV 데이터 항목의 형식이 올바르지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return "Room [location=" + location + ", name=" + name + ", capacity=" + capacity + "]";
    }
    
    public String toCSVString() {
        return String.format("%s,%s,%d", 
                this.getLocation(),
                this.getName(), 
                this.getCapacity());
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
