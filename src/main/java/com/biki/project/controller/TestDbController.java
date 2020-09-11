package com.biki.project.controller;

import com.biki.project.mapper.TestDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author biki
 * @date 2020/6/6
 */
@RestController
public class TestDbController {

    @Autowired
    private TestDbMapper testDbMapper;

    //http://localhost:8888/biki/test
    @GetMapping("/test")
    public String test(){
        return testDbMapper.finId();
    }

}
