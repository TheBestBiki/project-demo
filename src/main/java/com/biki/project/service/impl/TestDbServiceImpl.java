package com.biki.project.service.impl;

import com.biki.project.service.TestDbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/30
 */
@Service
public class TestDbServiceImpl implements TestDbService {


    @Override
    @Transactional
    public void testTransactional() {

    }
}
