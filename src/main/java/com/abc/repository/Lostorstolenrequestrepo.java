package com.abc.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.model.Lostorstolenrequest;


public interface Lostorstolenrequestrepo extends JpaRepository<Lostorstolenrequest, Integer> {

	@Query(value = "select*from Lostorstolen_request where servicerequestid=:servicerequestid", nativeQuery=true)
	List<Lostorstolenrequest> findbyservicerequestid(int serviceRequestId);
	
	@Query(value="select*from Lostorstolenrequest where responsestatus=:responsestatus", nativeQuery=true)
	List<Lostorstolenrequest>getrequeststatus(String status);
	
	@Query(value="select*from Lostorstolenrequest where accountnumber=:accountnumber",nativeQuery=true)
	List<Lostorstolenrequest>findbyaccountnumber(Long accountNumber);
}
