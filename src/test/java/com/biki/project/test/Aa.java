package com.biki.project.test;

import lombok.Getter;
import lombok.Setter;

/**
 * @author biki
 * @date 2020/6/6
 */
@Getter
@Setter
public class Aa {

    private String aa="00000";

    //加了lombok注解后，若类里有自定义的get或set方法，会以类里的方法为准
    public String getAa() {
        return aa+"fdfdsfd";
    }
}
