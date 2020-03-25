package com.athome.service.impl;

import com.athome.dao.BookDao;
import com.athome.pojo.Book;
import com.athome.pojo.User;
import com.athome.service.BookServiceimpl;
import com.athome.service.ServiceImpl;

import java.util.List;

public class BookService implements BookServiceimpl {

    BookDao bookDao = new BookDao();

    @Override
    public void addBookService(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookService(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBookService(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public List<Book> listBookService(Book book) {
        return bookDao.listBook(book);
    }

    @Override
    public Book queryForOne(int id) {
        Book book = bookDao.getBook(id);
        return book;
    }
}
