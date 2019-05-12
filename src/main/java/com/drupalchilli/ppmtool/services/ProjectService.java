package com.drupalchilli.ppmtool.services;

import com.drupalchilli.ppmtool.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);

    Project findProjectByIdentifier(String projectId);

    Iterable<Project> findAllProjects();

    void deleteProjectByIdentifier(String projectId);
}
