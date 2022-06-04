package com.bootcamp.homework1.repo;

import com.bootcamp.homework1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
