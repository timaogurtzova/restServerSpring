package com.hellocat.restServerSpring.service;

import com.hellocat.restServerSpring.domen.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    Role findRoleWithName(String roleTypeName);

}
