package com.viettel.tuandz.repository.impl;

import com.viettel.tuandz.repository.FileAttachmentRepository;
import com.viettel.tuandz.repository.FileAttachmentRepositoryCustom;
import com.viettel.tuandz.service.form.FileManagementDetail;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileAttachmentRepositoryImpl implements FileAttachmentRepositoryCustom {

    @Autowired
    public EntityManager entityManager;

    @Override
    public List<FileManagementDetail> getFileManagement(Integer fileType, Long objectId) {
        String sql =
            "select f.* from file_attachment f where  1 = 1                  " +
            "and :fileType id null or f.file_type = :fileType                                            " +
            "and :objectId is null or f.object_id in :objectId                                       ";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("fileType", fileType);
        query.setParameter("objectId", objectId);
        List<FileManagementDetail> fileManagementDetails = query
            .unwrap(org.hibernate.Query.class)
            .setResultTransformer(Transformers.aliasToBean(FileManagementDetail.class))
            .list();
        fileManagementDetails.forEach(fileManagementDetail -> {
            fileManagementDetail.setSourceUrl(String.format("/file-managements/view?id=%d", fileManagementDetail.getId()));
            fileManagementDetail.setSourceFile(String.format("/file-managements/download?id=%id", fileManagementDetail.getId()));
        });
        return fileManagementDetails;
    }
}
