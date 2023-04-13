package com.aprianfirlanda.controllers;

import com.aprianfirlanda.dtos.ProjectDto;
import com.aprianfirlanda.entities.Project;
import com.aprianfirlanda.mappers.ProjectMapper;
import com.aprianfirlanda.repositories.ProjectRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public ProjectDto saveProject(@RequestBody @NotNull @Valid ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        return projectMapper.toDto(projectRepository.save(project));
    }

    @PutMapping("/update")
    public ProjectDto updateProject(@RequestBody @NotNull @Valid ProjectDto projectDto) {
        if (projectDto.getId() == null) {
            throw new IllegalArgumentException("Project ID is Missing. Use /new to create a project");
        }

        Project project = projectRepository.findById(projectDto.getId()).orElseThrow();
        Project updatedProject = projectMapper.partialUpdate(projectDto, project);
        return projectMapper.toDto(projectRepository.save(updatedProject));
    }
}
