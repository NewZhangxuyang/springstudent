package com.tc.zxy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer menuId;
    private String menuName;
    private String code;
    private Integer type;
    private List<MenuVO> children;
}
