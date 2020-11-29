/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserService
 * Author:   苏晨宇
 * Date:     2020/11/24 16:16
 * Description: 提供list方法，进行分页查询
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.service;

import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈提供list方法，进行分页查询〉
 *
 * @author 苏晨宇
 * @create 2020/11/24
 * @since 1.0.0
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    UserDAO userDAO;

    @Cacheable(key = "'users-page-'+#p0+'-'+#p1")
    public Page4Navigator<User> list(int start, int size, int navigatePages) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page pageFromJPA = userDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    @Cacheable(key = "'users-one-name-'+#p0")
    public User getByName(String name) {
        return userDAO.findByName(name);
    }

    @Cacheable(key = "'users-one-name-'+#p0+'-password-'+#p1")
    public User get(String name, String password) {
        return userDAO.getByNameAndPassword(name, password);
    }

    public boolean isExist(String name) {
        User user = getByName(name);
        return user != null;
    }

    @CacheEvict(allEntries = true)
    public void add(User user) {
        userDAO.save(user);
    }
}
 
