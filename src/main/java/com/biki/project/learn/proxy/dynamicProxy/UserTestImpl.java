package com.biki.project.learn.proxy.dynamicProxy;

import java.util.List;

/**
 * @author biki
 * @date 2021/3/2
 */
public class UserTestImpl implements UserTest {

    @Override
    public String login(List<Integer> list) {
        System.out.println("登录");
        return "登录";
    }

    @Override
    public void registe() {
        System.out.println("注册");
    }
}
