package com.kodilla.good.patterns.challenges;

/**
 * Represents an operation that accepts MessageData input argument and returns no result.
 */
@FunctionalInterface
public interface InformationService {
  void inform(MessageData informationServiceDto);
}