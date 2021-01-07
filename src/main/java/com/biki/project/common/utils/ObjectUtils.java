package com.biki.project.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/7
 */
public class ObjectUtils {

    private static final Logger logger = LoggerFactory.getLogger(ObjectUtils.class);


    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                //把私有属性公有化
                f.setAccessible(true);

                /*System.out.print(f.getName() + ":");
                System.out.println(f.get(object));*/

                if (f.get(object) != null && StringUtils.isEmpty(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            logger.info("判断对象中属性值是否全为空报错：{}",e);
            return false;
        }

        return true;
    }

}
