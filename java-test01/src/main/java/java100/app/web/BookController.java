package java100.app.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Book;
import java100.app.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
    
    @Autowired ServletContext servletContext;
    @Autowired BookService bookService;
    
    @RequestMapping(value="add", method=RequestMethod.GET)
    public String form() {
        return "book/form";
    }
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Book book, MultipartFile file) throws Exception {
        
        // 업로드 파일을 저장할 폴더 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");
        
        String filename = writeUploadFile(file, uploadDir);
        book.setPhoto(filename);
        
        bookService.add(book);
        
        return "book/form";
    }
    
    long prevMillis = 0;
    int count = 0;
    
    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    // 파일명에서 뒤의 확장자명을 추출한다.
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writeUploadFile(MultipartFile part, String path) throws IOException {
        
        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }  
}










