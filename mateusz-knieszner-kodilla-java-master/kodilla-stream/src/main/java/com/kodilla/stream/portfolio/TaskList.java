package com.kodilla.stream.portfolio;

import java.util.LinkedList;
import java.util.List;

/**
 * Task List.
 */
public final class TaskList {
    private final List<Task> tasks = new LinkedList<>();
    private final String name;

    public TaskList(final String name) {
        this.name = name;
    }

    public void addTask(final Task task) {
        tasks.add(task);
    }

    public boolean removeTask(final Task task) {
        return tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new LinkedList<>(tasks);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskList{" + "name='" + name + '\''
                + ",\n" + "tasks=\n" + tasks + "\n" + '}' + "\n";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskList)) {
            return false;
        }
        final TaskList taskList = (TaskList) o;
        return name.equals(taskList.name);
    }

    @Override
    public int hashCode() {
        int result = tasks != null ? tasks.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}