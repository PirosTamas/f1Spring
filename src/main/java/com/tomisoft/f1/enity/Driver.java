package com.tomisoft.f1.enity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="driver_name")
    private String name;

    @Column(name="team")
    @Enumerated(EnumType.STRING)
    @JsonProperty("teams")
    private Teams teams;
}
