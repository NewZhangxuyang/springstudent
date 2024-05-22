package com.tc.zxy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String userName;
    private List<RoleVO> roles;
    private List<MenuVO> menus;
}
