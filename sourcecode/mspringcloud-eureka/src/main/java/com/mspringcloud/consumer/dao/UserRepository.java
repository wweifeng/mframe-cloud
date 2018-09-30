package com.mspringcloud.consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mspringcloud.consumer.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
