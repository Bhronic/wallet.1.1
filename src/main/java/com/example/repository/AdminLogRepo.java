package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Admin;



public interface AdminLogRepo extends JpaRepository<Admin, Long> {

	public List<Admin> findByuserName(String userName);


}
