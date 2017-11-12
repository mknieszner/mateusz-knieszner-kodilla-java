package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Represents TaskList.
 */
@Entity
@Table(name = "TASKLISTS")
public class TaskList {
  private int id;
  private String listName;
  private String description;
  private List<Task> tasks = new ArrayList<>();

  public TaskList() {
  }

  public TaskList(final String listName, final String description) {
    this.listName = listName;
    this.description = description;
  }

  public void addTask(final Task task) {
    task.setTaskList(this);
    this.tasks.add(task);
  }

  @NotNull
  @OneToMany(
      targetEntity = Task.class,
      mappedBy = "taskList",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER
  )
  public List<Task> getTasks() {
    return Collections.unmodifiableList(tasks);
  }

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "LISTNAME")
  public String getListName() {
    return listName;
  }

  @NotNull
  @Column(name = "DESCRIPTION")
  public String getDescription() {
    return description;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setTasks(final List<Task> tasks) {
    this.tasks = tasks;
  }

  public void setListName(final String listName) {
    this.listName = listName;
  }

  public void setDescription(final String description) {
    this.description = description;
  }
}
