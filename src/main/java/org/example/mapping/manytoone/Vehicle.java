package org.example.mapping.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {
    @Id
    private int id;
    private String registrationNo;
    private String brand;
    @ManyToOne()
    private Driver driver;

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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", registrationNo='" + registrationNo + '\'' +
                ", brand='" + brand + '\'' +
                ", driver=" + driver.getName() +
                '}';
    }
}
