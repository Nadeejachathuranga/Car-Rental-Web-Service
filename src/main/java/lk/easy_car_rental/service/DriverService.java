package lk.easy_car_rental.service;

import lk.easy_car_rental.dto.DriverDTO;

import java.util.ArrayList;
import java.util.List;


public interface DriverService {

    void addDriver(DriverDTO dto);

    void deleteDriver(String id);

    List<DriverDTO> getAllDrivers();

    DriverDTO findDriver(String id);

    void updateDriver(DriverDTO dto);

    String getLastIndex();

    ArrayList<DriverDTO> getAllAvailableDriver();
}
