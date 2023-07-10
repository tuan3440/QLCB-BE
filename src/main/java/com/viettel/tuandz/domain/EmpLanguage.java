package com.viettel.tuandz.domain;

import java.time.Instant;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "emp_language", schema = "QLCB", catalog = "")
public class EmpLanguage {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "employee_id")
    private Long employeeId;

    @Basic
    @Column(name = "language_degree_id")
    private Long languageDegreeId;

    @Basic
    @Column(name = "degree_name")
    private String degreeName;

    @Basic
    @Column(name = "degree_issued_Instant")
    private Instant degreeIssuedInstant;

    @Basic
    @Column(name = "start_Instant")
    private Instant startInstant;

    @Basic
    @Column(name = "end_Instant")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpLanguage that = (EmpLanguage) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(employeeId, that.employeeId) &&
            Objects.equals(languageDegreeId, that.languageDegreeId) &&
            Objects.equals(degreeName, that.degreeName) &&
            Objects.equals(degreeIssuedInstant, that.degreeIssuedInstant) &&
            Objects.equals(startInstant, that.startInstant) &&
            Objects.equals(endInstant, that.endInstant)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, languageDegreeId, degreeName, degreeIssuedInstant, startInstant, endInstant);
    }
}
