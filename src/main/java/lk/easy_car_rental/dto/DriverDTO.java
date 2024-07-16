package lk.easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String userId;
    private String name;
    private String contact;
    private String address;
    private String licenseNo;
    private String availability;
    private LoginDTO loginDTO;
}
