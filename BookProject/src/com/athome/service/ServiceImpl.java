package com.athome.service;

import com.athome.pojo.User;

public interface ServiceImpl {
    /**
     * 登录操作，判断数据库中是否存在账户密码
     * @param username
     * @param password
     * @return
     */
    public void login(String username,String password);

    /**
     * 注册操作，将数据保存到数据库中，前提账户名字唯一
     */
    public void register(User user);


    /**
     *
     */
    public boolean existUser(String username);
}
