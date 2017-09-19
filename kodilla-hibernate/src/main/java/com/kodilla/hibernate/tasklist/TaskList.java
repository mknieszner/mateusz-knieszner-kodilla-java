package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents TaskList.
 */
@Entity
@Table(name = "TASKLISTS")
public class TaskList {
  private int id;
  private String listName;
  private String description;

  public TaskList() {
  }

  public TaskList(final String listName, final String description) {
    this.listName = listName;
    this.description = description;
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

  public void setListName(final String listName) {
    this.listName = listName;
  }

  public void setDescription(final String description) {
    this.description = description;
  }
}
