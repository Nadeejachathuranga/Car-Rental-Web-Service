package lk.easy_car_rental.controller;

import lk.easy_car_rental.dto.CarDTO;
import lk.easy_car_rental.service.CarService;
import lk.easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;



@RestController
@RequestMapping("/car")
@CrossOrigin
@Transactional
public class CarController {

    @Autowired
    CarService service;

    @GetMapping
    public ResponseUtil getAllCars() {
        return new ResponseUtil("Ok", "Successfully Loaded", service.getAllCars());
    }

    @PostMapping
    public ResponseUtil addCar(CarDTO dto) {
        System.out.println(dto);
        service.addCar(dto);
        return new ResponseUtil("Ok", "Successfully Added", dto.getCarId());
    }

    @DeleteMapping(params = {"carId"})
    public ResponseUtil deleteCar(String carId) {
        service.deleteCar(carId);
        return new ResponseUtil("Ok", "Successfully Deleted", carId);
    }

    @PostMapping(path = "/update")
    public ResponseUtil updateCar(CarDTO dto) {
        service.updateCar(dto);
        return new ResponseUtil("Ok", "Successfully Updated", dto.getCarId());
    }

    @GetMapping(params = {"carId"})
    public ResponseUtil findCar(String carId) {
        return new ResponseUtil("Ok", "Successfully Searched", service.findCar(carId));
    }

    @GetMapping(path = "/newId")
    public ResponseUtil generateNewCusId() {
        return new ResponseUtil("Ok", "Successfully Id Generated", service.getLastCusId());
    }

    @GetMapping(path = "/search", params = {"transmission"})
    public ResponseUtil searchedByTransmissionType(@RequestParam String transmission) {
        return new ResponseUtil("OK", "Successfully Searched", service.filterByTransmissionType(transmission));
    }

    @GetMapping(path = "/search/type", params = {"type"})
    public ResponseUtil searchedByVehicleType(@RequestParam String type) {
        return new ResponseUtil("OK", "Successfully Searched", service.filterByVehicleType(type));
    }

    @GetMapping(path = "/search/fuel", params = {"fuelType"})
    public ResponseUtil searchedByFuelType(@RequestParam String fuelType) {
        return new ResponseUtil("OK", "Successfully Searched", service.filterByFuelType(fuelType));
    }

    @GetMapping(path = "/search/brand", params = {"brand"})
    public ResponseUtil searchedByBrand(@RequestParam String brand) {
        return new ResponseUtil("OK", "Successfully Searched", service.filterByBrand(brand));
    }
}
