package lk.easy_car_rental.service;

import lk.easy_car_rental.dto.CustomerDTO;
import lk.easy_car_rental.entity.Customer;

import java.util.ArrayList;


public interface CustomerService {

    void addCustomer(CustomerDTO dto);

    void deleteCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomer();

    Customer findCustomer(String id);

    void updateCustomer(CustomerDTO dto);

    String getLastCusId();
}
