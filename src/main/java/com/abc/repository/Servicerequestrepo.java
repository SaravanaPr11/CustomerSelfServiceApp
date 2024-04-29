package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Servicerequest;

public interface Servicerequestrepo extends JpaRepository<Servicerequest, Integer> {

}
