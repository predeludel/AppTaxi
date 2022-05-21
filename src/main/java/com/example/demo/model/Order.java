package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private String placeStart;
    private String placeFinish;
    private Long idDriver;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getPlaceStart() {
        return placeStart;
    }

    public void setPlaceStart(String placeStart) {
        this.placeStart = placeStart;
    }

    public String getPlaceFinish() {
        return placeFinish;
    }

    public void setPlaceFinish(String placeFinish) {
        this.placeFinish = placeFinish;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public Long getIdDriver() {
        return idDriver;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }


}
