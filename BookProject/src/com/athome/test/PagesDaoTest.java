package com.athome.test;

import com.athome.dao.PagesDao;
import com.athome.pojo.Book;
import com.athome.pojo.Pages;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PagesDaoTest {
            PagesDao pagesDao=new PagesDao();
    @Test
    public void getBooksCounts() {

        Object booksCounts = pagesDao.getBooksCounts();
        System.out.println(booksCounts);
    }

    @Test
    public void getPagesCounts() {

        int pagesCounts = pagesDao.getPagesCounts();
        System.out.println(pagesCounts);
    }


    @Test
    public void getBookOfOnePage() {

        pagesDao.getBookOfOnePage(0,4);
    }


    @Test
    public void getBookCountByPrice(){
        int i = pagesDao.getBookCountByPrice(10, 20);
        System.out.println(i);
    }


    @Test
    public void getPageCountByPrice(){
        int i = pagesDao.getPageCountByPrice(10, 20);
        System.out.println(i);
    }

    @Test
    public void getBookByprice(){
        Pages pages = pagesDao.getBookByprice(10, 20, 0, 3);

        System.out.println(pages.getItems());
    }
}