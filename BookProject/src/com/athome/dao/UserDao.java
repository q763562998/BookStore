package com.athome.dao;

import com.athome.dao.impl.UserDaoimpl;
import com.athome.pojo.Pages;
import com.athome.pojo.User;

import java.util.List;

public class UserDao extends BaseDao implements UserDaoimpl {
    @Override
    public User queryforUsename(String username) {
        String sql="select * from userinfomation where username=?";

          return queryforone(User.class,sql,username);
    }

    @Override
    public User queryforUsenameAndPassword(String username, String password){
        String sql="select * from userinfomation where username=? and password=?";
        return queryforone(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into userinfomation(username,PASSWORD,email) values(?,?,?)";

        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public Pages getBookByprice(int min0, int max0, int num, int size) {
        return null;
    }
}
