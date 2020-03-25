package com.athome.service.impl;

import com.athome.dao.PagesDao;
import com.athome.pojo.Pages;
import com.athome.service.PageServiceImpl;

public class PagesService implements PageServiceImpl {

    PagesDao pagesDao=new PagesDao();
    @Override
    public void getTotalBooks() {
        pagesDao.getBooksCounts();
    }

    @Override
    public Pages getBookOfOnePage(int a, int b) {


        Pages pages= pagesDao.getBookOfOnePage(a,b);
        return pages;
    }

    @Override
    public void getPagesCount() {
            pagesDao.getPagesCounts();
    }

    @Override
    public Pages getBookByPrice(int min0, int max0, int num, int size) {
        Pages pages=pagesDao.getBookByprice(min0,max0,num,size);
        return pages;
    }
}
