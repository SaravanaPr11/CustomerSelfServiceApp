package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.model.Account;
import com.abc.model.Accountstatement;

@Repository
public interface Accountrepo extends JpaRepository<Account, Long>{
	@Query(value="Select * from account where customerId=:customerId",nativeQuery=true)
	List<Account> findByCustomerId(int customerId);

	@Query(value="Select * from account where customerId=:customerId",nativeQuery=true)
	List<Account> findBycustomerId(int customerId);

	List<Accountstatement> getbyAccountNumber(long accountNumber);

	
}
