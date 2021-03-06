package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 0:24
 */
@Service(value = "userService")
public class IUserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(IUserServiceImpl.class);


    @Override
    public void testSpringJunitConfig(String word) {
        System.out.println("==============================================");
        log.warn("test the spring junit config : Hello " + word);
        System.out.println("==============================================");
    }
}
