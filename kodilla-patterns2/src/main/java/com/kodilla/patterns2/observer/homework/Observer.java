package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.ForumTopic;

/**
 * Observer interface for Mentor class.
 */
public interface Observer {
  void update(TaskQueue taskQueue);
}
