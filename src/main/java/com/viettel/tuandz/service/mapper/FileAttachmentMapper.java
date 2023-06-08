package com.viettel.tuandz.service.mapper;

import com.viettel.tuandz.domain.FileAttachment;
import com.viettel.tuandz.service.dto.FileAttachmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface FileAttachmentMapper extends EntityMapper<FileAttachmentDTO, FileAttachment> {}
