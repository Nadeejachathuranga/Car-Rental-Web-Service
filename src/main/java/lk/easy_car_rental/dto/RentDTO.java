package lk.easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDTO {
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private String requestDate;
    private String status;
    private CustomerDTO customer;
    private List<RentDetailsDTO> rentDetails;
}
