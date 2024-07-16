package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.CarDTO;
import lk.easy_car_rental.entity.Car;
import lk.easy_car_rental.repo.CarRepo;
import lk.easy_car_rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCar(CarDTO dto) {
        if (repo.existsById(dto.getCarId())) {
            throw new RuntimeException(dto.getCarId() + " is already available, please insert a new ID");
        }

        Car map = mapper.map(dto, Car.class);

        try {

            /*String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).
                    getParentFile().getParentFile().getAbsolutePath();*/

            String projectPath = "E:\\Semester_2_Final\\Car_Rental_System\\upload";
            System.out.println(projectPath);
            File uploadsDir = new File(projectPath + "/upload");
            uploadsDir.mkdir();

            dto.getFrontView().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontView().getOriginalFilename()));
            dto.getBackView().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getBackView().getOriginalFilename()));
            dto.getSideView().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getSideView().getOriginalFilename()));
            dto.getInterior().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getInterior().getOriginalFilename()));

            map.setFrontView("upload/" + dto.getFrontView().getOriginalFilename());
            map.setBackView("upload/" + dto.getBackView().getOriginalFilename());
            map.setSideView("upload/" + dto.getSideView().getOriginalFilename());
            map.setInterior("upload/" + dto.getInterior().getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        repo.save(map);
    }

    @Override
    public void deleteCar(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Car is not available, please check the ID before delete.!");
        }
        repo.deleteById(id);
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<Car>>() {
        }.getType());
    }

    @Override
    public Car findCar(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Car is not available, please check the ID.!");
        }
        Car car = repo.findById(id).get();
        return mapper.map(car, Car.class);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getCarId())) {
            throw new RuntimeException(dto.getCarId() + " Car is not available, please check the ID before update.!");
        }

        Car map = mapper.map(dto, Car.class);

        try {

           /* String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).
                    getParentFile().getParentFile().getAbsolutePath();*/

            String projectPath = "E:\\Semester_2_Final\\Car_Rental_System\\upload";
            System.out.println(projectPath);
            File uploadsDir = new File(projectPath + "/upload");
            uploadsDir.mkdir();

            dto.getFrontView().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontView().getOriginalFilename()));
            dto.getBackView().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getBackView().getOriginalFilename()));
            dto.getSideView().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getSideView().getOriginalFilename()));
            dto.getInterior().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getInterior().getOriginalFilename()));

            map.setFrontView("upload/" + dto.getFrontView().getOriginalFilename());
            map.setBackView("upload/" + dto.getBackView().getOriginalFilename());
            map.setSideView("upload/" + dto.getSideView().getOriginalFilename());
            map.setInterior("upload/" + dto.getInterior().getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        repo.save(map);
    }

    @Override
    public String getLastCusId() {
        return repo.getLastIndex();
    }

    @Override
    public ArrayList<CarDTO> filterByTransmissionType(String transmissionType) {
        ArrayList<Car> cars = repo.filterByTransmissionType(transmissionType);
        return mapper.map(cars, new TypeToken<ArrayList<Car>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> filterByVehicleType(String type) {
        ArrayList<Car> cars = repo.filterByVehicleType(type);
        return mapper.map(cars, new TypeToken<ArrayList<Car>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> filterByFuelType(String fuelType) {
        ArrayList<Car> cars = repo.filterByFuelType(fuelType);
        return mapper.map(cars, new TypeToken<ArrayList<Car>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> filterByBrand(String brand) {
        ArrayList<Car> cars = repo.filterByBrand(brand);
        return mapper.map(cars, new TypeToken<ArrayList<Car>>() {
        }.getType());
    }
}
