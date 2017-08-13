package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;
import static java.util.stream.Collectors.toList;

/**
 * Test Suite for Board class.
 */
public class BoardTestSuite {

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> testList = project.getTaskLists();

        //Then
        Assert.assertEquals(3, testList.size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists()
                .stream().flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());

        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists()
                .stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        double assertTestDelta = 0.001;
        double expectedResult = 10.0;

        //Given
        Board project = prepareTestData();

        //When
        double testAvaerage = project
                .getTaskLists()
                .stream()
                .filter(taskList -> taskList.getName().equals("In progress"))
                .flatMap(taskList -> taskList.getTasks().stream())
                .mapToInt(task -> toIntExact(
                        ChronoUnit.DAYS.between(task.getCreated(), LocalDate.now())))
                .average()
                .getAsDouble();

        //Then
        Assert.assertEquals(expectedResult, testAvaerage, assertTestDelta);
    }

    private static Board prepareTestData() {
        Board project = new Board("Project Weather Prediction");

        for (TaskList taskList:getTasksLists(getUniqueTaskList(getUserList()))) {
            project.addTaskList(taskList);
        }
        return project;
    }

    private static List<TaskList> getTasksLists(List<Task> uniqueTaskList) {
        List<TaskList> taskListArrayList = new ArrayList<>();

        taskListArrayList.add(new TaskList("To do"));
        taskListArrayList.add(new TaskList("In progress"));
        taskListArrayList.add(new TaskList("Done"));

        taskListArrayList.get(0).addTask(uniqueTaskList.get(0));
        taskListArrayList.get(0).addTask(uniqueTaskList.get(2));
        taskListArrayList.get(1).addTask(uniqueTaskList.get(4));
        taskListArrayList.get(1).addTask(uniqueTaskList.get(3));
        taskListArrayList.get(1).addTask(uniqueTaskList.get(1));
        return taskListArrayList;
    }

    private static List<Task> getUniqueTaskList(List<User> userList) {
        List<Task> uniqueTaskList = new ArrayList<>();
        Task task1 = new Task.Builder()
                .title("Microservice for taking temperature")
                .description("Write and test the microservice taking\n"
                        + "the temperaure from external service")
                .assignedUser(userList.get(0))
                .creator(userList.get(1))
                .created(LocalDate.now().minusDays(20))
                .deadline(LocalDate.now().plusDays(30))
                .build();
        Task task2 = new Task.Builder()
                .title("HQLs for analysis")
                .description("Prepare some HQL queries for analysis")
                .assignedUser(userList.get(0))
                .creator(userList.get(1))
                .created(LocalDate.now().minusDays(20))
                .deadline(LocalDate.now().minusDays(5))
                .build();
        Task task3 = new Task.Builder()
                .title("Temperatures entity")
                .description("Prepare entity for temperatures")
                .assignedUser(userList.get(2))
                .creator(userList.get(1))
                .created(LocalDate.now().minusDays(20))
                .deadline(LocalDate.now().plusDays(15))
                .build();
        Task task4 = new Task.Builder().title("Own logger")
                .description("Refactor company logger to meet our needs")
                .assignedUser(userList.get(2))
                .creator(userList.get(1))
                .created(LocalDate.now().minusDays(10))
                .deadline(LocalDate.now().plusDays(25))
                .build();
        Task task5 = new Task.Builder()
                .title("Optimize searching")
                .description("Archive data searching has to be optimized")
                .assignedUser(userList.get(3))
                .creator(userList.get(1))
                .created(LocalDate.now())
                .deadline(LocalDate.now().plusDays(5))
                .build();
        Task task6 = new Task.Builder().title("Use Streams")
                .description("use Streams rather than for-loops in predictions")
                .assignedUser(userList.get(3))
                .creator(userList.get(1))
                .created(LocalDate.now().minusDays(15))
                .deadline(LocalDate.now().minusDays(2))
                .build();

        uniqueTaskList.add(task1);
        uniqueTaskList.add(task2);
        uniqueTaskList.add(task3);
        uniqueTaskList.add(task4);
        uniqueTaskList.add(task5);
        uniqueTaskList.add(task6);

        return uniqueTaskList;
    }

    private static List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("developer1", "John Smith"));
        userList.add(new User("projectmanager1", "Nina White"));
        userList.add(new User("developer2", "Emilia Stephanson"));
        userList.add(new User("developer3", "Konrad Bridge"));

        return userList;
    }
}