package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired RoomDao roomDao;
    
    @Override
    public List<Room> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return roomDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return roomDao.countAll();
    }

    @Override
    public int add(Room score) {
        return roomDao.insert(score);
    }


    @Override
    public int delete(int no) {
        return roomDao.delete(no);
    }

}
