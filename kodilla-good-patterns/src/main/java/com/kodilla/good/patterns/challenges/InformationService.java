package com.kodilla.good.patterns.challenges;

/**
 * Represents an operation that accepts InformationServiceDto input argument and returns no result.
 */
@FunctionalInterface
public interface InformationService {
  void inform(InformationServiceDto informationServiceDto);
}