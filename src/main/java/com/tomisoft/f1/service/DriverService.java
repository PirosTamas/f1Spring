package com.tomisoft.f1.service;

import com.tomisoft.f1.enity.Driver;
import com.tomisoft.f1.mapper.DriverMapper;
import com.tomisoft.f1.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper mapper;

    public Driver save(Driver driver)
    {
        return this.driverRepository.save(driver);
    }

    public Optional<Driver> findById(Long id)
    {
        return this.driverRepository.findById(id);
    }

    public List<Driver> listAll()
    {
        return driverRepository.findAll();
    }

    public void deleteById(Long id)
    {
        this.driverRepository.deleteById(id);
    }

    public void increaseVote(Long id){this.driverRepository.increaseVote(id);}

}
