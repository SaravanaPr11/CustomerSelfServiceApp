package com.abcbankk.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbankk.model.CreditordebitRequest;

@Repository
public interface CreditordebitRequestRepo extends JpaRepository<CreditordebitRequest, Integer>{

	@Query(value="Select * from creditordebit_request where service_request_id=:serviceRequestId",nativeQuery=true)
	List<CreditordebitRequest> findByservicerequestId(@Param("serviceRequestId") int serviceRequestId);

	 @Query(value="Select * from creditordebit_request where account_number=:accountNumber",nativeQuery=true)
	List<CreditordebitRequest> findbyAccountNumber(@Param("accountNumber") long accountNumber);

	 @Query(value="Select * from creditordebit_request where card_number=:cardNumber",nativeQuery=true)
	 CreditordebitRequest findbyCardNumer(@Param("cardNumber") BigInteger bigInteger);

	@Query(value="Select * from creditordebit_request where account_number=:accountNumber and response_status=:status",nativeQuery=true)
	List<CreditordebitRequest> getstatusandAccountNumber(@Param("status") String status,@Param("accountNumber") long accountNumber);

}
