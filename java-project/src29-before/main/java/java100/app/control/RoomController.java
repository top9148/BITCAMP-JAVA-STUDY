package java100.app.control;

import java.util.Iterator;

import java100.app.domain.Room;
import java100.app.util.Prompts;

public class RoomController extends GenericController<Room> {
    
    // 상속 받은 execute()를 오버라이딩하지 않고 
    // 그냥 execution() 메서드를 새로 추가하였다. 
    // => 이렇게 해도 현재의 문법상 문제 없다.
    // => 문제가 없는 것이 문제다!
    // => 왜 이런 문제가 있는 것인가?
    //    execute()를 오버라이딩 하는 것이 강제 사항이 아니기 때문이다.
    public void execution() {
        loop:
        while (true) {
            System.out.print("강의실관리> ");
            String input = keyScan.nextLine();
            
            // 명령어를 처리하는 각 코드를 별도의 메서드로 추출한다.
            switch (input) {
            case "list": this.doList(); break;
            case "add": this.doAdd(); break;
            case "delete": this.doDelete(); break;
            case "main": break loop;
            default: 
                System.out.println("해당 명령이 없습니다.");
            }
        }
    }
    
    private void doList() {
        System.out.println("[강의실 목록]");
        
        Iterator<Room> iterator = list.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            System.out.printf("%s, %s, %d\n",  
                room.getLocation(), room.getName(), room.getCapacity());
        }
    }
    
    private void doAdd() {
        System.out.println("[강의실 등록]");
        
        Room room = new Room();
        room.setName(Prompts.inputString("강의실 이름? "));
        
        if (find(room.getName()) != null) {
            System.out.println("이미 등록된 강의실입니다.");
            return;
        }
        
        room.setLocation(Prompts.inputString("지역? "));
        room.setCapacity(Prompts.inputInt("수용인원? "));
        
        list.add(room);
    } 
    
    private void doDelete() {
        System.out.println("[강의실 삭제]");
        String roomName = Prompts.inputString("강의실 이름? ");
        
        Room room = find(roomName);
        
        if (room == null) {
            System.out.printf("'%s' 강의실 정보가 없습니다.\n", roomName);
            return;
        }
        
        if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
            list.remove(room);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
    }
    
    private Room find(String roomName) {
        Iterator<Room> iterator = list.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }
}










