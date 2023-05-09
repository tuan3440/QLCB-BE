package com.viettel.tuandz.domain;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "sys_cat_item", schema = "QLCB", catalog = "")
public class SysCatItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cat_id")
    private Integer catId;

    @Basic
    @Column(name = "code")
    private String code;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "cat_type_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysCatItem that = (SysCatItem) o;
        return (
            Objects.equals(catId, that.catId) &&
            Objects.equals(code, that.code) &&
            Objects.equals(name, that.name) &&
            Objects.equals(catTypeId, that.catTypeId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, code, name, catTypeId);
    }
}
