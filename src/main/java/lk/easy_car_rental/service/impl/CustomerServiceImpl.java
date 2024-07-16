package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.CustomerDTO;
import lk.easy_car_rental.entity.Customer;
import lk.easy_car_rental.repo.CustomerRepo;
import lk.easy_car_rental.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {

        if (customerRepo.existsById(dto.getCusId())) {
            throw new RuntimeException(dto.getCusId() + " is already available, please insert a new ID");
        }

        Customer customer = mapper.map(dto, Customer.class);
        System.out.println(customer);

        try {

            /*String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).
                    getParentFile().getParentFile().getAbsolutePath();*/

            String projectPath = "E:\\Semester_2_Final\\Car_Rental_System\\upload";
            System.out.println(projectPath);
            File uploadsDir = new File(projectPath + "/upload");
            uploadsDir.mkdir();

            /*save images to upload directory*/
            dto.getNic_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNic_Img().getOriginalFilename()));
            System.out.println("pathname : " + uploadsDir.getAbsolutePath());
            System.out.println("original file name : " + dto.getNic_Img().getOriginalFilename());

            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            /*save img path to db*/
            customer.setNic_Img("upload/" + dto.getNic_Img().getOriginalFilename());
            customer.setLicense_Img("upload/" + dto.getLicense_Img().getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException(id + " Customer is not available, please check the ID before delete.!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        System.out.println(all);
        return mapper.map(all, new TypeToken<ArrayList<Customer>>() {
        }.getType());
    }

    @Override
    public Customer findCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException(id + " Customer is not available, please check the ID.!");
        }
        Customer customer = customerRepo.findById(id).get();
        return mapper.map(customer, Customer.class);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!customerRepo.existsById(dto.getCusId())) {
            throw new RuntimeException(dto.getCusId() + " Customer is not available, please check the ID before update.!");
        }

        Customer map = mapper.map(dto, Customer.class);

        try {

           /* String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).
                    getParentFile().getParentFile().getAbsolutePath();*/

            String projectPath = "E:\\Semester_2_Final\\Car_Rental_System\\upload";
            System.out.println(projectPath);
            File uploadsDir = new File(projectPath + "/upload");
            uploadsDir.mkdir();

            /*save images to upload directory*/
            dto.getNic_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNic_Img().getOriginalFilename()));
            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            /*save img path to db*/
            map.setNic_Img("upload/" + dto.getNic_Img().getOriginalFilename());
            map.setLicense_Img("upload/" + dto.getLicense_Img().getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        customerRepo.save(map);
    }

    @Override
    public String getLastCusId() {
        return customerRepo.getLastIndex();
    }
}
