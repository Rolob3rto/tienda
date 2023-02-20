package com.rolob3rto.springprojects.tienda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.model.Permission;
import com.rolob3rto.springprojects.tienda.model.User;
import com.rolob3rto.springprojects.tienda.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User usuario = userRepository.findByNombre(username);        

        List<Permission> permisos = usuario.getPermisos();
        List<GrantedAuthority> permisosNombres = new ArrayList<>();

        for (Permission permission : permisos) {            
            permisosNombres.add(new SimpleGrantedAuthority(permission.getName()));
        }
        
        UserDetails user = org.springframework.security.core.userdetails.User.builder()        
            .username(usuario.getNombre())
            .password(usuario.getPassword())     
            .authorities(permisosNombres)
            .build();
    

        return  user;
    }
}


