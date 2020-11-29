/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CategoryDAO
 * Author:   苏晨宇
 * Date:     2020/11/23 9:22
 * Description: 继承JpaRepository 实现CRUD及分页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈继承JpaRepository 实现CRUD及分页〉
 *
 * @author 苏晨宇
 * @create 2020/11/23
 * @since 1.0.0
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
 
