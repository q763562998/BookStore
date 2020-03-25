package com.athome.service;

import com.athome.pojo.Pages;

public interface PageServiceImpl {



    public void getTotalBooks();


    public Pages getBookOfOnePage(int a , int b);


    public void getPagesCount();

    Pages getBookByPrice(int min0, int max0, int num, int size);

}
