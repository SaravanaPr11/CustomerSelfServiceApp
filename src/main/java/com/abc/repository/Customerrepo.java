package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import com.abc.model.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer> {
	@Query("select e from Customer e where e.userName= :userName")
	Customer find(@Param("userName")String username);

}
