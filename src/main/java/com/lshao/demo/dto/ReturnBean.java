package com.lshao.demo.dto;

/**
 * json对象
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class ReturnBean<T> {

    /**
     * 错误error
     */
    private static final String ERROR_CODE = "00100";

    /**
     * 验证失败
     */
    private static final String VALIDATE_FAIL_CODE = "00101";

    /**
     * 成功code
     */
    private static final String SUCCESS_CODE = "00000";

    /**
     * 返回code
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;


    public static <T> ReturnBean<T> error(T data){
        ReturnBean<T> bean = new ReturnBean<>();
        bean.code = ERROR_CODE;
        bean.data = data;
        return bean;
    }

    public static <T> ReturnBean<T> ok(T data){
        ReturnBean<T> bean = new ReturnBean<>();
        bean.code = SUCCESS_CODE;
        bean.data = data;
        return bean;
    }

    public static <T> ReturnBean<T> validateFail(T data){
        ReturnBean<T> bean = new ReturnBean<>();
        bean.code = VALIDATE_FAIL_CODE;
        bean.data = data;
        return bean;
    }


    /**
     * 获取 code 的值。
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 code 的值。
     *
     * @param code
     */
    public ReturnBean<T> code(String code) {
        this.code = code;
        return this;
    }

    /**
     * 获取 message 的值。
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置 message 的值。
     *
     * @param message
     */
    public ReturnBean<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * 获取 data 的值。
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * 设置 data 的值。
     *
     * @param data
     */
    public ReturnBean<T> data(T data) {
        this.data = data;
        return this;
    }

}
