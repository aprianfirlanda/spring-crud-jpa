package com.aprianfirlanda.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.aprianfirlanda.entities.Project} entity
 */
public class ProjectDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    @NotNull
    private final String name;
    private final UserDto manager;
    private final List<TaskDto> tasks;

    public ProjectDto(Long id, String name, UserDto manager, List<TaskDto> tasks) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserDto getManager() {
        return manager;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto entity = (ProjectDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.manager, entity.manager) &&
                Objects.equals(this.tasks, entity.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manager, tasks);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "manager = " + manager + ", " +
                "tasks = " + tasks + ")";
    }
}