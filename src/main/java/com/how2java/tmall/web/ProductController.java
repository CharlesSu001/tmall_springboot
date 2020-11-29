/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProductController
 * Author:   苏晨宇
 * Date:     2020/11/23 20:53
 * Description: Prodcut控制类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈Prodcut控制类〉
 *
 * @author 苏晨宇
 * @create 2020/11/23
 * @since 1.0.0
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start,
                                        @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Product> page = productService.list(cid, start, size, 5);
        productImageService.setFirstProductImage(page.getContent());
        return page;
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) {
        return productService.get(id);
    }

    @PostMapping("/products")
    public Object add(@RequestBody Product bean) {
        bean.setCreateDate(new Date());
        productService.add(bean);
        return bean;
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) {
        productService.delete(id);
        return null;
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product bean) {
        productService.update(bean);
        return bean;
    }
}
 
