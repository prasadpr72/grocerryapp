package com.grocerryshop.mygrocerry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocerryshop.mygrocerry.entity.GroceeryUser;

public interface UserDao extends JpaRepository<GroceeryUser,Long> {

}

