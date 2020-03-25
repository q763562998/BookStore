package com.athome.pojo;

import java.util.List;

public class Pages {
    private  static final int PAGE_SIZE=3;
    private int bookCounts;//图书的总数量
    private int onePageShows =PAGE_SIZE; //每一页显示多少数量
    private int pageTotals;//总页数
    // 当前页码
    private Integer pageNo;

    // 当前页数据
    private List<Book> items;

    // 分页条的请求地址
    private String url;

    public Pages() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {

        if (pageNo<1){
            this.pageNo=1;
        }
        if (pageNo>this.pageTotals)
        {
            this.pageNo=this.pageTotals;
        }
        this.pageNo = pageNo;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pages(int bookCounts, int onePageShows, int pageTotals) {
        this.bookCounts = bookCounts;
        this.onePageShows = onePageShows;
        this.pageTotals = pageTotals;
    }

    public  int getPageSize() {
        return PAGE_SIZE;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public int getOnePageShows() {
        return onePageShows;
    }

    public void setOnePageShows(int onePageShows) {
        this.onePageShows = onePageShows;
    }

    public int getPageTotals() {
        return pageTotals;
    }

    public void setPageTotals(int pageTotals) {
        this.pageTotals = pageTotals;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "BookCounts=" + bookCounts +
                ", OnePageShows=" + onePageShows +
                ", PageTotals=" + pageTotals +
                '}';
    }
}
