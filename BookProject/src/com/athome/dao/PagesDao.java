package com.athome.dao;

import com.athome.dao.impl.PagesDaoimpl;

import com.athome.pojo.Book;
import com.athome.pojo.Pages;

import java.util.List;


public class PagesDao extends BaseDao implements PagesDaoimpl {

    /**
     * 返回数据库中图书的数量
     * @return
     */
    @Override
    public int  getBooksCounts() {
        String sql="select count(*) from t_book ";
        Number o = (Number)queryforValue(sql);
        int i = o.intValue();

        return i;
    }



    /**
     * 获取有多少页
     */
    @Override
    public int getPagesCounts() {
        int i = getBooksCounts();
        Pages pages = new Pages();
        int pageSize = pages.getPageSize();
        int pageCounts = i / pageSize;
        if (i%pageSize>0){
            pageCounts++;
        }
        return pageCounts;


    }

    /**
     *
     * @param pagenum 当前的页码
     * @param Pagesize 当前的数量
     * @return
     */
    @Override
    public Pages getBookOfOnePage(int pagenum, int Pagesize) {

        Pages pages = new Pages();

        pages.setPageNo(pagenum);
        pages.setOnePageShows(Pagesize);


        int counts = getPagesCounts();
        pages.setPageTotals(counts);
        int i = getBooksCounts();
        pages.setBookCounts(i);


        int begin=(pages.getPageNo()-1)*Pagesize;
        if (begin<0){
            begin=0;
        }
        String sql="select * from t_book limit ?,?";

        List<Book> books = queryformore(Book.class, sql, begin, Pagesize);
        pages.setItems(books);
//        System.out.println(pages.getItems());
        return pages;
    }


    /**
     * 获取这个价格段内 数据库里有多少图书数量
     * @param min  最低价
     * @param max  最高价
     * @return
     */
    public int getBookCountByPrice(int min,int max){
        String sql="select count(*) from t_book where price between ? and ?";
        Number o = (Number)queryforValue(sql,min,max);
        int i =o.intValue();
        return i;

    }

    /**
     *  获取这个价格段内的图书 有几页 前提 一页最多占3本
     * @param min
     * @param max
     * @return
     */
    public int getPageCountByPrice( int min,int max){
        int i = getBookCountByPrice(min,max);
        Pages pages = new Pages();
        int pageSize = pages.getPageSize();
        int pageCounts = i / pageSize;
        if (i%pageSize>0){
            pageCounts++;
        }
        return pageCounts;
    }

    @Override
    public Pages getBookByprice(int min0, int max0, int pagenum, int Pagesize) {




        Pages pages = new Pages();

        pages.setPageNo(pagenum);
        pages.setOnePageShows(Pagesize);
        int counts = getPageCountByPrice(min0,max0);
        pages.setPageTotals(counts);
        int i = getBookCountByPrice(min0,max0);
        pages.setBookCounts(i);


        int begin=(pages.getPageNo()-1)*Pagesize;
        if (begin<0){
            begin=0;
        }


        String sql="select * from t_book where price between ? and ? order by price limit ?,?";
        List<Book> books = queryformore(Book.class, sql, min0,max0,begin, Pagesize);
        pages.setItems(books);
//        System.out.println(pages.getItems());
        return pages;

    }
}
