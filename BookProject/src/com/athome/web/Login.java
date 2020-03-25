package com.athome.web;

import com.athome.dao.UserDao;
import com.athome.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在这个类里获取浏览器里的参数，然后传入到数据库，比较数据库是否有值
 * 浏览器里需要填写的数据有数据，并且正确后，通过这个类跳入到下个界面
 */
public class Login extends HttpServlet {
    UserDao userDao=new UserDao();
    //！！！这里代码有细节问题，Web层应该访问service 而不是访问上面的Dao层
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userDao.queryforUsenameAndPassword(username, password);


        req.getSession().setAttribute("user",user);
        if (user==null){
            //说明没有这个用户名和密码
            req.setAttribute("msg","账号或密码错误");
            req.setAttribute("username",username);
            System.out.println("账号或密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
}
