package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Score;

public interface ScoreDao {
    List<Score> findAll(Map<String,Object> params);
    Score findByNo(int no);
    int countAll();
    int insert(Score score);
    int update(Score score);
    int delete(int no);
}















