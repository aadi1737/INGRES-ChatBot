package com.INGRES.INGRES.Controller;

import com.INGRES.INGRES.DTOs.HuggingFaceRequestDTO;
import com.INGRES.INGRES.Model.FinalResponse;
import com.INGRES.INGRES.Service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class FrontendController {

    @Autowired
    private FrontendService frontendService;

    @GetMapping("/")
    public String home() {
        return "INGRES Chatbot API is running! Use /getInputBody (POST) or /getInput/{message} (GET)";
    }

    @PostMapping("/inputBody")
    public String getUserInputBody(@RequestBody HuggingFaceRequestDTO dto){
//        FinalResponse userOutput = frontendService.getUserInput(inputMsg);

        String finalOutput = frontendService.getUserInput(dto.getInputs());
        return finalOutput;
    }

    @GetMapping("/getInput/{inputMsg}")
    public String getUserInput(@PathVariable String inputMsg){
//        FinalResponse userOutput = frontendService.getUserInput(inputMsg);
        String finalOutput = frontendService.getUserInput(inputMsg);
        return finalOutput;
    }


}
