package lk.easy_car_rental.controller;

import lk.easy_car_rental.dto.DriverDTO;
import lk.easy_car_rental.dto.LoginDTO;
import lk.easy_car_rental.service.DriverService;
import lk.easy_car_rental.service.LoginService;
import lk.easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;



@RestController
@RequestMapping("/driver")
@CrossOrigin
@Transactional
public class DriverController {

    @Autowired
    DriverService service;

    @Autowired
    LoginService loginService;

    @GetMapping
    public ResponseUtil getAllDrivers() {
        List<DriverDTO> allDrivers = service.getAllDrivers();
        System.out.println(allDrivers);
        return new ResponseUtil("Ok", "Successfully Loaded", service.getAllDrivers());
    }

    @PostMapping
    public ResponseUtil addDriver(DriverDTO dto, LoginDTO loginDTO) {

        //save driver as user
        loginService.addUser(loginDTO);

        //save driver to db
        dto.setLoginDTO(loginDTO);

        service.addDriver(dto);

        return new ResponseUtil("Ok", "Successfully Added", dto);
    }

    @DeleteMapping(params = {"dId"})
    public ResponseUtil deleteDriver(String dId) {
        service.deleteDriver(dId);
        return new ResponseUtil("Ok", "Successfully Deleted", dId);
    }

    @PostMapping(path = "/update")
    public ResponseUtil updateDriver(DriverDTO dto,LoginDTO loginDTO) {
        dto.setLoginDTO(loginDTO);
        System.out.println(dto.toString());
        service.updateDriver(dto);
        return new ResponseUtil("Ok", "Successfully Updated", dto);
    }

    @GetMapping(params = {"dId"})
    public ResponseUtil findDriver(@RequestParam String dId) {
        return new ResponseUtil("Ok", "Successfully Searched", service.findDriver(dId));
    }


    @GetMapping(path = "/newId")
    public ResponseUtil generateNewCusId() {
        return new ResponseUtil("Ok", "Successfully Id Generated", service.getLastIndex());
    }

    @GetMapping(path = "/availableDrivers")
    public ResponseUtil getAllAvailableDrivers() {
        System.out.println(service.getAllDrivers());
        return new ResponseUtil("Ok", "Successfully Id Generated", service.getAllAvailableDriver());
    }

}
