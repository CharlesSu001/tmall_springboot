/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProductAllComparator
 * Author:   苏晨宇
 * Date:     2020/11/25 10:44
 * Description: 综合排序销量*评价
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈综合排序销量*评价〉
 *
 * @author 苏晨宇
 * @create 2020/11/25
 * @since 1.0.0
 */
public class ProductAllComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getReviewCount()*o2.getSaleCount()-o1.getReviewCount()*o1.getSaleCount();
    }
}
 
