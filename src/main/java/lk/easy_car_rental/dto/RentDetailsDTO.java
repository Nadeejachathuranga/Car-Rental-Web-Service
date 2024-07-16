package lk.easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetailsDTO {
    private String carID;
    private String rentID;
    private String driverID;
}
