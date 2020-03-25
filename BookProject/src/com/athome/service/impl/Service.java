package com.athome.service.impl;

import com.athome.dao.UserDao;
import com.athome.pojo.User;
import com.athome.service.ServiceImpl;

public class Service implements ServiceImpl {

    UserDao userDao=new UserDao();
    @Override
    public void login(String username, String password) {
        User user = userDao.queryforUsenameAndPassword(username, password);
        if (user!=null) {
            System.out.println("登录成功");
        }
    }

    @Override
    public void register(User user) {

        if (existUser(user.getUsername())==false){
          userDao.saveUser(user);
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败，已存在用户名，请更改用户名");
        }

    }

    /**
     * 如果返回true，则表示数据库中已有账户名，需要更改账户名
     * @param username
     * @return
     */
    @Override
    public boolean existUser(String username) {
        User user = userDao.queryforUsename(username);
        if (user!=null){
            return true;
        }
        return false;
    }
}
