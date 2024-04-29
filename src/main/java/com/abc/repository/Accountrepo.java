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
	@Query(value="Select a.* from account a, creditdebitrequest b, loststolencard c, chequebookrequest d " + "where b.accountNumber=a.accountNumber and c.accountNumber=d.accountNumber and a.accountNumber=:accountNumber",nativeQuery=true)
	List<Accountstatement> getbyAccountNumber(long accountNumber);

	
}
