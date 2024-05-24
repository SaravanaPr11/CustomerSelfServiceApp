package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.model.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer>{

	@Query("SELECT e from Customer e Where e.userName=:userName")
	Customer findbyUserNameAndPassword(@Param("userName") String userName);


}
