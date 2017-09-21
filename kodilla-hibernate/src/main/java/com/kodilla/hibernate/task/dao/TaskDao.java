package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Task database repository.
 */
@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {
  List<Task> findByDuration(final int duration);
}