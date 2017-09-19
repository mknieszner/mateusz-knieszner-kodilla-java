package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Test Suite for TaskListDao class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
  @Autowired
  private TaskListDao taskListDao;
  private static final String DESCRIPTION = "Test: Learn Hibernate";
  private static final String LIST_NAME = "ToDo";

  @Test
  public void testTaskDaoSave() {
    //Given
    final TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);

    //When
    taskListDao.save(taskList);

    //Then
    final int id = taskList.getId();
    final TaskList readTaskList = taskListDao.findOne(id);
    Assert.assertEquals(id, readTaskList.getId());

    //CleanUp
    taskListDao.delete(id);
  }

  @Test
  public void testTaskDaoFindByDuration() {
    //Given
    final TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
    taskListDao.save(taskList);
    final String listName = taskList.getListName();

    //When
    final List<TaskList> readTasksList = taskListDao.findByListName(listName);

    //Then
    Assert.assertEquals(1, readTasksList.size());

    //CleanUp
    final int id = readTasksList.get(0).getId();
    taskListDao.delete(id);
  }
}
