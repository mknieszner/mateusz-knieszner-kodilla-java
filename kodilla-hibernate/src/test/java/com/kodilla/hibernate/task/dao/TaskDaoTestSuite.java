package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Test Suite for TaskDao class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
  @Autowired
  private TaskDao taskDao;
  private static final String DESCRIPTION = "Test: Learn Hibernate";

  @Test
  public void testTaskDaoSave() {
    //Given
    final Task task = new Task(DESCRIPTION, 7);

    //When
    taskDao.save(task);

    //Then
    final int id = task.getId();
    final Task readTask = taskDao.findOne(id);
    Assert.assertEquals(id, readTask.getId());

    //CleanUp
    taskDao.delete(id);
  }

  @Test
  public void testTaskDaoFindByDuration() {
    //Given
    final Task task = new Task(DESCRIPTION, 7);
    taskDao.save(task);
    final int duration = task.getDuration();

    //When
    final List<Task> readTasks = taskDao.findByDuration(duration);

    //Then
    Assert.assertEquals(1, readTasks.size());

    //CleanUp
    final int id = readTasks.get(0).getId();
    taskDao.delete(id);
  }
}