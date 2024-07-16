package lk.easy_car_rental.repo;

import lk.easy_car_rental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;


public interface RentRepo extends JpaRepository<Rent, String> {
    @Query(value = "SELECT rentID FROM Rent ORDER BY rentID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT * FROM Rent WHERE status='Pending'", nativeQuery = true)
    ArrayList<Rent> getAllPendingRents();
}
