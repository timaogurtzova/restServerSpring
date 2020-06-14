package com.hellocat.restServerSpring.repository;

import com.hellocat.restServerSpring.domen.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByName(String name);

}

