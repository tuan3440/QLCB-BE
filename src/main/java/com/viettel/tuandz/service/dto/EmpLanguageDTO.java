package com.viettel.tuandz.service.dto;

import java.time.Instant;

public class EmpLanguageDTO {

    private Long id;
    private Long employeeId;
    private Long languageDegreeId;
    private String degreeName;
    private Instant degreeIssuedInstant;
    private Instant startInstant;
    private Instant endInstant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getLanguageDegreeId() {
        return languageDegreeId;
    }

    public void setLanguageDegreeId(Long languageDegreeId) {
        this.languageDegreeId = languageDegreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Instant getDegreeIssuedInstant() {
        return degreeIssuedInstant;
    }

    public void setDegreeIssuedInstant(Instant degreeIssuedInstant) {
        this.degreeIssuedInstant = degreeIssuedInstant;
    }

    public Instant getStartInstant() {
        return startInstant;
    }

    public void setStartInstant(Instant startInstant) {
        this.startInstant = startInstant;
    }

    public Instant getEndInstant() {
        return endInstant;
    }

    public void setEndInstant(Instant endInstant) {
        this.endInstant = endInstant;
    }
}
