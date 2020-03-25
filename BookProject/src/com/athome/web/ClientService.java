package com.athome.web;

import com.athome.pojo.Pages;
import com.athome.service.impl.PagesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientService extends BaseBookServlet {
        PagesService pagesService=new PagesService();
    public void page1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println("经过前台的服务");

        String pageNo = req.getParameter("pageNo");
        int num=1;
        if (pageNo!=null){
            num=Integer.parseInt(pageNo);
        }
        int size=3;
        String onePageShows = req.getParameter("onePageShows");
        if (onePageShows!=null){
            size=Integer.parseInt(onePageShows);
        }


        Pages page = pagesService.getBookOfOnePage(num,size);
//        System.out.println(page.getItems());

        page.setUrl("client/bookService?action=page1");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,res);

    }


    public void pageByPrice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println("经过前台的服务");

        String pageNo = req.getParameter("pageNo");
        int num=1;
        if (pageNo!=null){
            num=Integer.parseInt(pageNo);
        }
        int size=3;
        String onePageShows = req.getParameter("onePageShows");
        if (onePageShows!=null){
            size=Integer.parseInt(onePageShows);
        }
        String min = req.getParameter("min");
        String max = req.getParameter("max");
        int min0=0;
        if (min!=null){
            min0=Integer.parseInt(min);
        }
        int max0=100000000;
        if (max!=null){
            max0=Integer.parseInt(max);
        }



//        Pages page = pagesService.getBookOfOnePage(num,size);
        Pages page=pagesService.getBookByPrice(min0,max0,num,size);
//        System.out.println(page.getItems());
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append("client/bookService?action=pageByPrice");
        stringBuilder.append("&min="+min0);
        stringBuilder.append("&max="+max0);

        req.setAttribute("min",min0);
        req.setAttribute("max",max0);

        page.setUrl(stringBuilder.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,res);

    }
}
