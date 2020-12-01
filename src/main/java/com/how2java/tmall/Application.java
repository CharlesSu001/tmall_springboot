/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Application
 * Author:   苏晨宇
 * Date:     2020/11/23 9:35
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall;

import com.how2java.tmall.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 〈一句话功能简述〉<br>
 * 〈启动类〉
 *
 * @author 苏晨宇
 * @create 2020/11/23
 * @since 1.0.0
 */
@SpringBootApplication
@EnableCaching
@EnableElasticsearchRepositories(basePackages= "com.how2java.tmall.es")
@EnableJpaRepositories(basePackages = {"com.how2java.tmall.dao","com.how2java.tmall.pojo"})
public class Application {
//    static {
//        PortUtil.checkPort(6379, "Redis服务端", true);
//        PortUtil.checkPort(9300,"ElasticSearch服务端",true);
//        PortUtil.checkPort(5601,"Kibana工具",true);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
 
