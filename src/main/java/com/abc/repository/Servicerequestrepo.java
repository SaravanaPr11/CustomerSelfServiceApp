package com.abcbankk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcbankk.model.ServiceRequest;

@Repository
public interface ServiceRequestRepo extends JpaRepository<ServiceRequest, Integer> {





}
