package com.wei.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.oauth2.domain.Role;
import com.wei.oauth2.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author skye
 * @version 1.0
 * @description:
 * @date 2020/11/30 16:04
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select name from role r INNER JOIN user_role ur on ur.user_id=1 and ur.role_id=r.id")
    List<Role> selectRoleByUserId(Integer id);
}
