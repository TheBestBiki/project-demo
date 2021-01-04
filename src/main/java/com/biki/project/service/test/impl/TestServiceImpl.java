package com.biki.project.service.test.impl;

import com.biki.project.service.test.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/30
 */
@Service("testServiceImpl1")
public class TestServiceImpl implements TestService {


    @Override
    @Transactional
    public void testTransactional() {

    }

    @Override
    public Integer muchImplements(Integer number) {
        return 1;
    }
}
