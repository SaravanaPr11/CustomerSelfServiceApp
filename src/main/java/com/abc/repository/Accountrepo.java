package com.abcbankk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbankk.model.Account;

@Repository
public interface Accountrepo extends JpaRepository<Account, Long> {

	@Query(value = "select * from account where customer_id=:customerId", nativeQuery = true)
	List<Account>findByCustomerId(@Param("customerId") int customerId);

}
