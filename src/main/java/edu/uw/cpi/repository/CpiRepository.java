package edu.uw.cpi.repository;


import edu.uw.cpi.model.Cpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CpiRepository extends JpaRepository<Cpi, Long> {
    //Optional<Cpi> findByYearAndMonth(String month, int year);


    @Query("SELECT c FROM Cpi c WHERE c.month = :month AND c.year = :year ORDER BY c.id DESC")
    Optional<Cpi> findByYearAndMonthFirst(@Param("month") String month, @Param("year") int year);


}
