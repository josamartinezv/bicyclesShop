package com.adsi.bike.web.rest;

import com.adsi.bike.domain.Sale;
import com.adsi.bike.service.ISAleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SaleResource {

    @Autowired
    ISAleService saleservice;

    @PostMapping("/sale")
    public Sale create (@RequestBody Sale sale) { return saleservice.create(sale); }

    @GetMapping("/sale")
    public Iterable<Sale> read() { return saleservice.read(); }

    @DeleteMapping("/sale/{id}")
    public void delete(@PathVariable Integer id) { saleservice.delete(id); }

    @PutMapping("/sale")
    public Sale update(@RequestBody Sale sale) { return saleservice.update(sale); }

    @GetMapping("/sale/{id}")
    public Optional<Sale> getById(@PathVariable Integer id) { return saleservice.getById(id); }



}
