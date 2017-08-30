package com.kodilla.good.patterns.challenges;

/**
 * Interface provides inform method.
 */
@FunctionalInterface
public interface InformationService {
    void inform(InformationServiceInformArgument orderRequest);
}