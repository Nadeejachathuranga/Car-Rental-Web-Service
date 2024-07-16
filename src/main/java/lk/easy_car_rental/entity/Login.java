package lk.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Login {
    @Id
    private String userId;
    private String userName;
    private String passWord;
    private String role;
}
