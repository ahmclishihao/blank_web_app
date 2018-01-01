package com.lshao.demo.util;

import com.lshao.demo.exception.ValidateFailException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 用于controller层参数验证的工具类
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class ValidateUtil {

    /**
     * 多验证条件
     */
    private List<ValidateEntry> validateEntries;

    /**
     * 错误消息集合
     */
    private Map<String,String> failMessages;

    private ValidateUtil() {
        validateEntries = new LinkedList<>();
        failMessages = new LinkedHashMap<String,String>();
    }

    public static ValidateUtil newInstance(){
        ValidateUtil validateUtil = new ValidateUtil();
        return validateUtil;
    }

    /**
     * 通过条件验证
     * @param code
     * @param condition
     * @param message
     * @param args
     * @return
     */
    public ValidateUtil check( String code,Condition condition, String message, Object... args){
        ValidateEntry con = new ValidateEntry();
        validateEntries.add(con);

        con.code = code;
        con.message = String.format(message,args);

        con.condition = condition;
        return this;
    }

    /**
     * 条件判断
     * @param code
     * @param passFlag
     * @param message
     * @param args
     */
    public ValidateUtil check(String code,boolean passFlag,String message,Object... args){
        ValidateEntry con = new ValidateEntry();
        validateEntries.add(con);

        con.code = code;
        con.message = String.format(message,args);

        con.passFlag = passFlag;
        return this;
    }

    /**
     * 非空判断
     * @param code
     * @param obj
     * @param message
     * @param args
     */
    public ValidateUtil notNull(String code,Object obj,String message,Object... args){
        ValidateEntry con = new ValidateEntry();
        validateEntries.add(con);

        con.code = code;
        con.message = String.format(message,args);

        con.passFlag = obj != null;
        return this;
    }

    /**
     * 字符串有值 非null 非""
     * @param code
     * @param str
     * @param message
     * @param args
     */
    public ValidateUtil notEmpty(String code,String str,String message,Object... args){
        ValidateEntry con = new ValidateEntry();
        validateEntries.add(con);

        con.code = code;
        con.message = String.format(message,args);

        con.passFlag = null != str && !str.isEmpty();
        return this;
    }

    /**
     * 字符串非空 非null 非"" 非"    "
     * @param code
     * @param str
     * @param message
     * @param args
     */
    public ValidateUtil notBlank(String code,String str,String message,Object... args){
        ValidateEntry con = new ValidateEntry();
        validateEntries.add(con);

        con.code = code;
        con.message = String.format(message,args);

        con.passFlag = null != str && !str.isEmpty() && !str.trim().isEmpty();
        return this;
    }

    /**
     * 验证条件集合，出现错误时将抛出错误信息集到 {@link ValidateFailException}
     * @throws ValidateFailException
     */
    public void validate(){
        for (ValidateEntry validateEntry : validateEntries) {
            if(validateEntry.validate()){
                continue;
            }else{
                failMessages.put(validateEntry.code, validateEntry.message);
            }
        }

        if(!failMessages.isEmpty()){
            throw new ValidateFailException(failMessages);
        }
    }

    /**
     * 判断条件
     */
    public interface Condition {
        /**
         * 是否通过条件
         * @return
         */
        boolean passCondition();
    }

    /**
     * 判断条件
     */
    public static class ValidateEntry {
        /**
         * 错误节点
         */
        protected String code;

        /**
         * 错误消息
         */
        protected String message;

        /**
         * 是否通过条件
         */
        private boolean passFlag;

        /**
         * 判断条件
         */
        protected Condition condition;

        /**
         * 验证条件
         * @return
         */
        protected boolean validate(){
            if(condition !=null){
                return condition.passCondition();
            }else{
                return passFlag;
            }
        }

    }

}
