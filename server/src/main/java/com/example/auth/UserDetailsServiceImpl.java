package com.example.auth;

import com.example.persistence.UserMapper;
import com.example.persistence.entity.Role;
import com.example.persistence.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByLoginId(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String[] roleNames = user.getRoles().stream().map(Role::getName).toArray(String[]::new);
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleNames);
        return new UserDetailsImpl(user, authorities);
    }
}
