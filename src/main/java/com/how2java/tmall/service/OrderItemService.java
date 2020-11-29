/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderItemService
 * Author:   苏晨宇
 * Date:     2020/11/24 16:51
 * Description: Order的fill方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.service;

import com.how2java.tmall.dao.OrderItemDAO;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈Order的fill方法〉
 *
 * @author 苏晨宇
 * @create 2020/11/24
 * @since 1.0.0
 */
@Service
@CacheConfig(cacheNames = "orderItems")
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    ProductImageService productImageService;

    public void fill(Order order) {
        List<OrderItem> orderItems = listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : orderItems) {
            total += oi.getNumber() * oi.getProduct().getPromotePrice();
            totalNumber += oi.getNumber();
            productImageService.setFirstProductImage(oi.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    public void fill(List<Order> orders) {
        for (Order order : orders) {
            fill(order);
        }
    }

    @Cacheable(key = "'orderItems-uid-'+#p0.id")
    public List<OrderItem> listByUser(User user) {
        return orderItemDAO.findByUserAndOrderIsNull(user);
    }

    @Cacheable(key = "'orderItems-oid-'+#p0.id")
    public List<OrderItem> listByOrder(Order order) {
        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }

    @Cacheable(key = "'orderItems-pid-'+#p0.id")
    public List<OrderItem> listByProduct(Product product) {
        return orderItemDAO.findByProduct(product);
    }

    public int getSaleCount(Product product) {
        List<OrderItem> ois = listByProduct(product);
        int result = 0;
        for (OrderItem oi : ois) {
            if (oi.getOrder() != null) {
                if (oi.getOrder() != null && oi.getOrder().getPayDate() != null)
                    result += oi.getNumber();
            }
        }
        return result;
    }

    @CacheEvict(allEntries = true)
    public void update(OrderItem bean) {
        orderItemDAO.save(bean);
    }

    @CacheEvict(allEntries = true)
    public void add(OrderItem bean) {
        orderItemDAO.save(bean);
    }

    @Cacheable(key = "'orderItems-one-'+#p0")
    public OrderItem get(int id) {
        return orderItemDAO.getOne(id);
    }

    @CacheEvict(allEntries = true)
    public void delete(int id) {
        orderItemDAO.deleteById(id);
    }


}
 
