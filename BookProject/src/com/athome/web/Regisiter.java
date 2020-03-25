package com.athome.web;

import com.athome.dao.UserDao;
import com.athome.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class Regisiter extends HttpServlet {
    UserDao userDao=new UserDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //匹配验证码
        String o = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        if (o!=null &&o.equalsIgnoreCase(code)) {
        //如果验证码正确，检查用户名是否存在
            User user = userDao.queryforUsename(username);
            if (user==null){
                //说明用户名不存在，可以注册，在数据库中添加，然后跳转到注册成功界面

                try {
                    User user1 = new User();
                    //BeanUtils.populate 是库中的方法，直接获取参数(底层是找参数的get 和set方法)，然后创建一个对象
                    BeanUtils.populate(user1,req.getParameterMap());

                    userDao.saveUser(user1);
                    req.getSession().setAttribute("user",user1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
            else {

                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("repwd",repwd);
                req.setAttribute("email",email);
                req.setAttribute("code",code);
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        } else {

            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("code",code);
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

        }
    }
}
