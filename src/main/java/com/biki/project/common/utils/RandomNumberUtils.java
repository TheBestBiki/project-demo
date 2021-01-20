package com.biki.project.common.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/7
 */
public class RandomNumberUtils {

    /**
     * 提供并发产生随机数，能够解决多个线程发生的竞争争夺
     * https://blog.csdn.net/xingxiupaioxue/article/details/104796276/
     *
     * @return
     */
    public static Integer getRandomNumber(){
        return ThreadLocalRandom.current().nextInt(1000, 9999);
    }

}
