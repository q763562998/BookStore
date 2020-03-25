package com.athome.test;

import com.athome.pojo.Book;
import com.athome.service.impl.BookService;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {


     BookService bookService=new BookService();
    @Test
    public void addBookService() {

        bookService.addBookService(new Book("serviceTest",30,"me",30,50,null));
    }

    @Test
    public void deleteBookService() {

        bookService.deleteBookService(23);
    }

    @Test
    public void updateBookService() {
        bookService.updateBookService(new Book(23,"updateTest111",30,"me",30,50,null));
    }

    @Test
    public void listBookService() {
    }
}