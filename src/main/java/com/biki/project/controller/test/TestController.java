package com.biki.project.controller.test;

import com.biki.project.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/4
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("testServiceImpl1")
    private TestService testService;

    //http://localhost:8888/biki/test/testMuchImplement

    /**
     * 测试接口多实现时的注入问题
     * 结果: 要用 @Qualifier 指定是哪一个实现类
     * @param number
     * @return
     */
    @GetMapping("/testMuchImplement")
    public Integer testMuchImplement(Integer number){
        return testService.muchImplements(number);
    }

}
