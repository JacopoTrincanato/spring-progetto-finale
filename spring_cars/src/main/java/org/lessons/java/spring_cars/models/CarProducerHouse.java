package org.lessons.java.spring_cars.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "producer_houses")
public class CarProducerHouse {

    // variabili d'istanza
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "producerHouse")
    private List<Car> cars;

    @Size(min = 5, max = 250, message = "producer house name field cannot be shorter than 5 chars and longer than 250")
    @NotBlank(message = "producer house name field cannot be blank, empty or null")
    private String name;

    @Size(min = 5, max = 50, message = "producer house city location field cannot be shorter than 5 chars and longer than 50")
    private String cityLocation;

    // metodi
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityLocation() {
        return this.cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

}
