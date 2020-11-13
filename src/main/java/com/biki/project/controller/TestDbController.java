package com.biki.project.controller;

import com.biki.project.dto.TestTable;
import com.biki.project.mapper.TestDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 测试查询到2条一模一样的数据的时候，List里的2个类的地址值是不是一样
     * 结果： 不是，2个类属性跟值都一样，但是地址不一样
     * @return
     */
    @GetMapping("/test2")
    public String test2(){
        List<TestTable> testTables = testDbMapper.testSameData();
        return testTables.get(0).toString()+"--"+testTables.get(1).toString();

    }

}
