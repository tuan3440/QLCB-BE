package com.viettel.tuandz.service.dto;

public class SysCatItemDTO {

    private Long catId;
    private String code;
    private String name;
    private Long catTypeId;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCatTypeId() {
        return catTypeId;
    }

    public void setCatTypeId(Long catTypeId) {
        this.catTypeId = catTypeId;
    }
}
