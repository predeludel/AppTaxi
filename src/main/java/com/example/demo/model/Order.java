package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private Long placeStart;
    private Long placeFinish;
    private Long idClient;
    private Long idDriver;
    private Long price;

    public Long getId() {
        return id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getPlaceStart() {
        return placeStart;
    }

    public void setPlaceStart(Long placeStart) {
        this.placeStart = placeStart;
    }

    public Long getPlaceFinish() {
        return placeFinish;
    }

    public void setPlaceFinish(Long placeFinish) {
        this.placeFinish = placeFinish;
    }

    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
