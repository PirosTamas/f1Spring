package com.tomisoft.f1.mapper;

import com.tomisoft.f1.document.Driver;
import com.tomisoft.f1.document.Teams;
import com.tomisoft.f1.dto.DriverDTO;
import com.tomisoft.f1.dto.TeamsDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DriverMapper {

    DriverDTO mapDriverDTO(Driver driver);

    Driver mapDriver(DriverDTO driverDTO);

    TeamsDTO mapTeamsDTO(Teams teams);

    Teams mapTeams(TeamsDTO teamsDTO);
}
