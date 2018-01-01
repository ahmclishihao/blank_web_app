package com.lshao.demo.exception;

import java.util.Map;

/**
 * 参数验证失败异常
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class ValidateFailException extends BaseException {

    /**
     * 错误信息集
     */
    private Map<String,String> failMessages;

    public ValidateFailException() {
        super();
    }

    public ValidateFailException(Map<String,String> failMessages) {
        super();
        this.failMessages = failMessages;
    }

    public ValidateFailException(Map<String,String> failMessages, String message) {
        super(message);
        this.failMessages = failMessages;
    }

    public ValidateFailException(String message, Map<String,String> failMessages, Throwable cause) {
        super(message, cause);
        this.failMessages = failMessages;
    }

    public ValidateFailException(Throwable cause) {
        super(cause);
    }

    protected ValidateFailException(String message, Map<String,String> failMessages, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.failMessages = failMessages;
    }

    /**
     * 获取 failMessages 的值。
     *
     * @return
     */
    public Map<String, String> getFailMessages() {
        return failMessages;
    }

    /**
     * 补充错误日志
     * @return
     */
    @Override
    public String getMessage() {
        if(failMessages != null){
            return String.format("%d 条验证失败记录", failMessages.size());
        }else{
            return super.getMessage();
        }
    }
}
