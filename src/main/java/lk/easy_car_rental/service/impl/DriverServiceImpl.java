package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.DriverDTO;
import lk.easy_car_rental.dto.LoginDTO;
import lk.easy_car_rental.entity.Driver;
import lk.easy_car_rental.entity.Login;
import lk.easy_car_rental.repo.DriverRepo;
import lk.easy_car_rental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (repo.existsById(dto.getUserId())) {
            throw new RuntimeException(dto.getUserId() + " is already available, please insert a new ID");
        }

        Driver map = mapper.map(dto, Driver.class);
        repo.save(map);
    }

    @Override
    public void deleteDriver(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Driver is not available, please check the ID before delete.!");
        }
        repo.deleteById(id);
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = repo.findAll();
        List<DriverDTO> list = new ArrayList<>();
        for (Driver driver : all) {
            String userId = driver.getUserId();
            String address = driver.getAddress();
            String contact = driver.getContact();
            Login login = driver.getLogin();
            String licenseNo = driver.getLicenseNo();
            String name = driver.getName();
            String availability = driver.getAvailability();

            DriverDTO driverDTO = new DriverDTO(userId, name, contact, address, licenseNo, availability,
                    new LoginDTO(login.getUserId(), login.getUserName(), login.getPassWord(), login.getRole()));

            list.add(driverDTO);
        }
        return list;
    }

    @Override
    public DriverDTO findDriver(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + " Driver is not available, please check the ID.!");
        }
        Driver driver = repo.findById(id).get();
        return mapper.map(driver, DriverDTO.class);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getUserId())) {
            throw new RuntimeException(dto.getUserId() + " Driver is not available, please check the ID before update.!");
        }
        Driver map = mapper.map(dto, Driver.class);
        repo.save(map);
    }

    @Override
    public String getLastIndex() {
        return repo.getLastIndex();
    }

    @Override
    public ArrayList<DriverDTO> getAllAvailableDriver() {
        ArrayList<Driver> drivers = repo.getAllAvailableDrivers();
        return mapper.map(drivers, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }
}
