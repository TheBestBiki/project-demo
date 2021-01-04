package com.biki.project.common.constant;

public enum ErrorMessageEnum {

    TERMS_NOT_EXIST("账期不存在", "terms not exist" , 22370),

    // 公示错误枚举
    REBATE_PUBLICITY_TYPE_IS_NULL("总览类型未配置 : {0}", " overview type is empty : {0}", 22104),
    REBATE_PUBLICITY_ITEM_DATA_IS_NULL("返点行数据为空 : {0}", " rebate applt item empty : {0}", 22105),
    REBATE_PUBLICITY_ITEM_TYPE_IS_ERROR("存在未按标准格式的返点类型 : {0}", " rebate applt item type error : {0}", 22106),
    REBATE_PUBLICITY_ITEM_IS_EMPTY("生成返点总览数据为空 : {0}", " rebate applt item is empty : {0}", 22107),;

    private String messageCn; // 中文

    private String messageEn; // 英文

    private int code; // 错误编号

    // 构造方法
    ErrorMessageEnum(String messageCn, String messageEn, int code) {
        this.messageCn = messageCn;
        this.messageEn = messageEn;
        this.code = code;
    }

    // 自动根据环境配置获取错误信息中英文版本
    public static String getMessage(int code) {
        for (ErrorMessageEnum c : ErrorMessageEnum.values()) {
            if (code == c.getCode()) {
                //if (PiContext.isLocaleCn()) {  判断当前使用的是哪种语言
                if (1==1) {
                    return c.messageCn;
                } else {
                    return c.messageEn;
                }
            }
        }
        return null;
    }

    public String getMessage() {
        //根据环境取中英文
        if (1==1) {
            return messageCn;
        } else {
            return messageEn;
        }
    }

    public String getMessageCn() {
        return messageCn;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public int getCode() {
        return code;
    }

}
