package com.INGRES.INGRES.Service;

import com.INGRES.INGRES.DTOs.*;
import com.INGRES.INGRES.Model.DatabaseResForInput;
import com.INGRES.INGRES.Model.FinalResponse;
import com.INGRES.INGRES.Model.GroundWaterData;
//import com.INGRES.INGRES.Repository.INGRES_DB;
import com.INGRES.INGRES.Repository.IngresMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class RAGService {

    private final String INPUT_API_URL= "https://ingres.onrender.com/chatbot/intent";
    private final String OUTPUT_API_URL="https://ingres.onrender.com/chatbot/generate-response";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
//    private INGRES_DB db;
    private IngresMongoDb mongoDb;

    public OutputResponseTemp sendInput(String msg){
        InputRequestTemp body = new InputRequestTemp();
        body.setQuery(msg);
        body.setUuid("dick01");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);

        HttpEntity<InputRequestTemp> request = new HttpEntity<>(body,headers);

        InputResponseTemp inputResponse = restTemplate.postForObject(
                INPUT_API_URL,request,InputResponseTemp.class);

        System.out.println(inputResponse);

        OutputRequestTemp dbResponse = getDBResponse(inputResponse);
        dbResponse.setQuery(msg);
        OutputResponseTemp responseTemp = finalResponse(dbResponse);
        return responseTemp;
    }


    public OutputResponseTemp finalResponse(OutputRequestTemp dbRes){

//        OutputRequestTemp.RawData r1 = new OutputRequestTemp.RawData();
//        r1.setBlock("Block S*x");
//        r1.setExtraction(69);
//
//        OutputRequestTemp.RawData r2 = new OutputRequestTemp.RawData();
//        r2.setBlock("Block P*ssy");
//        r2.setExtraction(96);
//
//        OutputRequestTemp.RawDataWrapper rawDataWrapper = new OutputRequestTemp.RawDataWrapper();
//        rawDataWrapper.setData(Arrays.asList(r1,r2));
//
//        OutputRequestTemp body = new OutputRequestTemp();
//        body.setIntent("list_units_by_condition0115");
//        body.setQuery("Show blocks with extraction above 90%");
//        body.setRawData(rawDataWrapper);
//        body.setUuid("A01");

//        mongoDb.save(body);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity request = new HttpEntity<>(dbRes,headers);


        OutputResponseTemp finalResponse = restTemplate.postForObject(OUTPUT_API_URL ,request, OutputResponseTemp.class);
//        System.out.println(finalResponse+"/n From Burhaan");

        return finalResponse;

        //         return FinalResponse.builder()
//                 .query("Jai ho mai jai kiski ho rhi?")
//                 .lang("Marwadi")
//                 .userId("A01")
//                 .build();
    }

    //Make new file for this in service (FOr SQL QUERY GENERATION) by Anjali
    public OutputRequestTemp getDBResponse(InputResponseTemp input){

//        List<GroundWaterData> dbRes = db.findByCityName("Pune");
        OutputRequestTemp dbRes = mongoDb.findById("68c64204db5c5418a86de90a");
        System.out.println(dbRes);


//        DatabaseResForInput fakeResponse = new DatabaseResForInput();
        return  dbRes;
    }
}
