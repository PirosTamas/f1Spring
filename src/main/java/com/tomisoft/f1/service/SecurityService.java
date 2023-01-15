package com.tomisoft.f1.service;

import com.tomisoft.f1.dto.UserinfoDTO;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {

    public UserinfoDTO getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserinfoDTO userinfoDTO = new UserinfoDTO();
        boolean isLoggedIn = !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
        userinfoDTO.setLoggedIn(isLoggedIn);
        userinfoDTO.setUsername(!isLoggedIn  ? null : authentication.getName());
        return userinfoDTO;
    }
}
