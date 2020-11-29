/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ReviewService
 * Author:   苏晨宇
 * Date:     2020/11/24 20:59
 * Description: 提供增加方法 以及通过产品获取评价方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.service;

import com.how2java.tmall.dao.ReviewDAO;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈提供增加方法 以及通过产品获取评价方法〉
 *
 * @author 苏晨宇
 * @create 2020/11/24
 * @since 1.0.0
 */
@Service
@CacheConfig(cacheNames = "reviews")
public class ReviewService {
    @Autowired
    ReviewDAO reviewDAO;
    @Autowired
    ProductService productService;

    @CacheEvict(allEntries = true)
    public void add(Review review) {
        reviewDAO.save(review);
    }

    @Cacheable(key = "'reviews-pid-'+#p0.id")
    public List<Review> list(Product product) {
        return reviewDAO.findByProductOrderByIdDesc(product);
    }

    @Cacheable(key = "'reviews-count-pid-'+#p0.id")
    public int getCount(Product product) {
        return reviewDAO.countByProduct(product);
    }
}
 
