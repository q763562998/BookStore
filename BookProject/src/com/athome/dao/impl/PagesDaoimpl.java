package com.athome.dao.impl;

import com.athome.pojo.Pages;

public interface PagesDaoimpl {


    /**
     * 获取图书总数量
     */
    public int getBooksCounts();


    /**
     * 获取总页数，通过总数量/每一页的数量 除不尽+1
     */
    public int getPagesCounts();

    public Pages getBookOfOnePage(int a, int b);


}
