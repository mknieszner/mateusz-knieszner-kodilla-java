package com.kodilla.good.patterns.challenges;

/**
 * Represents an operation that process information service.
 */
@FunctionalInterface
public interface InformationService {

  /**
   * @param messageDto - user and message data.
   */
  void inform(MessageData messageDto);
}