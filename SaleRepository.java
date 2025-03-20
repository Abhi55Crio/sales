package com.example.salesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.salesservice.model.Sale;
import java.time.LocalDateTime;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    @Query("SELECT SUM(s.amount) FROM Sale s WHERE s.saleTime BETWEEN :start AND :end")
    Double getTotalSalesForDay(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
