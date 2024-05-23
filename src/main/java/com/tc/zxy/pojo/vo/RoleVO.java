package com.tc.zxy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String roleName;
    private String remark;
}
