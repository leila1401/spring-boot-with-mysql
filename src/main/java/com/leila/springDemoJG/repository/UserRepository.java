package com.leila.springDemoJG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leila.springDemoJG.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
