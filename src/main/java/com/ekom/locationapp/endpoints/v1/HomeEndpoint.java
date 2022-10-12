package com.ekom.locationapp.endpoints.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeEndpoint {

    @GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

}
