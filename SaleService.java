package com.example.salesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.salesservice.repository.SaleRepository;
import com.example.salesservice.model.Sale;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale addSale(Sale sale) {
        sale.setSaleTime(LocalDateTime.now());
        return saleRepository.save(sale);
    }

    public Double getTotalSalesForToday() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);
        return saleRepository.getTotalSalesForDay(startOfDay, endOfDay);
    }
}
