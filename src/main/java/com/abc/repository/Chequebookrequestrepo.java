package com.abcbankk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbankk.model.ChequebookRequest;

@Repository
public interface ChequebookRequestRepo extends JpaRepository<ChequebookRequest, Integer> {

	 @Query(value="Select * from chequebook_request where service_request_id=:serviceRequestId",nativeQuery=true)
	 List<ChequebookRequest> findbyserviceid(@Param("serviceRequestId")int serviceRequestId);

	 @Query(value="Select * from chequebook_request where account_number=:accountNumber",nativeQuery=true)
	List<ChequebookRequest> findByAccountNumber(@Param("accountNumber")long accountNumber);

	 @Query(value="Select * from chequebook_request where account_number=:accountNumber and response_status=:status",nativeQuery=true)
	List<ChequebookRequest> getstatusandAccountnumber(@Param("status")String status,@Param("accountNumber") long accountNumber);


}
