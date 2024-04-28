package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.model.Creditordebitrequest;
import com.abc.service.Creditordebitrequestservice;



public interface Creditordebitrequestrepo extends JpaRepository<Creditordebitrequest, Integer>{

//	List<Creditordebitrequest> findbyaccountnumber(long accountNumber);
//	
//	List<Creditordebitrequest>getrequeststatus(String status);
//	
//	@Query(value = "select*from Creditordebitrequest where serviceRequestId=:serviceRequestId", nativeQuery=true)
//  List<Creditordebitrequest> findbyserviceId(int serviceRequestId);
//	
//	@Query (value="Select *from Creditordebitrequest where accountNumber=:accountNumber",nativeQuery = true)
//	List<Creditordebitrequest> findbyaccountnumber(long accountNumber);
//	
	@Query(value="Select * from creditdebitrequest where servicerequest_id=:service_request_id",nativeQuery=true)
	List<Creditordebitrequest> findByservicerequestId(int serviceRequestId);

	 @Query(value="Select * from creditdebitrequest where responseStatus=:status",nativeQuery=true)
	List<Creditordebitrequest> getrequeststatus(String status);

	
}