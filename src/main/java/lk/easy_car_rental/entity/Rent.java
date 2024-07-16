package lk.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rent {

    @Id
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private String requestDate;
    private String status;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "cusId", referencedColumnName = "cusId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails;
}
