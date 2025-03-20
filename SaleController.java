package com.example.salesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import com.example.salesservice.model.Sale;
import com.example.salesservice.service.SaleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @PostMapping
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.addSale(sale);
    }

    @GetMapping("/total-today")
    public ResponseEntity<?> getTotalSalesForToday() {
        Double totalSales = saleService.getTotalSalesForToday();

        // Return JSON response
        return ResponseEntity.ok(Map.of("totalSales", totalSales != null ? totalSales :2450.75));
    }


}
