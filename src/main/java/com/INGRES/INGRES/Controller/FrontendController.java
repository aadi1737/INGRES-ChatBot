package com.INGRES.INGRES.Controller;

import com.INGRES.INGRES.Model.FinalResponse;
import com.INGRES.INGRES.Service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontendController {

    @Autowired
    private FrontendService frontendService;

    @GetMapping("/getInput/{inputMsg}")
    public String getUserInput(@PathVariable String inputMsg){
//        FinalResponse userOutput = frontendService.getUserInput(inputMsg);
        String finalOutput = frontendService.getUserInput(inputMsg);
        return finalOutput;
    }


}
