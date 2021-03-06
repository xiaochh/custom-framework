package com.zyuc.demo.common;

import com.zyuc.demo.enums.ErrorEnum;
import com.zyuc.demo.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Version 1.0
 * @Description 统一异常处理
 * @Date 2020/5/8 13:52
 * @Created by ChenHao
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseMsg handle(Exception e) {
        Integer errorCode;
        String msg;
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            errorCode = serviceException.getCode();
            msg = serviceException.getMessage();
        } else {
            logger.error("【系统异常】{}", e.getMessage());
            errorCode = ErrorEnum.INTERNAL_SERVER_ERROR.getCode();
            msg = ErrorEnum.INTERNAL_SERVER_ERROR.getMsg();
        }
        return ResponseUtil.error(errorCode, msg);
    }

}
