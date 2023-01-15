package com.tomisoft.f1.dto;

import lombok.Data;

@Data
public class UserinfoDTO {
    private Long id;
    private String username;
    private boolean isLoggedIn;
}
