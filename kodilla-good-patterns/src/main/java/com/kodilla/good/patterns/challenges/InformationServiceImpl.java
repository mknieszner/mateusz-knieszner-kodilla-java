package com.kodilla.good.patterns.challenges;

/**
 * InformationService interface implementation.
 */
public class InformationServiceImpl implements InformationService {
    @Override
    public void inform(final InformationServiceInformArgument orderRequest) {
        System.out.printf("Inform: %s about his order: %s",
                orderRequest.getUserName(), orderRequest.getOrderToString());
    }
}
