package lk.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;



@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Car {

    @Id
    private String carId;
    private String brand;
    private String type;
    private String transmissionType;
    private String fuelType;
    private int noOfPassengers;
    private String frontView;
    private String backView;
    private String sideView;
    private String interior;
    private double dailyRate;
    private double monthlyRate;
    private double extraKmPrice;
    private double freeMileage;
    private String regNo;
    private String color;
    private String availability;

}
