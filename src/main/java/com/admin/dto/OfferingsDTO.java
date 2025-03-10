package com.admin.dto;

import lombok.Data;

@Data
public class OfferingsDTO {
    private Long offeringsId;
    private String offeringsName;
    private Long companyId;
    private Long cuisineId;
}
