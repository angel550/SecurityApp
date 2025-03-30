package com.securityApp.service;

import com.securityApp.persistence.entity.UserEntity;
import com.securityApp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert UserEntity to User from spring security (UserDetailsService implemented)
 */
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));

        // Roles y Permisos
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // Add ROLES
        userEntity.getRoles().forEach(role ->
                authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name())))
        );

        // Add permissions
        userEntity.getRoles().stream()
                .flatMap(r -> r.getPermissionList().stream())
                .forEach(p -> authorityList.add(new SimpleGrantedAuthority(p.getName())));

        // Return del User de spring security
        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                authorityList);
    }
}
