package com.mspringcloud.provider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mspringcloud.provider.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
