package com.athome.utils;

import com.athome.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class BeanUtils_Own{

    public static void webUtils(HttpServletRequest req, Object bean){

        try {
            BeanUtils.populate(bean,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
