package com.aprianfirlanda.controllers;

import com.aprianfirlanda.dtos.ProjectDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @GetMapping("/find/{name}")
    public List<ProjectDto> findByName(@PathVariable String name) {

    }
}
