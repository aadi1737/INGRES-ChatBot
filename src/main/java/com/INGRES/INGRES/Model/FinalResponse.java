package com.INGRES.INGRES.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinalResponse {
    private String lang;
    private String query;
    private String userId;

}
