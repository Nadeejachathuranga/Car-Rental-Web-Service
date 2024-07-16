package lk.easy_car_rental.controller;

import lk.easy_car_rental.dto.PaymentDTO;
import lk.easy_car_rental.service.PaymentService;
import lk.easy_car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;



@RestController
@RequestMapping("/payment")
@CrossOrigin
@Transactional
public class PaymentController {

    @Autowired
    PaymentService service;

    @GetMapping
    public ResponseUtil getAllPayments() {
        List<PaymentDTO> allPayments = service.getAllPayments();
        System.out.println(allPayments);
        return new ResponseUtil("Ok", "Successfully Loaded", service.getAllPayments());
    }

    @PostMapping
    public ResponseUtil addPayment(PaymentDTO dto) {
        service.addPayment(dto);
        return new ResponseUtil("Ok", "Successfully Added", dto);
    }

    @DeleteMapping(params = {"payId"})
    public ResponseUtil deletePayment(String payId) {
        service.deletePayment(payId);
        return new ResponseUtil("Ok", "Successfully Deleted", payId);
    }

    @PutMapping()
    public ResponseUtil updatePayment(@RequestBody PaymentDTO dto) {
        service.updatePayment(dto);
        return new ResponseUtil("Ok", "Successfully Updated", dto);
    }

    @GetMapping(params = {"payId"})
    public ResponseUtil findPayment(@RequestParam String payId) {
        return new ResponseUtil("Ok", "Successfully Searched", service.findPayment(payId));
    }

    @GetMapping(path = "/newId")
    public ResponseUtil generateNewCusId() {
        return new ResponseUtil("Ok", "Successfully Id Generated", service.getLastIndex());
    }

}
