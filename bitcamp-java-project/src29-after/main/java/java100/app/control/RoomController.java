package java100.app.control;

import java.util.Iterator;

import java100.app.domain.Room;
import java100.app.util.Prompts;

public class RoomController extends GenericController<Room> {
    
    // 수퍼 클래스로부터 상속 받은 execute() 메서드는 
    // 추상 메서드이기 때문에 반드시 오버라이딩 해야한다.
    // 만약 오버라이딩을 하지 않는다면 
    // 이 클래스 또한 추상 클래스가 되어야 하고,
    // 추상 클래스가 되는 순간 이 클래스의 인스턴스를 생성할 수 없다.
    // 
    // 즉 서브 클래스에게 반드시 오버라이딩 하도록 강제하는 문법이 
    // 바로 "추상 메서드"이다.
    @Override // 이 애노테이션은 붙이지 않아도 된다.
    public void execute() {
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










