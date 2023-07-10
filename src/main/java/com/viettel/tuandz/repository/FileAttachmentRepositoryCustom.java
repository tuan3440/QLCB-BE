package com.viettel.tuandz.repository;

import com.viettel.tuandz.service.form.FileManagementDetail;
import java.util.List;

public interface FileAttachmentRepositoryCustom {
    List<FileManagementDetail> getFileManagement(Integer fileType, Long longList);
}
