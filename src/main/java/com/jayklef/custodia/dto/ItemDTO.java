package com.jayklef.custodia.dto;
import com.jayklef.custodia.model.RiskLevel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ItemDTO {

    @NotBlank
    private String itemName;
    private Integer itemValue;

    @Min(1)
    private Long categoryId;

    @Min(1)
    private Long clientId;

    private RiskLevel riskLevel;
}
