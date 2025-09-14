package com.INGRES.INGRES.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroundWaterData {

    private String id;
    private String  stateName;
    private String districtName;
    private double monsoonRechargeFromRainfall;
    private double monsoonRechargeFromOtherSources;
    private double nonMonsoonSeasonRechargeFromRainfall;
    private double nonMonsoonRechargeFromOtherSources;
    private double totalAnnualGroundwaterRecharge;
    private double totalNaturalDischarge;
    private double annualExtractableGroundwaterResource;
    private double irrigationAnnualExtraction;
    private double industrialAnnualExtraction;
    private double domesticAnnualExtraction;
    private double totalAnnualExtraction;
    private double annualGwAllocationForDomesticUse;
    private double netGwAvailabilityForFuture;
    private double stageOfGwExtraction;
    private float groundWaterDepth;
}
