package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Logbook;

@Repository
public interface Logbookrepo extends JpaRepository<Logbook, Long> {
	
	@Query("FROM Logbook  WHERE (user LIKE :user) AND (active LIKE :active) AND (month(date) LIKE  :currentmonth) ORDER BY date DESC	")
	public List<Logbook> findByUserAndActive(@Param("user")String user, @Param("active")int active,@Param("currentmonth") int currentmonth,Pageable page);
	

	@Query("FROM Logbook  WHERE (user LIKE :user) AND (active LIKE :active) AND (month(date) LIKE  :currentmonth) ORDER BY date DESC	")
	public List<Logbook> findByUserAndActive(@Param("user")String user, @Param("active")int active,@Param("currentmonth") int currentmonth);
	
	
	@Query("FROM Logbook   WHERE  date  BETWEEN   :date1 AND  :date2  AND (user like :user) AND (active like :active) ORDER BY date DESC")
	public List<Logbook> findByDateAndActive(@Param("date1") String date1 , @Param("date2") String date2 , @Param("user") String user,@Param("active") int active, Pageable page);
	
	
	@Query("FROM Logbook   WHERE  date  BETWEEN   :date1 AND  :date2  AND (user like :user) AND (active like :active) ORDER BY date DESC")
	public List<Logbook> findByDateAndActive(@Param("date1") String date1 , @Param("date2") String date2 , @Param("user") String user,@Param("active") int active);

	@Query("SELECT SUM(amount) FROM Logbook WHERE (user LIKE :user) AND (active LIKE :active)")
	public String totalExpense(@Param("user")String user, @Param("active")int active);
	
	
	@Query("SELECT SUM(amount) FROM Logbook WHERE (user LIKE :user) AND (active LIKE :active) AND (month(date) LIKE  :currentmonth) ORDER BY date DESC")
	public String totalExpenseCrurrentMonth(@Param("user")String user, @Param("active")int active,@Param("currentmonth") int currentmonth);
	
	@Query("SELECT SUM(amount)FROM Logbook   WHERE  date  BETWEEN   :date1 AND  :date2  AND (user like :user) AND (active like :active) ORDER BY date DESC")
	public String totalExpenseFilterRecord(@Param("date1") String date1 , @Param("date2") String date2 , @Param("user") String user,@Param("active") int active);
	
	@Query("SELECT SUM(amount) FROM Logbook WHERE (payment like :payment) AND (user like :user) AND (active like :active)")
	public String calculateincome(@Param("payment") String payment,@Param("user")String user, @Param("active")int active);
	
	@Query("SELECT SUM(amount) FROM Logbook WHERE (payment like :payment) AND (user like :user) AND (active like :active) AND (month(date) like :currentmonth) ORDER BY date DESC")
	public String calculateincomecurrentmonth(@Param("payment") String payment,@Param("user")String user, @Param("active")int active,@Param("currentmonth") int currentmonth);
	
	@Query("SELECT SUM(amount)FROM Logbook   WHERE  date  BETWEEN   :date1 AND  :date2  AND (user like :user) AND (active like :active) AND (payment like :payment) ORDER BY date DESC")
	public String totalIncomeFilterRecord(@Param("date1") String date1 , @Param("date2") String date2 , @Param("user") String user,@Param("active") int active,@Param("payment") String payment);
	
	public Logbook findByid(Long id);

}
