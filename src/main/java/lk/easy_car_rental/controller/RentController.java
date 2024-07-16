package lk.easy_car_rental.controller;

import lk.easy_car_rental.dto.RentDTO;
import lk.easy_car_rental.entity.Rent;
import lk.easy_car_rental.service.RentDetailsService;
import lk.easy_car_rental.service.RentService;
import lk.easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;



@RestController
@RequestMapping("/rent")
@CrossOrigin
@Transactional
public class RentController {

    @Autowired
    RentService service1;

    @Autowired
    RentDetailsService service2;

    @GetMapping(path = "/newId")
    public ResponseUtil generateNewCusId() {
        return new ResponseUtil("Ok", "Successfully Id Generated", service1.getLastIndex());
    }

    @PostMapping
    public ResponseUtil saveRent(@RequestBody RentDTO rentDTO) {
        System.out.println(rentDTO);
        service1.addRent(rentDTO);
        return new ResponseUtil("Ok", "Successfully Rent Saved", null);
    }

    @GetMapping
    public ResponseUtil getAllRents() {
        return new ResponseUtil("OK", "Successfully Loaded", service1.getAllRents());
    }

    @DeleteMapping(params = {"rentId"})
    public ResponseUtil deleteDriver(String rentId) {
        System.out.println(rentId);
        service1.deleteRent(rentId);
        return new ResponseUtil("Ok", "Successfully Deleted", rentId);
    }

    @GetMapping(path = "/request/pending")
    public ResponseUtil getAllPendingRents() {
        return new ResponseUtil("OK", "Successfully Loaded", service1.getAllPendingRents());
    }

    @PutMapping
    public ResponseUtil updateRent(@RequestBody RentDTO dto) {
        service1.updateRent(dto);
        return new ResponseUtil("OK", "Successfully Updated", dto.getRentID());
    }

    @GetMapping(params = {"id"})
    public ResponseUtil searchRent(String id) {
        RentDTO rent = service1.findRent(id);
        return new ResponseUtil("OK", "Successfully Loaded", rent);
    }

}
