package com.viettel.tuandz.domain;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "code_id")
    private Long codeId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "birthday")
    private Instant birthDay;

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
    @Column(name = "city_id")
    private Integer cityId;

    public Instant getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Instant birthDay) {
        this.birthDay = birthDay;
    }

    @Basic
    @Column(name = "organization")
    private String organization;

    @Basic
    @Column(name = "job")
    private String job;

    @Basic
    @Column(name = "avatar_id")
    private Long avatarId;

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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
            Objects.equals(birthDay, employee.birthDay) &&
            Objects.equals(gender, employee.gender) &&
            Objects.equals(phone, employee.phone) &&
            Objects.equals(email, employee.email) &&
            Objects.equals(address, employee.address) &&
            Objects.equals(cityId, employee.cityId) &&
            Objects.equals(organization, employee.organization) &&
            Objects.equals(job, employee.job)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeId, name, birthDay, gender, phone, email, address, cityId, organization, job);
    }
}
