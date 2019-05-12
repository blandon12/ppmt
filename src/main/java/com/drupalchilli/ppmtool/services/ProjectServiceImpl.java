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

    @Override
    public Project findProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null) {
            throw new ProjectIdException("Project doesn't exist");
        }

        return project;
    }

    @Override
    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null) {
            throw new ProjectIdException("project doesn't exist");
        }

        projectRepository.delete(project);
    }
}
