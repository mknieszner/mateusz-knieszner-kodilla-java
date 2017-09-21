package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Represents Task.
 */
@Entity
@Table(name = "TASKS")
public final class Task {
  private int id;
  private String description;
  private Date created;
  private int duration;
  private TaskFinancialDetails taskFinancialDetails;
  private TaskList taskList;

  public Task() {
  }

  public Task(final String description, final int duration) {
    this.description = description;
    this.created = new Date();
    this.duration = duration;
  }

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "TASKS_FINANCIALS_ID")
  public TaskFinancialDetails getTaskFinancialDetails() {
    return taskFinancialDetails;
  }

  @ManyToOne
  @JoinColumn(name = "TASKLIST_ID")
  public TaskList getTaskList() {
    return taskList;
  }

  public void setTaskList(final TaskList taskList) {
    this.taskList = taskList;
  }

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "ID", unique = true)
  public int getId() {
    return id;
  }

  @Column(name = "DESCRIPTION")
  public String getDescription() {
    return description;
  }

  @NotNull
  @Column(name = "CREATED")
  public Date getCreated() {
    return (Date) created.clone();
  }

  @Column(name = "DURATION")
  public int getDuration() {
    return duration;
  }

  private void setId(final int id) {
    this.id = id;
  }

  private void setDescription(final String description) {
    this.description = description;
  }

  private void setCreated(final Date created) {
    this.created = created;
  }

  private void setDuration(final int duration) {
    this.duration = duration;
  }

  public void setTaskFinancialDetails(final TaskFinancialDetails taskFinancialDetails) {
    this.taskFinancialDetails = taskFinancialDetails;
  }
}