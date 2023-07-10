package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.FileAttachmentDTO;
import com.viettel.tuandz.service.form.FileManagementDetail;
import java.util.List;
import java.util.Optional;

public interface FileAttachmentService {
    FileAttachmentDTO save(FileAttachmentDTO fileAttachmentDTO);

    List<FileManagementDetail> getFileManagement(Integer fileType, Long objectId);

    Optional<FileAttachmentDTO> findOne(Long id);

    void deleteById(Long avatarId);
}
