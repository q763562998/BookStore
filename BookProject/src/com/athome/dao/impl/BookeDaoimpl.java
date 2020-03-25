package com.athome.dao.impl;

import com.athome.pojo.Book;

import java.util.List;

public interface BookeDaoimpl {
    /**
     * 增加图书
     *
     * @param book
     */
    public void addBook(Book book);

    /**
     * 删除图书
     *
     * @param
     */
    public void deleteBook(int id);

    /**
     * 修改图书内容
     *
     * @param book
     */
    public void updateBook(Book book);

    /**
     *查找所有图书
     * @return
     */
    public List<Book> listBook(Book book);
}
