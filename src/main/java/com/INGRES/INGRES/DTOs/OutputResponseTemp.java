package com.INGRES.INGRES.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutputResponseTemp {

    private String nl_response;
    private Map<String, Object> visualization_data; // kyunki {} aa raha h


}
