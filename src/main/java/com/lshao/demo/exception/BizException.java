package com.lshao.demo.exception;

/**
 * 业务层异常
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class BizException extends BaseException {

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
