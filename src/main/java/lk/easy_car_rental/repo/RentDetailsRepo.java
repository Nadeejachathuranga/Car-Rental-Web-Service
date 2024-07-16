package lk.easy_car_rental.repo;

import lk.easy_car_rental.entity.RentDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RentDetailsRepo extends JpaRepository<RentDetails,String> {
}
