package com.ekom.locationapp.endpoints.v1;

import com.ekom.locationapp.endpoints.LocationApiVersions;
import com.ekom.locationapp.services.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LocationApiVersions.V1_AUTH)
public class AuthEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(AuthEndpoint.class);

    private final TokenService tokenService;

    public AuthEndpoint(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/signin")
    public String token(Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return token;
    }

}
