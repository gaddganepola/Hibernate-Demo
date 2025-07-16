package org.example.mapping.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
    private int id;
    private String registrationNo;
    private String brand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", registrationNo='" + registrationNo + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
