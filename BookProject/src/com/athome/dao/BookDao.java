package com.athome.dao;

import com.athome.dao.impl.BookeDaoimpl;
import com.athome.pojo.Book;
import com.athome.pojo.Pages;

import java.util.List;

public class BookDao extends BaseDao implements BookeDaoimpl {


    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO t_book(NAME,author,price,sales,stock,img_path) VALUES(?,?,?,?,?,?)";
        update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public void deleteBook(int id) {
        String sql="delete  from t_book where id =?";
        update(sql,id);
    }

    @Override
    public void updateBook(Book book) {
        String sql="update t_book set name =?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public List<Book> listBook(Book book) {
            String sql="select * from t_book";
        List<Book> books = queryformore(Book.class, sql);
        return books;
    }

   public Book getBook(int id){
        String sql="select * from t_book where id =?";
       Book book = queryforone(Book.class, sql, id);
       return book;
   }

    @Override
    public Pages getBookByprice(int min0, int max0, int num, int size) {
        return null;
    }
}
