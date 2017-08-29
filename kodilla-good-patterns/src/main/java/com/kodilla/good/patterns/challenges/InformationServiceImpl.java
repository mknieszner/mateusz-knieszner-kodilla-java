package com.kodilla.good.patterns.challenges;

/**
 * InformationService interface implementation.
 */
public class InformationServiceImpl implements InformationService {
    @Override
    public void inform(final OrderRequest orderRequest) {
        System.out.printf("Inform: %s about his order: %s",
                orderRequest.getUser().getName(), orderRequest.getOrder().toString());
    }
}
