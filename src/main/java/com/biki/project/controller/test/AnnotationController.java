package com.biki.project.controller.test;

import com.biki.project.common.annotation.LoggerTest;
import com.biki.project.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/12/25
 */
@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    @GetMapping("/test1")
    @LoggerTest(value = "test")
    public Result<String> testAnnotation(){
        return Result.successMsg("333");
    }


}
