package com.adsi.bike.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private  int id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateSale;

    @ManyToOne
    private Bike bike;

    @ManyToOne
    private Client client;

    public Sale() {
    }
    public Sale(LocalDateTime dateSale, Bike bike, Client client) {
        this.dateSale = dateSale;
        this.bike = bike;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateSale() {
        return dateSale;
    }

    public void setDateSale(LocalDateTime dateSale) {
        this.dateSale = dateSale;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
