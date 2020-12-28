package com.example.demo.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhaoDesong
 * @date 2020/10/30 16:15
 */
@Getter
@AllArgsConstructor
public enum HttpResultCodeEnum {

    /**
     * 通用部分
     */
    SUCCESS(0,"成功"),
    SYSTEM_ERROR(1001,"系统错误"),
    /**
     * 登录相关
     */
    LOGIN_FAIL(2001,"账号或密码错误"),
    /**
     * 账户相关
     */
    ACCOUNT_REGISTER_ID_CARD_REPEAT(3001,"身份证号已被注册"),
    ACCOUNT_REGISTER_MOBILE_REPEAT(3002,"手机号已被注册"),
    /**
     * 审核相关
     */
    NONE_REGISTER_TO_CHECK(4001, "没有待审核的注册信息"),
    NONE_EASY_MEET_TO_CHECK(4002, "没有待审核的简易申报"),
    NONE_DETAIL_MEET_TO_CHECK(4003, "没有待审核的详细申报"),
    /**
     * 信息系统相关
     */
    NONE_LOOKED_MESSAGE(5001,"该用户没有已读信息"),
    NONE_NOT_LOOK_MESSAGE(5002,"该用户没有未读信息"),
    NONE_EASY_MEET_MESSAGE(5003,"该用户没有简易申报信息"),
    NONE_DETAIL_MEET_MESSAGE(5004,"该用户没有详细申报信息"),
    /**
     * 其他
     */
    NONE_DETAIL_MEET_ACCESS(6001, "没有与之对应的详细申报")

    /**
     * TODO 待进一步完善
     */

    ;


    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
}
