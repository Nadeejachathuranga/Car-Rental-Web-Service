package lk.easy_car_rental.repo;

import lk.easy_car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;


public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT carId FROM Car ORDER BY carId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT * FROM Car WHERE transmissionType =?1 and availability='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> filterByTransmissionType(String transmissionType);

    @Query(value = "SELECT * FROM Car WHERE type =?1 and availability='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> filterByVehicleType(String type);

    @Query(value = "SELECT * FROM Car WHERE fuelType =?1 and availability='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> filterByFuelType(String fuelType);

    @Query(value = "SELECT * FROM Car WHERE brand =?1 and availability='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> filterByBrand(String brand);
}
