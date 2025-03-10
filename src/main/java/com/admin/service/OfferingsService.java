package com.admin.service;

import com.admin.dto.OfferingsDTO;
import java.util.List;

public interface OfferingsService {
    List<OfferingsDTO> getAllOfferings();
    OfferingsDTO getOfferingById(Long offeringId);
    OfferingsDTO createOffering(OfferingsDTO offeringDTO);
    OfferingsDTO updateOffering(Long offeringId, OfferingsDTO offeringDTO);
    void deleteOffering(Long offeringId);
}
