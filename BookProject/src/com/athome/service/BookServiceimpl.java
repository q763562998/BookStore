package com.athome.service;

import com.athome.pojo.Book;

import java.util.List;

public interface BookServiceimpl {




    public void  addBookService(Book book);
    public void  deleteBookService(int id);
    public void  updateBookService(Book book);
    public List<Book> listBookService(Book book);
    public Book queryForOne(int id);
}
