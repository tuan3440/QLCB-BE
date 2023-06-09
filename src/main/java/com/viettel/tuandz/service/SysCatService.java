package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.SysCatDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface SysCatService {
    List<SysCatDTO> doSearch(String code, String name);

    SysCatDTO save(SysCatDTO sysCatDTO);
    SysCatDTO update(SysCatDTO sysCatDTO);

    void delete(Long id);

    SysCatDTO getCat(Long id);
}
