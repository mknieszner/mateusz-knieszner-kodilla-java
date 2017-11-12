package com.kodilla.good.patterns.challenges;

/**
 * Interface provides 2 essential methods to process information service.
 */
public interface MessageData {

  /**
   * @return Message content.
   */
  String getMessage();

  /**
   * @return Username used to identify user.
   */
  String getUsername();
}
