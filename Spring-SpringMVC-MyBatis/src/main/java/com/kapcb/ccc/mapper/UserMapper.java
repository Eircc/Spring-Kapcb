package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/27 - 18:37
 */
@Repository("userMapper")
public interface UserMapper {

    /**
     * 获取User信息列表
     *
     * @return List<User>
     */
    List<User> getUserList();

    /**
     * 根据Id查询User
     *
     * @param id Long
     * @return User
     */
    User getUserInfoByUserId(Long id);

    /**
     * 新增User
     *
     * @return boolean
     */
    boolean addUser();

    /**
     * 修改User信息
     *
     * @return boolean
     */
    boolean modifyUser();

    /**
     * 根据Id删除用户
     *
     * @param userId Long
     * @return boolean
     */
    boolean deleteUserByUserId(Long userId);

    /**
     * 批量删除用户
     *
     * @param userIds String[]
     * @return boolean
     */
    boolean deleteUserByUserIdBatch(String[] userIds);

}
