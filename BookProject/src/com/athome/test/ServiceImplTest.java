package com.athome.test;

import com.athome.dao.UserDao;
import com.athome.pojo.User;
import com.athome.service.impl.Service;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceImplTest {
   Service service= new Service();
   @Test
    public void test01(){
        service.login("jack","123456");
    }
    @Test
    public void test02(){
        service.register(new User("jerry3","1234567","123@163.com"));
    }
}