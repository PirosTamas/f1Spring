package com.tomisoft.f1.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Driver {

    @Id
    private String id;
    private String name;
    private Teams teams;

}
