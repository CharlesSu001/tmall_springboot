/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProductDateComparator
 * Author:   苏晨宇
 * Date:     2020/11/25 10:45
 * Description: 时间排序创建晚的在后面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈时间排序创建晚的在后面〉
 *
 * @author 苏晨宇
 * @create 2020/11/25
 * @since 1.0.0
 */
public class ProductDateComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getCreateDate().compareTo(o2.getCreateDate());
    }
}
 
