package lk.easy_car_rental.controller;

import lk.easy_car_rental.dto.LoginDTO;
import lk.easy_car_rental.service.LoginService;
import lk.easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping
    public ResponseUtil getAllUsers() {
        List<LoginDTO> allUser = service.getAllUser();
        return new ResponseUtil("Ok", "Successfully Loaded", allUser);
    }

    @GetMapping(params = {"uId"})
    public ResponseUtil findUser(@RequestParam String uId) {
        System.out.println("user - "+service.findUser(uId));
        return new ResponseUtil("Ok", "Successfully Searched", service.findUser(uId));
    }

    @GetMapping(path = "/newId")
    public ResponseUtil generateNewUserId() {
        String newUserId = service.generateNewUserId();
        return new ResponseUtil("OK", "Successfully Id Generated", newUserId);
    }
}
