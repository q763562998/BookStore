package com.athome.dao.impl;

import com.athome.pojo.User;

public interface UserDaoimpl {


    /**
     * 根据用户名查询信息
     * @param username
     * @return 返回Null 说明用户名不存在
     */
    public User queryforUsename(String username);


    /**
     * 查找用户名和密码，用于登录
     * 如果返回Null 则不能登录
     * @param username
     * @param password
     * @return
     */
    public User queryforUsenameAndPassword(String username,String password);


    /**
     * 保存用户
     * @param user
     * @return -1则代表不存在用户可以保存
     */
    public int saveUser(User user);
}
