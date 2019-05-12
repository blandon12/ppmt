package com.drupalchilli.ppmtool.web;

import com.drupalchilli.ppmtool.domain.Project;
import com.drupalchilli.ppmtool.exception.ProjectIdException;
import com.drupalchilli.ppmtool.services.MapValidationService;
import com.drupalchilli.ppmtool.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    private MapValidationService mapValidationService;

    public ProjectController(ProjectService projectService, MapValidationService mapValidationService) {
        this.projectService = projectService;
        this.mapValidationService = mapValidationService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        if (result.hasErrors()) {
            return mapValidationService.run(result);
        }
        Project project1 = projectService.saveOrUpdateProject(project);

        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }
}
