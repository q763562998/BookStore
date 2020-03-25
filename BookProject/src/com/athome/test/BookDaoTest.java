package com.athome.test;

import com.athome.dao.BookDao;
import com.athome.pojo.Book;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao bookDao=new BookDao();
    @Test
    public void addBook() {
        bookDao.addBook(new Book("TEST02",20.00,"me",30,50,null));
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void updateBook() {

        bookDao.updateBook(new Book(22,"update",20.00,"me",1000,50,null));
    }

    @Test
    public void listBook() {
        List<Book> books = bookDao.listBook(new Book());
//        Iterator<Book> iterator = books.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
}