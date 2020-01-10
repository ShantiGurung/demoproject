package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PersonDao extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

	@Query("SELECT u FROM Person u")
	List<Person> getAll();

}
