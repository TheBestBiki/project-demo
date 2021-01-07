package com.biki.project.common.utils;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/7
 */
public class PoiUtils {

    /**
     * 获取数字类型excel的真实String值
     * 导入Excel时，当传入带有小数的数字型数据时，可能会存在精度丢失的情况，用此方法可以获取完整准确的原数据
     *
     * @param value excel中的数据类型为数字，但传入系统的格式是字符串的值
     * @return 转换后的String
     */
    private String getRealValue(String value) {
        try {
            BigDecimal gap = BigDecimal.valueOf(1000000);
            BigDecimal real = new BigDecimal(new BigDecimal(value).setScale(6, BigDecimal.ROUND_HALF_UP).multiply(gap).longValue());
            return String.valueOf(real.divide(gap));
        } catch (Exception e) {
            return value;
        }
    }

}
