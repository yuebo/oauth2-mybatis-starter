package com.eappcat.base.oauth2.starter.auth.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuebo
 * @since 2019-10-20
 */
@RestController
@RequestMapping("/auth")

public class ClientController {

    @GetMapping("/me")
    public Authentication authentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

}

