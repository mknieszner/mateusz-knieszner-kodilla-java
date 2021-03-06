package com.kodilla.good.patterns.challenges;

/**
 * InformationService interface implementation.
 */
public class OrderInformationService implements InformationService {

  @Override
  public void inform(final MessageData informationServiceDto) {
    System.out.printf("Sending message: \"" + informationServiceDto.getMessage()
        + "\" to user: " + informationServiceDto.getUsername());
  }
}
