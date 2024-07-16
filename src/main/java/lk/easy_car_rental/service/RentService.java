package lk.easy_car_rental.service;

import lk.easy_car_rental.dto.RentDTO;
import lk.easy_car_rental.entity.Rent;

import java.util.ArrayList;


public interface RentService {

    String getLastIndex();

    void addRent(RentDTO dto);

    ArrayList<RentDTO> getAllRents();

    void deleteRent(String id);

    ArrayList<Rent> getAllPendingRents();

    void updateRent(RentDTO dto);

    RentDTO findRent(String id);
}
