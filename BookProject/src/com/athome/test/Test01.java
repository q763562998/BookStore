package com.athome.test;

import com.athome.dao.UserDao;
import com.athome.pojo.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.Locale;

public class Test01 {
    @Test
    public void test01() {

        Locale locale = Locale.getDefault();
        System.out.println(locale);
    }
}
