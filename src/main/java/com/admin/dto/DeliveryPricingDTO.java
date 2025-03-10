package com.admin.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DeliveryPricingDTO {
    private Long id;
    private BigDecimal distance;
    private BigDecimal price;
    private Long companyId;
}
