package com.mahagan.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  int prjId;

    private  String projectName;

    private String projectDomain;

    private String projectVersion;

    @ManyToMany(mappedBy = "projects",cascade = {CascadeType.ALL})
    Set<Employees> employees = new HashSet<Employees>();

    public int getPrjId() {
        return prjId;
    }

    public void setPrjId(int prjId) {
        this.prjId = prjId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDomain() {
        return projectDomain;
    }

    public void setProjectDomain(String projectDomain) {
        this.projectDomain = projectDomain;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }
}
