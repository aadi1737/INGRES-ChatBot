package com.INGRES.INGRES.Service;

import com.INGRES.INGRES.DTOs.*;
import com.INGRES.INGRES.Repository.IngresMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class RAGService {

    private static final Logger logger = LoggerFactory.getLogger(RAGService.class);

    // External API URLs (currently disabled)
    private final String INPUT_API_URL  = "https://burhan1863-ingres.hf.space/chatbot/intent";
    private final String OUTPUT_API_URL = "https://burhan1863-ingres.hf.space/chatbot/generate-response";

//    private final boolean USE_EXTERNAL_API = true; // Set to true when external APIs are working

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IngresMongoDb mongoDb;

    public OutputResponseTemp sendInput(String msg) {

            // Prepare request for intent detection
            InputRequestTemp body = new InputRequestTemp();
            body.setQuery(msg);
        System.out.println("/n Message got from User-"+msg);
            body.setUuid("A01"); // Professional identifier

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(APPLICATION_JSON);

            HttpEntity<InputRequestTemp> request = new HttpEntity<>(body, headers);

            // Call intent detection API
            InputResponseTemp inputResponse = restTemplate.postForObject(
                    INPUT_API_URL, request, InputResponseTemp.class);

//        String intentJi = inputResponse.getIntent();
//        System.out.println("\nBurhan FIrst API intent-"+intentJi);
            logger.info("Intent API response: {}", inputResponse);

            // Get database response based on intent
            OutputRequestTemp dbResponse = getDBResponse(inputResponse);
            dbResponse.setQuery(msg);
        System.out.println("/nQuery After DBres-"+dbResponse.getQuery());
//            logger.info("Database response: {}", dbResponse);

//        dbResponse.setIntent(intentJi);
            // Generate fina    l response
            return finalResponse(dbResponse);
//
//        } catch (Exception e) {
//            logger.error("Error in sendInput: {}", e.getMessage(), e);
//            return createErrorResponse("Sorry, I encountered an error processing your request: " + e.getMessage());
//        }
    }

    public OutputResponseTemp finalResponse(OutputRequestTemp dbRes) {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(APPLICATION_JSON);
            HttpEntity<OutputRequestTemp> request = new HttpEntity<>(dbRes, headers);

            // Call response generation API
            OutputResponseTemp finalResponse = restTemplate.postForObject(
                    OUTPUT_API_URL, request, OutputResponseTemp.class);

//            logger.info("Final response from external API: {}", finalResponse);
        System.out.println("/n/nBurhan Response-"+finalResponse.getNl_response());
            return finalResponse;

    }

    public OutputRequestTemp getDBResponse(InputResponseTemp input) {
            // Get data from MongoDB - using a fixed ID for now
            OutputRequestTemp dbRes = mongoDb.findById("68c64204db5c5418a86de90a");
            return dbRes;

//        catch (Exception e) {
//            logger.error("Error fetching from database: {}", e.getMessage(), e);
//            return createDefaultDBResponse();
//        }
    }
//
//    // Helper methods for response creation
//    private OutputResponseTemp createSuccessResponse(String query) {
//        OutputResponseTemp response = new OutputResponseTemp();
//        response.setNl_response("I received your query: '" + query + "'. " +
//                "I'm currently operating in offline mode. " +
//                "When external services are available, I'll provide detailed groundwater information.");
//        return response;
//    }
//
//    private OutputResponseTemp createErrorResponse(String errorMessage) {
//        OutputResponseTemp response = new OutputResponseTemp();
//        response.setNl_response(errorMessage);
//        return response;
//    }
//
//    private OutputResponseTemp createResponseFromDB(OutputRequestTemp dbRes) {
//        OutputResponseTemp response = new OutputResponseTemp();
//        if (dbRes != null && dbRes.getIntent() != null) {
//            response.setNl_response("Based on your query '" + dbRes.getQuery() +
//                    "', I detected intent: " + dbRes.getIntent() +
//                    ". In online mode, I would provide detailed groundwater analysis.");
//        } else {
//            response.setNl_response("I understand your query about groundwater data. " +
//                    "When external services are available, I'll provide comprehensive information " +
//                    "about water extraction, block data, and groundwater management.");
//        }
//        return response;
//    }
//
//    private OutputRequestTemp createDefaultDBResponse() {
//        OutputRequestTemp defaultResponse = new OutputRequestTemp();
//        defaultResponse.setIntent("general_water_query");
//        defaultResponse.setQuery("General groundwater information request");
//        defaultResponse.setUuid("default01");
//        return defaultResponse;
//    }
}