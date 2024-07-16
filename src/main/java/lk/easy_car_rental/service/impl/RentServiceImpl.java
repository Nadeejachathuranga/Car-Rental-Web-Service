package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.RentDTO;
import lk.easy_car_rental.dto.RentDetailsDTO;
import lk.easy_car_rental.entity.Car;
import lk.easy_car_rental.entity.Driver;
import lk.easy_car_rental.entity.Rent;
import lk.easy_car_rental.entity.RentDetails;
import lk.easy_car_rental.repo.CarRepo;
import lk.easy_car_rental.repo.DriverRepo;
import lk.easy_car_rental.repo.RentDetailsRepo;
import lk.easy_car_rental.repo.RentRepo;
import lk.easy_car_rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Transactional
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo repo;

    @Autowired
    RentDetailsRepo detailsRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public String getLastIndex() {
        return repo.getLastIndex();
    }

    @Override
    public void addRent(RentDTO dto) {

        Rent rent = mapper.map(dto, Rent.class);

        if (repo.existsById(dto.getRentID())) {
            throw new RuntimeException(dto.getRentID() + " is already available, please insert a new ID");
        }
        System.out.println("1-----------------------------------------" + dto);


        /*update car*/
        List<RentDetails> rentDetails1 = rent.getRentDetails();
        for (RentDetails rentDetail : rentDetails1) {
            Car car = carRepo.findById(rentDetail.getCarID()).get();
            car.setAvailability("NON-AVAILABLE");
            carRepo.save(car);
        }

        /*driver update*/
        List<RentDetails> rentDetails2 = rent.getRentDetails();
        for (RentDetails rentDetail : rentDetails2) {
            Driver driver = driverRepo.findById(rentDetail.getDriverID()).get();
            driver.setAvailability("NON-AVAILABLE");
            driverRepo.save(driver);
        }

        /*add rent*/
        System.out.println(rent);
        repo.save(rent);
    }


    @Override
    public ArrayList<RentDTO> getAllRents() {
        List<Rent> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RentDTO>>() {
        }.getType());
    }

    @Override
    public void deleteRent(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Rent Request is not available, please check the ID before delete.!");
        }
        Rent rent = repo.findById(id).get();

        /*first update car*/
        List<RentDetails> rentDetails1 = rent.getRentDetails();
        for (RentDetails rentDetail : rentDetails1) {
            Car car = carRepo.findById(rentDetail.getCarID()).get();
            car.setAvailability("AVAILABLE");
            carRepo.save(car);
        }

        /*driver update*/
        List<RentDetails> rentDetails2 = rent.getRentDetails();
        for (RentDetails rentDetail : rentDetails2) {
            Driver driver = driverRepo.findById(rentDetail.getDriverID()).get();
            driver.setAvailability("AVAILABLE");
            driverRepo.save(driver);
        }

        /*delete rent from table*/
        repo.deleteById(id);
    }

    @Override
    public ArrayList<Rent> getAllPendingRents() {
        List<Rent> all = repo.getAllPendingRents();
        return mapper.map(all, new TypeToken<ArrayList<RentDTO>>() {
        }.getType());
    }

    @Override
    public void updateRent(RentDTO dto) {
        if (!repo.existsById(dto.getRentID())) {
            throw new RuntimeException(dto.getRentID() + " Rent request is not available, please check the ID before update.!");
        }
        Rent map = mapper.map(dto, Rent.class);
        repo.save(map);
    }

    @Override
    public RentDTO findRent(String id) {
        Rent rent = repo.findById(id).get();
        return mapper.map(rent, RentDTO.class);
    }
}
