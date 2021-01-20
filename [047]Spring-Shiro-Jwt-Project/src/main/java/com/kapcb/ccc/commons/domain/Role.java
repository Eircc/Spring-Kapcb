package com.kapcb.ccc.commons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * <a>Title: Role </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 21:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private String username;
    private Set<String> roles;

}
