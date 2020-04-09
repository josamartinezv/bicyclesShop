package com.adsi.bike.domain;

import javax.persistence.*;

@Entity
public class Bike {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private int id;

    private String model;
    private String serial;
    private double price;

    public Bike() {
    }
    public Bike(String model, String serial, Double price){
        this.model = model;
        this.serial = serial;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
