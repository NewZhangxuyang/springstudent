package com.tc.zxy;

import com.tc.zxy.pojo.vo.MenuVO;
import com.tc.zxy.pojo.vo.RoleVO;
import com.tc.zxy.pojo.vo.UserVO;
import com.tc.zxy.service.MenuService;
import com.tc.zxy.service.RoleService;
import com.tc.zxy.service.StudentService;
import com.tc.zxy.service.UserService;
import com.tc.zxy.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class SpringStudentTest {
    @Resource
    private StudentService studentService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    @Test
    public void testUsers() {
        userService.listRolesByUserId(1).forEach(System.out::println);
        System.out.println(userService.selectUserDetailById(1));
    }

    @Test
    public void testRoles() {
        List<RoleVO> roles = userService.listRolesByUserId(1);
        List<Integer> ins = roles.stream().map(RoleVO::getId).toList();
        roleService.listMenusByRoleIds(ins).forEach(System.out::println);
    }

    @Test
    public void testParentMenu() {
        List<RoleVO> roles = userService.listRolesByUserId(1);
        List<Integer> ins = roles.stream().map(RoleVO::getId).toList();
        List<MenuVO> parents = roleService.listMenusByRoleIds(ins);
        parents.forEach(System.out::println);
    }


    @Test
    public void testMenuChildren() {
        List<RoleVO> roles = userService.listRolesByUserId(1);
        List<Integer> ins = roles.stream().map(RoleVO::getId).toList();
        List<MenuVO> parents = roleService.listMenusByRoleIds(ins);
        roleService.setMenuChildren(parents).forEach(System.out::println);

    }


}
