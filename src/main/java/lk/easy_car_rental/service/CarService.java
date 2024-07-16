package lk.easy_car_rental.service;

import lk.easy_car_rental.dto.CarDTO;
import lk.easy_car_rental.entity.Car;

import java.util.ArrayList;


public interface CarService {

    void addCar(CarDTO dto);

    void deleteCar(String id);

    ArrayList<CarDTO> getAllCars();

    Car findCar(String id);

    void updateCar(CarDTO dto);

    String getLastCusId();

    ArrayList<CarDTO> filterByTransmissionType(String transmissionType);

    ArrayList<CarDTO> filterByVehicleType(String type);

    ArrayList<CarDTO> filterByFuelType(String fuelType);

    ArrayList<CarDTO> filterByBrand(String brand);
}
