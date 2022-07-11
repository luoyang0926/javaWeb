package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static Object copyParamToBean(Map value, Object bean) {
        System.out.println("注入之前" + bean);


        try {
            BeanUtils.populate(bean, value);
            System.out.println("注入之后:"+bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception  e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }
}
