package com.biki.project.service.test.impl;

import com.biki.project.service.test.TestService;
import org.springframework.stereotype.Service;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/4
 */
@Service("testServiceImpl2")
public class TestServiceImpl2 implements TestService {

    @Override
    public Integer muchImplements(Integer number) {
        return 2;
    }
}
