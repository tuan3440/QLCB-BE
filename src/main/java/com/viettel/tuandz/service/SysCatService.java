package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.SysCatDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface SysCatService {
    Page<SysCatDTO> doSearch(@Param("code") String code, @Param("name") String name, Pageable pageable);
}
