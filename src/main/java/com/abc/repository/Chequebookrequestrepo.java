package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.model.Chequebookrequest;

@Repository
public interface Chequebookrequestrepo extends JpaRepository<Chequebookrequest, Integer> {
	
	 @Query(value="Select * from chequebookrequest where serviceRequestId=:serviceRequestId",nativeQuery=true)
	 List<Chequebookrequest> findbyserviceid(int serviceRequestId);

	 @Query(value="Select * from chequebookrequest where responsestatus=:status",nativeQuery=true)
	 List<Chequebookrequest> getrequeststatus(String status);

}
