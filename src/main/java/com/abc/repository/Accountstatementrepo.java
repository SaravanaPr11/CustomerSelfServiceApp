package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.model.Accountstatement;
@Repository
public interface Accountstatementrepo extends JpaRepository <Accountstatement,Integer> {
	
	
	@Query("Select e from Accountstatement e where e.Account.accountNumber=:accountNumber")
	List< Accountstatement> findByAccountnumber(@Param("accountNumber") long accountNumber);
	

}
