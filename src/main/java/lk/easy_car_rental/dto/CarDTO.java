package lk.easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;



@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
    private String carId;
    private String brand;
    private String type;
    private String transmissionType;
    private String fuelType;
    private int noOfPassengers;
    private MultipartFile frontView;
    private MultipartFile backView;
    private MultipartFile sideView;
    private MultipartFile interior;
    private double dailyRate;
    private double monthlyRate;
    private double extraKmPrice;
    private double freeMileage;
    private String regNo;
    private String color;
    private String availability;
}
