package com.INGRES.INGRES.Service;

import com.INGRES.INGRES.DTOs.OutputResponseTemp;
import com.INGRES.INGRES.Model.DatabaseResForInput;
import com.INGRES.INGRES.Model.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontendService {

    @Autowired
    private RAGService ragService;

    public String getUserInput(String inputMsg){
//        DatabaseResForInput dbResponseToSendRAG = ragService.sendInput(inputMsg);
        OutputResponseTemp responseTemp = ragService.sendInput(inputMsg);

//        FinalResponse finalResponse = ragService.finalResponse(dbResponseToSendRAG);
        return responseTemp.getNl_response();
    }

}
