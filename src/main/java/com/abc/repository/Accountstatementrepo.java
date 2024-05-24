package com.abcbankk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbankk.model.AccountStatement;

@Repository
public interface Accountstatementrepo extends JpaRepository<AccountStatement, Integer> {


	@Query(value="Select * from account_statement where account_number =:accountNumber",nativeQuery = true)
	List< AccountStatement> findByAccountnumber(@Param("accountNumber") Long accountNumber);

}
