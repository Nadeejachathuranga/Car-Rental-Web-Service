package lk.easy_car_rental.service.impl;

import lk.easy_car_rental.dto.RentDetailsDTO;
import lk.easy_car_rental.entity.RentDetails;
import lk.easy_car_rental.repo.RentDetailsRepo;
import lk.easy_car_rental.service.RentDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Service
@Transactional
public class RentDetailsServiceImpl implements RentDetailsService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    RentDetailsRepo repo;

    @Override
    public void saveRentDetails(RentDetailsDTO dto) {
        RentDetails map = mapper.map(dto, RentDetails.class);
        repo.save(map);
    }
}
