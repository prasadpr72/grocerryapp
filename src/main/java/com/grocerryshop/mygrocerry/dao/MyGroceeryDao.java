package com.grocerryshop.mygrocerry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocerryshop.mygrocerry.entity.MyGrocerry;

public interface MyGroceeryDao extends JpaRepository<MyGrocerry, Long> {

}