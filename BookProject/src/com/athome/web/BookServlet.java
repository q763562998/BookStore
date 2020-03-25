package com.athome.web;

import com.athome.pojo.Book;
import com.athome.pojo.Pages;
import com.athome.service.impl.BookService;
import com.athome.service.impl.PagesService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BookServlet extends BaseBookServlet {
     BookService bookService=new BookService();
     PagesService pagesService=new PagesService();
    public void add(HttpServletRequest rep, HttpServletResponse resp){
        try {
            Book book = new Book();
            BeanUtils.populate(book,rep.getParameterMap());
            bookService.addBookService(book);
            String pageNo = rep.getParameter("pageNo");

            //这里应该用重定向 重定向的/ 是代表到端口号所以要加个路径
            resp.sendRedirect(rep.getContextPath()+"/manager/bookServlet?action=page1&pageNo="+pageNo);

            //使用下面的转发会有F5反复请求的Bug
//            rep.getRequestDispatcher("/manager/bookServlet?action=list").forward(rep,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete(HttpServletRequest rep, HttpServletResponse resp){


        try {
            String id = rep.getParameter("id");


            bookService.deleteBookService(Integer.parseInt(id));


            resp.sendRedirect(rep.getContextPath()+"/manager/bookServlet?action=page1");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void update(HttpServletRequest rep, HttpServletResponse resp){


        try {
            Book book = new Book();
            BeanUtils.populate(book,rep.getParameterMap());
            System.out.println(book);
            bookService.updateBookService(book);
            resp.sendRedirect(rep.getContextPath()+"/manager/bookServlet?action=page1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getBook(HttpServletRequest rep, HttpServletResponse resp){
        try {
            String id = rep.getParameter("id");
            Book book = bookService.queryForOne(Integer.parseInt(id));
//            System.out.println(book);
            rep.setAttribute("id",book.getId());
            rep.setAttribute("name",book.getName());
            rep.setAttribute("price",book.getPrice());
            rep.setAttribute("author",book.getAuthor());
            rep.setAttribute("sales",book.getSales());
            rep.setAttribute("stock",book.getStock());
            rep.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(rep,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void list(HttpServletRequest rep, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.listBookService(new Book());
//        System.out.println(books);
        rep.setAttribute("books",books);
        rep.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(rep,resp);

    }

    public void page1(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
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
        System.out.println(page.getItems());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,res);

    }

    public void loginout(HttpServletRequest req,HttpServletResponse res) throws IOException {

        req.getSession().invalidate();
        res.sendRedirect(req.getContextPath()+"/index.jsp");

    }



}
