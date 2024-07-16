package lk.easy_car_rental.service;

import lk.easy_car_rental.dto.PaymentDTO;

import java.util.List;


public interface PaymentService {
    void addPayment(PaymentDTO dto);

    void deletePayment(String id);

    List<PaymentDTO> getAllPayments();

    PaymentDTO findPayment(String id);

    void updatePayment(PaymentDTO dto);

    String getLastIndex();
}
