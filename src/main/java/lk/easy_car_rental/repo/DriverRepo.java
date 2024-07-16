package lk.easy_car_rental.repo;

import lk.easy_car_rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;


public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "SELECT dId FROM Driver ORDER BY dId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT * FROM Driver WHERE availability='AVAILABLE'", nativeQuery = true)
    ArrayList<Driver> getAllAvailableDrivers();
}
