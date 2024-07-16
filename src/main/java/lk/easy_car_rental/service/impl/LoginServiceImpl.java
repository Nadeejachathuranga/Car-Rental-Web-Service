package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.LoginDTO;
import lk.easy_car_rental.entity.Login;
import lk.easy_car_rental.repo.LoginRepo;
import lk.easy_car_rental.service.LoginService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addUser(LoginDTO dto) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public List<LoginDTO> getAllUser() {
        List<Login> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<LoginDTO>>() {
        }.getType());
    }

    @Override
    public LoginDTO findUser(String id) {
        Login login = repo.findById(id).get();
        return mapper.map(login, LoginDTO.class);
    }

    @Override
    public void updateUser(LoginDTO dto) {

    }

    @Override
    public String generateNewUserId() {
        return repo.getLastIndex();
    }
}
