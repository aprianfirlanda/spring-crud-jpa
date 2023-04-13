package com.aprianfirlanda.controllers;

import com.aprianfirlanda.dtos.ProjectDto;
import com.aprianfirlanda.mappers.ProjectMapper;
import com.aprianfirlanda.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository,
                             ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping("/find/{name}")
    public List<ProjectDto> findByName(@PathVariable String name) {
        return projectRepository
                .findByName(name)
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }
}
