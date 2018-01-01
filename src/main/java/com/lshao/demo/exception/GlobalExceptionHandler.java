package com.lshao.demo.exception;

import com.lshao.demo.dto.ReturnBean;
import com.lshao.demo.web.StringJacksonMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局异常处理
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private StringJacksonMapper jacksonMapper;

    /**
     * 参数验证异常
     * @param exception
     * @return
     */
    @ExceptionHandler({ValidateFailException.class})
    @ResponseBody
    public Object validateFailException(ValidateFailException exception){
        if(logger.isInfoEnabled()){
            logger.info("参数验证失败",exception);
        }

        String validateMessage = exception.getMessage();
        Object messages = exception.getFailMessages();

        return ReturnBean.validateFail(messages).message(validateMessage);
    }

    /**
     * 业务逻辑层异常
     * @param exception
     * @return
     */
    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Object bizException(BizException exception){
        if(logger.isWarnEnabled()){
            logger.warn("业务异常",exception);
        }

        String bizMessage = exception.getMessage();

        return ReturnBean.error(null).message(bizMessage);
    }

    /**
     * 捕捉全局异常
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView baseException(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException {
        if(logger.isErrorEnabled()){
            logger.error("系统异常",exception);
        }

        String contentType = request.getContentType();

        if(StringUtils.isNotBlank(contentType) && contentType.contains(MediaType.APPLICATION_JSON_VALUE)){
            // json格式返回
            ReturnBean returnBean = new ReturnBean();
            String returnJson = jacksonMapper.writeValueAsString(returnBean);

            PrintWriter writer = response.getWriter();
            writer.print(returnJson);
            writer.flush();
            writer.close();
            return null;
        }else{

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("message",exception.getMessage());
            modelAndView.addObject("exception",exception);
            return modelAndView;
        }
    }

}
