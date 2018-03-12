package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.BoardDao;
import java100.app.dao.FileDao;
import java100.app.domain.Board;
import java100.app.domain.UploadFile;
import java100.app.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired BoardDao boardDao;
    @Autowired FileDao fileDao;
    
    @Override
    public List<Board> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return boardDao.findAll(params);
    }

    @Override
    public Board get(int no) {
        boardDao.updateViewCount(no);
        
        // 게시물의 첨부 파일 정보를 가져올 때 
        // 방법1: 
        // => 따로 따로 가져오기 
        //Board board = boardDao.findByNo(no);
        //board.setFiles(fileDao.findByBoardNo(no));
        
        // 방법2:
        // => board 객체에 묶어서 가져오기
        Board board = boardDao.findByNo2(no);
        
        return board;
    }
    
    @Override
    public int getTotalCount() {
        return boardDao.countAll();
    }

    @Override
    public int add(Board board) {
        // insert를 하기 전에는 board의 no 프로퍼티 값은 0이다.
        // insert를 한 후에는 no 프로퍼티에 DB에서 생성한 값이 저장된다.
        int count = boardDao.insert(board);
        
        List<UploadFile> files = board.getFiles();
        
        for (UploadFile file : files) {
            // 파일 정보를 insert 하기 전에 게실물 no를 설정한다.
            file.setBoardNo(board.getNo());
            fileDao.insert(file);
        }
        
        return count;
    }

    @Override
    public int update(Board board) {
        
        int count = boardDao.update(board);
        
        // 기존의 게시물 첨부파일은 모두 지운다. 
        fileDao.deleteAllByBoardNo(board.getNo());
        
        // 다시 게시물 첨부파일을 저장한다.
        List<UploadFile> files = board.getFiles();
        
        for (UploadFile file : files) {
            // 파일 정보를 insert 하기 전에 게실물 no를 설정한다.
            file.setBoardNo(board.getNo());
            fileDao.insert(file);
        }
        return count;
    }

    @Override
    public int delete(int no) {
        
        // 자식 테이블의 데이터를 먼저 지워야만 게시물 데이터를 지울 수 있다.
        // => 만약 bno 외부키에 대해 on delete cascade가 지정되어 있다면,
        //    부모 테이블 ex_board 의 데이터를 지우는 즉시 
        //    자식 테이블 ex_file의 데이터도 자동으로 지워진다.
        // 
        //fileDao.deleteAllByBoardNo(no);
        
        return boardDao.delete(no);
    }

}












