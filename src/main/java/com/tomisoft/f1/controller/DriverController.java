package com.tomisoft.f1.controller;

import com.tomisoft.f1.enity.Driver;
import com.tomisoft.f1.enity.Teams;
import com.tomisoft.f1.enity.User;
import com.tomisoft.f1.service.DriverService;
import com.tomisoft.f1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {

    private final DriverService driverService;
    private final UserService userService;
    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping("driver")
    public Driver save(@RequestBody Driver driver)
    {
        return this.driverService.save(driver);
    }

    @GetMapping(value = "driver", consumes = MediaType.ALL_VALUE)
    public List<Driver> listAll(){
        return this.driverService.listAll();
    }

    @GetMapping("driver/{id}")
    public Optional<Driver> findById(@PathVariable("id") Long id){
        return this.driverService.findById(id);
    }

    @DeleteMapping(value = "driver/{id}", consumes = MediaType.ALL_VALUE)
    public String delete(@PathVariable("id") Long id){
        this.driverService.deleteById(id);
        return "Delete was succesfull";
    }

    @GetMapping("driver/teams")
    public Teams[] getTeamsName()
    {
        return Teams.values();
    }

    @GetMapping("driver/vote/{id}")
    public String increaseVote(@PathVariable("id") Long id){
        User user = userService.getUser();
        if(user.isDailyVote()) {
            driverService.increaseVote(id);
            userService.changeDailyVote(user.getId());
        }
        return "Increase was successful";
    }

    @PutMapping("/driver/vote")
    public String clearVote()
    {
        driverService.clearVote();
        userService.clearVote();

        return "Clearing was successfull";
    }

}
