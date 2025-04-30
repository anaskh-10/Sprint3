package com.Anas.Pc.service;

import com.Anas.Pc.entities.Role;
import com.Anas.Pc.entities.User;

public interface UserService {
    void deleteAllusers();
    void deleteAllRoles();
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);

}
