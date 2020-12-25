package com.biki.project.common.annotation.Aspect;

import com.biki.project.common.annotation.LoggerTest;
import com.biki.project.common.utils.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Aspect 注解详解 https://blog.csdn.net/fz13768884254/article/details/83538709
 * Aop里对于@Before等注解执行顺序的详细说明:https://blog.csdn.net/u012843873/article/details/80540499
 * 用@Aspect注解需要引入依赖 org.aspectj.aspectjweaver
 *
 * 使用@Aspect 注解的类， Spring 将会把它当作一个特殊的Bean（一个切面），也就是不对这个类本身进行动态代理
 *
 * 注意点
 * 如果在同一个 aspect 类中，针对同一个 pointcut，定义了两个相同的 advice(比如，定义了两个 @Before)，
 * 那么这两个 advice 的执行顺序是无法确定的，哪怕你给这两个 advice 添加了 @Order 这个注解，也不行。这点切记。
 * 对于@Around这个advice，不管它有没有返回值，但是必须要方法内部，调用一下 pjp.proceed();
 * 否则，Controller 中的接口将没有机会被执行，从而也导致了 @Before这个advice不会被触发。
 * 比如，我们假设正常情况下，执行顺序为”aspect2 -> apsect1 -> controller”，
 * 如果，我们把 aspect1中的@Around中的 pjp.proceed();给删掉，那么，我们看到的输出结果将是：Controller 中的 接口 未被执行，aspect1 中的 @Before advice 也未被执行。
 *
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/12/25
 */
@Order(5) // 数值越小，越先执行  当有多个Aop需要对一个方法执行处理时，可以用该注解指定执行顺序
@Aspect
@Component
public class LoggerTestAspect {

    /**
     * execution表达式参考网址：https://blog.csdn.net/lang_niu/article/details/51559994
     */
    @Pointcut("execution(* com.biki.project.controller..*.*(..)) && @annotation(com.biki.project.common.annotation.LoggerTest)")
    public void loggerTest() {}

    /**
     * ProceedingJoinPoint.proceed(); 被注解标记的方法开始执行并返回结果
     * ProceedingJoinPoint.getArgs(); 被注解标记的方法的参数，参数可能有多个，所以返回值是数组
     * ProceedingJoinPoint.getTarget(); 被织入的目标对象，即代理类
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("loggerTest()")
    public Object doAroundAsyn(ProceedingJoinPoint point) throws Throwable {
        Method method = ((MethodSignature)point.getSignature()).getMethod();
        LoggerTest loggerTest = method.getAnnotation(LoggerTest.class);
        String s = loggerTest.value();
        Object result = point.proceed(); //被注解标记的方法开始执行，Object是方法的结果
        if(result instanceof Result){
            ((Result) result).setMsg("修改后的数据");
        }
        return result; //这里一定要返回被注解标记的方法的返回结果一样的类型
    }

    @Before("loggerTest()")
    public void permissionCheck(JoinPoint point) {
        System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
    }

    @AfterReturning(pointcut="loggerTest()", returning="returnValue")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + returnValue);
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());

    }

    @After("loggerTest()")
    public void releaseResource(JoinPoint point) {
        System.out.println("@After：模拟释放资源...");
        System.out.println("@After：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@After：被织入的目标对象为：" + point.getTarget());
    }

    @AfterThrowing(value="@annotation(com.biki.project.common.annotation.LoggerTest)",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) { // Throwable ex 为注解标注的方法抛出的异常
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        String s = method.getAnnotation(LoggerTest.class).value();
    }

    @AfterReturning(value="@annotation(com.biki.project.common.annotation.LoggerTest)", returning="result")//有注解标记的方法，执行该后置返回
    public void afterReturning(JoinPoint joinPoint , Object result) {//注解标注的方法返回值
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        LoggerTest loggerTest = method.getAnnotation(LoggerTest.class);

        String smsContent = loggerTest.value();
        boolean exec = loggerTest.execution();

}
}
