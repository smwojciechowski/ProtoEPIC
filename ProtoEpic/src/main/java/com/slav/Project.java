package com.slav;

import java.util.List;

public class Project {

    private String projectName;
    private List<ProjectDocument> projectDocumentation;

    public Project(){ }

    public Project(String projectName, List<ProjectDocument> projectDocumentation) {
        this.projectName = projectName;
        this.projectDocumentation = projectDocumentation;
    }

    public List<ProjectDocument> getProjectDocumentation() {
        return projectDocumentation;
    }

    public void setProjectDocumentation(List<ProjectDocument> projectDocumentation) {
        this.projectDocumentation = projectDocumentation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}
