package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {
    @Test
    public void test() {
        //获取你系统默认的语言，国家信息。
        Locale locale =Locale.getDefault();
        System.out.println(locale);

    }

    @Test
    public void i18nTest() {
        Locale locale = Locale.CHINA;
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println("password:"+bundle.getString("password"));
    }
}
