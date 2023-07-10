package com.viettel.tuandz.service.impl;

import com.viettel.tuandz.domain.FileAttachment;
import com.viettel.tuandz.repository.FileAttachmentRepository;
import com.viettel.tuandz.service.FileAttachmentService;
import com.viettel.tuandz.service.dto.FileAttachmentDTO;
import com.viettel.tuandz.service.form.FileManagementDetail;
import com.viettel.tuandz.service.mapper.FileAttachmentMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileAttachmentServiceImpl implements FileAttachmentService {

    @Autowired
    private FileAttachmentRepository fileAttachmentRepository;

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    public FileAttachmentDTO save(FileAttachmentDTO fileAttachmentDTO) {
        FileAttachment result = fileAttachmentMapper.toEntity(fileAttachmentDTO);
        result = fileAttachmentRepository.save(result);
        return fileAttachmentMapper.toDto(result);
    }

    @Override
    public List<FileManagementDetail> getFileManagement(Integer fileType, Long objectId) {
        return fileAttachmentRepository.getFileManagement(fileType, objectId);
    }

    @Override
    public Optional<FileAttachmentDTO> findOne(Long id) {
        return fileAttachmentRepository.findById(id).map(fileAttachmentMapper::toDto);
    }

    @Override
    public void deleteById(Long avatarId) {
        fileAttachmentRepository.deleteById(avatarId);
    }
}
