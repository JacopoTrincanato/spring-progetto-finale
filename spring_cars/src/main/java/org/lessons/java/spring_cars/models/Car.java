package org.lessons.java.spring_cars.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car {

    // variabili d'istanza
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(name = "car_optionals", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "optional_id"))
    private List<Optionals> optionals;

    @Size(min = 5, max = 100, message = "car model field cannot be shorter than 5 chars and longer than 100")
    @NotBlank(message = "car model field cannot be blank, empty or null")
    private String model;

    @Lob
    @NotBlank(message = "url image field cannot be blank, empty or null")
    private String urlImage;

    @NotNull(message = "production date field cannot be null")
    @PastOrPresent(message = "production date field cannot be set in the future")
    private LocalDate productionDate;

    @Size(min = 5, max = 20, message = "fuel type field cannot be shorter than 5 chars and longer than 20")
    @NotBlank(message = "fuel type field cannot be blank, empty or null")
    private String fuelType;

    @Size(min = 1, max = 20, message = "color field cannot be shorter than 1 chars and longer than 20")
    @NotBlank(message = "color field cannot be blank, empty or null")
    private String color;

    @NotNull(message = "number of doors field cannot be null")
    @Min(value = 2, message = "number of doors field cannot be less than 2")
    @Max(value = 5, message = "number of doors field cannot be greater than 5")
    private Integer numberOfDoors;

    @NotNull(message = "price field cannot be null")
    @Min(value = 0, message = "price field value cannot be less than 0")
    private BigDecimal price;

    @Lob
    private String description;

    // metodi
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Optionals> getOptionals() {
        return this.optionals;
    }

    public void setOptionals(List<Optionals> optionals) {
        this.optionals = optionals;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public LocalDate getProductionDate() {
        return this.productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
