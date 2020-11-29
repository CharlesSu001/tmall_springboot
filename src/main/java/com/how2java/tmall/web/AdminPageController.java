/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdminPageController
 * Author:   苏晨宇
 * Date:     2020/11/23 9:29
 * Description: 后台管理页面跳转专用控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈后台管理页面跳转专用控制器〉
 *
 * @author 苏晨宇
 * @create 2020/11/23
 * @since 1.0.0
 */
@Controller
public class AdminPageController {
    @GetMapping(value = "/admin")
    public String admin() {
        return "redirect:admin_category_list";
    }

    @GetMapping(value = "/admin_category_list")
    public String listCategory() {
        return "admin/listCategory";
    }



    @GetMapping(value = "/admin_property_list")
    public String listProperty(){
        return "admin/listProperty";

    }

    @GetMapping(value = "/admin_product_list")
    public String listProduct(){
        return "admin/listProduct";
    }


    @GetMapping(value = "/admin_order_list")
    public String listOrder(){
        return "admin/listOrder";
    }

    @GetMapping(value = "/admin_productImage_list")
    public String listProductImage(){
        return "admin/listProductImage";
    }

    @GetMapping(value = "/admin_user_list")
    public String listUser(){
        return "admin/listUser";
    }

    @GetMapping(value = "/admin_property_edit")
    public String editProperty(){
        return "admin/editProperty";
    }

    @GetMapping(value = "/admin_category_edit")
    public String editCategory() {
        return "admin/editCategory";
    }

    @GetMapping(value = "/admin_product_edit")
    public String editProduct(){
        return "admin/editProduct";
    }

    @GetMapping(value = "/admin_propertyValue_edit")
    public String editPropertyValue(){
        return "admin/editPropertyValue";
    }



}
 
