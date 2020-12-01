package com.wei.oauth2.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author skye
 * @version 1.0
 * @description:
 * @date 2020/11/30 16:01
 */

@Data
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "username")
    private String userName;
    private String password;
}
