package com.biki.project.service.test;

/**
 * 当一个接口有多个实现时，注入的时候，要指定是哪一个实现类，否则spring分不清要注入哪一个，会报错
 * 指定实现类用 @Qualifier("xxx实现类")
 */
public interface TestService {

    default void testTransactional(){};

    Integer muchImplements(Integer number);

}
