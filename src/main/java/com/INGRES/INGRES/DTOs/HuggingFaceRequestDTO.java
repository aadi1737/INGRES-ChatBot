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
public class HuggingFaceRequestDTO {
    private String inputs;  // The text input for the model
    private Map<String, Object> parameters; // Optional parameters
}
