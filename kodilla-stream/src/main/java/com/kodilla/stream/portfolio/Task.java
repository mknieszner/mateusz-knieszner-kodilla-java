package com.kodilla.stream.portfolio;

import java.time.LocalDate;

/**
 * Basic task class.
 */
public final class Task {
    private final String title;
    private final String description;
    private final User assignedUser;
    private final User creator;
    private final LocalDate created;
    private final LocalDate deadline;

    private Task(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.assignedUser = builder.assignedUser;
        this.creator = builder.creator;
        this.created = builder.created;
        this.deadline = builder.deadline;
    }


    /**
     * Builder pattern for Task class.
     */
    public static class Builder {
        private String title;
        private String description;
        private User assignedUser;
        private User creator;
        private LocalDate created;
        private LocalDate deadline;

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder assignedUser(final User assignedUser) {
            this.assignedUser = assignedUser;
            return this;
        }

        public Builder creator(final User creator) {
            this.creator = creator;
            return this;
        }

        public Builder created(final LocalDate created) {
            this.created = created;
            return this;
        }

        public Builder deadline(final LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public User getCreator() {
        return creator;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{"
                + "title='" + title + '\''
                + ", description='" + description
                + '\'' + ", assignedUser=" + assignedUser
                + ", creator=" + creator
                + ", created=" + created
                + ", deadline=" + deadline
                + '}' + "\n";
    }
}
