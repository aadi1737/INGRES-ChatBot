package com.INGRES.INGRES.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "OutputReq")
public class OutputRequestTemp {

    @Id
    @JsonIgnore
    private ObjectId id;
    private String intent;
    private String query;
    private RawDataWrapper rawData;

    // A new field required by the API
    private String uuid;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RawDataWrapper {
        private List<RawData> data;
    }

    @Getter
    @Setter
    public static class RawData {

        private String block;
        private int extraction;

    }
}
