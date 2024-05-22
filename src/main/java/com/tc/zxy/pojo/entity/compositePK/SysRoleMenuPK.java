package com.tc.zxy.pojo.entity.compositePK;

import lombok.Data;

import java.io.Serial;


@Data
public class SysRoleMenuPK implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer roleId;
    private Integer menuId;
}
