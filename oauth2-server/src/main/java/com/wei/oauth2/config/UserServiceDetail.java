package com.wei.oauth2.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wei.oauth2.domain.Role;
import com.wei.oauth2.domain.User;
import com.wei.oauth2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skye
 * @version 1.0
 * @description:
 * @date 2020/11/30 11:15
 */
@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = userMapper.selectRoleByUserId(user.getId());
        roles.forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new UserModel(user.getUserName(),user.getPassword(),authorities);
    }
}
