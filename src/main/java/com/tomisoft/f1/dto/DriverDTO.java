package com.tomisoft.f1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tomisoft.f1.enity.Teams;
import lombok.Data;

import javax.persistence.*;

@Data
public class DriverDTO {

    private Long id;

    private String name;

    private Teams teams;

    private int votes;
}
