/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GlobalExceptionHandler
 * Author:   苏晨宇
 * Date:     2020/11/23 9:41
 * Description: 异常处理 主要是外键约束
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈异常处理 主要是外键约束〉
 *
 * @author 苏晨宇
 * @create 2020/11/23
 * @since 1.0.0
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws ClassNotFoundException {
        e.printStackTrace();
        Class constrainViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if (e.getCause() == null && e.getCause().getClass() == constrainViolationException) {
            return "违反了约束，多半是外键约束";
        }
        return e.getMessage();
    }
}
 
