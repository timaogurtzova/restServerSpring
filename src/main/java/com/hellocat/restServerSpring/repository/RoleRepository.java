package com.hellocat.restServerSpring.repository;

import com.hellocat.restServerSpring.domen.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByRoleType(String roleType);

}
