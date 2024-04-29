package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.model.Lostorstolenrequest;

@Repository
public interface Lostorstolenrequestrepo extends JpaRepository<Lostorstolenrequest, Integer> {

	@Query(value="select * from Lostorstolen_request where service_request_id=:service_request_id ",nativeQuery=true)
    List<Lostorstolenrequest> findbyservicerequestid(int service_request_id);



    @Query(value="select * from Lostorstolen_request where response_status=:status",nativeQuery=true)

    List<Lostorstolenrequest> getrequeststatus(String status);



    @Query(value="select * from Lostorstolen_request where account_number=:account_number",nativeQuery=true)

    List<Lostorstolenrequest> findbyaccountnumber(Long account_number);
}
