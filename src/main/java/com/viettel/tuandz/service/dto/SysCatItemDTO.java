package com.viettel.tuandz.service.dto;

import lombok.Data;

public class SysCatItemDTO {

    private Integer catId;
    private String code;
    private String name;
    private Integer catTypeId;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
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

    public Integer getCatTypeId() {
        return catTypeId;
    }

    public void setCatTypeId(Integer catTypeId) {
        this.catTypeId = catTypeId;
    }
}
