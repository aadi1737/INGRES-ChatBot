package com.INGRES.INGRES.DTOs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entities {
    private String state;
    private String category;
    private int year;
    private int limit;

}
