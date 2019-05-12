package com.drupalchilli.ppmtool.services;

import com.drupalchilli.ppmtool.domain.Project;
import com.drupalchilli.ppmtool.exception.ProjectIdException;
import com.drupalchilli.ppmtool.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project) {
        try {
            return projectRepository.save(project);
        } catch (RuntimeException e) {
            throw new ProjectIdException("Project identifier " + project.getProjectIdentifier() + " exists");
        }
    }
}
