package com.viettel.tuandz.domain;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "file_attachment", schema = "QLCB", catalog = "")
public class FileAttachment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "file_type")
    private Integer fileType;

    @Basic
    @Column(name = "object_id")
    private Long objectId;

    @Basic
    @Column(name = "file_name")
    private String fileName;

    @Basic
    @Column(name = "path")
    private String path;

    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileAttachment that = (FileAttachment) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(fileType, that.fileType) &&
            Objects.equals(objectId, that.objectId) &&
            Objects.equals(fileName, that.fileName) &&
            Objects.equals(path, that.path) &&
            Objects.equals(createdDate, that.createdDate)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileType, objectId, fileName, path, createdDate);
    }
}
