package com.tomisoft.f1.controller;

import com.tomisoft.f1.dto.DriverDTO;
import com.tomisoft.f1.dto.TeamsDTO;
import com.tomisoft.f1.service.DriverService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Tag(name = "Feliratkozási eljárások")
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@ApiResponse(responseCode = "200", description = "Successfully retrieved data.", content = @Content(schema = @Schema(implementation = DriverDTO.class)))
@ApiResponse(responseCode = "201", description = "Successfully saved data.", content = @Content(schema = @Schema(implementation = DriverDTO.class)))
@ApiResponse(responseCode = "400", description = "The request could not be understood by the server due to malformed syntax.", content = @Content)
@ApiResponse(responseCode = "401", description = "You are not authorized to view the resource.", content = @Content)
@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden.", content = @Content)
@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found.", content = @Content)

public class DriverController {

    private final DriverService driverService;

    @PutMapping("driver")
    public Mono<ResponseEntity<DriverDTO>> save(@RequestBody DriverDTO driver)
    {
        return this.driverService.save(driver)
                .map(savedDriver -> ResponseEntity.status(HttpStatus.CREATED)
            .body(savedDriver));
    }

    @GetMapping(value = "driver", consumes = MediaType.ALL_VALUE)
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
