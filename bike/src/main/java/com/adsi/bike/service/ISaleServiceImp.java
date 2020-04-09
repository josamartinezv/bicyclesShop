package com.adsi.bike.service;

import com.adsi.bike.domain.Sale;
import com.adsi.bike.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ISaleServiceImp implements ISAleService {

    @Autowired
    SaleRepository saleRepository;

    @Override
    public Iterable<Sale> read() { return saleRepository.findAll(); }

    @Override
    public Sale update(Sale sale) { return saleRepository.save(sale); }

    @Override
    public void delete(Integer id) { saleRepository.deleteById(id); }

    @Override
    public Sale create(Sale sale) {
        sale.setDateSale(LocalDateTime.now());
        return saleRepository.save(sale); }

    @Override
    public Optional<Sale> getById(@PathVariable Integer id) { return saleRepository.findById(id); }
}
