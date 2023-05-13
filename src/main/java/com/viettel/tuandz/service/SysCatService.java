package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.SysCatDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface SysCatService {
    Page<SysCatDTO> doSearch(String code, String name, Pageable pageable);

    SysCatDTO save(SysCatDTO sysCatDTO);
    SysCatDTO update(SysCatDTO sysCatDTO);

    void delete(Long id);
}
