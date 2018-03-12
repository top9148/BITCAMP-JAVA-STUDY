package java100.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.BookDao;
import java100.app.domain.Book;
import java100.app.service.BookService;

@Service
public class DefaultBookService implements BookService {

    @Autowired BookDao bookDao;
    
    @Override
    public int add(Book book) {
        return bookDao.insert(book);
    }

}
