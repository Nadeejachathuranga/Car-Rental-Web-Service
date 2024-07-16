package lk.easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;



@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private String payId;
    private LocalDate date;
    private LocalTime time;
    private double lostDamage;
    private double total;
    private RentDTO rentDTO;
}
