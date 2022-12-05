package com.tomisoft.f1.service;

import com.tomisoft.f1.document.Teams;
import com.tomisoft.f1.dto.DriverDTO;
import com.tomisoft.f1.dto.TeamsDTO;
import com.tomisoft.f1.mapper.DriverMapper;
import com.tomisoft.f1.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    public Mono<DriverDTO> save(DriverDTO driver)
    {
        return this.driverRepository.save(this.driverMapper.mapDriver(driver)).map(driverMapper::mapDriverDTO);
    }

    public Mono<DriverDTO> findById(String id)
    {
        return this.driverRepository.findById(id).map(this.driverMapper::mapDriverDTO);
    }

    public Flux<DriverDTO> listAll()
    {
        return driverRepository.findAll().map(this.driverMapper::mapDriverDTO);
    }

    public Flux<TeamsDTO> getTeams()
    {
        return Flux.fromArray(TeamsDTO.values());
    }

    public Mono<Void> delete(String id)
    {
        return driverRepository.deleteById(id);
    }

}
