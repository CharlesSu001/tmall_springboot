/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SpringContextUtil
 * Author:   苏晨宇
 * Date:     2020/11/27 18:19
 * Description: 故意诱发aop
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈故意诱发aop〉
 *
 * @author 苏晨宇
 * @create 2020/11/27
 * @since 1.0.0
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private SpringContextUtil() {

    }

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
 
