package com.abcbankk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbankk.model.LostorstolenRequest;

@Repository
public interface LostorstolenRequestRepo extends JpaRepository<LostorstolenRequest, Integer> {



	@Query(value="select * from lostorstolen_request where service_request_id=:serviceRequestid",nativeQuery=true)
    List<LostorstolenRequest> findbyservicerequestid(@Param("serviceRequestid") int serviceRequestid);

    @Query(value="select * from lostorstolen_request where account_number=:accountNumber",nativeQuery=true)
    List<LostorstolenRequest> findbyaccountnumber(@Param("accountNumber")Long accountNumber);

    @Query(value="select * from lostorstolen_request where account_number=:accountNumber and response_status=:status",nativeQuery=true)
	List<LostorstolenRequest> getstatusandAccountNumber(@Param("status")String status,@Param("accountNumber") long accountNumber);


}
