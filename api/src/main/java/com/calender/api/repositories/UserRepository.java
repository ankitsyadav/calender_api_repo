package com.calender.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calender.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
