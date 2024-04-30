package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.model.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer> {
	
	 @Query("SELECT e FROM Customer e WHERE e.userName = :userName AND e.password = :password")
	    Customer findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);


}