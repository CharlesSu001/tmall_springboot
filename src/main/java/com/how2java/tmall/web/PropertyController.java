/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PropertyController
 * Author:   苏晨宇
 * Date:     2020/11/23 19:47
 * Description: y=映射不同路径的访问
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈映射不同路径的访问〉
 *
 * @author 苏晨宇
 * @create 2020/11/23
 * @since 1.0.0
 */
@RestController
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid")int cid, @RequestParam(value = "start",defaultValue = "0")int start,
    @RequestParam(value = "size",defaultValue = "5")int size){
        start=start<0?0:start;
        Page4Navigator<Property> page=propertyService.list(cid,start,size,5);
        return page;
    }

    @PostMapping("/properties")
    public Object add(@RequestBody Property bean){
        propertyService.add(bean);
        return bean;
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id")int id){
        return propertyService.get(id);
    }

    @PutMapping("/properties")
    public Object update(@RequestBody Property bean){
        propertyService.update(bean);
        return bean;
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id")int id, HttpServletRequest request){
        propertyService.delete(id);
        return null;
    }


}
 
