package com.tomisoft.f1.controller;

import com.tomisoft.f1.dto.DriverDTO;
import com.tomisoft.f1.dto.TeamsDTO;
import com.tomisoft.f1.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {

    private final DriverService driverService;

    @PutMapping("driver")
    public Mono<DriverDTO> save(@RequestBody DriverDTO driver)
    {
        return this.driverService.save(driver);
    }

    @GetMapping("driver")
    public Flux<DriverDTO> listAll(){
        return this.driverService.listAll();
    }

    @GetMapping("driver/{id}")
    public Mono<DriverDTO> findById(@PathVariable("id") String id){
        return this.driverService.findById(id);
    }

    @DeleteMapping("driver/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return this.driverService.delete(id);
    }

    @GetMapping("driver/teams")
    public Flux<TeamsDTO> getTeamsName()
    {
        return this.driverService.getTeams();
    }

}
