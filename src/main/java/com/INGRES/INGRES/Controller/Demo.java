package com.INGRES.INGRES.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Hy IGRIS here";
    }

}
