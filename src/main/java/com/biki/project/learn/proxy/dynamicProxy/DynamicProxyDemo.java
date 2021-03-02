package com.biki.project.learn.proxy.dynamicProxy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 动态代理调用示例
 *
 * @author biki
 * @date 2021/3/2
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {

        UserTest userTest = new UserTestImpl();
        MyInvocationHandler handler = new MyInvocationHandler(); //创建一个代理类的最终操作类，用于生成代理对象
        UserTest proxy = (UserTest)handler.bind(userTest); // 这里bind所得的对象，与UserTestImpl一样，都是 UserTest的实现类，但不是UserTestImpl类型
        //UserTest proxy = (UserTest)handler.bind(userTest); // 第二种写法，直接传实现类 new UserTestImpl() 也行
        proxy.login(new ArrayList<>(Arrays.asList(1,2,3))); // 这里会直接去调MyInvocationHandler的invoke方法，并将这里login方法的入参一并传给invoke方法，invoke方法里面再去调用接口UserTest的login方法
        System.out.println("------------------");
        proxy.registe(); // 同理上方login方法的调用
    }

}
