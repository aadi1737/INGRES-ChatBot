package com.INGRES.INGRES.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InputResponseTemp {
    private String intent;
    private Entities entities;
    private float confidence;
}
