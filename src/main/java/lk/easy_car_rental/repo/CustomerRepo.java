package lk.easy_car_rental.repo;

import lk.easy_car_rental.dto.CustomerDTO;
import lk.easy_car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepo extends JpaRepository<Customer, String> {
    @Query(value = "SELECT cusId FROM Customer ORDER BY cusId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
