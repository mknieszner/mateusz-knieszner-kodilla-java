package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Test Suite for TaskListDao class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
  @Autowired
  private TaskListDao taskListDao;
  @Autowired
  private TaskDao taskDao;
  private static final String DESCRIPTION = "Test: Learn Hibernate";
  private static final String LISTNAME = "ToDo";

  @Test
  public void testTaskDaoSave() {
    //Given
    final TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);

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
    final TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
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

  @Test
  public void testTaskListDaoSaveWithTasks() {
    //Given
    final TaskList taskList = getPreparedTaskList();

    //When
    taskListDao.save(taskList);

    //Then
    Assert.assertEquals(taskList.getTasks().size(), taskListDao.findOne(taskList.getId()).getTasks().size());

    //CleanUp
    taskListDao.delete(taskList.getId());
  }

  private TaskList getPreparedTaskList() {
    final Task task = new Task("Test: Learn Hibernate", 14);
    final Task task2 = new Task("Test: Write some entities", 3);

    task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(20), false));
    task2.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(10), false));

    final TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
    taskList.addTask(task);
    taskList.addTask(task2);

    return taskList;
  }

  @Test
  public void testNamedQueries() {
    //Given
    final Task task1 = new Task("Test: Study Hibernate", 3);
    final Task task2 = new Task("Test: Practice Named Queries", 6);
    final Task task3 = new Task("Test: Study native queries", 7);
    final Task task4 = new Task("Test: Makse some tests", 13);

    final TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
    final TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
    final TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
    final TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

    task1.setTaskFinancialDetails(tfd1);
    task2.setTaskFinancialDetails(tfd2);
    task3.setTaskFinancialDetails(tfd3);
    task4.setTaskFinancialDetails(tfd4);

    final TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
    taskList.addTask(task1);
    taskList.addTask(task2);
    taskList.addTask(task3);
    taskList.addTask(task4);

    taskListDao.save(taskList);
    final int id = taskList.getId();

    //When
    final List<Task> longTasks = taskDao.retrieveLongTasks();
    final List<Task> shortTasks = taskDao.retrieveShortTasks();
    final List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
    final List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

    //Then
    try {
      Assert.assertEquals(1, longTasks.size());
      Assert.assertEquals(3, shortTasks.size());
      Assert.assertEquals(3, enoughTimeTasks.size());
      Assert.assertEquals(2, durationLongerThanTasks.size());
    } finally {
      //CleanUp
      taskListDao.delete(id);
    }
  }
}
