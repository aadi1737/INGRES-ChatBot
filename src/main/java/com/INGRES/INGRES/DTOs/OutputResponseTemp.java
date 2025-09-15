package com.INGRES.INGRES.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutputResponseTemp {

    private String nl_response;
    private Map<String, Object> visualization_data; // kyunki {} aa raha h

    public String getNl_response() {
        return nl_response;
    }

    public void setNl_response(String nl_response) {
        this.nl_response = nl_response;
    }

    public Map<String, Object> getVisualization_data() {
        return visualization_data;
    }

    public void setVisualization_data(Map<String, Object> visualization_data) {
        this.visualization_data = visualization_data;
    }
}
