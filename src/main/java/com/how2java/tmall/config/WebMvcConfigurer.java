/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: WebMvcConfigurer
 * Author:   苏晨宇
 * Date:     2020/11/26 16:13
 * Description: 配置登陆拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.config;

import com.how2java.tmall.interceptor.LoginInterceptor;
import com.how2java.tmall.interceptor.OtherInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * 〈一句话功能简述〉<br>
 * 〈配置登陆拦截器〉
 *
 * @author 苏晨宇
 * @create 2020/11/26
 * @since 1.0.0
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public OtherInterceptor getOtherInterceptor() {
        return new OtherInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getOtherInterceptor())
                .addPathPatterns("/**");

        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**");
    }
}
 
