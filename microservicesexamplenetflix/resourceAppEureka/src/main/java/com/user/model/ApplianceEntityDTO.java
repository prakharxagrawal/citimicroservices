package com.user.model;

public class ApplianceEntityDTO {

    private Integer id;

    private String brand;

    private String model;

    private String status;


    public ApplianceEntityDTO(Integer id,String brand, String model, String status) {
        this.id=id;
        this.brand = brand;
        this.model = model;
        this.status = status;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
