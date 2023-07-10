package com.viettel.tuandz.service.dto;

import java.time.Instant;
import java.util.Date;

public class EmployeeDTO {

    private Long id;
    private Long codeId;
    private String name;
    private Instant birthDay;
    private Short gender;
    private String phone;
    private String email;
    private String address;
    private Integer cityId;
    private String organization;
    private String job;

    @SuppressWarnings("squid:S3437")
    private Instant dateBirthFrom;

    @SuppressWarnings("squid:S3437")
    private Instant dateBirthTo;

    private Long avatarId;

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public Instant getDateBirthFrom() {
        return dateBirthFrom;
    }

    public void setDateBirthFrom(Instant dateBirthFrom) {
        this.dateBirthFrom = dateBirthFrom;
    }

    public Instant getDateBirthTo() {
        return dateBirthTo;
    }

    public void setDateBirthTo(Instant dateBirthTo) {
        this.dateBirthTo = dateBirthTo;
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

    public Instant getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Instant birthDay) {
        this.birthDay = birthDay;
    }
}
