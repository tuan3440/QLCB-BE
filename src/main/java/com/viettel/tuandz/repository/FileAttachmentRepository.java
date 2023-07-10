package com.viettel.tuandz.repository;

import com.viettel.tuandz.domain.FileAttachment;
import com.viettel.tuandz.service.form.FileManagementDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileAttachmentRepository extends JpaRepository<FileAttachment, Long>, FileAttachmentRepositoryCustom {}
