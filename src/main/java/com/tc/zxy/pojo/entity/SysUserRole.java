package com.tc.zxy.pojo.entity;

import com.tc.zxy.pojo.entity.compositePK.SysUserRolePK;
import jakarta.persistence.*;

@Entity(name = "sys_role_user")
@IdClass(SysUserRolePK.class)
public class SysUserRole {

    @Id
    @Column(name = "rid")
    private Integer roleId;
    @Id
    @Column(name = "uid")
    private Integer userId;


}
