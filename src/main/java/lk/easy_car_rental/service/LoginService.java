package lk.easy_car_rental.service;

import lk.easy_car_rental.dto.LoginDTO;

import java.util.List;



public interface LoginService {

    void addUser(LoginDTO dto);

    void deleteUser(String id);

    List<LoginDTO> getAllUser();

    LoginDTO findUser(String id);

    void updateUser(LoginDTO dto);

    String generateNewUserId();
}
