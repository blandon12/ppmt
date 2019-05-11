package com.drupalchilli.ppmtool.services;

import com.drupalchilli.ppmtool.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);
}
