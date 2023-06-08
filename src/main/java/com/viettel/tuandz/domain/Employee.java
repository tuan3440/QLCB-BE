package com.viettel.tuandz.domain;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "codeId")
    private Long codeId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "birthday")
    private Date birthday;

    @Basic
    @Column(name = "gender")
    private Short gender;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "nation")
    private Integer nation;

    @Basic
    @Column(name = "organizationId")
    private String organizationId;

    @Basic
    @Column(name = "job")
    private String job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return (
            Objects.equals(id, employee.id) &&
            Objects.equals(codeId, employee.codeId) &&
            Objects.equals(name, employee.name) &&
            Objects.equals(birthday, employee.birthday) &&
            Objects.equals(gender, employee.gender) &&
            Objects.equals(phone, employee.phone) &&
            Objects.equals(email, employee.email) &&
            Objects.equals(address, employee.address) &&
            Objects.equals(nation, employee.nation) &&
            Objects.equals(organizationId, employee.organizationId) &&
            Objects.equals(job, employee.job)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeId, name, birthday, gender, phone, email, address, nation, organizationId, job);
    }
}
