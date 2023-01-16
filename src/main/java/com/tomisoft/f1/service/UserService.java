package com.tomisoft.f1.service;

import com.tomisoft.f1.dto.UserinfoDTO;
import com.tomisoft.f1.enity.User;
import com.tomisoft.f1.repository.UserRepository;
import com.tomisoft.f1.security.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserinfoDTO getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserinfoDTO userinfoDTO = new UserinfoDTO();
        boolean isLoggedIn = !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
        userinfoDTO.setLoggedIn(isLoggedIn);
        userinfoDTO.setUsername(!isLoggedIn  ? null : authentication.getName());
        return userinfoDTO;
    }

    public User getUser(){
        long userId = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        return this.repository.findById(userId).orElse(null);
    }

    public void changeDailyVote(Long id)
    {
        this.repository.changeDailyVote(id);
    }

    public void clearVote(){this.repository.clearVote();}
}
