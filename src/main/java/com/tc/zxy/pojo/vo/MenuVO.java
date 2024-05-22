package com.tc.zxy.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @JsonIgnore
    private Integer parentId;
    private String menuName;
    private String code;
    private Integer type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuVO> children;
}
