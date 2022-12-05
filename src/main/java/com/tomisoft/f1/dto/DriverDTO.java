package com.tomisoft.f1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tomisoft.f1.document.Teams;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DriverDTO {

    @Id
    private String id;
    private String name;

    @JsonProperty("teams")
    private Teams teams;
}
