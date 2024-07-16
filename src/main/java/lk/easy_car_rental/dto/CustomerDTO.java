package lk.easy_car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String cusId;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String nic;
    private String license;
    private MultipartFile nic_Img;
    private MultipartFile license_Img;
    private LoginDTO loginDTO;
}
