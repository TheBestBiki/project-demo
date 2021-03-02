package com.biki.project.learn.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 该类可以理解为 生成代理类，即代理类的最终操作类
 *
 * @author biki
 * @date 2021/3/2
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 该属性主要是被invoke方法调用，用来指向接口的实现类，即想要被增强的类
     * 即传入的类需为实现类，即该类要有实现的接口
     */
    private Object target;

    /**
     * @param target 某接口的实现类
     * @return
     */
    public Object bind(Object target){

        // 绑定一个委托对象，其实就是绑定接口的实现对象，即实现类
        this.target = target;

        // 这里会返回一个代理对象，该代理对象也是target的所实现的接口的实现类，但是跟传入的实现类的类型不一样，即一个新的类
        // 这一步的目的就是new 出一个接口的实现类
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

        System.out.println(proxy.getClass().getName()); // com.sun.proxy.$Proxy0
        System.out.println(proxy instanceof UserTest); // 结果：true 是接口的实行类
        System.out.println(proxy instanceof UserTestImpl); // 结果：false 与传入的实行类的类型不一样

        return proxy;
    }

    /**
     * 该方法会在代理对象调用接口的方法时 被调用
     *
     * @param proxy 代理实行类
     * @param method 代理实行类所实现的接口所调用的方法
     * @param args 调用接口的方法时所用到的入参，调用接口的某方法时想要传入的具体参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法前增强");
        Object result = method.invoke(target,args); // 这里会将参数传入 去调 接口的方法；invoke执行后所得的结果为：接口的方法根据入参执行后所得到的的返回值
        System.out.println("方法后增强");
        return result;
    }
}
