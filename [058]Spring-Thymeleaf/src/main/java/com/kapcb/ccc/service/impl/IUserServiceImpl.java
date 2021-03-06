package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/28 22:10
 */
@Slf4j
@Service(value = "userService")
public class IUserServiceImpl implements IUserService {

    @Override
    public List<User> getUserList() {
        log.warn("get user list from user mapper");
        return UserMapper.USER_LIST;
    }
}
