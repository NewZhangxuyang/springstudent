package com.tc.zxy.pojo.entity;

import com.tc.zxy.pojo.entity.compositePK.SysRoleMenuPK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity(name = "sys_role_menu")
@IdClass(SysRoleMenuPK.class)
public class SysRoleMenu {

    @Id
    @Column(name = "rid")
    private Integer roleId;

    @Id
    @Column(name = "mid")
    private Integer menuId;

    public SysRoleMenu() {
    }

    public SysRoleMenu(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SysRoleMenu that = (SysRoleMenu) o;
        return getRoleId() != null && Objects.equals(getRoleId(), that.getRoleId())
                && getMenuId() != null && Objects.equals(getMenuId(), that.getMenuId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(roleId, menuId);
    }
}
