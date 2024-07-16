package lk.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Driver {
    @Id
    @Column(name = "dId")
    private String userId;
    private String name;
    private String contact;
    private String address;
    private String licenseNo;
    private String availability;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
}
