package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MonthlyExpense;

public interface MonthlyExpenseRepo extends JpaRepository<MonthlyExpense,Long>{

}
