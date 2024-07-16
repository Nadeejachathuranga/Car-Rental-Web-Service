package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.PaymentDTO;
import lk.easy_car_rental.entity.Payment;
import lk.easy_car_rental.repo.PaymentRepo;
import lk.easy_car_rental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addPayment(PaymentDTO dto) {
        if (repo.existsById(dto.getPayId())) {
            throw new RuntimeException(dto.getPayId() + " is already available, please insert a new ID");
        }

        Payment map = mapper.map(dto, Payment.class);
        repo.save(map);
    }

    @Override
    public void deletePayment(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Payment is not available, please check the ID before delete.!");
        }
        repo.deleteById(id);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }

    @Override
    public PaymentDTO findPayment(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Payment is not available, please check the ID.!");
        }
        Payment payment = repo.findById(id).get();
        return mapper.map(payment, PaymentDTO.class);
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (!repo.existsById(dto.getPayId())) {
            throw new RuntimeException(dto.getPayId() + " Payment is not available, please check the ID before update.!");
        }
        Payment map = mapper.map(dto, Payment.class);
        repo.save(map);
    }

    @Override
    public String getLastIndex() {
        return  repo.getLastIndex();
    }
}
