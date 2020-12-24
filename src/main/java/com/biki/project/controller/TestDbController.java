package com.biki.project.controller;

import com.biki.project.dto.TestTable;
import com.biki.project.mapper.TestDbMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author biki
 * @date 2020/6/6
 */
@RestController
@Validated
public class TestDbController {

    private static final Logger logger = LoggerFactory.getLogger(TestDbController.class);

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

    /**
     * get类型的请求，若参数里加了@RequestParam(name="id")，则请求里一定要有id这个参数
     * 不加该注解，则当请求里没有该id参数时，该参数赋值为null
     * 加与不加的最大区别就是 加该注解的好处之一就是指定参数名且请求必须含有该参数
     *
     * 可以通过@RequestParam(required = false)设置为非必传。因为required值默认是true，所以默认必传。
     * 通过@RequestParam(defaultValue = "0")指定参数默认值，这时请求里不包含该参数也行
     *
     * get请求想要@NotNull 生效的话，要在本类controller上加@Validated注解
     */
    @GetMapping("/testRequestParam")
    public Integer test3(@RequestParam(name = "id") Integer id){
        return Objects.isNull(id) ? 1111 : id;
    }

    @PostMapping("/test4")
    public String test4(@RequestBody TestTable dto){
        System.out.println(dto.getAmount());
        return "111";
    }

    /**
     * Mybatis，将Map作为参数，跟平时建dto来传一样
     * 当查询参数只有少数的几个时，可以不用建新类，直接用map来作为入参
     * key 的值即是map里引用的值，如 #{id}
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/testInsertByMap")
    public String testInsertByMap(@RequestParam(name = "id",required = false) Integer id, @RequestParam(name = "name",required = false) String name){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        return testDbMapper.testInsertByMap(map);
    }

    /**
     * 推荐阅读日志打印相关文章：https://www.cnblogs.com/lingyejun/p/9366533.html
     * @return
     */
    @GetMapping("/testLogger")
    public String testLogger(){
        try{
            String aa= null;
            aa.equals("11");
        }catch (Exception e){
            logger.info("异常：",e); // info 异常后面不加大括号，能完整打印出异常所有信息
            logger.info("单号:{},异常:{}","111",e); // info 异常后面加了大括号，不能完整打印出异常所有信息
            logger.warn("单号:{},异常:{}","111",e); // warn 异常后面加了大括号，不能完整打印出异常所有信息
            logger.warn("单号:{},异常：","222",e);  // warn 异常后面不加大括号，能完整打印出详细的异常堆栈信息
            logger.warn("单号:{},异常：{}","222",e.toString(),e);  // 推荐写法，打印异常，并打印详细的异常堆栈信息  e.getMessage()打印的信息比e.toString()简短
        }
        return "111";
    }

}
